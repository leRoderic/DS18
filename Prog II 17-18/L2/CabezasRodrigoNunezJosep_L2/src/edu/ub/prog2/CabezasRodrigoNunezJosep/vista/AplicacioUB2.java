package edu.ub.prog2.CabezasRodrigoNunezJosep.vista;
import edu.ub.prog2.utils.Menu;
import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.Controlador;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class AplicacioUB2 {
    static private enum OpcionsPrincipal {PRINCIPAL_GESTIO,PRINCIPAL_GUARDAR,PRINCIPAL_RECUPERAR,PRINCIPAL_SORTIR};
    static private String[] descPrincipal={"Gestionar la biblioteca","Guardar les dades a disc","Carregar les dades de disc","Sortir de l'aplicació"};
    static private enum OpcionsGestio {GESTIO_AFEGIR,GESTIO_MOSTRAR,GESTIO_ELIMINAR,GESTIO_SORTIR};
    static private String[] descGestio={"Afegir un nou fitxer multimèdia","Mostrar el contingut de la biblioteca","Eliminar un dels fitxers existents","Menú anterior"};
    static private enum OpcionsAfegir {AFEGIR_VIDEO,AFEGIR_AUDIO,AFEGIR_SORTIR};
    static private String[] descAfegir={"Afegir un fitxer de vídeo","Afegir un fitxer d'àudio","Menú anterior"};
    private Controlador controlador;
    
    public AplicacioUB2(){
        this.controlador=new Controlador();
    }
    
    public void gestioAplicacioUB(Scanner sc) throws AplicacioException, ClassNotFoundException{
        Menu<OpcionsPrincipal> menu=new Menu<OpcionsPrincipal>("Menú principal",OpcionsPrincipal.values());
        menu.setDescripcions(descPrincipal);
        OpcionsPrincipal opcio = null;
        do {
            menu.mostrarMenu();opcio=menu.getOpcio(sc);
            switch(opcio) {
                case PRINCIPAL_GESTIO:
                    System.out.println("\nHas triat Gestionar la biblioteca.\n");
                    gestioBiblioteca(sc);
                    break;
                case PRINCIPAL_GUARDAR:
                    try{
                        System.out.println("\nHas triat Guardar les dades a disc.\n");                    
                        System.out.println("\nIntrodueix el camí del fitxer a on guardar: ");
                        String camiDesti=sc.nextLine();
                        this.controlador.guardarDadesDisc(camiDesti);
                    }catch(IOException e){}
                    break;
                case PRINCIPAL_RECUPERAR:
                    try{
                        System.out.println("\nHas triat Carregar les dades de disc.\n");                    
                        System.out.println("\nIntrodueix el camí del fitxer d'on carregar: ");
                        String camiOrigen=sc.nextLine();
                        this.controlador.carregarDadesDisc(camiOrigen);
                    }catch(IOException e){}
                    break;                
                case PRINCIPAL_SORTIR:
                    System.out.println("\nFins aviat!\n");
                    break;
            }
        } while(opcio!=OpcionsPrincipal.PRINCIPAL_SORTIR);
    }
    
    public void gestioBiblioteca(Scanner sc) throws AplicacioException{
        Menu<OpcionsGestio> menu=new Menu<OpcionsGestio>("Gestió de la biblioteca",OpcionsGestio.values());
        menu.setDescripcions(descGestio);
        OpcionsGestio opcio = null;
        do {
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);
            switch(opcio) {
                case GESTIO_AFEGIR:
                    System.out.println("\nHas triat Afegir un nou arxiu a la biblioteca.\n");
                    gestioAfegir(sc);
                    break;
                case GESTIO_MOSTRAR:
                    System.out.println("\nHas triat Mostrar el contingut de la biblioteca.\n");
                    System.out.print(this.controlador.mostrarBiblioteca());
                    break;
                case GESTIO_ELIMINAR:
                    System.out.println("\nHas triat Eliminar un dels fitxers existents a la biblioteca.\n");
                    if ((!this.controlador.isEmpty())){
                        System.out.println("\nAquests són els camins dels fitxers de la biblioteca: ");                    
                        System.out.print(this.controlador.mostrarCamins());
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
                case GESTIO_SORTIR:
                    System.out.println("\nHas triat Tornar al menú anterior.\n");
                    break;
            }
        } while(opcio!=OpcionsGestio.GESTIO_SORTIR);
    }
    
    public void gestioAfegir(Scanner sc) throws AplicacioException{
        Menu<OpcionsAfegir> menu=new Menu<OpcionsAfegir>("Afegir un nou fitxer multimèdia",OpcionsAfegir.values());
        menu.setDescripcions(descAfegir);
        OpcionsAfegir opcio = null;
        do {
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);
            Object[] compartit;
            switch(opcio) {
                case AFEGIR_VIDEO:
                    try{
                        System.out.println("\nHas triat Afegir un nou fitxer de vídeo.\n");
                        compartit=this.demana(sc);
                        Object[] video=this.demanaVideo(sc);
                        this.controlador.afegirVideo((String)compartit[0], (String)compartit[1], (String)compartit[2], (Float)compartit[3], (int)video[0], (int)video[1], (Float)video[2]);
                    }catch(AplicacioException e){}
                    break;
                case AFEGIR_AUDIO:
                    try{
                        System.out.println("\nHas triat Afegir un nou fitxer d'àudio.\n");
                        compartit=this.demana(sc);
                        Object[] audio=this.demanaAudio(sc);
                        this.controlador.afegirAudio((String)compartit[0], (String)compartit[1], (String)compartit[2], (Float)compartit[3], (String)audio[0], (int)audio[1]);
                    }catch(AplicacioException e){}
                    break;
                case AFEGIR_SORTIR:
                    System.out.println("\nHas triat Tornar al menú anterior.\n");
                    break;
            }
        } while(opcio!=OpcionsAfegir.AFEGIR_SORTIR);
    }
    
    public Object[] demanaVideo(Scanner sc){
        Object[] dades=new Object[3];                 
        System.out.println("\nIntrodueix l'alçada (valor enter) del vídeo: ");
        dades[0]=(int)sc.nextInt();         
        System.out.println("\nIntrodueix l'amplada (valor enter) del vídeo: ");
        dades[1]=(int)sc.nextInt();        
        System.out.println("\nIntrodueix els fps (valor float) del fitxer: ");
        dades[2]=sc.nextFloat();
        return dades;
    }
    
    public Object[] demanaAudio(Scanner sc){    
        Object[] dades=new Object[2];
        System.out.println("\nVols introduir una imatge per la reproducció? (y/n) ");
        String resposta=sc.nextLine();
        while((!(resposta.equals("n")))&&(!(resposta.equals("y")))){
            System.out.println("\nIntrodueix 'y' o 'n' ");
            resposta=sc.nextLine();
        }
        if (resposta.equals("y")){
            System.out.println("\nIntrodueix el camí de la imatge: ");
            resposta=sc.nextLine();
            File a=new File(resposta);
            while((a.isDirectory()) || (!(a.exists()))){                
                System.out.println("\nIntrodueix un camí vàlid: ");
                resposta=sc.nextLine();
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
    
    public Object[] demana(Scanner sc){        
        Object[] dades=new Object[4];
        System.out.println("\nIntrodueix el camí del fitxer: ");
        dades[0]=sc.nextLine();
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
    
}
