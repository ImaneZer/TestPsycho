package article;

public class InfosArticle implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final Integer idArticle;
    public final String libelle;
    public final double prixUnitaire;
    public final String categorie;
 
    public InfosArticle(Integer argIdArticle, String argLibelle, 
                double argPrixUnitaire, String argCategorie) {
        super();
        idArticle = argIdArticle;
        libelle = argLibelle;
        prixUnitaire = argPrixUnitaire;
        categorie = argCategorie;
    }
}
