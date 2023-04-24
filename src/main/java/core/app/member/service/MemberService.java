package core.app.member.service;

import core.app.exception.BusinessLogicException;
import core.app.exception.ExceptionCode;
import core.app.member.entity.Member;
import core.app.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // member 등록(닉네임의 중복을 확인해서 가입)
    public Member createMember(Member member){

        verifyExistsNickName(member.getNickName());

        return memberRepository.save(member);
    }

    // member 수정
    public Member updateMember(Member member){

        Member findMember = findVerifiedMember(member.getMemberId());

        // 로그인한 멤버와 작성자 확인 로직 필요 -> 같지 않으면 throw

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
