package be.ucll.unit.repository;

import be.ucll.model.User;
import be.ucll.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.function.Function;

public class UserRepositoryStub implements UserRepository {
    public List<User> users;

    public UserRepositoryStub() {
        users = new ArrayList<>(List.of(
                new User("John Doe", 25, "john.doe@ucll.be", "john1234"),
                new User("Jane Toe", 30, "jane.toe@ucll.be", "jane1234"),
                new User("Jack Doe", 5, "jack.doe@ucll.be", "jack1234"),
                new User("Sarah Doe", 4, "sarah.doe@ucll.be", "sarah1234"),
                new User("Birgit Doe", 18, "birgit.doe@ucll.be", "birgit1234")
        ));
    }

    @Override
    public List<User> findAll() { return users; }

    @Override
    public <S extends User> S save(S user) {
        users.add(user);
        return user;
    }

    @Override
    public void delete(User user) {
        users.removeIf(u -> u.getEmail().equals(user.getEmail()));
    }

    @Override
    public boolean existsByEmail(String email) {
        return users.stream().anyMatch(u -> u.getEmail().equals(email));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }

    @Override
    public List<User> findByAgeGreaterThan(int age) {
        return users.stream().filter(u -> u.getAge() > age).toList();
    }

    @Override
    public List<User> findByAgeBetween(int min, int max) {
        return users.stream().filter(u -> u.getAge() >= min && u.getAge() <= max).toList();
    }

    @Override
    public List<User> findByName(String name) {
        return users.stream().filter(u -> u.getName().equals(name)).toList();
    }

    @Override
    public List<User> findAllByOrderByAgeDesc() {
        return users.stream().sorted(Comparator.comparingInt(User::getAge).reversed()).toList();
    }

    @Override
    public List<User> findByNameContainingAndAgeGreaterThan(String chars, int age) {
        return users.stream()
                .filter(u -> u.getName().contains(chars) && u.getAge() > age)
                .toList();
    }

    @Override
    public List<User> findByProfileInterestsContainingIgnoreCaseOrderByProfileLocationAsc(String interest) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findByAgeGreaterThanAndProfileInterestsContainingIgnoreCaseOrderByProfileLocationAsc(int age, String interest) {
        throw new UnsupportedOperationException();
    }

    // -- Alle JPA-methoden die je niet gebruikt: laat de UnsupportedOperationException staan --
    @Override public void flush() { throw new UnsupportedOperationException(); }
    @Override public <S extends User> S saveAndFlush(S entity) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) { throw new UnsupportedOperationException(); }
    @Override public void deleteAllInBatch(Iterable<User> entities) { throw new UnsupportedOperationException(); }
    @Override public void deleteAllByIdInBatch(Iterable<Long> longs) { throw new UnsupportedOperationException(); }
    @Override public void deleteAllInBatch() { throw new UnsupportedOperationException(); }
    @Override public User getOne(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public User getById(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public User getReferenceById(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> Optional<S> findOne(Example<S> example) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> List<S> findAll(Example<S> example) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> List<S> findAll(Example<S> example, Sort sort) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> long count(Example<S> example) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> boolean exists(Example<S> example) { throw new UnsupportedOperationException(); }
    @Override public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) { throw new UnsupportedOperationException(); }
    @Override public <S extends User> List<S> saveAll(Iterable<S> entities) { throw new UnsupportedOperationException(); }
    @Override public Optional<User> findById(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public boolean existsById(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public List<User> findAllById(Iterable<Long> longs) { throw new UnsupportedOperationException(); }
    @Override public long count() { throw new UnsupportedOperationException(); }
    @Override public void deleteById(Long aLong) { throw new UnsupportedOperationException(); }
    @Override public void deleteAll(Iterable<? extends User> entities) { throw new UnsupportedOperationException(); }
    @Override public void deleteAll() { throw new UnsupportedOperationException(); }
    @Override public List<User> findAll(Sort sort) { throw new UnsupportedOperationException(); }
    @Override public Page<User> findAll(Pageable pageable) { throw new UnsupportedOperationException(); }
    @Override public void deleteAllById(Iterable<? extends Long> longs) { throw new UnsupportedOperationException(); }
    @Override public Optional<User> findFirstByOrderByAgeDesc() { throw new UnsupportedOperationException(); }


}
