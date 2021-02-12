package com.store.model;

import com.store.model.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Column(nullable = false)
    private String password;

    private Boolean active;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "product")
    private Set<Order> orders;

    @PrePersist
    public void prePersist(){
        active = false;
    }

}
