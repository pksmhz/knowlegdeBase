package com.example.memleak;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(value = "/doAction")
    public void doAction() {

    }
}
