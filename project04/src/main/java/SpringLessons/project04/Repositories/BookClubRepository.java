package SpringLessons.project04.Repositories;

import SpringLessons.project04.Models.BookClub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookClubRepository extends JpaRepository<BookClub,Long> {
}
