import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;

import calc.*;

public class CalcClient{
    public static void main(String[] args) throws Exception {
        Properties props = System.getProperties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                  "org.jnp.interfaces.NamingContextFactory");
        props.put(Context.URL_PKG_PREFIXES,
                  "org.jboss.naming:org.jnp.interfaces");
        props.put(Context.PROVIDER_URL, "jnp://localhost:1099");

        Context ctx = new InitialContext(props);
        Calc calc = (Calc) ctx.lookup("CalcBean/remote");

        double somme = 0;
        double multip = 0;
        somme = calc.add(1, 2);
        System.out.println("Addition de 1 + 2 = "+somme);
        multip = calc.mult(2, 3);
        System.out.println("Multiplication de 2 x 3 = "+multip);
    }
}
