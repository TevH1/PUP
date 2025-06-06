package com.puppyshop.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Puppy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String breed;
    private BigDecimal priceUsd;
    private LocalDate birthDate;
    private String sex;               // consider enum later

    /* ---- getters & setters ---- */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public BigDecimal getPriceUsd() { return priceUsd; }
    public void setPriceUsd(BigDecimal priceUsd) { this.priceUsd = priceUsd; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
}

