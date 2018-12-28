package app.resources;

import app.model.*;

import java.util.ArrayList;

/**
 * Data manager per StUB. Crea les estructures de dades necessaries
 * per a manegar la capa de persistència de STUB.
 *
 */
public class DAO_XML_STUB implements DAO_STUB {

	private String serie;
	private String temporada;
	private String client;
	private String episodi;
	private String valoracio;
	private String productora;
	private String artista;
	private String subscripcio;
	private String visualitzacio;
    private Catalog catalog;
    private ArrayList<User> users;
    private Series sSerie;
    private User user;

	public DAO_XML_STUB(String nomFitxer) {
        this.catalog = new Catalog();
        this.users = new ArrayList<User>();
		STUBXMLParser parser = new STUBXMLParser(this);
		parser.parse(nomFitxer);
	}
	/**
	 * Obté les dades del fitxer XML passat per paràmetre
	 *
	 * @param nomFitxer ruta del fitxer XML del que obtenir les dades
	 */
	public void obtenirDades(String nomFitxer) {
		STUBXMLParser parser = new STUBXMLParser(this);
		parser.parse(nomFitxer);
	}

	/**
	 * Crea una nova serie a partir de la informacio obtinguda del fitxer XML
	 *
	 * @param id id de la serie. El podeu utilitzar o no
	 * @param title títol de la serie
	 * @param desc descripcio de la serie
	 */
	public void loadSerie(String id, String title, String desc) {
        Series lSerie = new Series(title, desc, id);
        catalog.addSerie(lSerie);
        this.sSerie = lSerie;
		this.serie=title;
	}

	/**
	 * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
	 *
	 * @param idSerie
	 * @param numTemporada numero de la temporada
	 * @param numEpisodis numero d'episodis
	 *
	 */
	public void loadTemporada(String idSerie, String numTemporada, String numEpisodis) {
		SeriesSeason season = new SeriesSeason(this.sSerie, Integer.parseInt(numTemporada), Integer.parseInt(numEpisodis));
		this.sSerie.addSeason(season);
		this.temporada=numTemporada;
	}

	/**
	 * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
	 *  @param title titol de lepisodi
	 * @param duration duració de l'episodi
	 * @param idioma idioma de l'episodi V.O.
	 * @param description sinopsi de l'episodi
	 * @param data data d'estrena de l'episodi
	 * @param idSerie
	 * @param numTemporada
	 *
	 */
	public void loadEpisodi(String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada) {
		Episode epi = new Episode(title, duration, idioma, description, data, idSerie, numTemporada);
		this.sSerie.getSeason(Integer.parseInt(numTemporada)).addEpisode(epi);
		this.episodi=title;
	}

	/**
	 * Crea un nou artista a partir de la informacio obtinguda del fitxer XML
	 *
	 * @param id id del artista. El podeu utilitzar o no
	 * @param nom nom del artista
	 * @param tipus tipus (director\actor) del artista
	 * @param idSerie serie a la qual treballa. El podeu utilitzar o no
	 * @param nacionalitat
	 */

	public void loadArtista(String id, String nom, String tipus, String idSerie, String nacionalitat) {

		StaffFactory factory = new StaffFactory();
		Staff staff = factory.StaffFactory(nom, tipus, nacionalitat);
		if("actor".equals(tipus)){
			this.catalog.getSeries(idSerie).addStaff(staff);
		}
		else{
			this.catalog.getSeries(idSerie).setDirector((Director)staff);
		}
		this.artista = nom;
	}

	/**
	 * Crea productora del fitxer XML
	 *
	 * @param id id de la productora
	 * @param nom nom de la productora
	 * @param idSerie id de la serie que va fer. El podeu utilitzar o no
	 */
	public void loadProductora(String id, String nom, String idSerie) {
	    Producer producer = new Producer(nom, id, 1999);
        this.catalog.getSeries(idSerie).setProducer(producer);
		this.productora=nom;
	}

	/**
	 * Crea una valoracio a partir de la informacio obtinguda del fitxer XML
	 *  @param id id de la valoracio. El podeu utilitzar o no
	 * @param client identificador del client. El podeu utilitzar o no
	 * @param idSerie
	 * @param numTemporada
	 * @param puntuacio puntuacio donada al episodi
	 * @param data data en la que es va fer la puntuacio
	 */

	public void loadValoracio(String id, String client, String idSerie, String numTemporada, String episodi, String puntuacio, String data) {
		User tmp = this.getUser(id);
		Rating rating = new Rating(Integer.parseInt(puntuacio), "Not provided", null, tmp);
		this.catalog.getSeries(idSerie).getSeason(Integer.parseInt(numTemporada)).getEpisode(episodi).addRating(rating);
        this.valoracio = puntuacio;
	}

	/**
	 * Crea un nou admin a partir de la informacio obtinguda del fitxer XML
	 *
	 * @param id id del administrador
	 * @param nom nom del administrador
	 * @param usuari usuari del administrador
	 * @param password password del administrador
	 */
	public void loadAdmin(String id, String nom, String usuari, String password) {
	    /* No se implementa ya que en el enunciado de la práctica no pone nada de crear administradores.*/
	}

	/**
	 * Crea un nou client a partir de la informacio obtinguda del fitxer XML
	 *
	 * @param id id del client
	 * @param nom nom del client
	 * @param dni dni del client
	 * @param adreca adreça del client
	 * @param usuari usuari al sistema del client
	 * @param password password del client
	 *
	 */
	public void loadClient(String id, String nom, String dni, String adreca, String usuari, String password) {
        User user = new User(usuari, nom, password, adreca, "Not provided", id);
        if(!this.users.contains(user)) {
            this.users.add(user);
            this.client = usuari;
        }
	}

	public Catalog getCatalog(){
		return this.catalog;
	}

	/**
	 * Crea un nova subscripció a partir de la informació obtinguda del fitxer XML
	 *  @param id de la subscripció
	 * @param numTemporada
	 */
	public void loadSubscripcio(String id, String client, String serie, String numTemporada, String episodi) {
        getUser(client).addToSubscribedList(this.catalog.getSeries(serie).getSeason(Integer.parseInt(numTemporada)).getEpisode(episodi));
		this.subscripcio=episodi;
	}

	public User getUser(String id){
		for(int i = 0; i < this.users.size(); i++){
			if(this.users.get(i).getId().equals(id)){
				return this.users.get(i);
			}
		}
		return null;
	}

	/**
	 * Crea un nova visualització a partir de la informació obtinguda del fitxer XML
	 *  @param id de la visualització
	 * @param numTemporada
	 * @param data de la visualització del episodi
	 */
	public void loadVisualització(String id, String client, String serie, String numTemporada, String episodi, String data) {
        /* No se implementa ya que en el enunciado de la práctica no pone nada de guardar las visualizaciones de los usuarios.*/
	}

	public Episode getEpisode(String t, String id, int n){
		return this.catalog.getEpisode(t, id, n);
	}

	public ArrayList<User> getUsers(){
		return this.users;
	}

	public String getSerie() {
		return serie;
	}

	public String getTemporada() {
		return temporada;
	}

	public String getClient() {
		return client;
	}

	public String getAdmin() {
		return "";
	}

	public String getEpisodi() {
		return episodi;
	}

	public String getValoracio() {
		return valoracio;
	}

	public String getProductora() {
		return productora;
	}

	public String getArtista() {
		return artista;
	}

	public String getSubscripcio() {
		return subscripcio;
	}

	public String getVisualitzacio() {
		return visualitzacio;
	}

}
