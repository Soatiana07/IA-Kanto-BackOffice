/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDAO;
import dao.CibleDAO;
import dao.ContenuDAO;
import dao.Fonction;
import dao.HibernateDao;
import dao.TypeDAO;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Fanjava
 */
@Controller
public class BackOffice {

    TypeDAO typeDao = new TypeDAO();

    CibleDAO cibleDao = new CibleDAO();

    ContenuDAO contenuDaO = new ContenuDAO();

    Fonction f = new Fonction();

    AdminDAO adminDAO = new AdminDAO();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/formulaireLogin")
    public ModelAndView formulaireLogin() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("loginAdmin");
        return mv;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        String nom = request.getParameter("nom");
        String mdp = request.getParameter("mdp");
        int login = adminDAO.loginAdmin(nom, mdp);
        int idAdmin = adminDAO.getIdAdmin(nom, mdp);
        HttpSession session = request.getSession();
        session.setAttribute("idAdmin", idAdmin);
        if (login == 1) {
            mv.setViewName("acceuil");
        } else {
            mv.setViewName("loginAdmin");
        }
        return mv;
    }

    @RequestMapping(value = "/listeContenu", method = RequestMethod.GET)
    public ModelAndView listeContenu(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        int limite =3;
        int offset = 0;
        if(request.getParameter("limit")!= null && request.getParameter("offset")!= null){
            limite = Integer.parseInt(request.getParameter("limit"));
            offset = Integer.parseInt(request.getParameter("offset"));
        }
        ArrayList<V_contenu> listContenu = contenuDaO.listeViewContenu(limite, offset);
        mv.addObject("listContenu", listContenu);
        mv.addObject("limite", limite);
        mv.addObject("offset", offset);
        mv.setViewName("liste_Contenu");
        return mv;
    }

    @RequestMapping(value = "/formulaireContenu")
    public ModelAndView formulaireContenu() throws Exception {
        ModelAndView mv = new ModelAndView();
        ArrayList<Cible> listCible = cibleDao.listeCible();
        ArrayList<Type> listType = typeDao.listeType();
        mv.addObject("listCible", listCible);
        mv.addObject("listType", listType);
        mv.setViewName("ajouter_Contenu");
        return mv;
    }

    @RequestMapping(value = "/insertContenu")
    public ModelAndView insertContenu(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv = new ModelAndView();
        int type = Integer.parseInt(request.getParameter("type"));
        int cible = Integer.parseInt(request.getParameter("cible"));
        Date date = Date.valueOf(request.getParameter("date"));
        String titre = request.getParameter("titre");
        String descri = request.getParameter("descri");
         HttpSession session = request.getSession();
        int idAdmin = (int) session.getAttribute("idAdmin");
        Contenu contenu = new Contenu();
        contenu.setDate(date);
        contenu.setDescription(descri);
        contenu.setIdcible(cible);
        contenu.setIdtype(type);
        contenu.setTitre(titre);
        contenu.setIdadmin(idAdmin);
        contenu.insertContenu(f, contenu);
        mv.setViewName("acceuil");
        return mv;
    }
    
     @RequestMapping(value = "/formulaireModifier")
    public ModelAndView formulaireModif(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        ArrayList<Cible> listCible = cibleDao.listeCible();
        ArrayList<Type> listType = typeDao.listeType();
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Contenu> listContenu = contenuDaO.listeContenById(id);
        mv.addObject("listCible", listCible);
        mv.addObject("listType", listType);
        mv.addObject("listContenu", listContenu);
         mv.addObject("id", id);
        mv.setViewName("modif_Contenu");
        return mv;
    }

    @RequestMapping(value = "/modifier")
    public ModelAndView modifier(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        int idadmin = Integer.parseInt(request.getParameter("idAdmin"));
        int idcible = Integer.parseInt(request.getParameter("cible"));
        int idtype = Integer.parseInt(request.getParameter("type"));
         Date date = Date.valueOf(request.getParameter("date"));
        String titre = request.getParameter("titre");
        String descri = request.getParameter("descri");
        Contenu c = new Contenu();
        c.setDate(date);
        c.setDescription(descri);
        c.setId(id);
        c.setIdadmin(idadmin);
        c.setIdcible(idcible);
        c.setIdtype(idtype);
        c.setTitre(titre);
        contenuDaO.modifContenu(c);
        mv.setViewName("acceuil");
        return mv;
    }
    
    @RequestMapping(value = "/supprimer")
    public String supprimer(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        contenuDaO.deleteContenu(id);
        return "redirect:listeContenu";
    }

    @RequestMapping(value = "/lien")
    public ModelAndView lien(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        int s = Integer.parseInt(request.getParameter("s"));
        System.out.println("SSS "+s);
        mv.addObject("s", s);
        mv.setViewName("index");
        return mv;
    }

}
