package org.example.dto;

import java.util.List;

public class PowerDTO {

    private Long id;
    private String name;
    private String description;
    private Integer dangerLevel;
    private List<MonsterDTO> monsters;

    public PowerDTO(){
    }

    public PowerDTO(String name, String description, Integer dangerLevel, List<MonsterDTO> monsters){
        super();
        this.name = name;
        this.description = description;
        this.dangerLevel = dangerLevel;
        this.monsters = monsters;
    }

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

    public List<MonsterDTO> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<MonsterDTO> monsters) {
        this.monsters = monsters;
    }
}
