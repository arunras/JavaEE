import java.util.Properties;

import javax.naming.Context;

public class Main {
	public static void main(String[] args) {
		Properties jndiProperties = new Properties();
    jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
    jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
    jndiProperties.put("jboss.naming.client.ejb.context", true);
    
    Context jndi = new InitialContext(jndiProperties);

    ShoppingCartSession cart = jndi.lookup("");
	}

}
