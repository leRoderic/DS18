package edu.ub.prog2.CabezasRodrigoNunezJosep.vista;
import edu.ub.prog2.CabezasRodrigoNunezJosep.model.CarpetaFitxers;
import edu.ub.prog2.CabezasRodrigoNunezJosep.model.FitxerMultimedia;
import edu.ub.prog2.utils.Menu;
import java.util.*;

public class AplicacioUB1 {
    static private enum OpcionsMenuPrincipal {MENU_PRINCIPAL_AFEGIR,MENU_PRINCIPAL_ELIMINAR,MENU_PRINCIPAL_MOSTRAR,MENU_PRINCIPAL_SORTIR};
    static private String[] descMenuPrincipal={"Afegeir un nou arxiu a la carpeta",
                                               "Eliminar un dels fitxers existents a la carpeta",
                                               "Mostrar el contingut de la carpeta",
                                               "Sortir de l'aplicació"};
    
    public void gestioAplicacioUB(Scanner sc){        
        Menu<OpcionsMenuPrincipal> menu=new Menu<OpcionsMenuPrincipal>("Menu principal",OpcionsMenuPrincipal.values());
        menu.setDescripcions(descMenuPrincipal);
        OpcionsMenuPrincipal opcio = null;
        CarpetaFitxers carpeta=new CarpetaFitxers();
        do {
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);
            switch(opcio) {
                case MENU_PRINCIPAL_AFEGIR:
                    System.out.println("\nHas triat Afegir un nou arxiu a la carpeta.\n");
                    FitxerMultimedia fitxer;
                    System.out.println("\nIntrodueix el camí del fitxer: ");
                    String cami=sc.nextLine();
                    System.out.println("\nVols introduir descripció? (y/n) ");
                    String resposta=sc.nextLine();
                    while((!(resposta.equals("n")))&&(!(resposta.equals("y")))){
                        System.out.println("\nIntrodueix 'y' o 'n' ");
                        resposta=sc.nextLine();
                    }
                    if (resposta.equals("y")){
                        System.out.println("\nIntrodueix la descripció del fitxer: ");
                        String dsc=sc.nextLine();
                        fitxer=new FitxerMultimedia(cami,dsc);
                    }else{
                        fitxer=new FitxerMultimedia(cami);                        
                    }
                    carpeta.addFitxer(fitxer);
                    break;
                case MENU_PRINCIPAL_ELIMINAR:
                    System.out.println("\nHas triat Eliminar un dels fitxers existents a la carpeta.\n");
                    if ((!carpeta.isEmpty())){
                        System.out.println("\nAquests són els camins dels fitxers de la carpeta: ");                    
                        System.out.print(carpeta.toStringCami());
                        System.out.println("\nIntrodueix l'índex del fitxer a eliminar: ");
                        FitxerMultimedia elim=carpeta.getAt(sc.nextInt()-1);
                        while (elim==null){
                            System.out.println("\nTorna-ho a provar: ");
                            elim=carpeta.getAt(sc.nextInt()-1);
                        }
                        carpeta.removeFitxer(elim);
                    }else{
                        System.out.println("\nLa carpeta és buida. No es pot esborrar cap fitxer.\n");
                    }
                    here:
                    break;
                case MENU_PRINCIPAL_MOSTRAR:
                    System.out.println("\nHas triat Mostrar el contingut de la carpeta.\n");
                    System.out.print(carpeta.toString());
                    break;                
                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("\nFins aviat!\n");
                    break;
            }
        } while(opcio!=OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    }
}
