package edu.ub.prog2.CabezasRodrigoNunezJosep.model;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AlbumFitxersMultimedia extends CarpetaFitxers{
    
    private final int maxSize;
    private final String titol;
    
    /**
     * Constructor amb títol per párametre.
     * 
     * @param titol el títol del àlbum
     */
    public AlbumFitxersMultimedia(String titol){
        this.carpeta = new ArrayList<>();
        this.maxSize=10;
        this.titol=titol;
    }
    
    /**
     * Constructor amb títol i tamany màxim per paràmetre.
     * 
     * @param titol             el títol del àlbum
     * @param maxSize           la mida màxima del àlbum
     */
    public AlbumFitxersMultimedia(String titol, int maxSize){
        this.carpeta = new ArrayList<>();
        this.maxSize=maxSize;
        this.titol=titol;
    }
    
    /**
     * Getter per la capacitat màxima.
     * 
     * @return la capacitat màxima
     */
    public int getMaxSize(){
        return this.maxSize;
    }
    
    /**
     * Getter per títol del àlbum.
     * 
     * @return el títol del àlbum
     */
    public String getTitol(){
        return this.titol;
    }
    
    /**
     * Comprova si l'àlbum és ple.
     * 
     * @return true: ple    false: !ple
     */
    @Override
    public boolean isFull(){
        return this.getSize()==this.getMaxSize();
    }
    
    /**
     * Permet afegir un fitxer a la biblioteca.
     * 
     * @param file              fitxer a afegir
     */
    @Override
    public void addFitxer(File file) throws AplicacioException{
        FitxerMultimedia fitxer=(FitxerMultimedia) file;
        if((fitxer.exists()) && (!(fitxer.isDirectory()))){
            if(!(this.isFull())){
                this.carpeta.add(fitxer);
            }else{
                throw new AplicacioException("L'àlbum ja és ple.");
            }
        }else{
            throw new AplicacioException("Aquest fitxer no existeix.");
        }
    }
    
    /**
     * Elimina un fitxer del àlbum.
     * @param i 
     */
    public void removeFitxer(int i){
        this.carpeta.remove(i);
    }
    
    /**
     * Elimina un fitxer de la biblioteca.
     * 
     * @param file              el fitxer a eliminar
     */
    @Override
    public void removeFitxer(File file){
        FitxerMultimedia fitxer=(FitxerMultimedia) file;
        for (int i=0;i<this.getSize();i++){
            if(fitxer.equals(this.getAt(i))){
                this.carpeta.remove(i);
                i--;
            }
        }
    }
    
    /**
     * Sortida per imprimir usant toString de cada fitxer.
     * 
     * @return llista d'string amb resum de la carpeta
     */
    @Override
    public List<String> write(){
        List<String> resum=new ArrayList<>();
        if(this.isEmpty()){
            resum.add("\nL'àlbum és buit.\n\n");
        }else{
            resum.add("\nÀlbum "+this.getTitol()+":\n==============\n");
            for (int i=0;i<carpeta.size();i++){
                resum.add("["+(i+1)+"] "+this.getAt(i).toString()+"\n");
            }        
        }
        resum.add("\n");
        return resum;
    }
}