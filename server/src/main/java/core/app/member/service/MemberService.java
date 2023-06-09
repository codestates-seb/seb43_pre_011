package core.app.member.service;

import core.app.exception.BusinessLogicException;
import core.app.exception.ExceptionCode;
import core.app.member.entity.Member;
import core.app.member.repository.MemberRepository;
import core.app.security.auths.utils.CustomAuthorityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }

    // member 등록(닉네임의 중복을 확인해서 가입)
    public Member createMember(Member member){

        verifyExistsNickName(member.getNickName());

        String encryptedPassword = passwordEncoder.encode((member.getPassword()));
        member.setPassword(encryptedPassword);
        List<String> roles = authorityUtils.createRoles(member.getEmail());
        member.setRoles(roles);

        return memberRepository.save(member);
    }

    // member 수정
    public Member updateMember(Member member){

        Member findMember = findVerifiedMember(member.getMemberId());

                Optional.ofNullable(member.getEmail())
                .ifPresent(mail -> findMember.setEmail(mail));
                Optional.ofNullable(member.getPassword())
                .ifPresent(password -> findMember.setPassword(password));

        return memberRepository.save(findMember);
    }

    public Member findMember(Long memberId){
        return findVerifiedMember(memberId);
    }

    public Page<Member> findMembers(int page, int size){
        return memberRepository.findAll(PageRequest.of(page, size, Sort.by("memberId").descending()));
    }

    public void deleteMember(long memberId){
        Member findMember = findVerifiedMember(memberId);

        memberRepository.delete(findMember);
    }

    // 존재하는 회원인지 memberId로 검색
    public Member findVerifiedMember(long memberId){
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        Member findMember = optionalMember.orElseThrow(()-> new BusinessLogicException((ExceptionCode.MEMBER_NOT_FOUND)));

        return findMember;
    }

    // 닉네임이 존재하는지 확인
    public void verifyExistsNickName(String nickName){
        Optional<Member> member = memberRepository.findByNickName(nickName);
        if(member.isPresent()){
            throw new BusinessLogicException((ExceptionCode.MEMBER_EXISTS));
        }
    }
}