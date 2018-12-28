package app.spec.t4_suscribirseAEpisodio;

import app.controller.Controller;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class SubscribeToEpisodeTest {

    private Controller controller;

    @Before
    public void init() {
        this.controller = Controller.getInstance();
    }

    @Test
    public void playEpisode(String title, String idSerie, String nSeason, String idUser) {
        this.controller.viewEpisode(title, idSerie, nSeason, idUser);
    }

    @Test
    public String addSubscription(String id, String title, String nSeason, String idSerie) {
        int nSeas = Integer.parseInt(nSeason);
        if (this.controller.subscribeToEpisode(title, idSerie, nSeas, id))
            return ("Suscripción realizada");
        else
            return ("Suscripción no realizada");
    }
}


