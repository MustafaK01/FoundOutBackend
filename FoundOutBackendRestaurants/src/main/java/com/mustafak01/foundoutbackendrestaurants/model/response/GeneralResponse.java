package com.mustafak01.foundoutbackendrestaurants.model.response;
public class GeneralResponse {

    private String message;
    private boolean isSuccess;

    public GeneralResponse(String message, boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
