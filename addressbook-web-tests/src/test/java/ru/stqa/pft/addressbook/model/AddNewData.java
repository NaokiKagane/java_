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
  private int id;


  public int getId() {
    return id;
  }

  public AddNewData(String firstName, String lastName, String nickName, String homePhone, String mobilePhone, String emailAdress, String group, int id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.emailAdress = emailAdress;
    this.group = group;
    this.id = id;
  }

  public AddNewData(String firstName, String lastName, String nickName, String homePhone, String mobilePhone, String emailAdress, String group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.emailAdress = emailAdress;
    this.group = group;
    this.id = Integer.MAX_VALUE;
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

  public void setId(int id) {
    this.id = id;
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
