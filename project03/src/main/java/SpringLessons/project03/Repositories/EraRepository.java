package SpringLessons.project03.Repositories;

import SpringLessons.project03.Models.Era;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EraRepository extends JpaRepository<Era,Long> {
}
