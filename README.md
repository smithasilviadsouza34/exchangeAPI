# exchange
exchange the currency and pay the bill code 
EndPoint: http://localhost:8080/api/calculate
Request:
{
  "fromCurrency": "AED",
  "toCurrency": "INR",
  "amount": 100.0,
  "discount": "0.0",
  "customerExistsInSys":"3",
  "itemType":"hell0",
  "userRole":"Customer"
}

Response:
{
    "fromCurrency": "AED",
    "toCurrency": "INR",
    "originalAmount": 100.0,
    "discountedAmount": 5.0,
    "exchangeRate": 23.56,
    "payableAmount": 117.8
}
