package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class SumController {

    @GetMapping("/sum")
    public int sum(@RequestParam int a, @RequestParam int b) {
        return App.sum(a, b);
    }
}
