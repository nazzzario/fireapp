package com.store.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "person_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "order_description")
    private String orderDescription;

}
