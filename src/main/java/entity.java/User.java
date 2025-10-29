public class User {
  private int userId;
  private String username;
  private String email;
  private String password;
  private String phoneNumber;

  // Default constructor
  public User() {
  }

  // Parameterized constructor
  public User(int userId, String username, String email, String password, String phoneNumber) {
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
  }

  // Getters and Setters
  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}