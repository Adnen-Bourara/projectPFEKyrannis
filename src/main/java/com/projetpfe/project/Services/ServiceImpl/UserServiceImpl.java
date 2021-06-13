package com.projetpfe.project.Services.ServiceImpl;

import com.projetpfe.project.Entities.User;
import com.projetpfe.project.Repositories.UserRepository;
import com.projetpfe.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserAuth(String userName, String password) {
        return userRepository.findByUsernameAndPassword(userName,password);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User  findSuperAdmin() {
        try{
            User sp = userRepository.findByRole("SuperAdmin").get(0);
            return sp;
        }
        catch (Exception e)
    {
        return null;
    }
    }

    @Override
    public User checkUsername(String userName) {
        try{
        User sp = userRepository.findByUsername(userName);
        return sp;
    }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllClients() {
        return userRepository.findByRole("Client");
    }

    @Override
    public List<User> getAllAdmins() {
        return userRepository.findByRole("Assistant");
    }
    
    @Override
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("doesn't exist");
        }
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getClientByCompanyId(Long id) {
        return userRepository.findByCompany_Id(id);
    }

    @Override
    public List<User> getClientByAssistantd(Long id) {
        return userRepository.findByAssistant_Id(id);
    }
}
