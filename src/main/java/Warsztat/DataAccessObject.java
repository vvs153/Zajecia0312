package Warsztat;


import Warsztat.Model.HibernateUtil;
import Warsztat.Model.Mechanic;
import Warsztat.Model.Vehicle;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// DataAccessObject - instancja klasy ktora umozliwia manipulowanie danymi w bazie
// posiada metody curd dla wybranego modelu
public class DataAccessObject<T> {
    public void insert(T objectDoWstawienia){
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(objectDoWstawienia);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd dodawania do bazy danych");
        }
    }

    public List<T> findAll(Class<T> tClass){
        List<T> list = new ArrayList<>();
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            TypedQuery<T> zapytanie = session.createQuery("FROM" + tClass.getName(), tClass);
            list.addAll(zapytanie.getResultList());

        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
        return list;
    }

    public Optional<T> find(Class<T> tClass, Long id){
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            T entity = session.get(tClass,id);
           return Optional.ofNullable(entity);
        } catch (Exception e){
            System.err.println("blad bazy " + e);
        } return Optional.empty();
    }
    public boolean delete(Class<T> tClass, Long id){
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            T entity = session.get(tClass, id);
            if(entity==null) { //nie ma entity z takim id
                return false;
            }
            session.remove(entity);
            transaction.commit();
            return true; // znalezlismy entity i ja usunelismy
        } catch (Exception e){
            System.err.println("blad bazy " + e);
        }
        return false;
        }
    }

