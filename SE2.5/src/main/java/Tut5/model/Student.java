package Tut5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity(name = "student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @Length(min = 2, max = 30, message = "Name should be about 2-30 characters.")
    private String name;

    @Column(name = "age", nullable = false)
    @Min(value = 6, message = "Age should not be less than 6.")
    @Max(value = 60, message = "Age should not be greater than 60.")
    private int age;
}
