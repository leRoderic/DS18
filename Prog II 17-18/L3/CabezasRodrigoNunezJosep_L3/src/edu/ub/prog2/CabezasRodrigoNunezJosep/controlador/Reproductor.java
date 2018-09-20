package edu.ub.prog2.CabezasRodrigoNunezJosep.controlador;
import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.EscoltadorReproduccio;
import edu.ub.prog2.CabezasRodrigoNunezJosep.model.Audio;
import edu.ub.prog2.CabezasRodrigoNunezJosep.model.FitxerReproduible;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.ReproductorBasic;
import java.io.File;

public class Reproductor extends ReproductorBasic{
    
    /**
     * Contructor per defecte de la classe Reproductor.
     * 
     * @param controlador   obvi
     */
    public Reproductor(EscoltadorReproduccio controlador) {
        super(controlador);
    }
    
    /*public Reproductor(String vlcPath, int verbose, EscoltadorReproduccioBasic controlador) {
        super(vlcPath, verbose, controlador);
    }
    
    public Reproductor(String vlcPath, EscoltadorReproduccioBasic controlador) {
        super(vlcPath, controlador);
    }*/
    
    /**
     * Reprodueix un fitxer.
     * 
     * @param fr            el fitxer en qëstió
     * @throws AplicacioException abs
     */
    public void reprodueix(FitxerReproduible fr) throws AplicacioException{
        this.play(fr);        
    }
    
    /**
     * Reprodueix un àudio.
     * 
     * @param audio         l'audio
     * @param fitxerImatge  la seva caratula
     * @throws AplicacioException abs
     */
    public void reprodueix(Audio audio, File fitxerImatge) throws AplicacioException{
        this.play(audio,fitxerImatge);
    }
}
