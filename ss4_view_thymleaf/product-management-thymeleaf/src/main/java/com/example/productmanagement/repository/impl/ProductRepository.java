package com.example.productmanagement.repository.impl;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.ConnectionUtil;
import com.example.productmanagement.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Component
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> findAll() {
        List<Product> smartPhones = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        smartPhones = session.createQuery("FROM Product ").getResultList();
        session.close();
        return smartPhones;
    }

    @Override
    public boolean save(Product Product) {
        Transaction transaction = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.persist(Product);
            return true;
        } catch (Exception e) {
            if (transaction != null) {
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
    public boolean update(Product Product) {
        Product smartPhone1 = findById(Product.getId());
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            smartPhone1.setName(Product.getName());
            smartPhone1.setBrand(Product.getBrand());
            smartPhone1.setPrice(Product.getPrice());
            session.update(smartPhone1);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
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
    public boolean remove(int id) {
        Product Product = findById(id);
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(Product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null || Product == null) {
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
    public Product findById(int id) {
        Product Product;
        Session session = ConnectionUtil.sessionFactory.openSession();
        Product = (Product) session.createQuery("FROM Product WHERE id = :id").setParameter("id", id).getSingleResult();
        session.close();
        return Product;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> phones = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        try {
            TypedQuery<Product> query = session.createQuery("SELECT s FROM Product s WHERE s.name LIKE :name").setParameter("name", "%" + name + "%");
            phones = query.getResultList();
        } catch (Exception e) {
            if (session != null) {
                session.close();
            }
        }
        return phones;
    }
}
