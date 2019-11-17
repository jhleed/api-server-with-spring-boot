package me.jhleed.sample.apiserver.controller.view;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {

    @GetMapping("/hello")
    public String hello() {
        return "hello jongho 안녕 종호;";
    }
}
