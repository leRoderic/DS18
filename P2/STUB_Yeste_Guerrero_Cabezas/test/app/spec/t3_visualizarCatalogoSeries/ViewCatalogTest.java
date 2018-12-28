package app.spec.t3_visualizarCatalogoSeries;

import app.controller.Controller;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class ViewCatalogTest {

    private Controller controller;

    @Before
    public void init(){
        this.controller = new Controller("src/resources/StUB.xml");
    }

    @Test
    public String isInCatalog(String idSerie){
        if(this.controller.getSeries(idSerie) != null)
            return ("Serie existe");
        else
            return ("Serie no existe");
    }

    @Test
    public void clearCatalog(){
        this.controller.getCatalog().getSeries().clear();
    }

    @Test
    public String chkEmptyCatalog(){
        if(this.controller.getSeriesCatalog().size() == 0)
            return ("Catálogo vacío, no hay series disponibles");
        else
            return ("Hay series disponibles en el catálogo");
    }
}