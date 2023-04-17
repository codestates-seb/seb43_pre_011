package core.app.member.mapper;

import core.app.member.dto.MemberPatchDto;
import core.app.member.dto.MemberPostDto;
import core.app.member.dto.MemberResponseDto;
import core.app.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberToMemberPostDto(MemberPostDto memberPostDto);
    Member memberToMemberPatchDto(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
    List<MemberResponseDto> memberToMemberResponseDtos(List<Member> members);
}
