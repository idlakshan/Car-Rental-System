package lk.ijse.spring.repo;

import lk.ijse.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,String> {

    boolean existsUserByUserName(String userName);

    @Query(value = "SELECT COUNT(userId) AS NumberOfUsers FROM user", nativeQuery = true)
    int getRowCount();

    @Query(value = "SELECT userId FROM user ORDER BY userId DESC LIMIT 1", nativeQuery = true)
    String getLastId();
}
