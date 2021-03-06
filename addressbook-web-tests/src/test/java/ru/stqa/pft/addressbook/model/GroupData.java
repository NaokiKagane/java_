package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {

  private String name;
  private String header;
  private String footer;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id && Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  private int id = Integer.MAX_VALUE;

  public GroupData whitName(String name) {
    this.name = name;
    return this;
  }

  public GroupData whitHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData whitFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public GroupData whitId(int id) {
    this.id = id;
    return this;
  }


  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }
}
