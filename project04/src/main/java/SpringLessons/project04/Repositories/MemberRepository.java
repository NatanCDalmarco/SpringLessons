package SpringLessons.project04.Repositories;

import SpringLessons.project04.Models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
