package smartLamp.smartLampspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TextController {
    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("/hello")
    public String helloWorld(Model model){
        model.addAttribute("data", "hello, world!!");
        return "hello";
    }
}
