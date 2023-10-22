package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.SocksDto;
import org.example.model.Operation;
import org.example.model.Sock;
import org.example.repository.SocksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SocksService {

    SocksRepository repository;

    public Sock incomeSocks(SocksDto income) {
        Sock inDb = repository.findByColorAndCottonPart(income.getColor(), income.getCottonPart());
        inDb.setQuantity(inDb.getQuantity() + income.getQuantity());
        return repository.save(inDb);
    }

    public Sock outcomeSocks(SocksDto outcome) {
        Sock inDb = repository.findByColorAndCottonPart(outcome.getColor(), outcome.getCottonPart());
        inDb.setQuantity(inDb.getQuantity() - outcome.getQuantity());
        return repository.save(inDb);
    }

    public int getQuantity(String color, Operation operation, int cottonPart) {
        int value = 0;
        if (operation == Operation.equal) {
            Sock inDb = repository.findByColorAndCottonPart(color, cottonPart);
            value = inDb.getQuantity();
        } else if (operation == Operation.lessThan) {
            List<Sock> sockList = repository.findAllByColorAndCottonPartLessThan(color, cottonPart);
            for (Sock sock : sockList) {
                value = value + sock.getQuantity();
            }
        } else if (operation == Operation.moreThan) {
            List<Sock> sockList = repository.findAllByColorAndCottonPartGreaterThan(color, cottonPart);

            for (Sock sock : sockList) {
                value = value + sock.getQuantity();
            }
        } return value;
    }
}
