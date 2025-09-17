package SpringLessons.project04.Mappers;

import SpringLessons.project04.Dtos.MemberDto;
import SpringLessons.project04.Models.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "joinDate", ignore = true)
    Member toEntity(MemberDto memberDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "joinDate", ignore = true)
    void updateEntityFromDto(MemberDto memberDto, @MappingTarget Member member);
}
