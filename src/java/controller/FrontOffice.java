/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContenuDAO;
import dao.UtilisateurDAO;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.Cible;
import model.Contenu;
import model.Type;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kanto
 */
@Controller
public class FrontOffice {
    
    UtilisateurDAO utilDAO = new UtilisateurDAO();
    
    ContenuDAO contenuDAO = new ContenuDAO();

    @RequestMapping(value = "/formulaireLoginUtil")
    public ModelAndView formulaireLoginUtil() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("loginUtilisateur");
        return mv;
    }

    @RequestMapping(value = "/loginUtil")
    public String loginUtil(HttpServletRequest request) throws Exception {
        String nom = request.getParameter("nom");
        String mdp = request.getParameter("mdp");
        int login = utilDAO.loginUtilisateur(nom, mdp);
        if(login==1){
            return "listeContenuUtil";
        }else{
            return "formulaireLoginUtil";
        }
    }
    
    @RequestMapping(value = "/listeContenuUtil", method = RequestMethod.GET)
    public ModelAndView listeContenuUtil(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        int limite = 3;
        int offset = 0;
        ArrayList<Contenu> listContenu = contenuDAO.listeContenu(limite, offset);
        mv.addObject("listContenu", listContenu);
        mv.addObject("limite", limite);
        mv.addObject("offset", offset);
        mv.setViewName("liste_Contenu");
        return mv;
    }
}
