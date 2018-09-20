package edu.ub.prog2.CabezasRodrigoNunezJosep.controlador;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.CabezasRodrigoNunezJosep.model.Dades;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controlador {
    
    private Dades dades;
    
    /**
     * Constructor per defecte classe Controlador.
     */
    public Controlador(){
        this.dades=new Dades();
    }
    
    /**
     * Afegir vídeo a BibliotecaFitxerMultimedia
     * 
     * @param path direcció del arxiu
     * @param nomVideo nom del fitxer
     * @param codec el codec de l'audio
     * @param durada la duració del video
     * @param alcada la altura del video
     * @param amplada la amplada del video
     * @param fps els fps' del video
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    public void afegirVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException{
        this.dades.afegirVideo(path,nomVideo,codec,durada,alcada,amplada,fps);
    }
    
    /**
     * Constructor indicant la descripció.
     * 
     * @param cami camí absolut del fitxer
     * @param camiImatge path de la caratula del audio
     * @param nomAudio el nom del audio
     * @param codec el codec del video
     * @param durada la durada del video
     * @param kbps velocitat del audio
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    public void afegirAudio(String cami, String nomAudio, String codec, float durada, String camiImatge, int kbps) throws AplicacioException{
        this.dades.afegirAudio(cami,nomAudio,codec,durada,camiImatge,kbps);
    }
    
    /**
     * Mostra el contingut de la biblioteca.
     * 
     * @return list llista amb el contingut de la carpeta
     */
    public String mostrarBiblioteca(){
        return this.dades.toString();
    }
    
    /**
     * Elimina un fitxer de BibliotecaFitxerMultimedia.
     * 
     * @param id el id del fitxer a eliminar
     */
    public void esborrarFitxer(int id){
        this.dades.esborrarFitxer(id);
    }
    
    /**
     * Guarda les dades de BibliotecaFixerMultimedia al disc.
     * 
     * @param camiDesti path on es guardaran les dades
     * @throws edu.ub.prog2.utils.AplicacioException
     * @throws java.io.IOException
     */
    public void guardarDadesDisc(String camiDesti) throws AplicacioException, IOException{
        this.dades.guardar(camiDesti);
    }
    
    /**
     * Carrega les dades d'un determinat path a BibliotecaFitxerMultimedia.
     *
     * @param camiOrigen path d'on es carregaran les dades per BibliotectaFitxersMultimedia
     * @throws edu.ub.prog2.utils.AplicacioException
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException, FileNotFoundException, IOException, ClassNotFoundException{
        this.dades.carregar(camiOrigen);
    }
    
    /**
     * Mostra per pantalla les path contenides.
     * 
     * @return string amb les path
     */
    public String mostrarCamins() {
        return this.dades.mostrarCamins();
    }
    
    /**
     * Comprova si dades és buida.
     * 
     * @return true: és buida   false: no és buida
     */
    public boolean isEmpty(){
        return this.dades.isEmpty();
    }
    
    /**
     * Indica si les dades són borrables.
     * 
     * @param i l'id de les dades
     * @return  true: borrable  false: no borrable
     */
    public boolean isRemovable(int i){
        return this.dades.isRemovable(i);
    }
}
