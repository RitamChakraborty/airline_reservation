package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Admin;
import com.cognizant.airline_ticket_reservation_system.service.LoginService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    private static final Admin admin1 = new Admin();
    @Mock
    private static LoginService loginService1;
    @Mock
    private static LoginService loginService2;
    @Mock
    private static BindingResult bindingResult1;
    @Mock
    private static BindingResult bindingResult2;
    private final LoginController loginController = new LoginController();
    @Spy
    private ModelMap modelMap;

    @Before
    public void setUpBeforeClass() {
        Mockito.when(bindingResult1.hasErrors()).thenReturn(false);
        Mockito.when(bindingResult2.hasErrors()).thenReturn(true);

        Mockito.when(loginService1.validAdmin(admin1)).thenReturn(true);
        Mockito.when(loginService2.validAdmin(admin1)).thenReturn(false);
    }


    @Test
    public void adminLogin() {
        String expected = "admin-login";
        String actual = loginController.adminLogin(admin1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void adminHome_test_without_error() {
        loginController.setLoginService(loginService1);

        String errorMessage = "error-message";
        String expected = "admin-home";
        String actual = loginController.adminHome(admin1, bindingResult1, modelMap, errorMessage);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void adminHome_test_with_error_in_credential() {
        loginController.setLoginService(loginService2);

        String errorMessage = "error-message";
        String expected = "admin-login";
        String actual = loginController.adminHome(admin1, bindingResult1, modelMap, errorMessage);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void adminHome_test_with_error_in_validation() {
        loginController.setLoginService(loginService1);

        String errorMessage = "error-message";
        String expected = "admin-login";
        String actual = loginController.adminHome(admin1, bindingResult2, modelMap, errorMessage);

        Assert.assertEquals(expected, actual);
    }
}