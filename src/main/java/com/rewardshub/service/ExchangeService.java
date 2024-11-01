package com.rewardshub.service;


import com.rewardshub.model.Exchange;
import com.rewardshub.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    public Exchange createExchange(Exchange exchange) {
        return exchangeRepository.save(exchange);
    }

    public List<Exchange> getAllExchanges() {
        return exchangeRepository.findAll();
    }

    public Exchange getExchangeById(Long id) {
        return exchangeRepository.findById(id).orElse(null);
    }

    public void deleteExchange(Long id) {
        exchangeRepository.deleteById(id);
    }
}
