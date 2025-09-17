package SpringLessons.project04.Dtos;

import SpringLessons.project04.Models.Status;

import java.time.LocalDate;

public record TaskDto (
        String title,
        String description,
        LocalDate dueDate,
        Status status,
        Long bookclub_id) {
}
