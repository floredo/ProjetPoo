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
    Article getOne(int id);
    void saveOne(Article article);
    void updateOne(Article article);
    void deleteone(Article article);
    int afficherNombre();
}
