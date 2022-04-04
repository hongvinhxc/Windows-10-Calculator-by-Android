package com.vinhnh.calculator.models;

import androidx.annotation.NonNull;

public class CurrencyModel {

    private String countryName;
    private String currencyName;
    private String currencyCode;

    public CurrencyModel(String countryName,  String currencyName, String currencyCode) {
        this.countryName = countryName;
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }


    @NonNull
    @Override
    public String toString() {
        return countryName + " - " + currencyName;
    }
}
