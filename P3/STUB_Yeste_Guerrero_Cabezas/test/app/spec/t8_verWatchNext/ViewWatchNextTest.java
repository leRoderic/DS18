package app.spec.t8_verWatchNext;

import app.controller.Controller;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class ViewWatchNextTest {

    private Controller controller;

    @Before
    public void init() {
        this.controller = Controller.getInstance();
    }

    @Test
    public String checkHasEmptyWatchNextList(String id) {
        return this.controller.hasEmptyWatchNext(id);
    }

    @Test
    public void addNext(String id, String idSerie){
        this.controller.addWatchNextList(id,idSerie);
    }

    @Test
    public void playEpisode(String title, String id, String nSeason, String idUser){
        this.controller.viewEpisode(title, id, nSeason, idUser);
    }

    @Test
    public String chkWatchNextAvailable(String user){
        if(controller.getUser(user).getWatchedEpisodes().isEmpty())
            return ("Watch Next no disponible");
        return ("Watch Next disponible");
    }

}

