package core.app.member.mapper;

import core.app.member.dto.MemberDto.Patch;
import core.app.member.dto.MemberDto.Post;
import core.app.member.dto.MemberDto.Response;
import core.app.member.entity.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-26T14:22:53+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( requestBody.getEmail() );
        member.setPassword( requestBody.getPassword() );
        member.setNickName( requestBody.getNickName() );

        return member;
    }

    @Override
    public Member memberPatchDtoToMember(Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( requestBody.getMemberId() );
        member.setEmail( requestBody.getEmail() );
        member.setPassword( requestBody.getPassword() );
        member.setNickName( requestBody.getNickName() );

        return member;
    }

    @Override
    public Response memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        long memberId = 0L;
        String email = null;
        String password = null;
        String nickName = null;
        LocalDateTime createAt = null;
        LocalDateTime modifiedAt = null;

        if ( member.getMemberId() != null ) {
            memberId = member.getMemberId();
        }
        email = member.getEmail();
        password = member.getPassword();
        nickName = member.getNickName();
        createAt = member.getCreateAt();
        modifiedAt = member.getModifiedAt();

        Response response = new Response( memberId, email, password, nickName, createAt, modifiedAt );

        return response;
    }

    @Override
    public List<Response> memberToMemberResponseDtos(List<Member> members) {
        if ( members == null ) {
            return null;
        }

        List<Response> list = new ArrayList<Response>( members.size() );
        for ( Member member : members ) {
            list.add( memberToMemberResponseDto( member ) );
        }

        return list;
    }
}
