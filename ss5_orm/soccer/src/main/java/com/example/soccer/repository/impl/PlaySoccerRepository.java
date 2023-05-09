package com.example.soccer.repository.impl;

import com.example.soccer.model.SoccerPlayer;
import com.example.soccer.repository.IPlaySoccerRepository;
import com.example.soccer.service.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PlaySoccerRepository implements IPlaySoccerRepository {

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
        SoccerPlayer soccerPlayer = findById(id);
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(soccerPlayer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null || soccerPlayer == null) {
                assert transaction != null;
                transaction.rollback();
                return false;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public SoccerPlayer findById(Integer id) {
        SoccerPlayer soccerPlayer;
        Session session = ConnectionUtil.sessionFactory.openSession();
        soccerPlayer = (SoccerPlayer) session.createQuery("FROM SoccerPlayer WHERE id = :id").setParameter("id", id).getSingleResult();
        session.close();
        return soccerPlayer;
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
        SoccerPlayer upSoccerPlayer = findById(soccerPlayer.getId());
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

