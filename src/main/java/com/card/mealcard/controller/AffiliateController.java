package com.card.mealcard.controller;

import com.card.mealcard.entity.AffiliateStore;
import com.card.mealcard.service.AffiliateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/card")
@RequiredArgsConstructor
public class AffiliateController {
    private final AffiliateService affiliateService;

    @GetMapping("/meals")
    public String meals(Model model) {
        List<AffiliateStore> meals = affiliateService.findAll();
        model.addAttribute("meals", meals);

        return "card/meals";
    }

    @GetMapping("/mealsList")
    public String getAffiliateWithinRadius(
            @RequestParam(value = "latitude", required = false)Double latitude,
            @RequestParam(value = "longitude", required = false)Double longitude,
            @RequestParam(value = "radius", required = false)Double radius,
            Model model
    ) {
        if (latitude == null || longitude == null || radius == null) {
            return "card/list";
        }

        List<AffiliateStore> affiliateStores = affiliateService.findAffiliateWithinRadius(latitude, longitude, radius);

        model.addAttribute("affiliateStores", affiliateStores);

        return "card/list";
        // 커밋
    }

}