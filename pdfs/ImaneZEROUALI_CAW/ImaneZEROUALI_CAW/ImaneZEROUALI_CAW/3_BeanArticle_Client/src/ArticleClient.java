import javax.naming.*;
import java.util.*;
import article.*;

public class ArticleClient {

	public Article creerArticle(int numeroArticle, 
			String libelle, 
			double montantUnitaire, 
			String categorie) {
		ArticleHome ah;
		Article article = null;
		Properties props = new Properties();
		props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
		props.put("java.naming.provider.url", "localhost:1099");
		try {
			Context ic = new InitialContext(props);
			ah = (ArticleHome) ic.lookup("ArticleBean");

			article = ah.create(new Integer(numeroArticle),libelle, montantUnitaire, categorie);
			afficherInfosArticle(article.getInfos());

		} catch (Throwable th) {
			System.out.println("Erreur dans creerArticle : " + th);
		}
		return article;
	}


	public void afficherInfosArticle(InfosArticle infos) {
		System.out.println("voici les infos sur l'article : " + infos.idArticle);
		System.out.println("   id : " + infos.idArticle);
		System.out.println("   libelle : " + infos.libelle);
		System.out.println("   prix unitaire : " + infos.prixUnitaire);
		System.out.println("   categorie : " + infos.categorie);
	}

	public Article rechercherArticle(int numeroArticle) {
		ArticleHome ah;
		Article article = null;
		Properties props = new Properties();
		props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
		props.put("java.naming.provider.url", "localhost:1099");
		try {
			Context ic = new InitialContext(props);
			ah = (ArticleHome) ic.lookup("ArticleBean");
			article = ah.findByPrimaryKey(new Integer(numeroArticle));

			InfosArticle ia = article.getInfos();
			afficherInfosArticle(ia);
		} catch (Throwable th) {
			System.out.println("GereCommande.creerArticle : " + th);
		}
		return article;
	}

	public void rechercherArticlesParCategorie(String categorie) {

		ArticleHome ah;
		Article article;
		Collection<Article> col;
		Properties props = new Properties();
		props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
		props.put("java.naming.provider.url", "localhost:1099");
		try {
			Context ic = new InitialContext(props);
			ah = (ArticleHome) ic.lookup("ArticleBean");
			col = ah.findByCategorie(categorie);

			Iterator<Article> i = col.iterator();
			while (i.hasNext()) {
				article = (Article) i.next();
				afficherInfosArticle(article.getInfos());
			}
		} catch (Throwable th) {
			System.out.println("Erreur dans rechercherArticlesParCategorie : " + th);
		}
	}

	public static void main(java.lang.String[] args) {

		ArticleClient a = new ArticleClient ();
		System.out.println ("============== Creation des articles");
		a.creerArticle(1,"Les miserables", 21, "LIVRE");
		a.creerArticle(2,"Celine Dion au stade de France", 120, "CD");
		a.creerArticle(3,"Je l'aime a mourir", 28, "LIVRE");
		a.creerArticle(4,"La mer", 38, "LIVRE");

		// Recherche de l'article 3
		System.out.println ("============== Recherche de l'article 3");
		a.rechercherArticle(3);

		// Recherche de la categorie
		System.out.println ("============== Recherche des articles de type CD");
		a.rechercherArticlesParCategorie("CD");
	}
}
