package SpringLessons.project04.Mappers;

import SpringLessons.project04.Dtos.TaskDto;
import SpringLessons.project04.Models.Task;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-17T11:10:55-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task toEntity(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setTitle( taskDto.title() );
        task.setDescription( taskDto.description() );
        task.setDueDate( taskDto.dueDate() );
        task.setStatus( taskDto.status() );

        return task;
    }

    @Override
    public void updateEntityFromDto(TaskDto taskDto, Task task) {
        if ( taskDto == null ) {
            return;
        }

        task.setTitle( taskDto.title() );
        task.setDescription( taskDto.description() );
        task.setDueDate( taskDto.dueDate() );
        task.setStatus( taskDto.status() );
    }
}
