import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Simple Student entity/POJO.
 * Save as: src/main/java/entity/java/Student.java
 */
public class Student implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private LocalDate dateOfBirth;

  public Student() {
  }

  public Student(Long id, String firstName, String lastName, String email, LocalDate dateOfBirth) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
  }

  public Student(String firstName, String lastName, String email, LocalDate dateOfBirth) {
    this(null, firstName, lastName, email, dateOfBirth);
  }

  public Long getId() {
    return id;
  }

  public Student setId(Long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Student setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Student setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Student setEmail(String email) {
    this.email = email;
    return this;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public Student setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Returns the age in years calculated from dateOfBirth, or null if dateOfBirth
   * is null.
   */
  public Integer getAge() {
    if (dateOfBirth == null)
      return null;
    return Period.between(dateOfBirth, LocalDate.now()).getYears();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Student student = (Student) o;
    // if id is present use it for identity, otherwise compare important fields
    if (id != null && student.id != null) {
      return Objects.equals(id, student.id);
    }
    return Objects.equals(firstName, student.firstName) &&
        Objects.equals(lastName, student.lastName) &&
        Objects.equals(email, student.email) &&
        Objects.equals(dateOfBirth, student.dateOfBirth);
  }

  @Override
  public int hashCode() {
    if (id != null)
      return Objects.hash(id);
    return Objects.hash(firstName, lastName, email, dateOfBirth);
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", dateOfBirth=" + dateOfBirth +
        '}';
  }
}