package com.jekainfinity.controllers;

import com.jekainfinity.hibernate.bean.UserBean;
import com.jekainfinity.hibernate.dao.UserDao;
import com.jekainfinity.hibernate.entity.rootsUser.User;
import com.jekainfinity.hibernate.entity.rootsUser.UserRole;
import com.jekainfinity.hibernate.entity.enums.Roles;
import com.jekainfinity.hibernate.service.AuthService;
import com.jekainfinity.hibernate.service.UserService;
import com.jekainfinity.utills.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    AuthService authService;

    @Autowired
    Mapper mapper;

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap){
        modelMap.addAttribute("user", new UserBean());
        return "login";
    }

    @RequestMapping(value = "/successLogin", method = RequestMethod.GET)
    public String success() {
        return "succesedLogin";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user",new User());

        return "registration";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login";
    }

    @RequestMapping(value = "/registration", method = {RequestMethod.POST,RequestMethod.PUT})
    public String registrationUser(@Valid @ModelAttribute("user") User user,BindingResult bindingResult) {
        user.setPassword(new BCryptPasswordEncoder().encode( user.getPassword()));
        authService.registerUser(mapper.convertToUserBean(user));

        return "createdSuccess";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model,  Principal principal) {
        String username = principal.getName();
        User user = userDao.findByUserName(username);
        Set<UserRole> roles =  user.getUserRole();

        model.addAttribute("user", userDao.findByUserName(username));
        for (UserRole userRole: roles) {
            if (userRole.getRole().equals(Roles.ROLE_USER)) {
                return "user/dashboard";
            }
        }
        return "dashboard";
    }

}
