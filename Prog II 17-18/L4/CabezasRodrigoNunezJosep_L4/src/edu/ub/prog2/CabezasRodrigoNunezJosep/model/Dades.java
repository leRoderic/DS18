package edu.ub.prog2.CabezasRodrigoNunezJosep.model;
import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.Reproductor;
import edu.ub.prog2.utils.AplicacioException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dades implements Serializable{
    
    private final BibliotecaFitxersMultimedia biblioteca;
    private final ArrayList<AlbumFitxersMultimedia> albums;
    
    /**
     * Constructor per defecte.
     * 
     */
    public Dades(){
        this.biblioteca=new BibliotecaFitxersMultimedia();
        this.albums=new ArrayList<>();
    }
    
    /**
     * Comprova si hi ha algún àlbum.
     * 
     * @return true: hi ha  false: !no hi ha
     */
    public boolean anyAlbums(){
        return this.albums.isEmpty();
    }
    
    /**
     * Afegeix un nou àlbum.
     * 
     * @param titol         el títol del àlbum
     */
    public void addAlbum(String titol){
        albums.add(new AlbumFitxersMultimedia(titol));    
    }
    
    /**
     * Afegeix no nou àlbum amb títol i mida màxima.
     * 
     * @param titol         el títol del àlbum
     * @param i             la mida màxima
     */
    public void addAlbum(String titol,int i){
        albums.add(new AlbumFitxersMultimedia(titol,i));
    }
    
    /**
     * Retorna els títols dels fitxers que conté un àlbum.
     * 
     * @param titol         el títol del àlbum.
     * @return llista amb els títols del àlbum
     */
    public List<String> mostrarAlbum(String titol){
        return this.albums.get(titol2Id(titol)).write();
    }
    
    /**
     * Mostra els path's dels fitxers que conté l'àlbum.
     * 
     * @param titol         el títol del àlbum
     * @return llista amb els path's
     */
    public List<String> mostrarCaminsAlbum(String titol){
        return this.albums.get(titol2Id(titol)).writeCamins();
    }
    
    /**
     * Mostra els títols dels àlbums que hi ha.
     * 
     * @return llista amb els títols dels àlbums
     */
    public List<String> mostrarAlbums(){
        List<String> resum=new ArrayList<>();
        if(this.albums.isEmpty()){
            resum.add("No hi ha cap àlbum");
        }else{
            //resum.add("\nÀlbums:\n==============\n\n");
            for (int i=0;i<this.albums.size();i++){
                resum.add("["+(i+1)+"] "+this.albums.get(i).getTitol());
            }        
        }
        //resum.add("\n");
        return resum;
    }
    
    /**
     * Comprova si un àlbum donat és buit.
     * 
     * @param titol         el títol del àlbum a comprovar
     * @return true: és buit    false: !no és buit
     */
    public boolean isEmpty(String titol){
        return this.albums.get(titol2Id(titol)).isEmpty();
    }
    
    /**
     * Comprova si l'àlbum corresponent a una id existeix.
     * 
     * @param               i la id del àlbum 
     * @return true: existeix   false: no existeix
     */
    public boolean albumAcotat(int i){
        return ((i<this.albums.size())&&(i>-1));
    }
    
    /**
     * Esborra un àlbum donat.
     * 
     * @param titol el títol del àlbum a eliminar
     */
    public void esborrarAlbum(String titol){
        this.albums.remove(titol2Id(titol));
    }
    
    /**
     * Comprova si un àlbum existeix donat el títol d'aquest.
     * 
     * @param titol         el títol del àlbum
     * @return  true: existeix  false: no existeix
     */
    public boolean existeixAlbum(String titol) {
        int i=0;
        while(i<this.albums.size()){
            if(titol.equals(this.albums.get(i).getTitol())){
                return true;
            }
            i++;
        }
        return false;
    } 
    
    /**
     * Comprova si un àlbum existeix donat id i títol.
     * 
     * @param titol         el títol del àlbum
     * @param j             l'id del àlbum
     * @return  true: existeix  false: no existeix
     */
    public boolean albumAcotat(String titol, int j){
        return this.albums.get(titol2Id(titol)).acotat(j);
    }
    
    /**
     * Afegeix un fitxer de la biblioteca a un àlbum donat.
     * 
     * @param titol         el títol del àlbum 
     * @param i             l'id del fitxer 
     * @throws AplicacioException abs
     */
    public void afegirFitxer(String titol, int i) throws AplicacioException{
        this.albums.get(titol2Id(titol)).addFitxer(this.biblioteca.getAt(i));
    }
    
    /**
     * Esborra un fitxer del àlbum.
     * 
     * @param titol         el títol del àlbum
     * @param i             l'id del fitxer
     */
    public void esborrarFitxer(String titol, int i){
        this.albums.get(titol2Id(titol)).removeFitxer(i);
    }
    
    /**
     * Donat un id, esborra el fitxer corresponent.
     * 
     * @param i             el id del fitxer
     */
    public void esborrarFitxer(int i){
        FitxerMultimedia fitxer=this.biblioteca.getAt(i);
        this.biblioteca.removeFitxer(fitxer);
        for(int j =0;j<this.albums.size();j++){
            this.albums.get(j).removeFitxer(fitxer);
        }
    }
    
    /**
     * ToString de la classe Dades.
     * 
     * @return resum de les dades de la bibioteca
     */
    public List<String> mostrarBiblioteca(){
        return this.biblioteca.write();
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
     * @param i             la id del fitxer
     * @return  true: pot ser borrat    false: no és borrable
     */
    public boolean isRemovable(int i){
        return this.biblioteca.acotat(i);
    }
    
    /**
     * Retorna els path que conté la biblioteca.
     * 
     * @return path dels fitxers
     */
    public List<String> mostrarCamins() {
        return this.biblioteca.writeCamins();
    }
    
    /**
     * Afegeix un audio a la biblioteca.
     * 
     * @param cami          path del fitxer
     * @param nomAudio      nom del audio
     * @param codec         codec del audio
     * @param durada        duració del audio
     * @param camiImatge    path de la caratula
     * @param kbps          velocitat del audio
     * @param r             reproductor
     * @throws AplicacioException abs
     */
    public void afegirAudio(String cami, String nomAudio, String codec, float durada, String camiImatge, int kbps, Reproductor r) throws AplicacioException {
        File image=new File(camiImatge);
        Audio fitxer=new Audio(cami,nomAudio,codec,durada,image,kbps,r);
        this.biblioteca.addFitxer(fitxer);
    }
    
    /**
     * Afegeix un àudio a la biblioteca.
     * 
     * @param path          path del video
     * @param nomVideo      nom del video
     * @param codec         codec per el video
     * @param durada        durada del video
     * @param alcada        alçada del video
     * @param amplada       amplada del video
     * @param fps           els fps
     * @param r             el reproductor
     * @throws AplicacioException abs
     */
    public void afegirVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps, Reproductor r) throws AplicacioException {        
        Video fitxer=new Video(path,nomVideo,codec,durada,alcada,amplada,fps,r);
        this.biblioteca.addFitxer(fitxer);
    }
    
    /**
     * Guarda les dades al disc.
     * 
     * @param desti         path on es guardarà 
     * @throws AplicacioException abs
     */
    public void guardar(String desti) throws AplicacioException{
        try{            
            ObjectOutputStream os;
            File fitxer = new File(desti,"Dades.data");
            try (FileOutputStream fileStream = new FileOutputStream(fitxer)) {
                os = new ObjectOutputStream(fileStream);
                os.writeObject(this);
                fileStream.close();
            }
            os.close();        
        }catch(FileNotFoundException e1){
            throw new AplicacioException("Fitxer no trobat.");
        }catch(IOException e2){
            throw new AplicacioException("Problema amb el tractament del fitxer.");
        }        
    }
    
    /**
     * Carrega els fitxers.
     * 
     * @param origen    path d'on carregar les dades.
     * @return model    Dades a carregar  
     * @throws AplicacioException abs
     */
    public Dades carregar(String origen) throws AplicacioException {
        try{
            Dades model;
            ObjectInputStream ois;
            try (FileInputStream fileStream = new FileInputStream(origen)) {
                ois = new ObjectInputStream(fileStream);
                model=(Dades)ois.readObject();
                fileStream.close();
            }
            ois.close();
            return model;
        }catch(FileNotFoundException e1){
            throw new AplicacioException("Fitxer no trobat.");
        }catch(IOException e2){
            throw new AplicacioException("Problema amb el tractament del fitxer.");
        }catch(ClassNotFoundException e3){
            throw new AplicacioException("Problema amb el casting dels objectes.");
        }
    }
    
    /**
     * Setter global de reproductor per a biblioteca.
     * 
     * @param r         el reproductor
     */
    public void setReproductor(Reproductor r){
        for(int i=0;i<this.biblioteca.getSize();i++){
            FitxerReproduible elem=(FitxerReproduible)this.biblioteca.getAt(i);
            elem.setReproductor(r);
        }
    }
    
    /**
     * Retorna el títol d'un àlbum donada la seva ID.
     * 
     * @param id        l'id del àlbum
     * @return el títol
     */
    public String id2Titol(int id){
        return this.albums.get(id).getTitol();
    }
    
    /**
     * Retorna l'id d'un àlbum donat el seu títol.
     * 
     * @param titol     el títol del àlbum
     * @return l'id
     */
    public int titol2Id(String titol){
        boolean found=false;
        int ret=-1;
        int i=0;
        while((i<this.albums.size())&&(!(found))){
            if(titol.equals(this.albums.get(i).getTitol())){
                ret=i;
                found=true;
            }
            i++;
        }
        return ret;
    }
    
    /**
     * Retorna una nova CarpetaFitxers amb el fitxer a reproduir.
     * 
     * @param i         id del fitxer
     * @return carpeta amb el fitxer a reproduir
     * @throws AplicacioException abs
     */
    public CarpetaFitxers reproduirFitxer(int i) throws AplicacioException {
        CarpetaFitxers retorn=new CarpetaFitxers();
        retorn.addFitxer(this.biblioteca.getAt(i));
        return retorn;
    }
    
    /**
     * Retorna una nova CarpetaFitxers amb el fitxer a reproduir.
     * 
     * @param i         id del fitxer
     * @return carpeta amb el fitxer a reproduir
     * @throws AplicacioException abs
     */
    public CarpetaFitxers reproduirFitxers(int[] i) throws AplicacioException {
        CarpetaFitxers retorn=new CarpetaFitxers();
        for (int a:i)
            retorn.addFitxer(this.biblioteca.getAt(a));
        return retorn;
    }
    
    /**
     * Retorna la biblioteca.
     * 
     * @return la biblioteca
     */
    public CarpetaFitxers reproduirCarpeta() {
        return this.biblioteca;
    }

    /**
     * Retorna una carpeta amb un fitxer donat el títol.
     * 
     * @param titol         el títol de la carpeta
     * @return carpeta
     */
    public CarpetaFitxers reproduirCarpeta(String titol) {
        return this.albums.get(titol2Id(titol));
    }      
}