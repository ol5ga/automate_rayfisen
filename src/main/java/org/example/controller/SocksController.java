package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.dto.SocksDto;
import org.example.model.Operation;
import org.example.model.Sock;
import org.example.service.SocksService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/socks")
@AllArgsConstructor
public class SocksController {

    private SocksService service;

    @PostMapping("/income")
    @ResponseStatus(code = HttpStatus.OK)
    public Sock incomeSocks(@RequestBody SocksDto income){

        return service.incomeSocks(income);
    }

    @PostMapping("/outcome")
    public Sock outcomeSocks(@RequestBody SocksDto outcome){
        return service.outcomeSocks(outcome);
    }

    @GetMapping
    public int getQuantity(@RequestParam String color, @RequestParam Operation operation, @RequestParam int cottonPart){
        return service.getQuantity(color,operation,cottonPart);
    }

    @GetMapping("/one")
    public Sock get(){

        return service.getById(1);
    }
}
