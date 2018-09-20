package edu.ub.prog2.CabezasRodrigoNunezJosep.vista;
import java.util.Scanner;
import edu.ub.prog2.utils.Menu;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.Controlador;
import java.io.File;
import java.util.List;

public class AplicacioUB3 {
    
    static private enum OpcionsPrincipal {PRINCIPAL_BIBLIO,PRINCIPAL_ALBUM,PRINCIPAL_REPRO,PRINCIPAL_GUARDAR,PRINCIPAL_RECUPERAR,PRINCIPAL_SORTIR};
    private static final String[] PRINCIPAL={"Gestionar la biblioteca","Gestionar els àlbums","Gestionar el reproductor","Guardar les dades a disc","Carregar les dades de disc","Sortir de l'aplicació"};
    static private enum OpcionsBiblio {BIBLIO_AFEGIR,BIBLIO_MOSTRAR,BIBLIO_ELIMINAR,BIBLIO_SORTIR};
    private static final String[] BIBLIO={"Afegir un nou fitxer multimèdia","Mostrar el contingut de la biblioteca","Eliminar un dels fitxers existents","Menú anterior"};
    static private enum OpcionsAfegir {AFEGIR_VIDEO,AFEGIR_AUDIO,AFEGIR_SORTIR};
    private static final String[] AFEGIR={"Afegir un fitxer de vídeo","Afegir un fitxer d'àudio","Menú anterior"};
    static private enum OpcionsAlbum {ALBUM_AFEGIR,ALBUM_MOSTRAR,ALBUM_ELIMINAR,ALBUM_INCLOS,ALBUM_SORTIR};
    private static final String[] ALBUM={"Afegir un nou àlbum","Mostrar el conjunt dels àlbums","Eliminar un dels àlbums existents","Gestionar un dels àlbums","Menú anterior"};
    static private enum OpcionsInclos {INCLOS_AFEGIR,INCLOS_MOSTRAR,INCLOS_ELIMINAR,INCLOS_SORTIR};
    private static final String[] INCLOS={"Afegir un fitxer multimèdia","Mostrar el contingut de l'àlbum","Eliminar un dels fitxers de l'àlbum","Menú anterior"};
    static private enum OpcionsRepro {REPRO_FITXER,REPRO_BIBLIO,REPRO_ALBUM,REPRO_CONT,REPRO_ALE,REPRO_CURS,REPRO_SORTIR};
    private static final String[] REPRO={"Reproduir un fitxer multimèdia","Reproduir el contingut de la biblioteca","Reproduir el contingut d'un àlbum","Modificar la continuïtat de la reproducció","Modificar l'aleatorietat de la reproducció","Gestionar la reproducció en curs","Menú anterior"};
    static private enum OpcionsCurs {CURS_PLAY,CURS_PAUSE,CURS_STOP,CURS_NEXT,CURS_SORTIR};
    private static final String[] CURS={"Reactivar la reproducció   [▶]","Pausar la reproducció      [❚❚]","Parar la reproducció       [■]","Saltar al següent fitxer   [▶▶]","Menú anterior              [X]"};
    private final Controlador controlador;
    private final Scanner sc;
    
    /**
     * Constructor AplicacioUB3.
     */
    public AplicacioUB3(){
        this.controlador=new Controlador();
        this.sc=new Scanner(System.in);
    }
    
    /**
     * Gestió general de la aplicació.
     */
    public void gestioAplicacioUB(){
        Menu<OpcionsPrincipal> menu=new Menu<>("Menú principal",OpcionsPrincipal.values());
        menu.setDescripcions(PRINCIPAL);
        OpcionsPrincipal opcio;
        do {
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);
            switch(opcio) {
                case PRINCIPAL_BIBLIO:
                    System.out.println("\nHas triat Gestionar la biblioteca.\n");
                    gestioBiblioteca();
                    break;
                case PRINCIPAL_ALBUM:
                    System.out.println("\nHas triat Gestionar els àlbums.\n");
                    gestioAlbums();
                    break;
                case PRINCIPAL_REPRO:
                    System.out.println("\nHas triat Gestionar el reproductor.\n");
                    gestioReproductor();
                    break;
                case PRINCIPAL_GUARDAR:
                    try{
                        System.out.println("\nHas triat Guardar les dades a disc.\n");                    
                        System.out.println("\nIntrodueix el camí del fitxer a on guardar: ");
                        String camiDesti=pathClearing(sc.nextLine());
                        this.controlador.guardarDadesDisc(camiDesti);
                    }catch(AplicacioException e){}
                    break;
                case PRINCIPAL_RECUPERAR:
                    try{
                        System.out.println("\nHas triat Carregar les dades de disc.\n");                    
                        System.out.println("\nIntrodueix el camí del fitxer d'on carregar: ");
                        String camiOrigen=pathClearing(sc.nextLine());
                        this.controlador.carregarDadesDisc(camiOrigen);
                    }catch(AplicacioException e){}
                    break;                
                case PRINCIPAL_SORTIR:
                    try{
                        this.controlador.tancarFinestraReproductor();
                    }catch(AplicacioException e){}
                    System.out.println("\nFins aviat!\n");
                    break;
            }
        } while(opcio!=OpcionsPrincipal.PRINCIPAL_SORTIR);
    }
    
    /**
     * Gestió de la biblioteca.
     */
    public void gestioBiblioteca(){
        Menu<OpcionsBiblio> menu=new Menu<>("Gestió de la biblioteca",OpcionsBiblio.values());
        menu.setDescripcions(BIBLIO);
        OpcionsBiblio opcio;
        do {
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);
            switch(opcio) {
                case BIBLIO_AFEGIR:
                    System.out.println("\nHas triat Afegir un nou arxiu a la biblioteca.\n");
                    gestioAfegir();
                    break;
                case BIBLIO_MOSTRAR:
                    System.out.println("\nHas triat Mostrar el contingut de la biblioteca.\n");
                    imprimir(this.controlador.mostrarBiblioteca());
                    break;
                case BIBLIO_ELIMINAR:
                    System.out.println("\nHas triat Eliminar un dels fitxers existents a la biblioteca.\n");
                    if (!(this.controlador.isEmpty())){
                        System.out.println("\nAquests són els camins dels fitxers de la biblioteca: ");                    
                        imprimir(this.controlador.mostrarCamins());
                        System.out.println("\nIntrodueix l'índex del fitxer a eliminar: ");
                        int num=sc.nextInt()-1;
                        while (!(this.controlador.isRemovable(num))){
                            System.out.println("\nTorna-ho a provar: ");
                            num=sc.nextInt()-1;
                        }
                        this.controlador.esborrarFitxer(num);
                    }else{
                        System.out.println("\nLa biblioteca és buida. No es pot esborrar cap fitxer.\n");
                    }
                    break;                
                case BIBLIO_SORTIR:
                    System.out.println("\nHas triat Tornar al menú anterior.\n");
                    break;
            }
        } while(opcio!=OpcionsBiblio.BIBLIO_SORTIR);
    }
    
    /**
     * Gestió noves entrades a la biblioteca.
     */
    public void gestioAfegir(){
        Menu<OpcionsAfegir> menu=new Menu<>("Afegir un nou fitxer multimèdia",OpcionsAfegir.values());
        menu.setDescripcions(AFEGIR);
        OpcionsAfegir opcio;
        do {
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);
            Object[] compartit;
            switch(opcio) {
                case AFEGIR_VIDEO:
                    try{
                        System.out.println("\nHas triat Afegir un nou fitxer de vídeo.\n");
                        compartit=this.demana();
                        Object[] video=this.demanaVideo();
                        this.controlador.afegirVideo((String)compartit[0], (String)compartit[1], (String)compartit[2], (Float)compartit[3], (int)video[0], (int)video[1], (Float)video[2]);
                    }catch(AplicacioException e){}
                    break;
                case AFEGIR_AUDIO:
                    try{
                        System.out.println("\nHas triat Afegir un nou fitxer d'àudio.\n");
                        compartit=this.demana();
                        Object[] audio=this.demanaAudio();
                        this.controlador.afegirAudio((String)compartit[0], (String)audio[0], (String)compartit[1], (String)compartit[2], (Float)compartit[3], (int)audio[1]);
                    }catch(AplicacioException e){}
                    break;
                case AFEGIR_SORTIR:
                    System.out.println("\nHas triat Tornar al menú anterior.\n");
                    break;
            }
        } while(opcio!=OpcionsAfegir.AFEGIR_SORTIR);
    }
    
    /**
     * Recull dades per afegir un nou vídeo.
     * 
     * @return dades del vídeo
     */
    public Object[] demanaVideo(){
        Object[] dades=new Object[3];                 
        System.out.println("\nIntrodueix l'alçada (valor enter) del vídeo: ");
        dades[0]=(int)sc.nextInt();         
        System.out.println("\nIntrodueix l'amplada (valor enter) del vídeo: ");
        dades[1]=(int)sc.nextInt();        
        System.out.println("\nIntrodueix els fps (valor float) del fitxer: ");
        dades[2]=sc.nextFloat();
        return dades;
    }
    
    /**
     * Recull dades per afegir un àudio.
     * 
     * @return dades del àudio
     */
    public Object[] demanaAudio(){    
        Object[] dades=new Object[2];
        System.out.println("\nVols introduir una imatge per la reproducció? (y/n) ");
        String resposta=sc.nextLine();
        while((!(resposta.equals("n")))&&(!(resposta.equals("y")))){
            System.out.println("\nIntrodueix 'y' o 'n' ");
            resposta=sc.nextLine();
        }
        if (resposta.equals("y")){
            System.out.println("\nIntrodueix el camí de la imatge: ");
            resposta=pathClearing(sc.nextLine());
            File a=new File(resposta);
            while((a.isDirectory()) || (!(a.exists()))){                
                System.out.println("\nIntrodueix un camí vàlid: ");
                resposta=pathClearing(sc.nextLine());
                a=new File(resposta);
            }
            dades[0]=resposta;
        }else{
            dades[0]="";                        
        }         
        System.out.println("\nIntrodueix els kbps (valor enter) de l'arxiu: ");
        dades[1]=(int)sc.nextInt();
        return dades;
    }
    
    /**
     * Recull les dades per afegir un fitxer.
     * 
     * @return les dades
     */
    public Object[] demana(){        
        Object[] dades=new Object[4];
        System.out.println("\nIntrodueix el camí del fitxer: ");
        dades[0]=pathClearing(sc.nextLine());
        System.out.println("\nVols introduir descripció? (y/n) ");
        String resposta=sc.nextLine();
        while((!(resposta.equals("n")))&&(!(resposta.equals("y")))){
            System.out.println("\nIntrodueix 'y' o 'n' ");
            resposta=sc.nextLine();
        }
        if (resposta.equals("y")){
            System.out.println("\nIntrodueix la descripció del fitxer: ");
            dades[1]=sc.nextLine();
        }else{
            dades[1]="";                        
        }        
        System.out.println("\nIntrodueix el codec de l'arxiu: ");
        dades[2]=sc.nextLine();        
        System.out.println("\nIntrodueix la durada (valor float) de reproducció del fitxer: ");
        dades[3]=sc.nextFloat();
        return dades;
    }
    
    /**
     * Gestions relacionades amb els àlbums.
     */
    public void gestioAlbums(){
        Menu<OpcionsAlbum> menu=new Menu<>("Gestió dels àlbums",OpcionsAlbum.values());
        menu.setDescripcions(ALBUM);
        OpcionsAlbum opcio;
        do {
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);
            switch(opcio) {
                case ALBUM_AFEGIR:
                    System.out.println("\nHas triat Afegir un nou àlbum.\n");
                    System.out.println("\nIntrodueix el nom de l'àlbum: ");
                    String titol=sc.nextLine();
                    while(this.controlador.existeixAlbum(titol)){
                        System.out.println("\nProva amb un nom d'àlbum que no existeixi encara: ");
                        titol=sc.nextLine();
                    }
                    System.out.println("\nVols que la capacitat de l'àlbum sigui diferent a 10 fitxers? (y/n) ");
                    String resposta=sc.nextLine();
                    while((!(resposta.equals("n")))&&(!(resposta.equals("y")))){
                        System.out.println("\nIntrodueix 'y' o 'n' ");
                        resposta=sc.nextLine();
                    }
                    if (resposta.equals("y")){
                        System.out.println("\nIntrodueix el número de fitxers: ");
                        int numero=sc.nextInt();
                        while(numero<=0){                
                            System.out.println("\nIntrodueix un número més gran que zero: ");
                            numero=sc.nextInt();
                        }
                        this.controlador.afegirAlbum(titol,numero);
                    }else{
                        this.controlador.afegirAlbum(titol);                    
                    }
                    break;
                case ALBUM_MOSTRAR:
                    System.out.println("\nHas triat Mostrar el conjunt dels àlbums.\n");
                    imprimir(this.controlador.mostrarLlistatAlbums());
                    break;
                case ALBUM_ELIMINAR:
                    System.out.println("\nHas triat Eliminar un dels àlbums existents.\n");
                    if (!(this.controlador.anyAlbums())){
                        System.out.println("\nAquests són àlbums de la biblioteca: ");                    
                        imprimir(this.controlador.mostrarLlistatAlbums());
                        System.out.println("\nIntrodueix l'índex de l'àlbum a eliminar: ");
                        int num=sc.nextInt()-1;
                        while (!(this.controlador.albumAcotat(num))){
                            System.out.println("\nTorna-ho a provar: ");
                            num=sc.nextInt()-1;
                        }
                        String number=this.controlador.id2Titol(num);
                        try{
                            this.controlador.esborrarAlbum(number);
                        }catch (AplicacioException e){}
                    }else{
                        System.out.println("\nNo hi ha cap àlbum.\n");
                    }
                    break;
                case ALBUM_INCLOS:
                    System.out.println("\nHas triat Gestionar un dels àlbums.\n");
                    if (!(this.controlador.anyAlbums())){
                        System.out.println("\nAquests són àlbums de la biblioteca: ");                    
                        imprimir(this.controlador.mostrarLlistatAlbums());
                        System.out.println("\nIntrodueix l'índex de l'àlbum a gestionar: ");
                        int num=sc.nextInt()-1;
                        while (!(this.controlador.albumAcotat(num))){
                            System.out.println("\nTorna-ho a provar: ");
                            num=sc.nextInt()-1;
                        }
                        String number=this.controlador.id2Titol(num);
                        gestioContingut(number);
                    }else{
                        System.out.println("\nNo hi ha cap àlbum.\n");
                    }
                    break;
                case ALBUM_SORTIR:
                    System.out.println("\nHas triat Tornar al menú anterior.\n");
                    break;
            }
        } while(opcio!=OpcionsAlbum.ALBUM_SORTIR);
    }
    
    /**
     * Gestions relacionades amb un àlbum en concret.
     * 
     * @param number opció que recull de gestionAlbums()
     */
    public void gestioContingut(String number){
        Menu<OpcionsInclos> menu=new Menu<>("Gestió d'un dels àlbums",OpcionsInclos.values());
        menu.setDescripcions(INCLOS);
        OpcionsInclos opcio;
        do {
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);
            switch(opcio) {
                case INCLOS_AFEGIR:
                    System.out.println("\nHas triat Afegir un fitxer multimèdia.\n");
                    if (!(this.controlador.isEmpty())){
                        System.out.println("\nAquests són els camins dels fitxers de la biblioteca: ");                    
                        imprimir(this.controlador.mostrarCamins());
                        System.out.println("\nIntrodueix l'índex del fitxer a afegir: ");
                        int num=sc.nextInt()-1;
                        while (!(this.controlador.isRemovable(num))){
                            System.out.println("\nTorna-ho a provar: ");
                            num=sc.nextInt()-1;
                        }
                        try{
                            this.controlador.afegirFitxer(number,num);                        
                        }catch(AplicacioException e){}
                    }else{
                        System.out.println("\nLa biblioteca és buida. No es pot afegir cap fitxer.\n");
                    }
                    break;
                case INCLOS_MOSTRAR:
                    System.out.println("\nHas triat Mostrar el contingut de l'àlbum.\n");
                    try{
                        imprimir(this.controlador.mostrarAlbum(number));                        
                    }catch(AplicacioException e){}
                    break;
                case INCLOS_ELIMINAR:
                    System.out.println("\nHas triat Eliminar un dels fitxers de l'àlbum.\n");
                    if (!(this.controlador.isEmpty(number))){
                        System.out.println("\nAquests són els camins dels fitxers de l'àlbum: ");                    
                        imprimir(this.controlador.mostrarCaminsAlbum(number));
                        System.out.println("\nIntrodueix l'índex del fitxer a eliminar: ");
                        int num=sc.nextInt()-1;
                        while (!(this.controlador.albumAcotat(number,num))){
                            System.out.println("\nTorna-ho a provar: ");
                            num=sc.nextInt()-1;
                        }
                        try{
                            this.controlador.esborrarFitxer(number,num);
                        }catch (AplicacioException e){}
                    }else{
                        System.out.println("\nL'àlbum és buit. No es pot esborrar cap fitxer.\n");
                    }
                    break;
                case INCLOS_SORTIR:
                    System.out.println("\nHas triat Tornar al menú anterior.\n");
                    break;
            }
        } while(opcio!=OpcionsInclos.INCLOS_SORTIR);
    }
    
    /**
     * Gestions del reproductor.
     */
    public void gestioReproductor(){
        Menu<OpcionsRepro> menu=new Menu<>("Gestió del reproductor",OpcionsRepro.values());
        menu.setDescripcions(REPRO);
        OpcionsRepro opcio;
        do {
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);
            switch(opcio) {
                case REPRO_FITXER:
                    System.out.println("\nHas triat Reproduir un fitxer multimèdia.\n");
                    if (!(this.controlador.isEmpty())){
                        System.out.println("\nAquests són els camins dels fitxers de la biblioteca: ");                    
                        imprimir(this.controlador.mostrarCamins());
                        System.out.println("\nIntrodueix l'índex del fitxer a reproduir: ");
                        int num=sc.nextInt()-1;
                        while (!(this.controlador.isRemovable(num))){
                            System.out.println("\nTorna-ho a provar: ");
                            num=sc.nextInt()-1;
                        }
                        try{
                            this.controlador.reproduirFitxer(num);
                        }catch(AplicacioException e){}
                    }else{
                        System.out.println("\nLa biblioteca és buida. No es pot reproduir cap fitxer.\n");
                    }
                    break;
                case REPRO_BIBLIO:
                    System.out.println("\nHas triat Reproduir el contingut de la biblioteca.\n");
                    if (!(this.controlador.isEmpty())){
                        try{
                            this.controlador.reproduirCarpeta();
                        }catch(AplicacioException e){}
                    }else{
                        System.out.println("\nLa biblioteca és buida. No es pot reproduir cap fitxer.\n");
                    }
                    break;
                case REPRO_ALBUM:
                    System.out.println("\nHas triat Reproduir el contingut d'un àlbum.\n");
                    if (!(this.controlador.anyAlbums())){
                        System.out.println("\nAquests són àlbums de la biblioteca: ");                    
                        imprimir(this.controlador.mostrarLlistatAlbums());
                        System.out.println("\nIntrodueix l'índex de l'àlbum a reproduir: ");
                        int num=sc.nextInt()-1;
                        while (!(this.controlador.albumAcotat(num))){
                            System.out.println("\nTorna-ho a provar: ");
                            num=sc.nextInt()-1;
                        }
                        String number=this.controlador.id2Titol(num);
                        try{
                            this.controlador.reproduirCarpeta(number);
                        }catch(AplicacioException e){}
                    }else{
                        System.out.println("\nNo hi ha cap àlbum.\n");
                    }
                    break;
                case REPRO_CONT:
                    System.out.println("\nHas triat Modificar la continuïtat de la reproducció.\n");
                    System.out.println("\nVols que la reproducció sigui en mode continu? (y/n) ");
                    String resposta=sc.nextLine();
                    while((!(resposta.equals("n")))&&(!(resposta.equals("y")))){
                        System.out.println("\nIntrodueix 'y' o 'n' ");
                        resposta=sc.nextLine();
                    }
                    if (resposta.equals("y")){
                        this.controlador.setContinu(true);
                    }else{
                        this.controlador.setContinu(false);                    
                    }
                    break;
                case REPRO_ALE:
                    System.out.println("\nHas triat Modificar l'aleatorietat de la reproducció.\n");
                    System.out.println("\nVols que la reproducció sigui en mode aleatori? (y/n) ");
                    resposta=sc.nextLine();
                    while((!(resposta.equals("n")))&&(!(resposta.equals("y")))){
                        System.out.println("\nIntrodueix 'y' o 'n' ");
                        resposta=sc.nextLine();
                    }
                    if (resposta.equals("y")){
                        this.controlador.setAleatori(true);
                    }else{
                        this.controlador.setAleatori(false);                    
                    }
                    break;
                case REPRO_CURS:
                    System.out.println("\nHas triat Gestionar la reproducció en curs.\n");
                    gestioCurs();
                    break;
                case REPRO_SORTIR:
                    System.out.println("\nHas triat Tornar al menú anterior.\n");
                    break;
            }
        } while(opcio!=OpcionsRepro.REPRO_SORTIR);
    }
    
    /**
     * Controls del reproductor.
     */
    public void gestioCurs() {
        Menu<OpcionsCurs> menu=new Menu<>("Gestió de la reproducció en curs",OpcionsCurs.values());
        menu.setDescripcions(CURS);
        OpcionsCurs opcio;
        do {
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);
            switch(opcio) {
                case CURS_PLAY:
                    System.out.println("\nHas triat Reactivar la reproducció.\n");
                    try{
                        this.controlador.reemprenReproduccio();
                    }catch (AplicacioException e){}
                    break;
                case CURS_PAUSE:
                    System.out.println("\nHas triat Pausar la reproducció.\n");
                    try{
                        this.controlador.pausaReproduccio();
                    }catch (AplicacioException e){}
                    break;
                case CURS_STOP:
                    System.out.println("\nHas triat Parar la reproducció.\n");
                    try{
                        this.controlador.aturaReproduccio();
                    }catch (AplicacioException e){}
                    break;
                case CURS_NEXT:
                    System.out.println("\nHas triat Saltar al següent fitxer.\n");
                    try{
                        this.controlador.saltaReproduccio();
                    }catch (AplicacioException e){}
                    break;
                case CURS_SORTIR:
                    System.out.println("\nHas triat Tornar al menú anterior.\n");
                    break;
            }
        } while(opcio!=OpcionsCurs.CURS_SORTIR);
    }
    
    /**
     * Imprimeix llistes.
     * 
     * @param llista obvi
     */
    public void imprimir(List<String> llista){
        for(int i=0;i<llista.size();i++){
            System.out.print(llista.get(i));
        }
    }
    
    /**
     * Elimina els caràcters que causen conflicte quan s'introdueixen rutes al
     * programa.
     * 
     * @param path  la ruta sense processar
     * @return la ruta processada
     */
    public String pathClearing(String path){
        String ruta = path;
        ruta = ruta.replace("\"","");
        return ruta;
    }
}