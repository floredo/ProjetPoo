/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.projet.poo.models.Article;
import java.util.List;

/**
 *
 * @author Toussain bankafe
 */
public interface IArticleDAO {
    List<Article> getAll();
    Article getOne(String code);
    Article saveOne(Article article);
    Article updateOne(Article article);
    void deleteone(String code);
}
