package com.rewardshub.controller;

import com.rewardshub.model.BusinessUser;
import com.rewardshub.service.BusinessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/business-users")
public class BusinessUserController {

    @Autowired
    private BusinessUserService businessUserService;

    @PostMapping
    public BusinessUser assignUserToBusiness(@RequestParam Long userId, @RequestParam Long businessId, @RequestParam String role) {
        return businessUserService.assignUserToBusiness(userId, businessId, role);
    }

    @DeleteMapping
    public void removeUserFromBusiness(@RequestParam Long userId, @RequestParam Long businessId) {
        businessUserService.removeUserFromBusiness(userId, businessId);
    }
}
