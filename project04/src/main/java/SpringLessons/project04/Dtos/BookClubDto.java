package SpringLessons.project04.Dtos;

import SpringLessons.project04.Models.Status;

import java.time.LocalDate;

public record BookClubDto (
        String name,
        String description,
        LocalDate creationDate) {
}
