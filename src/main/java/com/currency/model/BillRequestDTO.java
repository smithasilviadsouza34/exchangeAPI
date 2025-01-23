package com.currency.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


public class BillRequestDTO {
    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @NotBlank
    private String fromCurrency;

    @NotBlank
    private String toCurrency;

    @NotNull
    @Min(0)
    private Double amount;

    @Min(0)
    private Double discount;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    private String userRole;

    public String getCustomerExistsInSys() {
        return customerExistsInSys;
    }

    public void setCustomerExistsInSys(String customerExistsInSys) {
        this.customerExistsInSys = customerExistsInSys;
    }

    private String customerExistsInSys;

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    private String itemType;
}