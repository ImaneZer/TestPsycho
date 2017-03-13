package hello;

import javax.ejb.*;

@Stateless 
@Remote
public class HelloBean implements Hello {
    public String hello (String msg){
        return "Hello "+msg;
    }
}
