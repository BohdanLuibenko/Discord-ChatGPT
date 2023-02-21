package Implements;

import Interfaces.AskListener;
import com.example.Discord_Chatgpt.Client.ChatGptClient;
import Entity.QuestionToChatGPT;
import feign.FeignException;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImplAskListener implements AskListener {

    public final ChatGptClient chatGptClient;
    public final String Token;

    public ImplAskListener(ChatGptClient chatGptClient, @Value("${ChatGPTToken}") String token) {
        this.chatGptClient = chatGptClient;
        Token = token;
    }

    private Logger log = LogManager.getLogger(ChatGptClient.class);;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().startsWith("!ask")) {
            String[] splited = event.getMessageContent().split("\\s+", 2);
            String question = splited.length > 1 ? splited[1] : "";
            if (splited[0].equals("!ask") && question != "") {
                QuestionToChatGPT questionToChatGPT = new QuestionToChatGPT(question, 100, 0.5);
                try {
                    event.getChannel().sendMessage(chatGptClient.AskChatGPT(Token, questionToChatGPT));
                } catch (FeignException.FeignClientException exception) {
                    event.getChannel().sendMessage("your qeuestion '" + question + "' now cant be answered");
                    log.error("Does not have access to the API"+exception.getMessage());
                }
            } else {
                event.getChannel()
                        .sendMessage("that`s wrong you should use this command like '!ask [your question]'");
            }
        }
    }
}
