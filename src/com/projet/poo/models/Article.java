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
    private String code;
    private String libelle;
    private double prix;
    private int qte;
    private Date date_creation;

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
    public Date getDate_creation(){
        return date_creation;
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
    public void setDate_creation(Date Date_creation) {
        this.date_creation = date_creation;
    }

    public Article(String code, String libelle, double prix, int qte, Date date_creation) {
        this.code = code;
        this.libelle = libelle;
        this.prix = prix;
        this.qte = qte;
        this.date_creation = date_creation;
    }
    
}
