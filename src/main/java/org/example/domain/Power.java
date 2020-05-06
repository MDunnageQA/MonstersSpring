package org.example.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Integer dangerLevel;

    @OneToMany(mappedBy = "power", fetch = FetchType.LAZY)
    private List<Monsters> monsters = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(Integer dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Power power = (Power) o;
        return Objects.equals(id, power.id) &&
                Objects.equals(name, power.name) &&
                Objects.equals(description, power.description) &&
                Objects.equals(dangerLevel, power.dangerLevel) &&
                Objects.equals(monsters, power.monsters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dangerLevel, monsters);
    }
}
