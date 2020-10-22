package com.artsgard.core.config;

import com.artsgard.core.model.Contact;
import com.artsgard.core.repository.ContactRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 *
 * @author WillemDragstra
 */
public class Main {

    @Autowired
    private static ContactRepository contactsRepo;

    @Autowired
    private static Environment env;

    public static void main(String[] args) {
        ApplicationContext rootContext = new AnnotationConfigApplicationContext(AppConfig.class);

        EntityManagerFactory entityManagerFactory
                = (EntityManagerFactory) rootContext.getBean("entityManagerFactory");

        EntityManager em = entityManagerFactory.createEntityManager();

        Contact contact = em.find(Contact.class, 40L);
        List<Contact> contacts = em.createQuery("SELECT a FROM Contact a", Contact.class).getResultList();

        System.out.println(contact.getEmailAddress());
        
        for (Contact cnt : contacts) {
            System.out.println(cnt.getLastName());
        }

    }
}