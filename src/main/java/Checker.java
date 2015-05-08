
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.apache4.ApacheHttpClient4;
import com.sun.jersey.client.apache4.config.ApacheHttpClient4Config;
import com.sun.jersey.client.apache4.config.DefaultApacheHttpClient4Config;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;


public class Checker {

    //~ Methods ----------------------------------------------------------------
    /**
     * DOCUMENT ME!
     *
     * @param args DOCUMENT ME!
     *
     * @throws Exception DOCUMENT ME!
     */
    public static void main(final String[] args) throws Exception {
        final DefaultApacheHttpClient4Config cc = new DefaultApacheHttpClient4Config();

        String host=args[0];
        String domain=args[1];
        String user=args[2];
        String pw=args[3];
        
        System.out.println("proxy="+host+" domain="+domain+" user="+user+ " pw="+pw);
        
        cc.getProperties().put(DefaultApacheHttpClient4Config.PROPERTY_PROXY_URI, host);

        CredentialsProvider credentialsProvider=new org.apache.http.impl.client.BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new NTCredentials(user, pw,"",domain ));
  
        cc.getProperties().put(ApacheHttpClient4Config.PROPERTY_CREDENTIALS_PROVIDER,credentialsProvider);

        final ApacheHttpClient4 client = ApacheHttpClient4.create(cc);
        System.out.println(cc.getProperties());

        final WebResource r = client.resource("http://httpbin.org/ip");
        final String s = r.get(String.class);
        System.out.println(s);

    }
}
