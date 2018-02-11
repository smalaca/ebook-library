package com.smalaca.ebook.registration;

import com.smalaca.ebook.view.SystemInterface;
import org.junit.Test;

import static com.smalaca.ebook.communication.Response.aFailureResponse;
import static com.smalaca.ebook.communication.Response.aSuccessfuleResponse;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RegistrationViewTest {
    private static final String SOME_LOGIN = "login";
    private static final String SOME_PASSWORD = "password";
    private static final String FAILURE_MESSAGE = "some failure message";

    private RegistrationController registrationController = mock(RegistrationController.class);
    private SystemInterface systemInterface = mock(SystemInterface.class);
    private RegistrationView registrationView = new RegistrationView(registrationController, systemInterface);

    @Test
    public void shouldRegisterNewUser() {
        given(systemInterface.readInformation()).willReturn(SOME_LOGIN, SOME_PASSWORD);
        given(registrationController.register(SOME_LOGIN, SOME_PASSWORD)).willReturn(aSuccessfuleResponse());

        registrationView.show();

        verify(systemInterface).display("Udało się zarejestrować użytkownia " + SOME_LOGIN + ".");
    }

    @Test
    public void shouldNotRegisterUser() {
        given(systemInterface.readInformation()).willReturn(SOME_LOGIN, SOME_PASSWORD);
        given(registrationController.register(SOME_LOGIN, SOME_PASSWORD)).willReturn(aFailureResponse(FAILURE_MESSAGE));

        registrationView.show();

        verify(systemInterface).display("Rejestracja się nie powiodła.");
        verify(systemInterface).display(FAILURE_MESSAGE);
    }
}
