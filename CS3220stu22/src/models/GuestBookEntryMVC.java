package models;

import java.util.Date;

public class GuestBookEntryMVC {

  private static int count = 0;

  int id;
  String name;
  String message;
  Date date;

  public GuestBookEntryMVC(String name, String message) {
    super();
    this.name = name;
    this.message = message;
    this.id = count++;
    date = new Date();
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

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


}
