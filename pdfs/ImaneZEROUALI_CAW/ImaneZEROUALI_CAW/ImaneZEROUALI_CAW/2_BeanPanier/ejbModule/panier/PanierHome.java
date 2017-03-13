package panier;

import javax.ejb.*;
import java.rmi.*;

public interface PanierHome extends EJBHome {
    public Panier create() 
                throws RemoteException, CreateException;
    public Panier createAvecNom(String nomClient)
                throws RemoteException, CreateException;
}
