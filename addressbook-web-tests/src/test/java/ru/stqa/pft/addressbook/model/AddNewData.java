package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class AddNewData {
  private String firstName;
  private String lastName;
  private String nickName;
  private String homePhone;
  private String mobilePhone;
  private String emailAdress;
  private String group;
  private int id = Integer.MAX_VALUE;


  public int getId() {
    return id;
  }

  public AddNewData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public AddNewData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public AddNewData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public AddNewData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public AddNewData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public AddNewData withEmailAdress(String emailAdress) {
    this.emailAdress = emailAdress;
    return this;
  }

  public AddNewData withGroup(String group) {
    this.group = group;
    return this;
  }

  public AddNewData withid(int id) {
    this.id = id;
    return this;
  }


  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getEmailAdress() {
    return emailAdress;
  }

  public String getFirstName() {
    return firstName;
  }


  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "AddNewData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", id='" + id + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AddNewData that = (AddNewData) o;
    return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}
