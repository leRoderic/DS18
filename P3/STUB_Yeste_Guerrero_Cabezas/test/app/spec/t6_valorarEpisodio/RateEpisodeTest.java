package app.spec.t6_valorarEpisodio;

import app.controller.Controller;
import app.model.Episode;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class RateEpisodeTest {

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
    public String canBeRated(String episode, String idSerie, String nSeason, String idUser, String point){
        if(controller.episodeExists(episode, idSerie, Integer.parseInt(nSeason)))
            return ("Episodio valorable");
        return ("Episodio no valorable");
    }

    @Test
    public String rateEpisode(String idUser, String idSerie, String nSeason, String episode, String point) {
        int nSeas = Integer.parseInt(nSeason);
        this.controller.rateEpisode(idUser, idSerie, nSeason, episode, point);
        Episode e = controller.getEpisode(episode, idSerie, nSeas);
        if (e.findRating(idUser) != null)
            return e.findRating(idUser).getEmotion();
        else
            return ("No se puede hacer la valoración");
    }
}
