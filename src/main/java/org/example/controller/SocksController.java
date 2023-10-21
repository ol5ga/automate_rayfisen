package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.SocksDto;
import org.example.model.Sock;
import org.example.service.SocksService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/socks")
@AllArgsConstructor
public class SocksController {

    SocksService service;

    @PostMapping("/income")
    public Sock incomeSocks(@RequestBody SocksDto income){
        return service.incomeSocks(income);
    }

    @PostMapping("/outcome")
    public Sock outcomeSocks(@RequestBody SocksDto outcome){
        return service.outcomeSocks(outcome);
    }

    @GetMapping
    public int getQuantity(@RequestParam String color, @RequestParam String operation,@RequestParam int cottonPart){
        return service.getQuantity(color,operation,cottonPart);
    }

}
