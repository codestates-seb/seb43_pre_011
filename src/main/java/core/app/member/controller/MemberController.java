package core.app.member.controller;

import core.app.dto.MultiResponseDto;
import core.app.dto.SingleResponseDto;
import core.app.member.dto.MemberPatchDto;
import core.app.member.dto.MemberPostDto;
import core.app.member.entity.Member;
import core.app.member.mapper.MemberMapper;
import core.app.member.service.MemberService;
import core.app.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@Validated
@RestController
@RequestMapping("/members")
@Slf4j
public class MemberController {
    private final static String MEMBER_DEFAULT_URL = "/members";
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper){
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto){

        Member member = mapper.memberPostDtoToMember(memberPostDto);

        Member createMember = memberService.createMember(member);
        URI location = UriCreator.createUri(MEMBER_DEFAULT_URL, createMember.getMemberId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") Long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto){

        memberPatchDto.setMemberId(memberId);

        Member member = memberService.updateMember(mapper.memberPatchDtoToMember(memberPatchDto));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.memberToMemberResponseDto(member)), HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive Long memberId){

        Member response = memberService.findMember(memberId);

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size){


        Page<Member> pageMembers = memberService.findMembers(page - 1, size);

        List<Member> members =pageMembers.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.memberToMemberResponseDtos(members),pageMembers), HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive Long memberId){

        memberService.deleteMember(memberId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
