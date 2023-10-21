package org.example.repository;

import org.example.model.Sock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocksRepository extends JpaRepository<Sock,Integer> {
}
