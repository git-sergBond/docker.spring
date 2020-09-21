package play.spring.docker.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import play.spring.docker.api.ChatApi;
import play.spring.docker.service.ChatService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChatController implements ChatApi {

    ChatService chatService;

    @Override
    public void sendMessage(String author, String message) {
        chatService.sendMessage(author, message);
    }

    @Override
    public List<String> getMessages() {
        return chatService.getMessages();
    }
}
