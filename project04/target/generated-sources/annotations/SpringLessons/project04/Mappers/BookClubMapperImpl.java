package SpringLessons.project04.Mappers;

import SpringLessons.project04.Dtos.BookClubDto;
import SpringLessons.project04.Models.BookClub;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-17T11:31:25-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class BookClubMapperImpl implements BookClubMapper {

    @Override
    public BookClub toEntity(BookClubDto bookClubDto) {
        if ( bookClubDto == null ) {
            return null;
        }

        BookClub bookClub = new BookClub();

        bookClub.setName( bookClubDto.name() );
        bookClub.setDescription( bookClubDto.description() );

        return bookClub;
    }

    @Override
    public void updateEntityFromDto(BookClubDto bookClubDto, BookClub bookClub) {
        if ( bookClubDto == null ) {
            return;
        }

        bookClub.setName( bookClubDto.name() );
        bookClub.setDescription( bookClubDto.description() );
    }
}
