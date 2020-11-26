/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;
import javax.persistence.EntityManager;

/**
 *
 * @author USER
 */
public class Dvdcat1Table {
    public static Vector<Dvdcat1> findAllDvdcat1(EntityManager em) {
        Vector<Dvdcat1> empList = null;
        try {
            empList = (Vector<Dvdcat1>) em.createNamedQuery("Dvdcat1.findAll").getResultList();
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return empList;
    }
    public static Dvdcat1 findDvdByName(EntityManager em, String name) {
        Dvdcat1 emp = null;
        try {
            emp = em.find(Dvdcat1.class, name);
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return emp;
    }
    //public static int updateEmployee(EntityManager em, 
    //        UserTransaction utx, Employee emp) {
    public static int updateDvd(EntityManager em, Dvdcat1 emp) {
        try {
            em.getTransaction().begin();
            Dvdcat1 target = em.find(Dvdcat1.class, emp.getDvdnames());
            if (target == null) {
                return 0;
            }
            target.setRate(emp.getRate());
            target.setYears(emp.getYears());
            target.setPrice(emp.getPrice());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
        
    }
    public static int removeDvd(EntityManager em, String name) {
        try {
            em.getTransaction().begin();
            Dvdcat1 target = em.find(Dvdcat1.class, name);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
    }
    
    public static int insertDvd(EntityManager em, Dvdcat1 emp) {
        try {
            em.getTransaction().begin();
            Dvdcat1 target = em.find(Dvdcat1.class, emp.getDvdnames());
            if (target != null) {
                return 0;
            }
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
    }
}
