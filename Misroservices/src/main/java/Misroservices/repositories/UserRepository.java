package Misroservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Misroservices.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
