package com.rewardshub.service;

import com.rewardshub.model.Business;
import com.rewardshub.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public Business saveBusiness(Business business) {
        return businessRepository.save(business);
    }

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public Business getBusinessById(Long id) {
        return businessRepository.findById(id).orElse(null);
    }

    public Business updateBusiness(Long id, Business businessDetails) {
        Business business = getBusinessById(id);
        if (business != null) {
            business.setName(businessDetails.getName());
            business.setAddress(businessDetails.getAddress());
            return businessRepository.save(business);
        }
        return null;
    }

    public Business getBusinessByName(String name) {
        return businessRepository.findByName(name).orElse(null);
    }

    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }
}
