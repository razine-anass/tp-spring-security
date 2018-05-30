package org.opendevup.Dao;

import org.opendevup.entitee.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

}
