package edu.ub.prog2.CabezasRodrigoNunezJosep.model;

import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.Reproductor;

public abstract class FitxerReproduible extends FitxerMultimedia{
    
    private final String codec;
    private final float durada;
    private final Reproductor reproductor;
   
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
    
    protected abstract void reproduir();
    
    public Reproductor getReproductor(){
        return this.reproductor;
    }

    public String getCodec(){
        return this.codec;
    }
    
    public float getDurada(){
        return this.durada;
    }
    
    @Override
    public String toString(){
        String retorn=super.toString()+"codec = "+this.getCodec()+"\ndurada = "+this.getDurada()+"\n";
        return retorn;
    }
}
