package com.chenhao.contrlooer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {
    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id){
        System.out.println("id====>"+id);

        return "hello spring boot!";
    }

}
