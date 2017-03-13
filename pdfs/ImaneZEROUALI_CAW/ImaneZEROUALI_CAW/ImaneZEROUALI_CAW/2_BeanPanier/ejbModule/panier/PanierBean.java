package panier;

import javax.ejb.*;
import java.util.*;

public class PanierBean implements SessionBean {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SessionContext sessionContext;
    Vector<Integer> articles;
    String nomClient;

    public void ejbCreate() throws  CreateException {
        articles = new Vector<Integer>();
    }

    public void ejbCreateAvecNom(String nomClient) throws  CreateException {
        this.nomClient = nomClient;
        articles = new Vector<Integer>();
    }

    public void ejbRemove() { }
    public void ejbActivate() { }
    public void ejbPassivate() { }

    public void setSessionContext(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

    public void ajouterArticle(int idArticle) {
        articles.add(new Integer(idArticle));
    }

    public void supprimerArticle(int idArticle){
    articles.remove(new Integer(idArticle));
    }

    public Vector<Integer> listerArticles(){
        return articles;
    }

    public void setNom(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getNom() {
        return nomClient;
    }
}
