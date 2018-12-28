/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

/**
 *
 * @author anna
 */
public interface DAO_STUB {
    public void loadSerie(String id, String title, String desc);
    public void loadTemporada(String idSerie, String numTemporada, String numEpisodis);
    public void loadEpisodi(String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada);
    public void loadArtista(String id, String nom, String tipus, String idSerie, String nacionalitat);
    public void loadProductora(String id, String nom, String idSerie);
    public void loadAdmin(String id, String nom, String usuari, String password);
    public void loadClient(String id, String nom, String dni, String adreca, String usuari, String password);
    public void loadSubscripcio(String id, String client, String serie, String numTemporada, String episodi);
    public void loadVisualització(String id, String client, String serie, String numTemporada, String episodi, String data);
    public void loadValoracio(String id, String client, String idSerie, String numTemporada, String episodi, String puntuacio, String data);

}
