package Service;

import Implements.ImplAskListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DiscordService {
    @Value("${token}")
    public String token;

    @Autowired
    private ImplAskListener listener;

    @Bean
    public DiscordApi discordApi() {
        DiscordApi api = new DiscordApiBuilder().setToken(token)
                .setAllIntents()
                .login()
                .join();
        api.addMessageCreateListener(listener);
        return api;
    }
}
