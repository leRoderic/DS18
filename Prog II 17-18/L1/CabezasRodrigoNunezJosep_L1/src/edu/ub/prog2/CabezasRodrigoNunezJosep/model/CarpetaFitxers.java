package edu.ub.prog2.CabezasRodrigoNunezJosep.model;
import java.util.ArrayList;

public class CarpetaFitxers {
    private int maxSize;
    private ArrayList<FitxerMultimedia> carpeta;
    
    /**
     * Constructor per defecte.
     * 
     */
    public CarpetaFitxers(){
        this.maxSize = 100;
        this.carpeta = new ArrayList<FitxerMultimedia>(100);
    }
    
    /**
     * Constructor de carpeta amb tamany variable.
     * 
     * @param tamany el tamany de la carpeta
     */
    public CarpetaFitxers(int tamany){
        this.maxSize = tamany;
        this.carpeta = new ArrayList<FitxerMultimedia>(tamany);
    }
    
    /**
     * Retorna el nombre d'elements a la carpeta
     * 
     * @return nombre elements
     */
    public int getSize(){        
        return this.carpeta.size();
        
    }
    
    /**
     * Afegeix fitxer a la carpeta.
     * 
     * @param fitxer el fitxer a afegir
     * @return èxit o fracàs de la inserció
     */
    public int addFitxer(FitxerMultimedia fitxer){
        if(this.isFull()){            
            System.out.print("\n\033[31mError! La carpeta ja és plena.\033[0m\n");
            return -2;
        }
        for(int i=0;i<this.getSize();i++){
            if(this.getAt(i).equals(fitxer)){
                System.out.print("\n\033[31mError! El fitxer ja es troba a la carpeta.\033[0m\n");
                return -1;
            }
        }
        this.carpeta.add(fitxer);
        System.out.print("\n\033[32mFitxer afegit amb èxit.\033[0m\n");
        return 1;
}
    
    /**
     * Suprimeix el fitxer de la carpeta.
     * 
     * @param fitxer el fitxer a borrar
     * @return èxit o fracàs de l'eliminació
     */
    public boolean removeFitxer(FitxerMultimedia fitxer){
        boolean removed = false;
        int i =0;
        while((i<this.getSize())&&(!(removed))){
            if (fitxer.equals(this.getAt(i))){
                this.carpeta.remove(i);
                removed = true;
            }
            i++;
        }
        if(!removed){
            System.out.print("\n\033[31mError! L'arxiu no existeix o no es troba en aquesta carpeta.\033[0m\n");
            return false;
        }
        System.out.print("\n\033[32mFitxer eliminat amb èxit.\033[0m\n");
        return true;
}
    
    /**
     * Retorna el fitxer de una posició donada.
     * 
     * @param position la posició de la carpeta
     * @return el fitxer de la carpeta
     */
    public FitxerMultimedia getAt(int position){
        if((position>(this.getSize()-1))||(position<0)){
            System.out.print("\033[31mError! No hi ha cap arxiu en aquesta posició.\033[0m");
            return null;
        }else{
            return this.carpeta.get(position);
        }
    }
    
    /**
     * Buidar la carpeta de fitxers.
     * 
     */
    public void clear(){
        this.carpeta.clear();        
    }
    
    /**
     * Retorna true si la carpeta és plena.
     * 
     * @return true: plena  false: hi ha espai encara
     */
    public boolean isFull(){
        return this.getSize() == this.maxSize;
    }
    
    /**
     * Retorna true si la carpeta és buida.
     * 
     * @return true: buida  false: hi ha algun fitxer
     */
    public boolean isEmpty(){
        return this.getSize() == 0;
    }
    
    @Override
    public String toString(){
        if(this.isEmpty()){
            return "La carpeta és buida.\n\n";
        }
        String resum = "Carpeta fitxers:\n==============\n\n";
        for (int i=0;i<carpeta.size();i++){
            resum=resum+"["+(i+1)+"] "+this.getAt(i).toString()+"\n";
        }
        return resum;
    }
    
    /**
     * Mostra el camí dels fitxers de la carpeta.
     * 
     * @return llista de camins absoluts dels fitxers
     */
    public String toStringCami(){        
        String resum = "\n==============\n\n";
        for (int i=0;i<carpeta.size();i++){
            resum=resum+"["+(i+1)+"] "+this.getAt(i).getCamiAbsolut()+"\n";
        }
        return resum;
    }
}
