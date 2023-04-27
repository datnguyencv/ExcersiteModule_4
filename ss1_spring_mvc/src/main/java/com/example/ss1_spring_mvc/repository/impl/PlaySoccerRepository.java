package com.example.ss1_spring_mvc.repository.impl;

import com.example.ss1_spring_mvc.model.SoccerPlayer;
import com.example.ss1_spring_mvc.repository.IPlaySoccerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlaySoccerRepository implements IPlaySoccerRepository {
    private static final List<SoccerPlayer> listPlay = new ArrayList<>();

    static {
        listPlay.add(new SoccerPlayer(
                "001", "Nguyễn Văn Tài", "2000/11/02", "1", "Tiền Đạo", "https://nld.mediacdn.vn/2020/3/23/ronaldo-15849298589031057007974.jpg"));

        listPlay.add(new SoccerPlayer(
                "002", "Nguyễn Văn Tài", "2000/11/02", "1", "Tiền Đạo", "https://nld.mediacdn.vn/2020/3/23/ronaldo-15849298589031057007974.jpg"));

        listPlay.add(new SoccerPlayer(
                "003", "Nguyễn Văn Tài", "2000/11/02", "1", "Tiền Đạo", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/phil-foden-696x463.jpg"));

        listPlay.add(new SoccerPlayer(
                "004", "Nguyễn Văn Tài", "2000/11/02", "1", "Tiền Đạo", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-kdb-696x392.jpeg"));

        listPlay.add(new SoccerPlayer(
                "005", "Nguyễn Văn Tài", "2000/11/02", "1", "Tiền Đạo", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-mbappe-696x392.jpeg"));

        listPlay.add(new SoccerPlayer(
                "006", "Nguyễn Văn Tài", "2000/11/02", "1", "Tiền Đạo", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-lewandowski-696x493.jpg"));

        listPlay.add(new SoccerPlayer(
                "007", "Nguyễn Văn Tài", "2000/11/02", "1", "Tiền Đạo", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-salah-696x455.jpg"));

        listPlay.add(new SoccerPlayer(
                "008", "Nguyễn Văn Tài", "2000/11/02", "1", "Tiền Đạo", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-benzema-696x392.jpg"));

    }


    @Override
    public List<SoccerPlayer> findAll() {
        return listPlay ;
    }
}

