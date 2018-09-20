package edu.ub.prog2.CabezasRodrigoNunezJosep.model;
import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.Reproductor;
import edu.ub.prog2.utils.AplicacioException;

public abstract class FitxerReproduible extends FitxerMultimedia{
    
    private final String codec;
    private final float durada;
    private transient Reproductor reproductor;
   
    /**
     * Constructor de fitxer reproduible
     * 
     * @param cami      path del fitxer
     * @param nom       descripció del fitxer
     * @param codec     el codec del fitxer
     * @param durada    la durada del fitxer reproduible
     * @param r         el reproductor pel fitxer reproduible
     */
    protected FitxerReproduible(String cami, String nom, String codec, float durada, Reproductor r){
        super(cami, nom);
        this.codec = codec;
        this.durada = durada;
        this.reproductor = r;
    }
    
    /**
     * Reprodueix el fitxer.
     * 
     * @throws AplicacioException asb
     */
    public abstract void reproduir() throws AplicacioException;
    
    /**
     * Getter per reproductor.
     * 
     * @return el reproductor
     */
    public Reproductor getReproductor(){
        return this.reproductor;
    }
    
    /**
     * Getter per codec.
     * 
     * @return codec
     */
    public String getCodec(){
        return this.codec;
    }
    
    /**
     * Getter per la durada del fitxer.
     * 
     * @return la durada
     */
    public float getDurada(){
        return this.durada;
    }
    
    /**
     * Setter per reproductor.
     * 
     * @param reproductor obvi
     */
    public void setReproductor(Reproductor reproductor){
        this.reproductor=reproductor;
    }
    
    /**
     * ToString de la classe FitxerReproduible.
     * 
     * @return resum del fitxer
     */
    @Override
    public String toString(){
        String retorn=super.toString()+"codec = "+this.getCodec()+"\ndurada = "+this.getDurada()+"\n";
        return retorn;
    }
}