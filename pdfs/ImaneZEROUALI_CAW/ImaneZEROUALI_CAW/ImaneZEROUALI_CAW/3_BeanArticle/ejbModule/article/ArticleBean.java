package article;

import java.util.*;
import javax.ejb.*;

public abstract class ArticleBean implements EntityBean {

	private static final long serialVersionUID = 1L;
	EntityContext ec = null;

    public ArticleBean() { }

    // accesseurs(1)

    public abstract String getCategorie();
    public abstract Integer getIdArticle();
    public abstract String getLibelle();
    public abstract double getPrixUnitaire();
    public abstract void setCategorie(String categorie);
    public abstract void setIdArticle(Integer idArticle);
    public abstract void setLibelle(String libelle);
    public abstract void setPrixUnitaire(double prixUnitaire);

    // methodes metier (2)

    public InfosArticle getInfos() {
        InfosArticle ia = new InfosArticle(getIdArticle(), getLibelle(), getPrixUnitaire(), getCategorie());
        return ia;
    }

    // methodes de creation (3)

    public Integer ejbCreate(Integer idArticle, String libelle, double prixUnitaire, String categorie) 
        throws CreateException {
        if (libelle == null || libelle.equals("")) {
            throw new CreateException("Le libelle est obligatoire");
        }
        setIdArticle(idArticle);
        setLibelle(libelle);
        setPrixUnitaire(prixUnitaire);
        setCategorie(categorie);
        return null;
    }
    public void ejbPostCreate(Integer idArticle, String libelle, double prixUnitaire, String categorie) 
        throws CreateException { }

    public Integer ejbCreateSansID(String libelle, double prixUnitaire, String categorie) 
    throws CreateException {
        Integer idArticle = new Integer(libelle.hashCode());
    return ejbCreate(idArticle, libelle, prixUnitaire, categorie);
    }

    //methodes sans entite (4) 

    public Integer ejbHomeGetNbreArticleDeCategorie(String categorie) {
        int res = 0;
        try {
            Collection<Article> lesArticles = null;
            // Implementation sans select
            ArticleHome ao = (ArticleHome) (ec.getEJBHome());
            lesArticles = ao.findByCategorie(categorie);
            res = lesArticles.size();
        } catch (FinderException fe) {
            throw new EJBException(fe);
        } catch (java.rmi.RemoteException re) {
            throw new EJBException(re);
        }
        return new Integer(res);
    }

    public void ejbPostCreateSansID(String libelle, double prixUnitaire, String categorie)
            throws CreateException {
    }

    // methodes de rappel (6)
    
    public void setEntityContext(javax.ejb.EntityContext param1) { ec = param1; }
    public void unsetEntityContext() { ec = null; }

    public void ejbActivate() { System.out.println("ejbActivate"); }
    public void ejbLoad() { System.out.println("ejbLoad"); }
    public void ejbStore() { System.out.println("ejbStore"); }
    public void ejbRemove()  { System.out.println("ejbRemove"); }
    public void ejbPassivate() { System.out.println("ejbPassivate"); }
}
