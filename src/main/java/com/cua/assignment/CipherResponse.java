package com.cua.assignment;

public class CipherResponse {
    String responseText;

    public CipherResponse(String response) {
        this.responseText = response;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }
}
