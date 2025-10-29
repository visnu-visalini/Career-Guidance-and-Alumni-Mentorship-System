import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Simple Mentor entity.
 * Save as Mentor.java
 */
public class Mentor implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private final List<String> expertise = new ArrayList<>();
  private boolean active = true;

  public Mentor() {
  }

  public Mentor(Long id, String firstName, String lastName, String email, String phone, List<String> expertise,
      boolean active) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    if (expertise != null) {
      this.expertise.addAll(expertise);
    }
    this.active = active;
  }

  // Convenience constructor
  public Mentor(Long id, String firstName, String lastName, String email) {
    this(id, firstName, lastName, email, null, null, true);
  }

  public Long getId() {
    return id;
  }

  public Mentor setId(Long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Mentor setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Mentor setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Mentor setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public Mentor setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public List<String> getExpertise() {
    return new ArrayList<>(expertise);
  }

  public Mentor addExpertise(String area) {
    if (area != null && !area.trim().isEmpty()) {
      this.expertise.add(area.trim());
    }
    return this;
  }

  public Mentor removeExpertise(String area) {
    this.expertise.remove(area);
    return this;
  }

  public boolean isActive() {
    return active;
  }

  public Mentor setActive(boolean active) {
    this.active = active;
    return this;
  }

  public String getFullName() {
    StringBuilder sb = new StringBuilder();
    if (firstName != null)
      sb.append(firstName);
    if (lastName != null) {
      if (sb.length() > 0)
        sb.append(' ');
      sb.append(lastName);
    }
    return sb.toString();
  }

  @Override
  public String toString() {
    return "Mentor{" +
        "id=" + id +
        ", name='" + getFullName() + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", expertise=" + expertise +
        ", active=" + active +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Mentor mentor = (Mentor) o;
    // If id is set, use it as primary identifier
    if (id != null && mentor.id != null) {
      return Objects.equals(id, mentor.id);
    }
    return Objects.equals(firstName, mentor.firstName) &&
        Objects.equals(lastName, mentor.lastName) &&
        Objects.equals(email, mentor.email);
  }

  @Override
  public int hashCode() {
    if (id != null)
      return Objects.hash(id);
    return Objects.hash(firstName, lastName, email);
  }
}