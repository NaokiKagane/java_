package ru.stqa.pft.addressbook.model;

public class AddNewData {
  private final String lastName;
  private final String nickName;
  private final String homePhone;
  private final String mobilePhone;
  private final String emailAdress;
  private final String firstName;

  public AddNewData(String lastName, String nickName, String homePhone, String mobilePhone, String emailAdress, String firstName) {
    this.lastName = lastName;
    this.nickName = nickName;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.emailAdress = emailAdress;
    this.firstName = firstName;
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
}
