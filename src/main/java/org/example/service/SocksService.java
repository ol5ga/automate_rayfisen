package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.StorageException;
import org.example.dto.SocksDto;
import org.example.model.Operation;
import org.example.model.Sock;
import org.example.repository.SocksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;

@Service
@AllArgsConstructor
public class SocksService {

    private SocksRepository repository;
    private ModelMapper mapper;


    public Sock incomeSocks(SocksDto income) {
        Sock inDb = repository.findByColorAndCottonPart(income.getColor(), income.getCottonPart());
        if(inDb != null) {
            inDb.setQuantity(inDb.getQuantity() + income.getQuantity());
        } else {
            inDb = mapper.map(income, Sock.class);
        }
        return repository.save(inDb);
    }

    public Sock outcomeSocks(SocksDto outcome) {
        Sock inDb = repository.findByColorAndCottonPart(outcome.getColor(), outcome.getCottonPart());
        if (inDb != null) {
            inDb.setQuantity(inDb.getQuantity() - outcome.getQuantity());
        } else {
            throw new StorageException("Таких носков нет на складе");
        }
        return repository.save(inDb);
    }

    public int getQuantity(String color, Operation operation, int cottonPart) {
        int value = 0;
        if (operation == Operation.equal) {
            Sock inDb;
            try {
            inDb = repository.findByColorAndCottonPart(color, cottonPart);
            } catch (NullPointerException ex) {
                throw new StorageException("Таких носков нет на складе");
            }
            value = inDb.getQuantity();
        } else if (operation == Operation.lessThan) {
            List<Sock> sockList;
            try {
            sockList = repository.findAllByColorAndCottonPartLessThan(color, cottonPart);
            } catch (NullPointerException ex) {
                throw new StorageException("Таких носков нет на складе");
            }
            for (Sock sock : sockList) {
                value = value + sock.getQuantity();
            }
        } else if (operation == Operation.moreThan) {
            List<Sock> sockList;
            try{
                sockList = repository.findAllByColorAndCottonPartGreaterThan(color, cottonPart);
            } catch (NullPointerException ex) {
                throw new StorageException("Таких носков нет на складе");
            }

            for (Sock sock : sockList) {
                value = value + sock.getQuantity();
            }
        } return value;
    }

    public Sock getById(int id) {
        return Sock.builder()
                .color("red")
                .cottonPart(15)
                .quantity(10)
                .build();
    }
}
