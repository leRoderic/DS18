package edu.ub.prog2.CabezasRodrigoNunezJosep.model;

import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.Reproductor;

public class Video extends FitxerReproduible {
    
    private int alcada, amplada;
    private float fps;
    
    /**
     * Constructor de Video
     * 
     * @param cami      path del fitxer
     * @param nom       descripció del fitxer
     * @param codec     el codec del fitxer
     * @param durada    la durada del vídeo
     * @param alcada    la alçada del vídeo
     * @param amplada   la amplada del video
     * @param fps       els fps del vídeo
     * @param r         el reproductor del vídeo
     */
    public Video(String cami, String nom, String codec, float durada, int alcada, int amplada, float fps, Reproductor r){
        super(cami, nom, codec, durada, r);
        this.alcada = alcada;
        this.amplada = amplada;
        this.fps = fps;
    }
    
    /**
     * Retorna la alçada del video
     * 
     * @return alcada la alcaçada del video
     */
    public int getAlcada(){
        return this.alcada;
    }
    
    /**
     * Retorna la amplada del video.
     * 
     * @return amplada  la amplada del video
     */
    public int getAmplada(){
        return this.amplada;
    }
    
    /**
     * Retorna els fps' del video
     * 
     * @return fps els fps'
     */
    public float getFps(){
        return this.fps;
    }
    
    /**
     * ToString de la classe Video.
     * 
     * @return string amb el resum dels fitxers
     */
    @Override
    public String toString(){
        String retorn=super.toString()+"alçada = "+this.getAlcada()+"\namplada = "+this.getAmplada()+"\nfps = "+this.getFps()+"\n";
        return retorn;
    }
    
    /**
     * Reprodueix el vídeo.
     */
    @Override
    public void reproduir(){
        // TO DO -> LLIURAMENT 3
    }
}
