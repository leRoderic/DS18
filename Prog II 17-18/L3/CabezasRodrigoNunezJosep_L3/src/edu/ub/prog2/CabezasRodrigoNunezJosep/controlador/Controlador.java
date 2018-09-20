package edu.ub.prog2.CabezasRodrigoNunezJosep.controlador;
import edu.ub.prog2.CabezasRodrigoNunezJosep.model.Dades;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.InControlador;
import java.util.List;

public class Controlador implements InControlador{
    private Dades dades;
    private Reproductor reproductor;
    private final EscoltadorReproduccio escoltador;
    
    /**
     * Constructor per defecte classe Controlador.
     */
    public Controlador(){
        this.dades=new Dades();
        this.escoltador=new EscoltadorReproduccio();
        this.reproductor=new Reproductor(this.escoltador);
    }
    
    /**
     * Activa la reproducció cíclica.
     * 
     * @param state             estat de la reproducció cíclica
     */
    public void setContinu(boolean state){
        try{
            tancarFinestraReproductor();
        }catch(AplicacioException e){}
        this.escoltador.setCiclica(state);
        this.reproductor=new Reproductor(this.escoltador);
        this.setReproductor();
    }
    
    /**
     * Activa la reproducció aleatória.
     * 
     * @param state             estat de la reproducció aleatória
     */
    public void setAleatori(boolean state){
        try{
            tancarFinestraReproductor();
        }catch(AplicacioException e){}
        this.escoltador.setAleatoria(state);
        this.reproductor=new Reproductor(this.escoltador);
        this.setReproductor();
    }
    
    /**
     * Setter per reproductor.
     */
    public void setReproductor(){
        this.dades.setReproductor(this.reproductor);
    }
    
    /**
     * Afegir vídeo a BibliotecaFitxerMultimedia
     * 
     * @param path          direcció del arxiu
     * @param nomVideo      nom del fitxer
     * @param codec         el codec de l'audio
     * @param durada        la duració del video
     * @param alcada        la altura del video
     * @param amplada       la amplada del video
     * @param fps           els fps' del video
     */
    
    /**
     * Afegeix vídeo a la biblitoeca.
     * 
     * @param path          camí absolut del fitxer
     * @param nomVideo      nom del vídeo
     * @param codec         codec del vídeo
     * @param durada        durada del vídeo
     * @param alcada        alçada del vídeo
     * @param amplada       amplada del vídeo
     * @param fps           els fps del vídeo
     */
    @Override
    public void afegirVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException{
        this.dades.afegirVideo(path,nomVideo,codec,durada,alcada,amplada,fps,this.getReproductor());
    }
    
    /**
     * Getter per reproductor.
     * 
     * @return el reproductor
     */
    public Reproductor getReproductor(){
        return this.reproductor;
    }
    
    /**
     * Afegeix áudio a  la bilbioteca.
     * 
     * @param cami          camí absolut del fitxer
     * @param camiImatge    path de la caratula del audio
     * @param nomAudio      el nom del audio
     * @param codec         el codec del video
     * @param durada        la durada del video
     * @param kbps          velocitat del audio
     */
    @Override
    public void afegirAudio(String cami, String camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException{
        this.dades.afegirAudio(cami,nomAudio,codec,durada,camiImatge,kbps,this.getReproductor());
    }
    
    /**
     * Mostra el contingut de la biblioteca.
     * 
     * @return list llista amb el contingut de la carpeta
     */
    @Override
    public List<String> mostrarBiblioteca(){
        return this.dades.mostrarBiblioteca();
    }
    
    /**
     * Elimina un fitxer de BibliotecaFitxerMultimedia.
     * 
     * @param id            el id del fitxer a eliminar
     */
    @Override
    public void esborrarFitxer(int id){
        this.dades.esborrarFitxer(id);
    }
    
    /**
     * Guarda les dades de BibliotecaFixerMultimedia al disc.
     * 
     * @param camiDesti     path on es guardaran les dades
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    @Override
    public void guardarDadesDisc(String camiDesti) throws AplicacioException{
        this.dades.guardar(camiDesti);
    }
    
    /**
     * Carrega les dades d'un determinat path a BibliotecaFitxerMultimedia.
     *
     * @param camiOrigen    path d'on es carregaran les dades per BibliotectaFitxersMultimedia
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    @Override
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException{
        this.dades=this.dades.carregar(camiOrigen);
        this.dades.setReproductor(this.reproductor);
    }
    
    /**
     * Mostra per pantalla les path contenides.
     * 
     * @return llista amb direccions
     */
    public List<String> mostrarCamins() {
        return this.dades.mostrarCamins();
    }    
    
    /**
     * Retorna el path del álbum indicat.
     * 
     * @param titol         nom del álbum
     * @return path del fitxers que conté
     */
    public List<String> mostrarCaminsAlbum(String titol){
        return this.dades.mostrarCaminsAlbum(titol);
    } 
    
    /**
     * Comprova si hi ha albums.
     * 
     * @return true: hi ha  false: no hi ha
     */
    public boolean anyAlbums(){
        return this.dades.anyAlbums();
    }
    
    /**
     * Donada la id d'un àlbum comprova si existeix.
     * 
     * @param i             id del àlbum
     * @return true: existeix   false: !existeix
     */
    public boolean albumAcotat(int i){
        return this.dades.albumAcotat(i);
    }
    
    /**
     * Donada l'id i el títol d'un àlbum comprova si existeix.
     * 
     * @param titol         el títol del álbum
     * @param j             id del àlbum
     * @return true: existeix   false: !existeix
     */
    public boolean albumAcotat(String titol,int j){
        return this.dades.albumAcotat(titol,j);
    }
    
    /**
     * Esborra un álbum donat.
     * 
     * @param titol         el títol del álbum
     */
    @Override
    public void esborrarAlbum(String titol) throws AplicacioException {
        this.dades.esborrarAlbum(titol);
    }
    
    /**
     * Comprova si l'álbum és buit
     * 
     * @param titol         l'álbum a comprovar
     * @return true: buit   false: no és buit
     */
    public boolean isEmpty(String titol){
        return this.dades.isEmpty(titol);
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
     * @param i             l'id de les dades
     * @return  true: borrable  false: no borrable
     */
    public boolean isRemovable(int i){
        return this.dades.isRemovable(i);
    }
    
    /**
     * Afegeix un álbum amb una capacitat màxima.
     * 
     * @param titol         el títol del àlbum
     * @param numero        capacitat del àlbum  
     */
    public void afegirAlbum(String titol, int numero) {
        this.dades.addAlbum(titol,numero);
    }
    
    /**
     * Afegeix un nou álbum amb la capacitat per defecte.
     * 
     * @param titol         el títol del àlbum
     */
    @Override
    public void afegirAlbum(String titol) {
        this.dades.addAlbum(titol);
    }
    
    /**
     * Mostrar els àlbums que hi ha.
     * 
     * @return llista amb els àlbums
     */
    @Override
    public List<String> mostrarLlistatAlbums() {
        return this.dades.mostrarAlbums();
    }
    
    /**
     * Afegeix un fitxer donat a un àlbum donat.
     * 
     * @param titol         l'àlbum al que afegirem
     * @param i             id del fitxer que s'afegirà
     */
    @Override
    public void afegirFitxer(String titol, int i) throws AplicacioException {
        this.dades.afegirFitxer(titol,i);
    }
    
    /**
     * Esborra un fitxer donat d'un àlbum donat.
     * 
     * @param titol         l'àlbum al que afegirem
     * @param i             id del fitxer que s'afegirà
     */
    @Override
    public void esborrarFitxer(String titol, int i) throws AplicacioException {
        this.dades.esborrarFitxer(titol,i);
    }
    
    /**
     * Mostra els fitxers d'un àlbum.
     * 
     * @param titol         el títol del àlbum
     * @return llista amb el títol dels fitxers
     */
    @Override
    public List<String> mostrarAlbum(String titol) throws AplicacioException {
        return this.dades.mostrarAlbum(titol);
    }
    
    /**
     * Comprova si existeix un álbum determinat.
     * 
     * @param titol         l'àlbum a comprovar
     * @return true: exiesteix  false: !existeix
     */
    @Override
    public boolean existeixAlbum(String titol) {
        return this.dades.existeixAlbum(titol);
    } 
    
    /**
     * Reprodueix un fitxer.
     * 
     * @param i             id del fitxer
     */
    @Override
    public void reproduirFitxer(int i) throws AplicacioException {
        try{
            tancarFinestraReproductor();
        }catch(AplicacioException e){}
        obrirFinestraReproductor();
        escoltador.setLlista(this.dades.reproduirFitxer(i));
        //tancarFinestraReproductor();
    }
    
    /**
     * Reprodueix tot el contingut de la carpeta.
     * 
     */
    @Override
    public void reproduirCarpeta() throws AplicacioException {
        try{
            tancarFinestraReproductor();
        }catch(AplicacioException e){}
        obrirFinestraReproductor();
        escoltador.setLlista(this.dades.reproduirCarpeta());
        //tancarFinestraReproductor();
    }
    
    /**
     * Reprodueix el fitxer corresponent al titol que se li passa.
     * 
     * @param titol         el títol del fitxer que es reproduirà
     */
    @Override
    public void reproduirCarpeta(String titol) throws AplicacioException {
        try{
            tancarFinestraReproductor();
        }catch(AplicacioException e){}
        obrirFinestraReproductor();
        escoltador.setLlista(this.dades.reproduirCarpeta(titol));
        //tancarFinestraReproductor();
    }
    
    /**
     * Obre una finestra amb les comandes per la reproducció.
     * 
     */
    @Override
    public void obrirFinestraReproductor() {
        this.reproductor.open();
    }
    
    /**
     * Tanca la finestra amb els controls del reproductor.
     * 
     */
    @Override
    public void tancarFinestraReproductor() throws AplicacioException {
        this.reproductor.close();
    }
    
    /**
     * Torna a reproduir el fitxer després d'haver-se pausat.
     * 
     */
    @Override
    public void reemprenReproduccio() throws AplicacioException {
        this.reproductor.resume();
    }
    
    /**
     * Pausa el fitxer que s'està reproduint en el moment.
     * 
     */
    @Override
    public void pausaReproduccio() throws AplicacioException {
        this.reproductor.pause();
    }
    
    /**
     * Atura la reproducció, NO ES POT FER RESUME.
     * 
     */
    @Override
    public void aturaReproduccio() throws AplicacioException {
        this.reproductor.stop();
    }
    
    /**
     * Salta al següent fitxer a reproduir.
     * 
     */
    @Override
    public void saltaReproduccio() throws AplicacioException {
        this.escoltador.next();
    }
    
    /**
     * Retorna el títol del fitxer corresponent a la id que se li passa.
     * 
     * @param id        el id del fitxer
     * @return títol del fitxer
     */
    public String id2Titol(int id){
        return this.dades.id2Titol(id);
    }
}