package com.meep.test.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Data
public class Company {
    @Id
    String id;
    String name;
    @ManyToMany
    private List<City> cities;

}
