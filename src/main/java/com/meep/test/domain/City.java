package com.meep.test.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class City {
    @Id
    String id;
    String name;
    @ManyToMany
    private List<Company> companies;
    @OneToMany
    private List<Location> locations;

}
