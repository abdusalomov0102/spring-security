package uz.security.security01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Developed by Jaxongir Abdusalomov
 * Date : 20.06.2022
 * Time : 17:41
 * Project Name : security01
 */

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/courses")
    public String getCourses() {
        return "courses";
    }

}
