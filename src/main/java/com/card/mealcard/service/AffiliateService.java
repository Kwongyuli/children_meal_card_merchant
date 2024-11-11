package com.card.mealcard.service;

import com.card.mealcard.entity.AffiliateStore;
import com.card.mealcard.repository.AffiliateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class AffiliateService {
    private final AffiliateRepository affiliateRepository;

    public AffiliateService(AffiliateRepository affiliateRepository) {
        this.affiliateRepository = affiliateRepository;
    }

    public List<AffiliateStore> findAll() {
        return affiliateRepository.findAll();
    }

    public List<AffiliateStore> findAffiliateWithinRadius(Double latitude, Double longitude, Double radius) {
        List<AffiliateStore> affiliates = affiliateRepository.findNearbyAffiliates(latitude, longitude, radius);
        return affiliates;
    }
}
