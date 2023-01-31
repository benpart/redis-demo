package fr.pe.polygone.redisdemo.web.services;

import fr.pe.polygone.redisdemo.web.model.Message;
import fr.pe.polygone.redisdemo.web.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {


    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(String texte) {
        return messageRepository.save(new Message(texte));
    }

    public void deleteMessage(String texte) {
        Message message = messageRepository.findByTexte(texte);
        messageRepository.deleteById(message.getId());
    }

    public Iterable<Message> retrieveMessages() {
        return messageRepository.findAll();
    }


}