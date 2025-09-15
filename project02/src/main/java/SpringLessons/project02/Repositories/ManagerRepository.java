package SpringLessons.project02.Repositories;

import SpringLessons.project02.Model.Manager;
import SpringLessons.project02.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {
    // List<Manager> findByTeam_Id(Long teamId);
}
