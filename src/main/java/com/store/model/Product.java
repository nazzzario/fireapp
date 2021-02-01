package com.store.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // todo fix price type
    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int amount;

    @Column(name = "photo_link", nullable = false)
    private String photoLink;
}
