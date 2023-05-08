package Tut2_3_4.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

@Entity(name = "company")
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @Length(min = 3, max = 30, message = "Name should be about 3-30 characters.")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "address", nullable = false)
    @Length(min = 5, max = 50, message = "Name should be about 5-50 characters.")
    private String address;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImagePath() {
        if (getImage() == null || getId() == null) return null;
        return "comp_images/" + getId() + "/" + getImage();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
