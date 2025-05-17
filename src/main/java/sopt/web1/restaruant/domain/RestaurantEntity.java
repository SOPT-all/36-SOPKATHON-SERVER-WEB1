package sopt.web1.restaruant.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "restaurant")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "image_url", nullable = false)
    private String image_url;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "introduction", nullable = false)
    private String introduction;

    @Column(name = "likes", nullable = false)
    private int likes;

    @Column(name = "bundle_id", nullable = false)
    private int bundleId;

}
