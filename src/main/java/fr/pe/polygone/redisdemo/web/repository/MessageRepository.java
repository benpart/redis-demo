package fr.pe.polygone.redisdemo.web.repository;

import fr.pe.polygone.redisdemo.web.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, String> {

    Message findByTexte(String texte);

}