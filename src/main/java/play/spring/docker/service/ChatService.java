package play.spring.docker.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import play.spring.docker.kafka.Topic;

import java.util.List;

@Service
@AllArgsConstructor
public class ChatService {

    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String author, String message) {

       ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(Topic.MESSAGE_TOPIC.name(), author+ " > " + message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + stringStringSendResult.getRecordMetadata().offset() + "]");
            }
        });
    }

    public List<String> getMessages() {
        return null;
    }
}
