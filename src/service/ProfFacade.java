/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Departement;
import bean.Matiere;
import bean.Prof;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hamza
 */
public class ProfFacade extends AbstractFacade<Prof>{
    
    public ProfFacade() {
        super(Prof.class);
    }
    
    public void createProf(String cne,String nom,String prenom,String adresse,String email,int tel,Departement departement,List<Matiere> matieres){
        Prof prof = new Prof(cne, nom, prenom, adresse, email, tel, departement, matieres);
        create(prof);
    }
    
    public void editProf(Prof prof,String nom,String prenom,String adresse,String email,int tel){
        prof.setNom(nom);
        prof.setPrenom(prenom);
        prof.setAdresse(adresse);
        prof.setEmail(email);
        prof.setTel(tel);
        edit(prof);
    }
    
    private MatiereFacade matiereFacade = new MatiereFacade();
    
    public void save(Prof prof, List<Matiere> matieres){
        create(prof);
        for (Matiere matiere : matieres) {
            prof.getMatieres().add(matiere);
        }
        edit(prof);
    }
    
    public List<Prof> FindProf(String nom, Departement departement) {
        String requette = "SELECT p FROM Prof p WHERE 1=1";
        if (!"".equals(nom)) {
            requette += " AND p.nom='" + nom + "'";
        }
        if (departement != null) {
            requette += " AND p.departement.nom='" + departement.getNom() +"'" ;
        }
       
        return getEntityManager().createQuery(requette).getResultList();
    }
    
   
    
    public List<Prof> findProfByMatiere(Matiere matiere){
        List<Prof> profs = findAll();
        List<Prof> profsM = new ArrayList<>();
        for (Prof prof : profs) {
             List<Matiere> matieres = prof.getMatieres();
             for (Matiere matierep : matieres) {
                if(matierep.getNom().equals(matiere.getNom())){
                    profsM.add(prof);
                }
            }
        }
        return profsM;
    }
    
    public List<Prof> findProfByDep(Departement departement){
 return getEntityManager().createQuery("SELECT p FROM Prof p WHERE p.departement.nom='"+departement.getNom()+"'").getResultList();
    }
    
   
    public void deleteProf(Prof prof){
        remove(prof);
    }
    
}
