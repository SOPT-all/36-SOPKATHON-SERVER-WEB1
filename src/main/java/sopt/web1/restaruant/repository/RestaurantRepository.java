package sopt.web1.restaruant.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sopt.web1.restaruant.domain.RestaurantEntity;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
