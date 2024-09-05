package com.example.productservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class SampleController {
    @GetMapping("/{name}/{city}")
    public String sayHello(@PathVariable("name") String name, @PathVariable String city) {
        return "Hello" + " " + name + " " + city;
    }

    @GetMapping("/1/{name}/{number}")
    public String sayHello1(@PathVariable("name") String name, @PathVariable("number") int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= number; i++) {
            sb.append("Hello" + name);
        }
        return sb.toString();
    }
}
       // return "Hello" + " "+name +" " +city;


