package app.spec.t9_verNotStartedYet;

import app.controller.Controller;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class ViewNotStartedYetTest {
    private Controller controller;

    @Before
    public void init() {
        this.controller = Controller.getInstance();
    }

    @Test
    public String checkHasEmptyNonStartedYetList(String id) {
        return this.controller.hasNonStartedYet(id);
    }

    @Test
    public void addNonStarted(String id, String idSerie){
        this.controller.addNonStartedYet(id,idSerie);
    }

    @Test
    public void addComingEpisodes(String id, String tEpisode,String idSerie1,int nSeason,String idSerie2){
        this.controller.addComingEpisode(id,tEpisode,idSerie1,nSeason,idSerie2);
    }
    @Test
    public String checkIfComingEpisode(String id){
        return this.controller.hasComingEpisode(id);
    }
}
