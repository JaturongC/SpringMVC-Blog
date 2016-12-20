package blog.jaturong.controller;

import blog.jaturong.forms.LoginForm;
import blog.jaturong.services.NotificationService;
import blog.jaturong.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping(value = "/users/login")
    public String login(@Valid LoginForm loginForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/login";
        }

        if(!userService.authenticate(loginForm.getUsername(), loginForm.getPassword())) {
            notifyService.addErrorMessage("Invalid login!");
            return "users/login";
        }

        notifyService.addInfoMessage("Login successful");
        return "redirect:/";
    }
}
