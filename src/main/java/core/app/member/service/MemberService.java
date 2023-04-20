package core.app.member.service;

import core.app.exception.BusinessLogicException;
import core.app.exception.ExceptionCode;
import core.app.member.entity.Member;
import core.app.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member){

        verifyExistsNickName(member.getNickName());

        return memberRepository.save(member);
    }

    public Member updateMember(Member member){

        Member findMember = findVerifiedMember(member.getMemberId());

                Optional.ofNullable(member.getEmail())
                .ifPresent(mail -> findMember.setEmail(mail));
        Optional.ofNullable(member.getPassword())
                .ifPresent(password -> findMember.setPassword(password));
        Optional.ofNullable(member.getGrade())
                .ifPresent(grade -> findMember.setGrade(grade));

        return memberRepository.save(findMember);
    }

    public Member findMember(Long memberId){
        return findVerifiedMember(memberId);
    }

    public Page<Member> findMembers(int page, int size){
        return memberRepository.findAll(PageRequest.of(page, size, Sort.by("memberId").descending()));
    }

    public void deleteMember(Long memberId){
        Member findMember = findVerifiedMember(memberId);

        memberRepository.delete(findMember);
    }

    public Member findVerifiedMember(Long memberId){
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        Member findMember = optionalMember.orElseThrow(()-> new BusinessLogicException((ExceptionCode.MEMBER_NOT_FOUND)));

        return findMember;
    }

    public void verifyExistsNickName(String nickName){
        Optional<Member> member = memberRepository.findByNickName(nickName);
        if(member.isPresent()){
            throw new BusinessLogicException((ExceptionCode.MEMBER_EXISTS));
        }
    }
}
