package com.vault.vault.response;
// the fourth class .
// this one is just to display api response and status.(this is the first time i am actually using this keyword willingly and for a purpose. i feel like a fancy dev)
public class apiResponse {
    public boolean success;
    public String message;
    public Object data;
    public apiResponse(boolean success, String message, Object data){
        this.success=success;
        this.data=data;
        this.message=message;
    }

}
