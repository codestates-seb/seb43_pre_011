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
<<<<<<< HEAD
    date = "2023-04-26T13:23:25+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
=======
    date = "2023-04-26T01:10:49+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
>>>>>>> d89187dd16726e2638b9e5ae8d2dc039d9a96b88
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

<<<<<<< HEAD
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
=======
        MemberDto.Response response = new MemberDto.Response();
>>>>>>> d89187dd16726e2638b9e5ae8d2dc039d9a96b88

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
