package article;

import java.util.*;
import javax.ejb.*;
import java.rmi.RemoteException;

public interface ArticleHome extends EJBHome {
    public Article create(Integer idArticle, String libelle, double prixUnitaire, String categorie)
            throws RemoteException, CreateException;
    public Article createSansID(String libelle, double prixUnitaire, String categorie)
            throws RemoteException, CreateException;
    public Collection<Article> findByCategorie(String categorie) 
            throws RemoteException, FinderException;
    public Article findByPrimaryKey(Integer id) 
            throws RemoteException, FinderException;
    public Integer getNbreArticleDeCategorie(String categorie) 
            throws RemoteException;
}
