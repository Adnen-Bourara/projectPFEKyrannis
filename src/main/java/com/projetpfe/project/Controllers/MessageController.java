package com.projetpfe.project.Controllers;

import com.projetpfe.project.Entities.Message;
import com.projetpfe.project.Entities.User;
import com.projetpfe.project.Services.MessageService;
import com.projetpfe.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @PostMapping("/Message/Sender/{id1}/Receiver/{id2}")
    public Object sendMessage(@RequestBody Message message , @PathVariable("id1") Long id1, @PathVariable("id2") Long id2)
    {
        User sender = userService.getById(id1);
        User receiver = userService.getById(id2);
        message.setSender(sender);
        message.setReceiver(receiver);
        message = messageService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping("/Message/getConversation/user1/{id1}/user2/{id2}")
    public Object getConversations(@PathVariable("id1") Long id1,@PathVariable("id2") Long id2)
    {
        List<Message> messageList = messageService.getConversation(id1, id2);
        return ResponseEntity.status(HttpStatus.CREATED).body(messageList);
    }

    @GetMapping("/Message/getListConversation/{iduser}")
    public Object getListConversation(@PathVariable Long id)
    {
        List<Message> messagesReceived = messageService.getReceivedMessages(id);
        List<Message> messagesSent = messageService.getSentMessages(id);

        List<User> listSenders = messagesReceived.stream().map(a-> a.getSender()).distinct().collect(Collectors.toList());
        List<User> listReceivers = messagesSent.stream().map(a-> a.getSender()).distinct().collect(Collectors.toList());

//        messagesReceived = messagesReceived.stream().sorted(Comparator.comparing(Message::getDateEnvoie)).collect(Collectors.toList());
//        messagesSent = messagesSent.stream().sorted(Comparator.comparing(Message::getDateEnvoie)).collect(Collectors.toList());
        List<User> listConversation = new ArrayList<>();
        listConversation.addAll(listSenders);
        listConversation.addAll(listReceivers);
        listConversation = listConversation.stream().distinct().collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(listConversation);
//    

    }
}
