package com.projetpfe.project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String tel;

    private String email;

    private String role ; //superAdmin/Admin/Client

    private String poste; //if Admin

    @JsonIgnore
    @OneToMany(mappedBy = "assistant", cascade = CascadeType.REMOVE )
    private List<User> listClient;

    @ManyToOne
    @JoinColumn(name = "AssistantId")
    private User assistant;

    @ManyToOne
    @JoinColumn(name = "CompanyId")
    private Company company;


    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE )
    private List<Fichier> listFichiers;

    @JsonIgnore
    @OneToMany(mappedBy = "commentor", cascade = CascadeType.REMOVE )
    private List<Commentaire> listCommentaires;

    @JsonIgnore
    @OneToMany(mappedBy = "sender", cascade = CascadeType.REMOVE )
    private List<Message> messagesSent;

    @JsonIgnore
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.REMOVE )
    private List<Message> messagesReceived;


    public User() {
    }

    public User(String u,String p)
    {
        this.username = u;
        this.password = Integer.toString(p.hashCode());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public List<User> getListClient() {
        return listClient;
    }

    public void setListClient(List<User> listClient) {
        this.listClient = listClient;
    }

    public User getAssistant() {
        return assistant;
    }

    public void setAssistant(User assistant) {
        this.assistant = assistant;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Fichier> getListFichiers() {
        return listFichiers;
    }

    public void setListFichiers(List<Fichier> listFichiers) {
        this.listFichiers = listFichiers;
    }

    public List<Commentaire> getListCommentaires() {
        return listCommentaires;
    }

    public void setListCommentaires(List<Commentaire> listCommentaires) {
        this.listCommentaires = listCommentaires;
    }

    public List<Message> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(List<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }

    public List<Message> getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(List<Message> messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
