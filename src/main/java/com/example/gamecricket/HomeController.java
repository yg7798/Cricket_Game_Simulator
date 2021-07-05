package com.example.gamecricket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class HomeController {

    @GetMapping("/")
    public String homePage()
    {
        return "YASH ";
    }

}
