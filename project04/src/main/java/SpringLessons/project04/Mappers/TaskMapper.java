package SpringLessons.project04.Mappers;

import SpringLessons.project04.Dtos.TaskDto;
import SpringLessons.project04.Models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    Task toEntity(TaskDto taskDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    void updateEntityFromDto(TaskDto taskDto, @MappingTarget Task task);
}
