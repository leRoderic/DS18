package edu.ub.prog2.CabezasRodrigoNunezJosep.model;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.Serializable;
        
public class BibliotecaFitxersMultimedia extends CarpetaFitxers implements Serializable{
    
    public BibliotecaFitxersMultimedia(){
        super();
    }
    
    /**
     * Permet afegir un fitxer a la biblioteca.
     * 
     * @param file fitxer a afegir
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    public void addFitxer(File file) throws AplicacioException{
        FitxerMultimedia fitxer=(FitxerMultimedia) file;
        if((fitxer.exists()) && (!(fitxer.isDirectory()))){
            if (this.contains(fitxer)){
                throw new AplicacioException("Aquest fitxer ja es troba a la biblioteca.");
            }else{
                this.carpeta.add(fitxer);
            }
        }else{
            throw new AplicacioException("Aquest fitxer no existeix.");
        }
    }
    
    /**
     * Elimina un fitxer de la biblioteca.
     * 
     * @param fitxer el fitxer a eliminar
     */
    public void removeFitxer(FitxerMultimedia fitxer){
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
    
    /**
     * Indica si el fitxer és pot borrar.
     * 
     * @param i id del fitxer
     * @return  true: borrable  false: no borrable
     */
    public boolean isRemovable(int i){
        return ((i<this.getSize())&&(i>-1));
    }   
}
