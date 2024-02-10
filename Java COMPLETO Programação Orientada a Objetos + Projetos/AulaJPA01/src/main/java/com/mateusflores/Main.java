package com.mateusflores;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Done");
        em.close();
        emf.close();
    }
}