package apap.tutorial.emsidi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import apap.tutorial.emsidi.model.UserModel;
import org.springframework.stereotype.Repository;

public interface UserDb extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    UserModel findByEmail(String email);
}
