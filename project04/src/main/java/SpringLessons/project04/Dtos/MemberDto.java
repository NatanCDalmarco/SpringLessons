package SpringLessons.project04.Dtos;

import SpringLessons.project04.Models.Status;

import java.time.LocalDate;

public record MemberDto (
        String name,
        String description,
        Long bookclub_id
) {
}
