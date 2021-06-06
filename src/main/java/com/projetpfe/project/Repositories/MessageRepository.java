package com.projetpfe.project.Repositories;

import com.projetpfe.project.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findBySender_Id(Long id);
    List<Message> findByReceiverId(Long id);
    List<Message> findBySender_IdAndReceiverId(Long id1,Long id2);
}
