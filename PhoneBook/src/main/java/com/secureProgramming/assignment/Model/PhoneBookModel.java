package com.secureProgramming.assignment.Model;


import javax.persistence.*;
@Entity
@Table(name="phonebook")
public class PhoneBookModel {

  @Id
  private int id;

  @Column(nullable = false)
  private String name = null;

  @Column(nullable = false)
  private String number;

  public PhoneBookModel name(String name) {
    this.name = name;
    return this;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

    public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

}
