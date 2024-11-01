package com.rewardshub.controller;

import com.rewardshub.model.Business;
import com.rewardshub.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping
    public Business saveBusiness(@RequestBody Business business) {
        return businessService.saveBusiness(business);
    }

    @GetMapping
    public List<Business> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Business> getBusinessById(@PathVariable Long id) {
        Business business = businessService.getBusinessById(id);
        return ResponseEntity.ok(business);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Business> updateBusiness(@PathVariable Long id, @RequestBody Business businessDetails) {
        Business updatedBusiness = businessService.updateBusiness(id, businessDetails);
        return ResponseEntity.ok(updatedBusiness);
    }

    @DeleteMapping("/{id}")
    public void deleteBusiness(@PathVariable Long id) {
        businessService.deleteBusiness(id);
    }


    @PreAuthorize("@businessUserService.isUserAdminForBusiness(#businessId)")
    @PostMapping("/{businessId}/add-points")
    public ResponseEntity<?> addPoints(@PathVariable Long businessId, @RequestParam int points) {
        // Lógica para adicionar pontos
        return ResponseEntity.ok("Pontos adicionados com sucesso.");
    }

    @PreAuthorize("@businessUserService.isUserAdminForBusiness(#businessId)")
    @DeleteMapping("/{businessId}/remove-user/{targetUserId}")
    public ResponseEntity<?> removeUser(@PathVariable Long businessId, @PathVariable Long targetUserId) {
        // Lógica para remover um usuário do negócio
        return ResponseEntity.ok("Usuário removido com sucesso.");
    }
}
