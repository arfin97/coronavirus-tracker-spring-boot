package io.javabrains.coronavirustracker.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Greetings {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String message;

    public Greetings(String message) {
        this.message = message;
    }
}
