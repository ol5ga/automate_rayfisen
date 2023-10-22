package org.example.repository;

import org.example.model.Sock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SocksRepository extends JpaRepository<Sock,Integer> {
    Sock findByColorAndCottonPart(String color, int cottonPart);

    List<Sock> findAllByColorAndCottonPartGreaterThan(String color, int cottonPart);

    List<Sock> findAllByColorAndCottonPartLessThan(String color, int cottonPart);

}
