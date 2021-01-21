package com.cognizant.airline_ticket_reservation_system.service;


import com.cognizant.airline_ticket_reservation_system.dao.AdminDao;
import com.cognizant.airline_ticket_reservation_system.model.Admin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
    private static final Admin admin1 = new Admin();
    private static final Admin admin2 = new Admin();
    @Mock
    private AdminDao adminDao;

    @InjectMocks
    private LoginService loginService;

    @BeforeClass
    public static void setUpAll() {
        admin1.setUsername("ritam");
        admin1.setPassword("password");

        admin2.setUsername("pritam");
        admin2.setPassword("password");
    }

    @Before
    public void setUp() {
        Mockito.when(adminDao.findById("ritam")).thenReturn(Optional.of(admin1));
        Mockito.when(adminDao.findById("pritam")).thenReturn(Optional.empty());
    }

    @Test
    public void test() {
        Assert.assertNotNull(adminDao);
        Assert.assertNotNull(loginService);
    }

    @Test
    public void validAdmin_test_valid_admin() {
        boolean result = loginService.validAdmin(admin1);
        Assert.assertTrue(result);
    }

    @Test
    public void validAdmin_test_invalid_admin() {
        boolean result = loginService.validAdmin(admin2);
        Assert.assertFalse(result);
    }

    @Test
    public void validAdmin_test_verify_call_findById() {
        loginService.validAdmin(admin1);
        Mockito.verify(adminDao).findById("ritam");
    }
}