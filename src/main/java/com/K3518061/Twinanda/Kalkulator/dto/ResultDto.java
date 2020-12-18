package com.K3518061.Twinanda.Kalkulator.dto;

public class ResultDto<T> {
    private T datainput;
    private Double result;
    private String message;

    public T getDatainput() {
        return datainput;
    }

    public void setDatainput(T datainput) {
        this.datainput = datainput;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
