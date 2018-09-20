package edu.ub.prog2.CabezasRodrigoNunezJosep.model;
import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.Reproductor;
import edu.ub.prog2.utils.AplicacioException;
import java.io.*;

public class Dades implements Serializable{
    
    private final BibliotecaFitxersMultimedia biblioteca;
    
    /**
     * Constructor per defecte.
     */
    public Dades(){
        this.biblioteca=new BibliotecaFitxersMultimedia();
    }
    
    /**
     * Donat un id, esborra el fitxer corresponent.
     * 
     * @param i     el id del fitxer
     */
    public void esborrarFitxer(int i){
        FitxerMultimedia fitxer=this.biblioteca.getAt(i);
        this.biblioteca.removeFitxer(fitxer);
    }
    
    /**
     * ToString de la classe Dades.
     * 
     * @return resum de les dades de la bibioteca
     */
    @Override
    public String toString(){
        return this.biblioteca.toString();
    }
    
    /**
     * Comprova si la biblioteca és buida.
     * 
     * @return true: és buida   false: no és buida
     */
    public boolean isEmpty(){
        return this.biblioteca.isEmpty();
    }
    
    /**
     * Donat una id, indica si el fitxer pot ser borrat.
     * 
     * @param i la id del fitxer
     * @return  true: pot ser borrat    false: no és borrable
     */
    public boolean isRemovable(int i){
        return this.biblioteca.isRemovable(i);
    }
    
    /**
     * Retorna els path que conté la biblioteca.
     * 
     * @return path dels fitxers
     */
    public String mostrarCamins() {
        return this.biblioteca.mostrarCamins();
    }
    
    /**
     * Afegir audio a la biblioteca.
     * 
     * @param cami      path del fitxer
     * @param nomAudio  nom del audio
     * @param codec     codec del audio
     * @param durada    duració del audio
     * @param camiImatge path de la caratula
     * @param kbps      velocitat del audio
     * @throws AplicacioException 
     */
    public void afegirAudio(String cami, String nomAudio, String codec, float durada, String camiImatge, int kbps) throws AplicacioException {
        Reproductor r=new Reproductor();
        File image=new File(camiImatge);
        Audio fitxer=new Audio(cami,nomAudio,codec,durada,image,kbps,r);
        this.biblioteca.addFitxer(fitxer);
    }
    
    /**
     * Afegir video a la biblioteca.
     * 
     * @param path      path del video
     * @param nomVideo  nom del video
     * @param codec     codec per el video
     * @param durada    durada del video
     * @param alcada    alçada del video
     * @param amplada   amplada del video
     * @param fps       els fps
     * @throws AplicacioException 
     */
    public void afegirVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException {        
        Reproductor r=new Reproductor();
        Video fitxer=new Video(path,nomVideo,codec,durada,alcada,amplada,fps,r);
        this.biblioteca.addFitxer(fitxer);
    }
    
    /**
     * Guarda les dades al disc.
     * 
     * @param desti     path on es guardarà
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void guardar(String desti) throws FileNotFoundException, IOException {
        ObjectOutputStream os;
        try (FileOutputStream fileStream = new FileOutputStream(desti)) {
            os = new ObjectOutputStream(fileStream);
            for(int i=0;i<this.biblioteca.getSize();i++){
                FitxerMultimedia guardo=this.biblioteca.getAt(i);
                os.writeObject(guardo);
            }
            os.writeObject(null);
        }
        os.close();
    }
    
    /**
     * Carrega els fitxers.
     * 
     * @param origen    path d'on carregar les dades.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     * @throws edu.ub.prog2.utils.AplicacioException 
     */
    public void carregar(String origen) throws FileNotFoundException, IOException, ClassNotFoundException, AplicacioException {
        ObjectInputStream ois;
        try (FileInputStream fileStream = new FileInputStream(origen)) {
            ois = new ObjectInputStream(fileStream);
            Object carrego=ois.readObject();
            while (carrego!=null){
                try{
                    this.biblioteca.addFitxer((FitxerMultimedia)carrego);
                }catch(AplicacioException e){}
                carrego=ois.readObject();
            }
        }
        ois.close();
    }
}
