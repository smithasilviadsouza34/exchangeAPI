package com.currency.controller;


import com.currency.model.BillRequestDTO;
import com.currency.model.BillResponseDTO;
import com.currency.service.DiscountCalcService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/")
@Slf4j
public class Init {

    @Autowired
    DiscountCalcService discountCalcService;
    @GetMapping(path="healthcheck")
    public String helloWorld(){
        return "hello";
    }

    @GetMapping(path="/calculate")
    public ResponseEntity<BillResponseDTO> calculateBillPayment(@Valid @RequestBody BillRequestDTO request){
        BillResponseDTO response=discountCalcService.calculatePayableAmount(request);
        return ResponseEntity.ok(response);
    }
}
