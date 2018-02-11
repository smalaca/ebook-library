package com.smalaca.ebook.communication;

public class Response {
    private static final boolean FAILURE = false;
    private static final boolean SUCCESS = true;

    private final boolean isSuccess;
    private String message;

    public static Response aFailureResponse(String message) {
        Response response = new Response(FAILURE);
        response.message = message;

        return response;
    }

    public static Response aSuccessfuleResponse() {
        return new Response(SUCCESS);
    }

    private Response(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
