package SpringLessons.project03.Repositories;

import SpringLessons.project03.Models.Fossil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FossilRepository extends JpaRepository<Fossil, Long> {
}
