package com.currency.service;

import com.currency.model.BillRequestDTO;
import com.currency.model.BillResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Service
@AllArgsConstructor
public class DiscountCalcService {

    private final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public BillResponseDTO calculatePayableAmount(BillRequestDTO request) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + request.getFromCurrency();
        var response = restTemplate.getForObject(url, Map.class);

        if (response == null || !response.containsKey("rates")) {
            throw new RuntimeException("Unable to fetch exchange rates.");
        }

        // Fetch exchange rate
        var rates = (Map<String, Double>) response.get("rates");
        Double exchangeRate = rates.get(request.getToCurrency());

        if (exchangeRate == null) {
            throw new RuntimeException("Invalid target currency.");
        }
        double discountedAmount = 0;
        if(request.getItemType().equalsIgnoreCase("Groceries")){
            if(request.getUserRole().equalsIgnoreCase("Employee")){
                discountedAmount = request.getAmount() * (1 - (request.getDiscount() != null ? 30 / 100 : 0));
            }else if(request.getUserRole().equalsIgnoreCase("Affiliate")){
                discountedAmount = request.getAmount() * (1 - (request.getDiscount() != null ? 10 / 100 : 0));
            }else if(request.getUserRole().equalsIgnoreCase("Customer") && Integer.valueOf(request.getCustomerExistsInSys())>2){
                discountedAmount = request.getAmount() * (1 - (request.getDiscount() != null ? 5 / 100 : 0));
            }else if(request.getToCurrency().equals("USD") && request.getAmount()>100){

                discountedAmount= request.getAmount() * (1 - (request.getDiscount() != null ? 5 / 100 : 0));
            }
        }

        // Apply discount

        // Calculate payable amount
        double payableAmount = discountedAmount * exchangeRate;

        // Prepare response
        BillResponseDTO responseDTO = new BillResponseDTO();
        responseDTO.setFromCurrency(request.getFromCurrency());
        responseDTO.setToCurrency(request.getToCurrency());
        responseDTO.setOriginalAmount(request.getAmount());
        responseDTO.setDiscountedAmount(discountedAmount);
        responseDTO.setExchangeRate(exchangeRate);
        responseDTO.setPayableAmount(payableAmount);

        return responseDTO;
    }
}
