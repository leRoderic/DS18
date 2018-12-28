package app.spec.t5_visualizarEpisodio;

import app.controller.Controller;
import app.model.Episode;
import app.model.User;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class ViewEpisodeTest {

    private Controller controller;

    @Before
    public void init() {
        this.controller = Controller.getInstance();
    }

    @Test
    public void playEpisode(String title, String idSerie, String nSeason, String idUser) {
        int nSeas = Integer.parseInt(nSeason);
        this.controller.viewEpisode(title, idSerie, nSeason, idUser);
    }

    @Test
    public String hasBeenPlayed(String title, String idSerie, String nSeason, String idUser) {
        int nSeas = Integer.parseInt(nSeason);
        Episode tmp = this.controller.getEpisode(title, idSerie, nSeas);
        User u = controller.getUser(idUser);
        if(u.isWatched(tmp))
            return ("Reproducido");
        else
            return ("No Reproducido");
    }
}
