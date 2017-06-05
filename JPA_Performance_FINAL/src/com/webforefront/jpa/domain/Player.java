package com.webforefront.jpa.domain;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="Master")
public class Player {

    @Id
    @GeneratedValue
    @Column(name = "lahmanID")
    private long id;
    @Column(name = "nameFirst")
    private String firstName;
    @Column(name = "nameLast")
    private String lastName;

    public Player(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Player() {
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(long id) {
        this.id = id;
    }
 
    public long getId() {
        return id;
    }
}
