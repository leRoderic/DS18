package edu.ub.prog2.CabezasRodrigoNunezJosep.controlador;
import edu.ub.prog2.CabezasRodrigoNunezJosep.model.CarpetaFitxers;
import edu.ub.prog2.CabezasRodrigoNunezJosep.model.FitxerReproduible;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.EscoltadorReproduccioBasic;

public class EscoltadorReproduccio extends EscoltadorReproduccioBasic{
    private CarpetaFitxers llistaReproduint;
    private boolean [ ] llistaCtrl;
    private boolean reproduccioCiclica, reproduccioAleatoria;
    private int pos;
    
    /**
     * Constructor per defecte de la classe EscoltadorReproduccio.
     * 
     */
    public EscoltadorReproduccio(){
        this.llistaReproduint=new CarpetaFitxers();
        this.reproduccioCiclica=false;
        this.reproduccioAleatoria=false;
        this.pos=0;
    }
    
    /**
     * Setter per la carpeta de fitxers que és reproduïda.
     * 
     * @param llistaReproduint      la carpeta
     */
    public void setLlista(CarpetaFitxers llistaReproduint){
        this.llistaReproduint=llistaReproduint;
        this.llistaCtrl=new boolean[this.llistaReproduint.getSize()];
        for(int i=0;i<this.llistaReproduint.getSize();i++){
            this.llistaCtrl[i]=false;
        }
        FitxerReproduible fitxer=(FitxerReproduible)this.getLlista().getAt(pos);
        llistaCtrl[pos]=true;
        try{
            fitxer.reproduir();
        }catch (AplicacioException e){}
    }
    
    /**
     * Canvia l'estat de la reprodució cíclica.
     * 
     * @param reproduccioCiclica    nou estat
     */
    public void setCiclica(boolean reproduccioCiclica){
        this.reproduccioCiclica=reproduccioCiclica;
    }
    
    /**
     * Canvia l'estat de la reprodució aleatória.
     * 
     * @param reproduccioAleatoria  nou estat
     */
    public void setAleatoria(boolean reproduccioAleatoria){
        this.reproduccioAleatoria=reproduccioAleatoria;
    }
    
    /**
     * Getter per la carpeta en reproducció.
     * 
     * @return la carpeta
     */
    public CarpetaFitxers getLlista(){
        return this.llistaReproduint;
    }
    
    /**
     * Getter per l'array de control.
     * 
     * @return l'array de control
     */
    public boolean[] getControl(){
        return this.llistaCtrl;
    }
    
    /**
     * Retorna l'estat de la reproducció cíclica.
     * 
     * @return estat de la reproducció cíclica
     */
    public boolean getCiclica(){
        return this.reproduccioCiclica;
    }
    
    /**
     * Retorna l'estat de la reproducció aleatória.
     * 
     * @return estat de la reproducció aleatória
     */
    public boolean getAleatoria(){
        return this.reproduccioAleatoria;
    }
    
    /**
     * Si hi ha següent, reproduirà el següent fitxer. Si la reproducció cíclica
     * és activa, tornarà a reproduir desde el principi. En els altres cassos s'atura
     * la reproducció.
     */
    @Override
    protected void onEndFile(){
        if(hasNext()){
            next();
        }
        else{
            if(getCiclica()){
                setLlista(this.llistaReproduint);
                next();
            }
        }
    }

    /**
     * Si la reproducció aleatòria es seleccionada, triarà una posició aleatòria
     * que correspondrà a un fitxer de la carpeta reproduïda en l'instant. Si no
     * és activa, augmentarà la posició una unitat per reproduir el següent fitxer
     * a la carpeta.
     */
    @Override
    public void next() {
        if(getAleatoria()){
            pos=(int)Math.round(Math.random()*(llistaCtrl.length-1));
            while(llistaCtrl[pos]){
                if((pos+1)<llistaCtrl.length){
                    pos++;
                }else{
                    pos=0;
                }
            }
        }else{
            if((pos+1)<llistaCtrl.length){
                pos++;
            }else{
                pos=0;
            }
        }
        FitxerReproduible fitxer=(FitxerReproduible)this.getLlista().getAt(pos);
        llistaCtrl[pos]=true;
        try{
            fitxer.reproduir();
        }catch (AplicacioException e){}
    }

    /**
     * Comprova si s'ha reproduït tota la carpeta.
     * 
     * @return true: queda per reproduïr    false: no hi has més fitxers
     */
    @Override
    protected boolean hasNext() {
        if (llistaCtrl != null){
            for(int i=0;i<llistaCtrl.length;i++){
                if(!(llistaCtrl[i])){
                    return true;
                }
            }
        }
        return false;
    }
}
