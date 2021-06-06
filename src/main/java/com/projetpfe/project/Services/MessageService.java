package com.projetpfe.project.Services;

import com.projetpfe.project.Entities.Message;
import com.projetpfe.project.Entities.User;

import java.util.List;

public interface MessageService {
    Message sendMessage(Message message);
    List<Message> getConversation(Long user1Id,Long user2Id);
    List<Message> getSentMessages(Long userId);
    List<Message> getReceivedMessages(Long userId);

}
