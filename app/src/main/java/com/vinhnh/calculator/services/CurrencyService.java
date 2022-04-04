package com.vinhnh.calculator.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrencyService {
    @GET("/v6/5427e3b9b1959f85bb34262b/latest/USD")
    Call<ResponseBody> getExchangeRate();
}
