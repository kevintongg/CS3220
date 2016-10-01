package homework;

public class User {

  int id;
  String firstName,lastName;
  String email;
  String password;

  public User(String firstName, String lastName, String email, String password, int count) {
    this.id = count++;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }
}
