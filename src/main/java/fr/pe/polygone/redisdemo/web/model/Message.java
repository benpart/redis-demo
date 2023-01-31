package fr.pe.polygone.redisdemo.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

@Data
@RedisHash("Message")
@NoArgsConstructor
public class Message {

    @Id
    private String id;

    @Indexed
    private String texte;

    public Message(String texte) {
        this.texte = texte;
    }
}