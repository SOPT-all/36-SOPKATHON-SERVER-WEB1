package sopt.web1.activity.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "activity")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "operating_hours", nullable = false)
    private String time;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "introduction", nullable = false)
    private String introduction;

    @Column(name = "like_count", nullable = false)
    private int likeCount;

    @Column(name = "bundle_id", nullable = false)
    private int bundleId;

}
