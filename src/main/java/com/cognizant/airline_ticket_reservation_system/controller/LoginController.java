package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.dao.UserDao;
import com.cognizant.airline_ticket_reservation_system.model.*;
import com.cognizant.airline_ticket_reservation_system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@PropertySource("classpath:messages.properties")
public class LoginController {
    private LoginService loginService;
    private UserDao userDao;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("roleSelection") RoleSelection roleSelection) {
        String role = roleSelection.getRole();

        switch (role) {
            case "Admin": {
                return "redirect:/admin-login";
            }
            case "User": {
                return "redirect:/user-login";
            }
            default: {
                return "error";
            }
        }
    }

    @GetMapping("/admin-login")
    public String adminLogin(@ModelAttribute("admin") Admin admin) {
        return "admin-login";
    }

    @PostMapping("/admin-login")
    public String adminLogin(
            @Valid @ModelAttribute("admin") Admin admin,
            BindingResult bindingResult,
            ModelMap modelMap,
            HttpServletRequest request,
            @Value("${error.admin.invalidCredentials}") String errorMessage
    ) {
        if (bindingResult.hasErrors()) {
            return "admin-login";
        }

        boolean validAdmin = loginService.validAdmin(admin);

        if (!validAdmin) {
            modelMap.addAttribute("errorMessage", errorMessage);
            return "admin-login";
        }

        request.getSession().setAttribute("admin", admin);
        return "redirect:/admin-home";
    }

    @GetMapping("/user-login")
    public String userLogin(@ModelAttribute("userLogin") UserLogin userLogin) {
        return "user-login";
    }

    @PostMapping("/user-login")
    public String userLogin(
            @Valid @ModelAttribute("userLogin") UserLogin userLogin,
            BindingResult bindingResult,
            ModelMap modelMap,
            HttpServletRequest request,
            @Value("${error.admin.invalidCredentials}") String errorMessage
    ) {
        if (bindingResult.hasErrors()) {
            return "user-login";
        }

        User user = loginService.getValidateUser(userLogin);

        if (user == null) {
            modelMap.addAttribute("errorMessage", errorMessage);
            return "user-login";
        }

        request.getSession().setAttribute("user", user);

        return "redirect:/user-home";
    }

    @GetMapping("/user-registration")
    public String userRegistration(@ModelAttribute("userRegistration") UserRegistration userRegistration) {
        return "user-registration";
    }

    @PostMapping("/user-singup")
    public String userSignup(
            @Valid @ModelAttribute("userRegistration") UserRegistration userRegistration,
            BindingResult bindingResult,
            ModelMap modelMap,
            HttpServletRequest request,
            @Value("${error.user.confirmPassword.notEqual}") String errorMessage
    ) {
        if (bindingResult.hasErrors()) {
            return "user-registration";
        } else if (!userRegistration.getPassword().equals(userRegistration.getConfirmPassword())) {
            modelMap.addAttribute("errorMessage", errorMessage);
            return "user-registration";
        }

        User user = new User();
        user.setName(userRegistration.getName());
        user.setPassword(userRegistration.getPassword());
        user.setEmail(userRegistration.getEmail());
        user.setAddress(userRegistration.getAddress());
        user.setPhone(userRegistration.getPhone());
        user.setSecretQuestion(userRegistration.getSecretQuestion());
        user.setAnswer(userRegistration.getAnswer());

        userDao.save(user);
        request.getSession().setAttribute("user", user);

        return "redirect:/user-home";
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return new RedirectView("/");
    }

    @ModelAttribute("secretQuestions")
    public List<String> secretQuestions(@Value("#{'${user.secretQuestions}'.split(',')}") List<String> secretQuestions) {
        return secretQuestions;
    }
}
