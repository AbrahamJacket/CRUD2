package com.example.crud2.entity;

import javax.persistence.*;

@Entity
@Table(name = "PLAYERS")
@AttributeOverride(name = "id",column = @Column(name = "player_id"))
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "PLAYER_FIRST_NAME")
    private String firstName;
    @Column(name = "PLAYER_LAST_NAME")
    private String lastName;
    @Column(name = "PLAYER_AGE")
    private Integer Age;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Team getTeam() {
        return team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
