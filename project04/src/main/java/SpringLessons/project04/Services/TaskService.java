package SpringLessons.project04.Services;

import SpringLessons.project04.Dtos.TaskDto;
import SpringLessons.project04.Mappers.TaskMapper;
import SpringLessons.project04.Models.BookClub;
import SpringLessons.project04.Models.Task;
import SpringLessons.project04.Repositories.BookClubRepository;
import SpringLessons.project04.Repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;
    TaskMapper taskMapper;
    BookClubRepository bookClubRepository;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper, BookClubRepository bookClubRepository) {
        this.taskRepository = taskRepository;
        this.bookClubRepository = bookClubRepository;
        this.taskMapper = taskMapper;
    }

    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task with id " + id + " not found"));
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task create(TaskDto taskDto) {
        BookClub bookClub = bookClubRepository.findById(taskDto.bookclub_id())
                .orElseThrow(() -> new RuntimeException("BookClub não encontrado com o ID: " + taskDto.bookclub_id()));

        Task task = taskMapper.toEntity(taskDto);
        task.setCreationDate(LocalDate.now());
        task.setClub(bookClub);

        return taskRepository.save(task);
    }

    public Task update(Long id,TaskDto taskDto) {
        Task task = getById(id);
        taskMapper.updateEntityFromDto(taskDto, task);

        return taskRepository.save(task);
    }

    public void delete(Long id) {
        Task task = getById(id);
        taskRepository.delete(task);
    }
}
