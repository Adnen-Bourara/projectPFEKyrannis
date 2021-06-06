package com.projetpfe.project.Services;


import com.projetpfe.project.Entities.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User getUserAuth(String userName, String password);
    User editUser(User user);
    User findSuperAdmin();
    User checkUsername(String userName);
    List<User> getAllClients();
    List<User> getAllAdmins();
    void deleteUser(Long id);
    User getById(Long id);
    List<User> getClientByCompanyId(Long id);
    List<User> getClientByAssistantd(Long id);
}
