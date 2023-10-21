package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.SocksDto;
import org.example.model.Sock;
import org.example.repository.SocksRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SocksService {

    SocksRepository repository;

    public Sock incomeSocks(SocksDto income) {
        return null;
    }

    public Sock outcomeSocks(SocksDto outcome) {
        return null;
    }

    public int getQuantity(String color, String operation, int cottonPart) {
        return 0;
    }
}
