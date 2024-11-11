package com.card.mealcard.repository;

import com.card.mealcard.entity.AffiliateStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface AffiliateRepository extends JpaRepository<AffiliateStore, Integer> {

    @Query(value = "SELECT m.* FROM mealcard m WHERE 6371 * acos(cos(radians(:latitude)) * cos(radians(m.latitude)) * cos(radians(m.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(m.latitude))) <= :radius", nativeQuery = true)
    List<AffiliateStore> findNearbyAffiliates(@Param("latitude")Double latitude, @Param("longitude")Double longitude, @Param("radius")Double radius);

//    List<AffiliateStore> findByCuisine(String cuisine);
}
