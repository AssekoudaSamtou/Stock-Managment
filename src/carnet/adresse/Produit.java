/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnet.adresse;

import java.io.Serializable;

/**
 *
 * @author Hp
 */
public class Produit implements Serializable, Comparable<Produit>{
    
    protected String numero;
    protected String categorie;
    protected String libelle;
    protected String prixUnitaire;
    protected String datePeremption;

    public Produit(String categorie, String libelle, String prixUnitaire, String datePeremption) {
        this.categorie = categorie;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePeremption = datePeremption;
    }

    public Produit(String numero, String categorie, String libelle, String prixUnitaire, String datePeremption) {
        this.numero = numero;
        this.categorie = categorie;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePeremption = datePeremption;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(String prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(String datePeremption) {
        this.datePeremption = datePeremption;
    }

    @Override
    public String toString() {
        return "Produit{" + "numero=" + numero + ", categorie=" + categorie + ", libelle=" + libelle + ", prixUnitaire=" + prixUnitaire + ", datePeremption=" + datePeremption + '}';
    }

    @Override
    public int compareTo(Produit o) {
        return  this.getNumero().compareTo(o.getNumero());
    }
    
    public Object[] toObject() {
        return new Object[]{numero, categorie, libelle, prixUnitaire, datePeremption};
    }
}
