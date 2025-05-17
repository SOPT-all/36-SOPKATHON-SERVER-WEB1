package sopt.web1.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.web1.activity.domain.ActivityEntity;

import java.util.List;
import java.util.Optional;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {

    List<ActivityEntity> findByBundleId(int bundleId);
}
