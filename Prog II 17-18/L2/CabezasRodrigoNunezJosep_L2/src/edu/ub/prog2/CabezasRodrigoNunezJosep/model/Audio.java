package edu.ub.prog2.CabezasRodrigoNunezJosep.model;
import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.Reproductor;
import java.io.File;

public class Audio extends FitxerReproduible {
    
    private final int kbps;
    private final File fitxerImatge;
    
    /**
     * Constructor de Audio
     * 
     * @param cami          path del fitxer
     * @param fitxerImatge  caratula per l'àudio
     * @param nom           descripció de l'àudio
     * @param codec         el codec de l'àudio
     * @param durada        la durada de l'àudio
     * @param kbps          la velocitat de l'àudio
     * @param r             el reproductor
     */
    public Audio(String cami, String nom, String codec, float durada, File fitxerImatge, int kbps, Reproductor r){
        super(cami, nom, codec, durada, r);
        this.kbps = kbps;
        this.fitxerImatge = fitxerImatge;
    }
    
    /**
     * Getter de la velocitat.
     * 
     * @return kpbs la velocitat del audio
     */
    public int getKbps(){
        return this.kbps;
    }
    
    /**
     * Getter de la caratula.
     * 
     * @return File el fitxer imatge del audio
     */
    public File getImatge(){
        return this.fitxerImatge;
    }
    
    /**
     * ToString de la classe Audio.
     * 
     * @return string amb el resum de les dades
     */
    @Override
    public String toString(){
        String retorn=super.toString()+"kbps = "+this.getKbps()+"\n";
        return retorn;
    }
    
    /**
     * Reprodueix l'audio
     */
    @Override
    public void reproduir(){
        // TO DO -> LLIURAMENT 3
    }
}
