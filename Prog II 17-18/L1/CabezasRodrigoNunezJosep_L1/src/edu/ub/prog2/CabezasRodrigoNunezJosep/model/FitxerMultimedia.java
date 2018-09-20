package edu.ub.prog2.CabezasRodrigoNunezJosep.model;
import java.io.File;
import java.util.*;

public class FitxerMultimedia extends File{
    private String camiAbsolut,nom,extensio;
    private Date lastModified;
    private String descripcio;
    
    /**
     * Constructor per defecte.
     * 
     * @param cami camí absolut del fitxer
     */
    public FitxerMultimedia(String cami) {
        super(cami);
        if((this.exists()) && (!(this.isDirectory()))){
            this.setUltimaModificacio(new Date(this.lastModified()));
            this.setCamiAbsolut(this.getAbsolutePath());
            String name=this.getName();
            int punt=name.lastIndexOf(".");
            this.setNomFitxer(name.substring(0,punt));        
            this.setExtensio(name.substring(punt));
        }else{
            //System.out.println("\nEl fitxer no existeix.\n");
            this.setUltimaModificacio(new Date());
            this.setCamiAbsolut(cami);            
            this.setNomFitxer("");        
            this.setExtensio("");
        }
        this.setDescripcio("");
    }
    
    /**
     * Constructor indicant la descripció.
     * 
     * @param cami camí absolut del fitxer
     * @param desc descripció del fitxer
     */
    public FitxerMultimedia(String cami, String desc) {
        super(cami);
        if((this.exists()) && (!(this.isDirectory()))){
            this.setUltimaModificacio(new Date(this.lastModified()));
            this.setCamiAbsolut(this.getAbsolutePath());
            String name=this.getName();
            int punt=name.lastIndexOf(".");
            this.setNomFitxer(name.substring(0,punt));        
            this.setExtensio(name.substring(punt));
        }else{
            //System.out.println("\nEl fitxer no existeix.\n");
            this.setUltimaModificacio(new Date());
            this.setCamiAbsolut(cami);            
            this.setNomFitxer("");        
            this.setExtensio("");
        }
        this.setDescripcio(desc);
    }
    
    /**
    * Estableix la data de la última modificació.
    * 
    * @param lastModified data de la última modificació
    */
    public void setUltimaModificacio(Date lastModified){
        this.lastModified=lastModified;
    }
    
    /**
     * Estableix ruta on és el fitxer.
     * 
     * @param camiAbsolut directori del fitxer
     */
    public void setCamiAbsolut(String camiAbsolut){
        this.camiAbsolut=camiAbsolut;
    }
    
    /**
     * Dóna nom a un fitxer.
     * 
     * @param nom el nom del fitxer
     */
    public void setNomFitxer(String nom){
        this.nom=nom;
    }
    
    /**
     * Estableix extensió per el fitxer.
     * 
     * @param extensio la extensió del fitxer
     */
    public void setExtensio(String extensio){
        this.extensio=extensio;
    }
    
    /**
     * Dóna descprició al fitxer.
     * 
     * @param descripcio la descripció del fitxer
     */
    public void setDescripcio(String descripcio){
        this.descripcio=descripcio;
    }
    
    /**
     * Retorna la data de la última modificació.
     * 
     * @return data de la última modificació
     */
    public Date getUltimaModificacio(){
        return lastModified;
    }
    
    /**
     * Retorna el directori on és troba el fitxer.
     * 
     * @return path del fitxer
     */
    public String getCamiAbsolut(){
        return camiAbsolut;
    }
    
    /**
     * Retorna el nom del fitxer.
     * 
     * @return nom del fitxer
     */
    public String getNomFitxer(){
        return nom;
    }
    
    /**
     * Retorna la extensió del fitxer.
     * 
     * @return extensió del fitxer
     */
    public String getExtensio(){
        return extensio;
    }
    
    /**
     * Retorna la descripció del fitxer.
     * 
     * @return la descripció
     */
    public String getDescripcio(){
        return descripcio;
    }
    
    /**
     * Comparador de dos fitxers.
     * 
     * @return true: són iguals false: són diferents
     */
    public boolean equals(/*Object*/FitxerMultimedia fitxerMultimedia){
        if (!(fitxerMultimedia.getUltimaModificacio().equals(this.getUltimaModificacio()))){
            return false;
        }else if (!(fitxerMultimedia.getCamiAbsolut().equals(this.getCamiAbsolut()))){
            return false;
        }else if (!(fitxerMultimedia.getNomFitxer().equals(this.getNomFitxer()))){
            return false;
        }else if (!(fitxerMultimedia.getExtensio().equals(this.getExtensio()))){
            return false;
        }else{
            return fitxerMultimedia.getDescripcio().equals(this.getDescripcio());
        }        
    }
    
    @Override
    public String toString(){
        //String retorn="Nom del fitxer: "+this.getNomFitxer()+"\nExtensió: "+this.getExtensio()+"\nCamí absolut: "+this.getCamiAbsolut()+"\nDescripció: "+this.getDescripcio()+"\nÚltima modificació: "+this.getUltimaModificacio();
        String retorn="Descripció = "+this.getDescripcio()+"\ndata = "+this.getUltimaModificacio()+"\nnom = "+this.getNomFitxer()+"\next = "+this.getExtensio()+"\ncamí complet = "+this.getCamiAbsolut()+"\n";
        return retorn;
    }
}
