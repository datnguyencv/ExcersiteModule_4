package com.example.soccer.repository.impl;

import com.example.soccer.model.SoccerPlayer;
import com.example.soccer.repository.IPlaySoccerRepository;
import com.example.soccer.service.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PlaySoccerRepository implements IPlaySoccerRepository {
    private static List<SoccerPlayer> playList = new ArrayList<>();


    @Override
    public List<SoccerPlayer> findAllByName(String name) {
        List<SoccerPlayer> players = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        try {
            TypedQuery<SoccerPlayer> query = session.createQuery(
                            "SELECT s FROM SoccerPlayer s WHERE s.name LIKE :name")
                    .setParameter("name", "%" + name + "%");
            players = query.getResultList();
        } catch (Exception e) {
            if (session != null) {
                session.close();
            }
        }
        return players;
    }

    @Override
    public List<SoccerPlayer> findAll() {
        List<SoccerPlayer> playerList = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        playerList = session.createQuery("FROM SoccerPlayer ").getResultList();
        session.close();
        return playerList;
    }


    @Override
    public boolean removePlayer(Integer id) {
        if (playList.remove(findById(id))) {
            return true;
        }
        ;
        return false;
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
        Transaction transaction = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.persist(soccerPlayer);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(SoccerPlayer soccerPlayer) {
        SoccerPlayer upSoccerPlayer = findById(SoccerPlayer.getId());
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            upSoccerPlayer.setCode(soccerPlayer.getCode());
            upSoccerPlayer.setName(soccerPlayer.getName());
            upSoccerPlayer.setDateOfBirth(soccerPlayer.getDateOfBirth());
            upSoccerPlayer.setExperience(soccerPlayer.getExperience());
            upSoccerPlayer.setPosition(soccerPlayer.getPosition());
            upSoccerPlayer.setUrlImg(soccerPlayer.getUrlImg());
            session.update(upSoccerPlayer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

