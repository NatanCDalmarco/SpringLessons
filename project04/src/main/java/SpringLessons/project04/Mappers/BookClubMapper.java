package SpringLessons.project04.Mappers;

import SpringLessons.project04.Dtos.BookClubDto;
import SpringLessons.project04.Models.BookClub;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookClubMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    BookClub toEntity(BookClubDto bookClubDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    void updateEntityFromDto(BookClubDto bookClubDto, @MappingTarget BookClub bookClub);
}
