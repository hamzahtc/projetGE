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
public class DepartementFacade extends AbstractFacade<Departement>{
    
    public DepartementFacade() {
        super(Departement.class);
    }
    
    ProfFacade profFacade = new ProfFacade();
    MatiereFacade matiereFacade = new MatiereFacade();
    
    
    public void createDepartement(String nom){
        Departement departement = new Departement(nom);
        create(departement);
    }
    
    public void editDepartement(Departement departement,String nom){
        departement.setNom(nom);
        edit(departement);
    }
    
    public void deleteDepartement(Departement departement){
        List<Matiere> matieres = matiereFacade.findMatiereByDep(departement);
        for (Matiere matiere : matieres) {
            matiereFacade.deleteMatiere(matiere);
        }
        
        List<Prof> profs = profFacade.findProfByDep(departement);
        for (Prof prof : profs) {
            profFacade.remove(prof);
        }
        
        remove(departement);
    }
            
    
}
