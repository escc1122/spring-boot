package com.example.demo.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/thymeleaf")
public class HelloWorldController {
    @GetMapping("/index")
    public String viewTest(HttpServletRequest request,Model model){
        String key = request.getParameter("key");
        model.addAttribute("key",key);
        return "hello_world";
    }

    @GetMapping("/index2")
    public String viewTest2(HttpServletRequest request){
        String key = request.getParameter("key");
        request.setAttribute("key",key);
//        System.out.println(key);
//        model.addAttribute("key",key);
        return "hello_world";
    }
}
