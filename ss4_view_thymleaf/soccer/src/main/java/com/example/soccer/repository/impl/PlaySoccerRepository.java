package com.example.soccer.repository.impl;

import com.example.soccer.model.SoccerPlayer;
import com.example.soccer.repository.IPlaySoccerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PlaySoccerRepository implements IPlaySoccerRepository {
    private static List<SoccerPlayer> playList = new ArrayList<>();

    static {
        playList.add(new SoccerPlayer(
                1,"001", "Nguyễn Văn Tài", "2000/11/02", "1", "Tiền Đạo", "https://nld.mediacdn.vn/2020/3/23/ronaldo-15849298589031057007974.jpg"));

        playList.add(new SoccerPlayer(
                2,"002", "Nguyễn Văn Quyết", "2000/11/02", "1", "Tiền Vệ", "https://nld.mediacdn.vn/2020/3/23/ronaldo-15849298589031057007974.jpg"));

        playList.add(new SoccerPlayer(
                3,"003", "Bùi Tiến Dũng", "2000/11/02", "1", "Hậu Vệ", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/phil-foden-696x463.jpg"));

        playList.add(new SoccerPlayer(
                4,"004", "Nguyễn Văn Dũng", "2000/11/02", "1", "Thủ Môn", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-kdb-696x392.jpeg"));

        playList.add(new SoccerPlayer(
                5,"005", "Nguyễn Văn Hậu", "2000/11/02", "1", "Trung Vệ", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-mbappe-696x392.jpeg"));

        playList.add(new SoccerPlayer(
                6,"006", "Phan Văn Tài", "2000/11/02", "1", "Thủ Môn", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-lewandowski-696x493.jpg"));

        playList.add(new SoccerPlayer(
                7,"007", "Nguyễn Ngọc Hùng", "2000/11/02", "1", "Tiền Đạo", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-salah-696x455.jpg"));

        playList.add(new SoccerPlayer(
                8,"008", "Nguyễn Công Phượng", "2000/11/02", "1", "Tiền Đạo", "https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/06/anh-benzema-696x392.jpg"));
    }

    @Override
    public List<SoccerPlayer> findAll() {
        return playList ;
    }

    @Override
    public boolean removePlayer(Integer id) {
        if (playList.remove(findById(id))){
            return true;
        };  return false;
    }

    @Override
    public SoccerPlayer findById(Integer id) {
        for (int i = 0; i < playList.size(); i++) {
            if (playList.get(i).getId().equals(id)) {
                return playList.get(i);
            }
        }
        return null;
    }


    @Override
    public void create(SoccerPlayer soccerPlayer) {
        soccerPlayer.setId(playList.size() + 1);
        playList.add(soccerPlayer);
    }

    @Override
    public void update(SoccerPlayer soccerPlayer) {
        for (SoccerPlayer upSoccerPlayer : playList) {
            if (Objects.equals(upSoccerPlayer.getId(), soccerPlayer.getId())) {
                upSoccerPlayer.setCode(soccerPlayer.getCode());
                upSoccerPlayer.setName(soccerPlayer.getName());
                upSoccerPlayer.setDateOfBirth(soccerPlayer.getDateOfBirth());
                upSoccerPlayer.setExperience(soccerPlayer.getExperience());
                upSoccerPlayer.setPosition(soccerPlayer.getPosition());
                upSoccerPlayer.setUrlImg(soccerPlayer.getUrlImg());
            }
        }
    }
}

