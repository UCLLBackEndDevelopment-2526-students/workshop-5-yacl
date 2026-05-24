package be.ucll.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Bio is required.")
    private String bio;

    @NotBlank(message = "Location is required.")
    private String location;

    @NotBlank(message = "Interests are required.")
    private String interests;

    public Profile(String bio, String location, String interests) {
        this.bio = bio;
        this.location = location;
        this.interests = interests;
    }

    protected Profile() {}

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getInterests() { return interests; }
    public void setInterests(String interests) { this.interests = interests; }
}