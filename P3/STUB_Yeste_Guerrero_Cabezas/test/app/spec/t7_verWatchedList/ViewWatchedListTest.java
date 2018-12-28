package app.spec.t7_verWatchedList;

import app.controller.Controller;
import app.model.Series;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class ViewWatchedListTest {
    private Controller controller;

    @Before
    public void init() {
        this.controller = Controller.getInstance();
    }

    @Test
    public String checkHasEmptyWatchedList(String id) {
        return this.controller.hasEmptyWatchedList(id);
    }

    @Test
    public void add(String id, String idSerie){
       this.controller.addWatchedList(id,idSerie);
    }

}

