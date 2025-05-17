package sopt.web1.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.web1.activity.domain.ActivityEntity;

import java.util.List;


public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {

    List<ActivityEntity> findTop10ByOrderByLikeCountDesc();
    List<ActivityEntity> findByBundleId(int bundleId);
}

