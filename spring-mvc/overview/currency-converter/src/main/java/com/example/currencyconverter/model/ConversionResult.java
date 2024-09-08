package com.example.currencyconverter.model;

public class ConversionResult {
    private double usd;
    private double vnd;
    private double rate;

    public ConversionResult(double usd, double vnd, double rate) {
        this.usd = usd;
        this.vnd = vnd;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getVnd() {
        return vnd;
    }

    public void setVnd(double vnd) {
        this.vnd = vnd;
    }
}
