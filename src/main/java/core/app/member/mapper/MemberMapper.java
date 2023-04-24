package core.app.member.mapper;

import core.app.member.dto.MemberDto;
import core.app.member.dto.MemberPatchDto;
import core.app.member.dto.MemberPostDto;
import core.app.member.dto.MemberResponseDto;
import core.app.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberDto.Post requestBody);
    Member memberPatchDtoToMember(MemberDto.Patch requestBody);
    MemberDto.Response memberToMemberResponseDto(Member member);
    List<MemberDto.Response> memberToMemberResponseDtos(List<Member> members);
}
