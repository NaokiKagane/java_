package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<AddNewData> {

  private Set<AddNewData> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<AddNewData>(contacts.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<AddNewData>();
  }

  @Override
  protected Set<AddNewData> delegate() {
    return delegate;
  }
  public Contacts withAdded (AddNewData contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }
  public Contacts without (AddNewData contact) {
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }
}
