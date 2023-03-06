package br.com.letscode.zoo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="animal")
@Getter
@Setter
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String uid;

    private String name;

    private int age;
}
