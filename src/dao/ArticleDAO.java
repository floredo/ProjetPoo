/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.projet.poo.models.Article;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinc
 */
public class ArticleDAO implements IArticleDAO{
    
    private Connection connection = DatabaseConnexion.getConnection();

    @Override
    public List<Article> getAll() {
        List<Article> articles = new ArrayList<>();
       
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM article");
            while(resultSet.next()){
                Article article = new Article();
                article.setCode(resultSet.getString("code"));
                article.setLibelle(resultSet.getString("libelle"));
                article.setPrix(resultSet.getDouble("prix"));
                article.setQte(resultSet.getInt("qte"));
                article.setDateCreation(resultSet.getDate("datecreation"));
                article.setId(resultSet.getInt("id"));
                articles.add(article);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException sQLException){
            sQLException.printStackTrace();
        }
        
        return articles;
    }

    @Override
    public Article getOne(int id) {
        Article article = new Article();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM article WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                article.setCode(resultSet.getString("code"));
                article.setLibelle(resultSet.getString("libelle"));
                article.setPrix(resultSet.getDouble("prix"));
                article.setQte(resultSet.getInt("qte"));
                article.setDateCreation(resultSet.getDate("datecreation"));
                article.setId(resultSet.getInt("id"));
            }
            resultSet.close();
            preparedStatement.close();
        }catch(SQLException sQLException){
            sQLException.printStackTrace();
        }
        return article ;
    }

    @Override
    public void saveOne(Article article) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO article(code,datecreation,libelle,prix,qte) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, article.getCode());
            preparedStatement.setDate(2, new Date(article.getDateCreation().getYear(), article.getDateCreation().getMonth(), article.getDateCreation().getDay()));
            preparedStatement.setString(3, article.getLibelle());
            preparedStatement.setDouble(4, article.getPrix());
            preparedStatement.setInt(5, article.getQte());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void updateOne(Article article) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE article set datecreation=?, libelle=?, prix=?,qte=?,code=? WHERE id=?");
            preparedStatement.setDate(1, new Date(article.getDateCreation().getYear(), article.getDateCreation().getMonth(), article.getDateCreation().getDay()));
            preparedStatement.setString(2, article.getLibelle());
            preparedStatement.setDouble(3, article.getPrix());
            preparedStatement.setInt(4, article.getQte());
            preparedStatement.setString(5,article.getCode());
            preparedStatement.setInt(6, article.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteone(Article article) {
       try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM article  WHERE id=?");
            preparedStatement.setInt(1, article.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public int afficherNombre(){
        int nbretotal=0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS totalArticle FROM article");
            
             ResultSet afficher =preparedStatement.executeQuery();
             afficher.next();
             nbretotal=afficher.getInt(1);
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return nbretotal;
    }
    public List<Article> getListe() {
        List<Article> articles = new ArrayList<>();
       
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM article WHERE Qte <= 15");
            while(resultSet.next()){
                Article article = new Article();
                article.setCode(resultSet.getString("code"));
                article.setLibelle(resultSet.getString("libelle"));
                article.setPrix(resultSet.getDouble("prix"));
                article.setQte(resultSet.getInt("qte"));
                article.setDateCreation(resultSet.getDate("datecreation"));
                article.setId(resultSet.getInt("id"));
                articles.add(article);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException sQLException){
            sQLException.printStackTrace();
        }
        
        return articles;
    } 
    public void approvisionner(Article article, int qte) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE article set qte=qte+? WHERE id=?");
            preparedStatement.setInt(1, qte);
            preparedStatement.setInt(2,article.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
     public void approvisionner(int id, int qte) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE article set qte=qte+? WHERE id=?");
            preparedStatement.setInt(1, qte);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public void vendreArticle(Article article, int qte) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE article set qte=qte-? WHERE id=?");
            preparedStatement.setInt(1, qte);
            preparedStatement.setInt(2,article.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public void vendreArticle(int id, int qte) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE article set qte=qte-? WHERE id=?");
            preparedStatement.setInt(1, qte);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
}
