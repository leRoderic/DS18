package app.spec.t2_loginNuevoCliente;

import app.controller.Controller;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class LoginTest {

    private Controller controller;

    @Before
    public void init() {
        this.controller = Controller.getInstance();
    }

    @Test
    public String testLogIn(String nick, String password) {
        if(this.controller.loginSuccesful(nick, password))
            return ("Login correcto");
        return ("Login no válido");
    }

    @Test
    public String userExists(String nick){
        if(this.controller.userExists(nick))
            return ("Usuario existe");
        return ("Usuario no existe");
    }
}

