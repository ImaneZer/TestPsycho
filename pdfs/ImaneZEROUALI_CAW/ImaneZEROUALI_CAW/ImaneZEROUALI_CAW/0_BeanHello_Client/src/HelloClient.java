import javax.naming.Context;
import javax.naming.InitialContext;
import hello.*;
import java.util.*;

public class HelloClient{
    public static void main(String[] args) throws Exception {
        Properties props = System.getProperties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
             
        Context ctx = new InitialContext(props);
        Hello hello = (Hello) ctx.lookup("HelloBean/remote");

        System.out.println(hello.hello("Le Havre"));
    }
}
