package Tut2_3_4_5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "employee")
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @Length(min = 2, max = 30, message = "Name should be about 2-30 characters.")
    private String name;

    @Column(name = "email")
    @NotEmpty(message = "Email should not be empty.")
    @Email(message = "Invalid email.")
    private String email;

    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "[0-9]{10}", message = "Invalid phone number.")
    private String phone;

    @Column(name = "age", nullable = false)
    @Min(value = 18, message = "Age should not be less than 18.")
    @Max(value = 55, message = "Age should not be greater than 55.")
    private int age;

    @Column(name = "image", length = 255, nullable = true)
    private String image;

    @Column(name = "address", nullable = false)
    @NotEmpty(message = "Address not found!")
    private String address;

    @ManyToOne
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "employees_jobs",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private Set<Job> jobs = new HashSet<>();

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImagePath() {
        if (getImage() == null || getId() == null) return null;
        return "emp_images/" + getId() + "/" + getImage();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }
}
