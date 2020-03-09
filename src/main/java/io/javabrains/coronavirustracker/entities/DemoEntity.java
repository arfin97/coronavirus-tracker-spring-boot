package io.javabrains.coronavirustracker.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DemoEntity {
    @Id
    @GeneratedValue
    public long id;
}
