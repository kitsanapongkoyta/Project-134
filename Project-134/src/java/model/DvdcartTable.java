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
public class DvdcartTable {
    public static Vector<Dvdcart> findAllDvdcart(EntityManager em) {
        Vector<Dvdcart> empList = null;
        try {
            empList = (Vector<Dvdcart>) em.createNamedQuery("Dvdcart.findAll").getResultList();
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return empList;
    }
    public static Dvdcart findCartbyName(EntityManager em, String name) {
        Dvdcart emp = null;
        try {
            emp = em.find(Dvdcart.class, name);
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return emp;
    }
    //public static int updateEmployee(EntityManager em, 
    //        UserTransaction utx, Employee emp) {
    public static int updateCart(EntityManager em, Dvdcart emp) {
        try {
            em.getTransaction().begin();
            Dvdcart target = em.find(Dvdcart.class, emp.getCDvdnames());
            if (target == null) {
                return 0;
            }
            target.setCRate(emp.getCRate());
            target.setCYears(emp.getCYears());
            target.setCPrice(emp.getCPrice());
            target.setCQuantity(emp.getCQuantity());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
        
    }
    public static int removeCart(EntityManager em, String name) {
        try {
            em.getTransaction().begin();
            Dvdcart target = em.find(Dvdcart.class, name);
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
    
    public static int insertCart(EntityManager em, Dvdcart emp) {
        try {
            em.getTransaction().begin();
            Dvdcart target = em.find(Dvdcart.class, emp.getCDvdnames());
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
