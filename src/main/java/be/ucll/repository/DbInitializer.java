package be.ucll.repository;

import be.ucll.model.Profile;
import be.ucll.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {

    private UserRepository userRepository;

    public DbInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private ProfileRepository profileRepository;

    @PostConstruct
    public void initialize() {
        Profile profileJohn = profileRepository.save(new Profile("Student", "Antwerp", "Amazing science"));
        Profile profileJane = profileRepository.save(new Profile("Architect", "Leuven", "Sleeping"));
        Profile profileBirgit = profileRepository.save(new Profile("Java Programmer", "Hasselt", "Walking in the forest, Science"));

        userRepository.save(new User("John Doe", 25, "john.doe@ucll.be", "john1234", profileJohn));
        userRepository.save(new User("Jane Toe", 30, "jane.toe@ucll.be", "jane1234", profileJane));
        userRepository.save(new User("Birgit Doe", 18, "birgit.doe@ucll.be", "birgit1234", profileBirgit));

    }
}
