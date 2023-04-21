package smartLamp.smartLampspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import smartLamp.smartLampspring.model.User;

import java.util.HashMap;
import java.util.Map;


@RestController
public class TextController {

    @GetMapping("/")
    public String hello(Model model){
        System.out.println("test");
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("/hello")
    public String helloWorld(Model model){
        model.addAttribute("data", "hello, world!!");
        return "hello";
    }

//    @PostMapping("/")
//    public void test(@RequestBody HashMap<String, Object> map){
//
//        System.out.println("data:" + map);
//    }

    @PostMapping("/")
    public void test(@RequestBody User map){

        System.out.println("data:" + map.getUsername());
    }
}
