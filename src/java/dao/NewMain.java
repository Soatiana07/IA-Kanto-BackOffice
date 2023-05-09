///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
//import model.Categorie;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// *
// * @author Kanto
// */
//public class NewMain {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        
//        HibernateDao h = (HibernateDao) context.getBean("hibernateDAO");
//        Categorie r = new Categorie();
//        r.setNom("fiesta");
//        r = h.create(r);
//    }
//    
//}
