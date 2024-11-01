package com.rewardshub.service;

import com.rewardshub.model.BusinessUser;
import com.rewardshub.repository.BusinessUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessUserService {

    @Autowired
    private BusinessUserRepository businessUserRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BusinessService businessService;

    public BusinessUser assignUserToBusiness(Long userId, Long businessId, String role) {
        BusinessUser businessUser = new BusinessUser();
        businessUser.setUser(userService.getUserById(userId));
        businessUser.setBusiness(businessService.getBusinessById(businessId));
        businessUser.setRole(role);
        return businessUserRepository.save(businessUser);
    }

    public List<BusinessUser> getUsersByBusiness(Long businessId) {
        return businessUserRepository.findByBusinessId(businessId);
    }

    public void removeUserFromBusiness(Long userId, Long businessId) {
        businessUserRepository.deleteByUserIdAndBusinessId(userId, businessId);
    }

    public boolean isUserAdminForBusiness(Long businessId) {
        // Recupera o usuário autenticado
        String username = getAuthenticatedUsername();
        return businessUserRepository.findByUserEmailAndBusinessIdAndRole(username, businessId, "admin").isPresent();
    }

    private String getAuthenticatedUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}
