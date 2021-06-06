package com.projetpfe.project.Services.ServiceImpl;

import com.projetpfe.project.Entities.Message;
import com.projetpfe.project.Repositories.MessageRepository;
import com.projetpfe.project.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getConversation(Long user1Id, Long user2Id) {
        return messageRepository.findBySender_IdAndReceiverId(user1Id, user2Id);
    }

    @Override
    public List<Message> getSentMessages(Long userId) {
        return messageRepository.findBySender_Id(userId);
    }

    @Override
    public List<Message> getReceivedMessages(Long userId) {
        return messageRepository.findByReceiverId(userId);
    }
}
