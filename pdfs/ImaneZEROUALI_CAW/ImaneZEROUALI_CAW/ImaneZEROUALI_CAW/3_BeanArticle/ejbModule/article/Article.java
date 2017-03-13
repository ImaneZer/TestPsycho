package article;

import javax.ejb.*;
import java.rmi.RemoteException;
 
public interface Article extends EJBObject {
    public double getPrixUnitaire() throws RemoteException;
    public void setCategorie(String categorie) throws RemoteException;
    public void setLibelle(String libelle) throws RemoteException;
    public void setPrixUnitaire(double prixUnitaire) throws RemoteException;
    public InfosArticle getInfos() throws RemoteException;
}
