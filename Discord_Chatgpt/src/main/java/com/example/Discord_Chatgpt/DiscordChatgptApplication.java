package com.example.Discord_Chatgpt;

import Entity.QuestionToChatGPT;
import Implements.ImplAskListener;
import Interfaces.AskListener;
import Service.DiscordService;
import com.example.Discord_Chatgpt.Client.ChatGptClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = DiscordService.class)
@ComponentScan(basePackageClasses = ImplAskListener.class)
@ComponentScan(basePackageClasses = AskListener.class)
@ComponentScan(basePackageClasses = QuestionToChatGPT.class)
@EnableFeignClients(basePackageClasses = ChatGptClient.class)
public class DiscordChatgptApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscordChatgptApplication.class, args);
    }

}
