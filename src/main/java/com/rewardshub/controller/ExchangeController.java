package com.rewardshub.controller;

import com.rewardshub.model.Exchange;
import com.rewardshub.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchanges")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @PostMapping
    public Exchange createExchange(@RequestBody Exchange exchange) {
        return exchangeService.createExchange(exchange);
    }

    @GetMapping
    public List<Exchange> getAllExchanges() {
        return exchangeService.getAllExchanges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exchange> getExchangeById(@PathVariable Long id) {
        Exchange exchange = exchangeService.getExchangeById(id);
        return ResponseEntity.ok(exchange);
    }

    @DeleteMapping("/{id}")
    public void deleteExchange(@PathVariable Long id) {
        exchangeService.deleteExchange(id);
    }
}
