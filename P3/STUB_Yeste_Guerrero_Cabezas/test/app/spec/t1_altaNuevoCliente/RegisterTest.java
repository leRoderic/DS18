package app.spec.t1_altaNuevoCliente;

import app.controller.Controller;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class RegisterTest {

    private Controller controller;

    @Before
    public void init(){
        controller = Controller.getInstance();
    }

    @Test
    public void registerUser(String id, String dni, String name, String adress, String nick, String password){
        this.controller.addNewUser(id, name, dni, adress, nick, password);

    }

    @Test
    public String isRegistered(String nick){
        if(this.controller.userExists(nick))
            return ("Registrado");
        return ("No registrado");
    }

    @Test
    public String isAlreadyRegistered(String nick){
        if(this.controller.userExists(nick))
            return ("Registro no disponible");
        return ("Registro disponible");
    }

    @Test
    public String isValidNick(String nick){
        if(this.controller.userExists(nick))
            return ("Usuario no disponible");
        return ("Usuario disponible");
    }
}
