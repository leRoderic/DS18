package edu.ub.prog2.CabezasRodrigoNunezJosep.model;
import edu.ub.prog2.utils.AplicacioException;
import java.util.ArrayList;
import java.util.List;
import edu.ub.prog2.utils.InFileFolder;
import java.io.File;
import java.io.Serializable;

public class CarpetaFitxers implements InFileFolder,Serializable{
    protected ArrayList<FitxerMultimedia> carpeta;
    
    /**
     * Constructor per defecte.
     * 
     */
    public CarpetaFitxers(){
        this.carpeta = new ArrayList<>();
    }
    
    /**
     * Retorna el nombre d'elements a la carpeta
     * 
     * @return nombre elements
     */
    @Override
    public int getSize(){        
        return this.carpeta.size();
    }    
    
    /**
     * Retorna el fitxer de una posició donada.
     * 
     * @param position      la posició de la carpeta
     * @return el fitxer de la carpeta
     */
    @Override
    public FitxerMultimedia getAt(int position){
        return this.carpeta.get(position);
    }
    
    /**
     * Buidar la carpeta de fitxers.
     * 
     */
    @Override
    public void clear(){
        this.carpeta.clear();        
    }
    
    /**
     * Retorna true si la carpeta és buida.
     * 
     * @return true: buida  false: hi ha algun fitxer
     */
    public boolean isEmpty(){
        return (this.getSize() == 0);
    }
    
    /**
     * Sortida per imprimir usant toString de cada fitxer.
     * 
     * @return llista d'string amb resum de la carpeta
     */
    public List<String> write(){
        List<String> resum=new ArrayList<>();
        if(this.isEmpty()){
            resum.add("\nLa carpeta és buida.\n\n");
        }else{
            resum.add("\nCarpeta fitxers:\n==============\n");
            for (int i=0;i<carpeta.size();i++){
                resum.add("["+(i+1)+"] "+this.getAt(i).toString()+"\n");
            }        
        }
        resum.add("\n");
        return resum;
    }
    
    /**
     * Mostra el camí dels fitxers de la carpeta.
     * 
     * @return llista de camins absoluts dels fitxers
     */
    public List<String> writeCamins(){        
        List<String> resum =new ArrayList<>();
        //resum.add("\n==============\n");
        for (int i=0;i<carpeta.size();i++){
            resum.add("["+(i+1)+"] "+this.getAt(i).getNomFitxer()+this.getAt(i).getExtensio());
        }
        //resum.add("\n");
        return resum;
    }
    
    /**
     * Comprova si un fitxer és a la carpeta.
     * 
     * @param fitxer        el fitxer que ha de ser comprovat
     * @return true: sí que hi és   false: no hi és
     */
    public boolean contains(FitxerMultimedia fitxer){
        boolean found = false;
        int i =0;
        while((i<this.getSize())&&(!(found))){
            if (fitxer.equals(this.getAt(i))){
                found = true;
            }
            i++;
        }
        return found;
    }
    
    /**
     * Retorna si el fitxer corresponent  la id és a la carpeta.
     * 
     * @param i             l'id del fitxer
     * @return true: hi és  false: !no hi és
     */
    public boolean acotat(int i){
        return ((i<this.getSize())&&(i>-1));
    }

    /**
     * Permet afegir un fitxer a la biblioteca.
     * 
     * @param file          fitxer a afegir
     */
    @Override
    public void addFitxer(File file) throws AplicacioException{
        FitxerMultimedia fitxer=(FitxerMultimedia) file;
        if((fitxer.exists()) && (!(fitxer.isDirectory()))){
            if (this.contains(fitxer)){
                throw new AplicacioException("Aquest fitxer ja es troba a la carpeta.");
            }else{
                this.carpeta.add(fitxer);
            }
        }else{
            throw new AplicacioException("Aquest fitxer no existeix.");
        }
    }
    
    @Override
    public boolean isFull(){
        return false;
    }
    
    /**
     * Elimina un fitxer de la biblioteca.
     * 
     * @param file          el fitxer a eliminar
     */
    @Override
    public void removeFitxer(File file){
        FitxerMultimedia fitxer=(FitxerMultimedia) file;
        boolean removed = false;
        int i =0;
        while((i<this.getSize())&&(!(removed))){
            if (fitxer.equals(this.getAt(i))){
                this.carpeta.remove(i);
                removed = true;
            }
            i++;
        }
    }
}