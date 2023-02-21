package com.example.Discord_Chatgpt;

import Entity.QuestionToChatGPT;
import com.example.Discord_Chatgpt.Client.ChatGptClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.http.RequestEntity.post;

@SpringBootTest(classes = ChatGptClient.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestConnectToChatGPT extends DiscordChatgptApplicationTests{
    private final ChatGptClient chatGptClient;
    private final String Token;
    public TestConnectToChatGPT(ChatGptClient chatGptClient,@Value("${ChatGPTToken}") String token) {
        this.chatGptClient = chatGptClient;
        Token = token;
    }

    @Test
    public void TestConnection()throws Exception
    {
        assertThat(this.chatGptClient.AskChatGPT(Token,new QuestionToChatGPT("Hello",100,0.5))).isNotNull();
    }
}
