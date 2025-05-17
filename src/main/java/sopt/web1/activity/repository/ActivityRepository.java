package sopt.web1.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.web1.activity.domain.ActivityEntity;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {
}
