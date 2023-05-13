package com.example.soccer.aop;

import com.example.soccer.dto.SoccerPlayerDTO;
import com.example.soccer.model.SoccerPlayer;
import com.example.soccer.service.IPlaySoccerService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggAop {
    @Autowired
    private IPlaySoccerService soccerService;

    @Pointcut("execution(* com.example.soccer.controller.PlaySoccerController.updateSoccerPlayer(..))&&args(soccerPlayerDTO,*,*,*)")
    public void getAllUpdate(SoccerPlayerDTO soccerPlayerDTO){}

    @After(value = "getAllUpdate(soccerPlayerDTO)", argNames = "soccerPlayerDTO")
    public void printUpdate(SoccerPlayerDTO soccerPlayerDTO){
        int count = 0;
        for (SoccerPlayer soccerPlayer: soccerService.findAll()){
            if (soccerPlayer.isStatus()==true){
                count++;
            }
        }
        System.out.println("Player's Status" + soccerPlayerDTO.getName() + " has been converted to " + soccerPlayerDTO.isStatus());
        System.out.println("The number of registered players is: " + count);
    }
}
