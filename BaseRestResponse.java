package com.sintialab.rest;

public class BaseRestResponse {

    private Integer status;
    private ApiError apiError;

    public BaseRestResponse(){

    }


    public BaseRestResponse(Integer status, ApiError apiError){
        this.status = status;
        this.apiError = apiError;
    }

    public BaseRestResponse(Integer status){
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }

    @Override
    public String toString() {
        return "BaseRestResponse{" +
                "status=" + status +
                ", apiError=" + apiError +
                '}';
    }

}

