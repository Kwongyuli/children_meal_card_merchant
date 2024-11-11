package com.card.mealcard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "mealcard") //  JPA 에서는 @Entity 클래스 이름과 데이터베이스 테이블 이름이 같다고 가정하고 매핑을 시도
@Getter
@Setter
@NoArgsConstructor
public class AffiliateStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime data_creation_date;
    private String affiliate_name;
    private String road_name_address;
    private String number_address;
    private String business_type;
    private Double latitude;
    private Double longitude;
    private LocalDateTime affiliated_store_base_date;
}
