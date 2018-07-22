/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Departement;
import bean.Matiere;
import bean.Prof;
import java.util.List;

/**
 *
 * @author Hamza
 */
public class MatiereFacade extends AbstractFacade<Matiere>{
    
    public MatiereFacade() {
        super(Matiere.class);
    }
    
    public void editMatiere(Matiere matiere,Departement departement,String nom){
        matiere.setDepartement(departement);
        matiere.setNom(nom);
        edit(matiere);
    }

    public List<Matiere> findMatiereByProf(Prof prof){
        return getEntityManager().createQuery("SELECT m FROM Matiere m WHERE m.prof.cne='"+prof.getCne()+"'").getResultList();
    }
    public List<Matiere> findMatiereByDep(Departement departement){
        return getEntityManager().createQuery("SELECT m FROM Matiere m WHERE m.departement.nom='"+departement.getNom()+"'").getResultList();
    }
    
    public void deleteMatiere(Matiere matiere){
        remove(matiere);
    }
}
