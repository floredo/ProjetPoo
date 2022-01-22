/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.poo.models;

import java.util.Date;

/**
 *
 * @author Toussain bankafe
 */
public class Article {
    private int id;
    private String code;
    private String libelle;
    private double prix;
    private int qte;
    private Date dateCreation;

    public int getId(){
        return id;
    }
    public String getCode() {
        return code;
    }
    public String getLibelle(){
        return libelle;
    }
    public double getPrix(){
        return prix;
    }
    public int getQte(){
        return qte;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public void setQte(int qte) {
        this.qte = qte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    

    public Article() {
    }

    
    public Article(String code, String libelle, double prix, int qte, Date dateCreation) {
        this.code = code;
        this.libelle = libelle;
        this.prix = prix;
        this.qte = qte;
        this.dateCreation = dateCreation;
    }
    
}
