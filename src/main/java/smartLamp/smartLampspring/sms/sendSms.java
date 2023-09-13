package smartLamp.smartLampspring.sms;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Balance;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource("classpath:properties/env.properties")
public class sendSms {
    private final Environment environment;
    final DefaultMessageService messageService;
    public sendSms(Environment environment) {
        this.environment = environment;
        String apiKey = environment.getProperty("apiKey");
        String apiSecretKey = environment.getProperty("apiSecretKey");
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecretKey, "https://api.coolsms.co.kr");
    }

    @GetMapping("/sendMsg")
    public Message sendOne() {
        Message message = new Message();

        String sendFrom = environment.getProperty("sendFrom");
        message.setFrom(sendFrom);
        message.setTo("");
        message.setText("테스트 메세지");
        System.out.println("s");
//        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
//        System.out.println(response);
//        return response;
        return message;
    }

    @GetMapping("/get-balance")
    public Balance getBalance() {
        Balance balance = this.messageService.getBalance();
        System.out.println(balance);
        return balance;
    }
}
