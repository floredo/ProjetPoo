/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.poo;

import com.projet.poo.models.Article;
import dao.ArticleDAO;
import java.util.Date;

/**
 *
 * @author Toussain bankafe
 */
public class Projet_Poo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArticleDAO dao = new ArticleDAO();
        //System.out.println("Nombre d'articles dans la base:"+dao.getAll().size());
        //Article article = new Article();
        //article.setCode("APPLE");
        //article.setLibelle("Macbook Pro");
        //article.setDateCreation(new Date());
        //article.setQte(10);
        //article.setPrix(100000);
        //dao.saveOne(article);
        //System.out.println("Nombre d'articles dans la base:"+dao.getAll().size());
        System.out.println(dao.getOne(2));
        Article article=dao.getOne(2);
        dao.vendreArticle(article,9);
        System.err.println(dao.getOne(2));
        
    }
    
}
