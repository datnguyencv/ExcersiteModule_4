package com.example.soccer.repository.impl;

import com.example.soccer.model.SoccerPlayer;
import com.example.soccer.repository.IPlaySoccerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlaySoccerRepository implements IPlaySoccerRepository {
    private static List<SoccerPlayer> listPlay = new ArrayList<>();

    static {
        listPlay.add(new SoccerPlayer(
                "001", "Nguyễn Văn Tài", "2000/11/02", "1", "Tiền Đạo", "https://nld.mediacdn.vn/2020/3/23/ronaldo-15849298589031057007974.jpg"));

        listPlay.add(new SoccerPlayer(
                "002", "Nguyễn Văn Quyết", "2000/11/02", "1", "Tiền Vệ", "https://nld.mediacdn.vn/2020/3/23/ronaldo-15849298589031057007974.jpg"));

        listPlay.add(new SoccerPlayer(
                "003", "Bùi Tiến Dũng", "2000/11/02", "1", "Hậu Vệ", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/phil-foden-696x463.jpg"));

        listPlay.add(new SoccerPlayer(
                "004", "Nguyễn Văn Dũng", "2000/11/02", "1", "Thủ Môn", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-kdb-696x392.jpeg"));

        listPlay.add(new SoccerPlayer(
                "005", "Nguyễn Văn Hậu", "2000/11/02", "1", "Trung Vệ", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-mbappe-696x392.jpeg"));

        listPlay.add(new SoccerPlayer(
                "006", "Phan Văn Tài", "2000/11/02", "1", "Thủ Môn", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-lewandowski-696x493.jpg"));

        listPlay.add(new SoccerPlayer(
                "007", "Nguyễn Ngọc Hùng", "2000/11/02", "1", "Tiền Đạo", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-salah-696x455.jpg"));

        listPlay.add(new SoccerPlayer(
                "008", "Nguyễn Công Phượng", "2000/11/02", "1", "Tiền Đạo", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-benzema-696x392.jpg"));

    }


    @Override
    public List<SoccerPlayer> findAll() {
        return listPlay ;
    }
}

