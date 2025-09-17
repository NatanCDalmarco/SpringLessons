package SpringLessons.project04.Mappers;

import SpringLessons.project04.Dtos.MemberDto;
import SpringLessons.project04.Models.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-17T11:10:55-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member toEntity(MemberDto memberDto) {
        if ( memberDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setName( memberDto.name() );
        member.setDescription( memberDto.description() );

        return member;
    }

    @Override
    public void updateEntityFromDto(MemberDto memberDto, Member member) {
        if ( memberDto == null ) {
            return;
        }

        member.setName( memberDto.name() );
        member.setDescription( memberDto.description() );
    }
}
