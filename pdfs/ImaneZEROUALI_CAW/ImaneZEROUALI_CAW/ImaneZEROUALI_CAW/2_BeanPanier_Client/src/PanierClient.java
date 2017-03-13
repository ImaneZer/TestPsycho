import javax.naming.*;
import javax.rmi.PortableRemoteObject;
import java.util.*;
import panier.*;

public class PanierClient {
	public static void main(String[] args) throws Exception {
		try {
			Properties props = System.getProperties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			props.put(Context.PROVIDER_URL, "jnp://localhost:1099"); 
			Context ctx = new InitialContext();
			Object ref = ctx.lookup("PanierEJB");
			PanierHome panierHome = (PanierHome) PortableRemoteObject.narrow(ref, PanierHome.class);
			Panier monPanier = panierHome.createAvecNom("Dupont");
			monPanier.ajouterArticle(65);
			monPanier.ajouterArticle(53);

			System.out.println ("====================================");
			Vector<Integer> mesArticles = monPanier.listerArticles();
			System.out.println ("Il y a "+mesArticles.size()+" article(s) dans le panier !");
			Enumeration<Integer> e = mesArticles.elements();
			while (e.hasMoreElements()) {
				System.out.println((Integer)e.nextElement());
			}

			monPanier.ajouterArticle(23);
			monPanier.ajouterArticle(18);
			monPanier.supprimerArticle(65);

			System.out.println ("====================================");
			mesArticles = monPanier.listerArticles();
			System.out.println ("Il y a "+mesArticles.size()+" article(s) dans le panier !");
			e = mesArticles.elements();
			while (e.hasMoreElements()) {
				System.out.println((Integer)e.nextElement());
			}
			monPanier.remove();
		} catch (Exception e) { e.printStackTrace();}
	}
}
