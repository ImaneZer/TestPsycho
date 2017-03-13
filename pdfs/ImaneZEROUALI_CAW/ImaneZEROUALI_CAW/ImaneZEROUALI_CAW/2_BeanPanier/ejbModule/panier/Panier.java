package panier;

import javax.ejb.*;
import java.util.*;
import java.rmi.*;

public interface Panier extends EJBObject {
    public void ajouterArticle(int idArticle) throws RemoteException;
    public void supprimerArticle(int idArticle) throws RemoteException;
    public Vector<Integer> listerArticles() throws RemoteException;
    public void setNom(String nomClient) throws RemoteException;
    public String getNom() throws RemoteException;
}
