package com.smalaca.ebook.communication;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseTest {
    private static final String SOME_MESSAGE = "java is the best";

    @Test
    public void shouldCreateSuccessfulResponse() {
        Response response = Response.aSuccessfuleResponse();

        assertTrue(response.isSuccess());
        assertNull(response.getMessage());
    }

    @Test
    public void shouldCreateFailureResponse() {
        Response response = Response.aFailureResponse(SOME_MESSAGE);

        assertFalse(response.isSuccess());
        assertEquals(SOME_MESSAGE, response.getMessage());
    }
}
