package sopt.web1.restaruant.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sopt.web1.restaruant.domain.RestaurantEntity;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    List<RestaurantEntity> findByBundleId(int bundleId);
}
