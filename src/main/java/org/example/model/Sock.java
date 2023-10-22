package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "socks")
@Setter
@Getter
public class Sock {

    @Id
    @GeneratedValue
    int id;
    @Column(name = "color", nullable = false)
    String color;
    @Column(name="cotton_part")
    int cottonPart;
    @Column(name="quantity")
    int quantity;
}
