package dao;

import model.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.List;


public class UserDao {

    public UserEntity findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From UserEntity where name=:name").setParameter("name", name);
        return (UserEntity) query.uniqueResult();
    }

    public void save(UserEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        user.setIdUser(user.getIdUser());
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
    }

    public void update(UserEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(UserEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public List<UserEntity> findAll() {
        return (List<UserEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From UserEntity").list();
    }
}
