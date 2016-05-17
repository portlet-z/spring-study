package com.zhang.web;

import com.zhang.domain.WiselyMessage;
import com.zhang.domain.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author zhangxinzheng
 * @Date 2016/5/10
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception{
        Thread.sleep(2000);
        return new WiselyResponse("Welcome, " + message.getName() + " !");
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg){
        if(principal.getName().equals("wyf")){
            messagingTemplate.convertAndSendToUser("wisely", "/queue/notifications", principal.getName() + "-send:" + msg);
        }else {
            messagingTemplate.convertAndSendToUser("wyf", "/queue/notifications", principal.getName() + "-send:" + msg);
        }
    }
}
