package com.example.Discord_Chatgpt.Client;

import Entity.QuestionToChatGPT;
import feign.FeignException;
import org.junit.Test;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "ChatGPT" ,url = "https://api.openai.com/v1/engines/davinci-codex/completions")
public interface ChatGptClient {

    @PostMapping
    String AskChatGPT(@RequestHeader("Authorization")String Authorization, @RequestBody QuestionToChatGPT question)throws FeignException.FeignClientException;
}
