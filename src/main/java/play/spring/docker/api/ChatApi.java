package play.spring.docker.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RequestMapping("/chat") TODO why not work?
public interface ChatApi {

    @RequestMapping(method = RequestMethod.POST, path = "/chat/send-message")
    void sendMessage(String author, String message);

    @RequestMapping(method = RequestMethod.GET, path = "/messages-list")
    List<String> getMessages();
}
