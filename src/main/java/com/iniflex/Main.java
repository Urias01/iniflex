package com.iniflex;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.iniflex.models.Funcionario;

public class Main {
    public static void main(String[] args) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Funcionario func1 = new Funcionario("Maria", LocalDate.parse("18/10/2000", formatter), BigDecimal.valueOf(2009.44), "Operador");
        Funcionario func2 = new Funcionario("João", LocalDate.parse("12/05/1990", formatter), BigDecimal.valueOf(2284.38), "Operador");
        Funcionario func3 = new Funcionario("Caio", LocalDate.parse("02/05/1961", formatter), BigDecimal.valueOf(9836.14), "Coordenador");
        Funcionario func4 = new Funcionario("Miguel", LocalDate.parse("14/10/1988", formatter), BigDecimal.valueOf(19119.88), "Diretor");
        Funcionario func5 = new Funcionario("Alice", LocalDate.parse("05/01/1995", formatter), BigDecimal.valueOf(2234.68), "Recepcionista");
        Funcionario func6 = new Funcionario("Heitor", LocalDate.parse("19/11/1999", formatter), BigDecimal.valueOf(1582.72), "Operador");
        Funcionario func7 = new Funcionario("Arthur", LocalDate.parse("31/03/1993", formatter), BigDecimal.valueOf(4071.84), "Contador");
        Funcionario func8 = new Funcionario("Laura", LocalDate.parse("08/07/1994", formatter), BigDecimal.valueOf(3017.45), "Gerente");
        Funcionario func9 = new Funcionario("Heloísa", LocalDate.parse("21/05/2003", formatter), BigDecimal.valueOf(1606.85), "Eletricista");
        Funcionario func10 = new Funcionario("Helena", LocalDate.parse("02/09/1996", formatter), BigDecimal.valueOf(2799.93), "Gerente");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("funcionario-jpa");
        EntityManager em = emf.createEntityManager();

        // Inserir funcionários na mesma ordem da tabela
        em.getTransaction().begin();
        em.persist(func1);
        em.persist(func2);
        em.persist(func3);
        em.persist(func4);
        em.persist(func5);
        em.persist(func6);
        em.persist(func7);
        em.persist(func8);
        em.persist(func9);
        em.persist(func10);
        em.getTransaction().commit();
        
        // Remover o funcionário João da lista
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM Funcionario f WHERE f.nome = :nome");
        q.setParameter("nome", "João");
        q.executeUpdate();
        em.getTransaction().commit();

        // Lista funcionários
        q = em.createQuery("SELECT f FROM Funcionario f");
        List<Funcionario> funcionarios = q.getResultList();

        funcionarios.forEach(System.out::println);

        em.close();
        emf.close();
    }
}