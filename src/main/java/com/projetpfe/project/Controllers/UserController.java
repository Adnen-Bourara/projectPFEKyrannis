package com.projetpfe.project.Controllers;

import com.projetpfe.project.Entities.Company;
import com.projetpfe.project.Entities.User;
import com.projetpfe.project.Services.CompanyService;
import com.projetpfe.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;




    @PostMapping("/login")
    public Object login(@RequestBody String[] auth)
    {
        User sp = userService.findSuperAdmin();

        if(sp==null)
        {
            sp = new User("Kyrannis","Kyrannis2021");
            sp.setRole("SuperAdmin");
            userService.addUser(sp);
        }
        try {
            User user = userService.getUserAuth(auth[0], Integer.toString(auth[1].hashCode()));
            String hiddenPassword = "";
            for (int i=0; i<user.getPassword().length(); i++)
                hiddenPassword += '*';
            user.setPassword(hiddenPassword);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
        catch (Exception e )
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }

    }


    @PostMapping("/User/createAssistant")
    public Object saveAdmin(@RequestBody User user)
    {   if(userService.checkUsername(user.getUsername()) != null)
        return ResponseEntity.status(HttpStatus.CREATED).body("username already used");

        user.setPassword(Integer.toString(user.getPassword().hashCode()));
        user.setRole("Assistant");
        user =  userService.addUser(user);
        String hiddenPassword = "";
        for (int i=0; i<user.getPassword().length(); i++)
            hiddenPassword += '*';
        user.setPassword(hiddenPassword);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/User/createClient/Company/{id1}/Assistant/{id2}")
    public Object createClient(@RequestBody User user,@PathVariable("id1") Long id1,@PathVariable("id2") Long id2)
    {
        User assistant = userService.getById(id2);
        user.setAssistant(assistant);
        System.out.println(user.getPassword());
        user.setPassword(Integer.toString(user.getPassword().hashCode()));
        user.setRole("Client");
        Company company = companyService.getById(id1);
        user.setCompany(company);
        user =  userService.addUser(user);
        String hiddenPassword = "";
        for (int i=0; i<user.getPassword().length(); i++)
            hiddenPassword += '*';
        user.setPassword(hiddenPassword);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/User/checkUsername")
    public Object checkUserName(@RequestBody User user)
    {String response = new String();
        User userNameCheck = userService.checkUsername(user.getUsername());
        if (user.getId() != userNameCheck.getId())
            response = "username already used";
        else
            response = "username clean";
        System.out.println(response);
        return response;
    }

    @PutMapping("/User/Edit")
    public Object editUser(@RequestBody User user)
    {

        User oldPassword = userService.getById(user.getId());
        user.setPassword(oldPassword.getPassword());
        user = userService.editUser(user);

        String hiddenPassword = "";
        for (int i=0; i<user.getPassword().length(); i++)
            hiddenPassword += '*';
        user.setPassword(hiddenPassword);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("User/Edit/Company/{id1}/Assistant/{id2}")
    public Object editClient(@RequestBody User user,@PathVariable("id1") Long id1,@PathVariable("id2") Long id2) {


        User assistant = userService.getById(id2);
        user.setAssistant(assistant);

        Company company = companyService.getById(id1);
        user.setCompany(company);

        User oldPassword = userService.getById(user.getId());
        user.setPassword(oldPassword.getPassword());
        user = userService.editUser(user);

        String hiddenPassword = "";
        for (int i = 0; i < user.getPassword().length(); i++)
            hiddenPassword += '*';
        user.setPassword(hiddenPassword);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/User/ChangePassword/{id]")
    public Object editUser(@RequestBody String newpassword,@PathVariable Long id)
    {

        User user = userService.getById(id);
        user.setPassword(Integer.toString(newpassword.hashCode()));
        user = userService.editUser(user);

        String hiddenPassword = "";
        for (int i=0; i<user.getPassword().length(); i++)
            hiddenPassword += '*';
        user.setPassword(hiddenPassword);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/User/GetById/{id}")
    public Object getById(@PathVariable Long id)
    {
        User user = userService.getById(id);
        String hiddenPassword = "";
        for (int i=0; i<user.getPassword().length(); i++)
            hiddenPassword += '*';
        user.setPassword(hiddenPassword);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/User/GetAllClients")
    public Object getAllClient()
    {
        List<User> userList = userService.getAllClients();
        for (User user : userList) {
            String hiddenPassword = "";
            for (int i=0; i<user.getPassword().length(); i++)
                hiddenPassword += '*';
            user.setPassword(hiddenPassword);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userList);
    }

    @GetMapping("/User/GetAllAssistants")
    public Object getAllAdmins()
    {
        List<User> userList = userService.getAllAdmins();
        for (User user : userList) {
            String hiddenPassword = "";
            for (int i=0; i<user.getPassword().length(); i++)
                hiddenPassword += '*';
            user.setPassword(hiddenPassword);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userList);
    }

    @GetMapping("/User/getClients/Company/{id}")
    public Object getClientsByCompany(@PathVariable Long id)
    {
        List<User> userList = userService.getClientByCompanyId(id);
        for (User user : userList) {
            String hiddenPassword = "";
            for (int i=0; i<user.getPassword().length(); i++)
                hiddenPassword += '*';
            user.setPassword(hiddenPassword);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userList);
    }

    @GetMapping("/User/getClients/Assistant/{id}")
    public Object getClientsByAssistant(@PathVariable Long id)
    {
        List<User> userList = userService.getClientByAssistantd(id);
        for (User user : userList) {
            String hiddenPassword = "";
            for (int i=0; i<user.getPassword().length(); i++)
                hiddenPassword += '*';
            user.setPassword(hiddenPassword);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userList);
    }


    @DeleteMapping("/User/delete/{id}")
    public Object deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);

    }




}
