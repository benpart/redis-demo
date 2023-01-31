package fr.pe.polygone.redisdemo.web.controller;

import fr.pe.polygone.redisdemo.web.model.Message;
import fr.pe.polygone.redisdemo.web.services.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = "/message/save")
    public ResponseEntity<Message> saveMessage(@RequestBody String texte) {
        return ResponseEntity.ok(messageService.createMessage(texte));
    }

    @DeleteMapping(value = "/message/delete")
    public ResponseEntity<String> deleteMessage(@RequestBody String texte) {
        messageService.deleteMessage(texte);
        return ResponseEntity.ok("Message supprimé");
    }

    @GetMapping(value = "/message/get")
    public ResponseEntity<Iterable<Message>> getMessages() {
        return new ResponseEntity<>(messageService.retrieveMessages(), HttpStatus.OK);
    }

}
