package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "socks")
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
