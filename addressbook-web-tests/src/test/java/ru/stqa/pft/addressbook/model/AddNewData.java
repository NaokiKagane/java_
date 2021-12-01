package ru.stqa.pft.addressbook.model;

public class AddNewData {
  private String firstName;
  private String lastName;
  private String nickName;
  private String homePhone;
  private String mobilePhone;
  private String emailAdress;
  private String group;

  public AddNewData(String firstName, String lastName, String nickName, String homePhone, String mobilePhone, String emailAdress, String group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.emailAdress = emailAdress;
    this.group = group;
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
}
