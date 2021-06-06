package com.projetpfe.project.Repositories;

import com.projetpfe.project.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
    List<User> findByRole(String role);
    List<User> findByCompany_Id(Long id);
    List<User> findByAssistant_Id(Long id);
    User findByUsername(String username);
}
