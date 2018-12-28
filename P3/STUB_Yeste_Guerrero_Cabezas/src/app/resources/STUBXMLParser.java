package app.resources;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Parser per a obtenir dades d'un fitxer XML de STUB
 *
 */
public class STUBXMLParser {

	/**
	 * DAO
	 */
	private DAO_XML_STUB daoXml;

	/**
	 * Constructor
	 * @param daoXml
	 */
	public STUBXMLParser(DAO_XML_STUB daoXml) {
		this.daoXml = daoXml;
	}

	/**
	 * Parseja un fitxer XML de STUB i guarda les dades al sistema
	 *
	 * @param nomFitxer
	 */
	public void parse(String nomFitxer) {
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File(nomFitxer));
			doc.getDocumentElement().normalize();

			// Obtenim dades
			this.obtenirSeries(doc);
			this.obtenirValoracions(doc);
			this.obtenirAdministradors(doc);
			this.obtenirClients(doc);
			this.obtenirSubcripcions(doc);
			this.obtenirVisualitzacions(doc);
		}
		catch (SAXParseException err) {
			System.out.println ("** Error parsejant" +", linia " + err.getLineNumber () + ", uri " + err.getSystemId ());
			System.out.println(" " + err.getMessage ());
		}
		catch (SAXException e) {
			Exception x = e.getException ();
			((x == null) ? e : x).printStackTrace ();
		}
		catch (Throwable t) {
			t.printStackTrace ();
		}
	}

	/**
	 * Obte les Series per STUB
	 *
	 * @param doc document XML del que obtenir les dades
	 */
	private void obtenirSeries(Document doc) {
		NodeList Series = doc.getElementsByTagName("Serie");
		String id, title, desc;
		int numSeries = Series.getLength();

		// Parsejo tots els elements Series
		for(int i=0; i<numSeries; i++) {
			Node serie = Series.item(i);

			if(serie.getNodeType() == Node.ELEMENT_NODE){
				Element eSerie = (Element)serie;
				id = serie.getAttributes().getNamedItem("id").getTextContent();


				NodeList nTitle = eSerie.getElementsByTagName("title");
				Element eTitle = (Element)nTitle.item(0);
				title = eTitle.getTextContent();

				NodeList nDesc = eSerie.getElementsByTagName("description");
				Element eDesc = (Element)nDesc.item(0);
				desc = eDesc.getTextContent();

				// Creem una nova serie amb la informacio obtinguda
				daoXml.loadSerie(id, title, desc);

				// Obtenim informacio de la productora
				this.obtenirProductora(eSerie, id);

				// Obtenim informacio dels artistes
				this.obtenirArtistes(eSerie, id);

				// Obtenim informacio de les temporades
				this.obtenirTemporades(eSerie, id);
			}
		}
	}

	/**
	 * Obte la productura que va fer la serie
	 *
	 * @param eSerie serie on buscar els generes
	 * @param idSerie id de la serie
	 */
	private void obtenirProductora(Element eSerie, String idSerie) {
		String nom, id;
		Node productora = eSerie.getElementsByTagName("productora").item(0);

		if(productora.getNodeType() == Node.ELEMENT_NODE){
			id = productora.getAttributes().getNamedItem("id").getTextContent();
			nom = productora.getAttributes().getNamedItem("name").getTextContent();

			daoXml.loadProductora(id, nom, idSerie);
		}
	}

	/**
	 * Obte informacio sobre els artistes que hi participen a una serie
	 *
	 * @param eSerie serie on buscar els artistes
	 * @param idSerie id de la serie
	 */
	private void obtenirArtistes(Element eSerie, String idSerie) {
		NodeList artistes = eSerie.getElementsByTagName("artist");
		String id, nom, tipus,nacionalitat;
		int numArtistes = artistes.getLength();

		// Parsejo tots els elements artist
		for(int i=0; i<numArtistes; i++) {
			Node artist = artistes.item(i);

			if(artist.getNodeType() == Node.ELEMENT_NODE){
				id = artist.getAttributes().getNamedItem("id").getTextContent();
				nom = artist.getAttributes().getNamedItem("nom").getTextContent();
				tipus = artist.getAttributes().getNamedItem("tipus").getTextContent();
				nacionalitat = artist.getAttributes().getNamedItem("nacionalitat").getTextContent();
				daoXml.loadArtista(id,nom,tipus,idSerie,nacionalitat);
			}
		}
	}

	/**
	 * Obte informacio sobre les temporades d'una serie
	 *
	 * @param eSerie serie on buscar les temporades
	 * @param idSerie id de la serie
	 */
	private void obtenirTemporades(Element eSerie, String idSerie) {
		NodeList temporades = eSerie.getElementsByTagName("temporada");
		String numTemporada, numEpisodis;
		int numTemporades = temporades.getLength();

		// Parsejo tots els elements artist
		for(int i=0; i<numTemporades; i++) {
			Node temporada = temporades.item(i);

			if(temporada.getNodeType() == Node.ELEMENT_NODE){

				Element eTemporada = (Element)temporada;

				NodeList nTemporada = eTemporada.getElementsByTagName("numeroTemporada");
				Element eeTemporada = (Element)nTemporada.item(0);
				numTemporada = eeTemporada.getTextContent();

				NodeList nEpisodi = eTemporada.getElementsByTagName("numeroEpisodis");
				Element eeEpisodi = (Element)nEpisodi.item(0);
				numEpisodis = eeEpisodi.getTextContent();

				daoXml.loadTemporada(idSerie, numTemporada, numEpisodis);

				obtenirEpisodis(eTemporada, idSerie, numTemporada);
			}
		}
	}

	/**
	 * Obte informacio sobre les temporades d'una serie
	 *
	 * @param idSerie serie on buscar les temporades
	 * @param idSerie id de la serie
	 */
	private void obtenirEpisodis(Element eTemporada, String idSerie, String numTemporada) {
		NodeList episodis = eTemporada.getElementsByTagName("episodi");
		String title,  duration,  idioma,  description,  data;
		int numEpisodis = episodis.getLength();

		// Parsejo tots els elements episodi
		for(int i=0; i<numEpisodis; i++) {
			Node episodi = episodis.item(i);

			if(episodi.getNodeType() == Node.ELEMENT_NODE){

				Element eEpisodi = (Element)episodi;

				NodeList nTitle = eEpisodi.getElementsByTagName("title");
				Element eeTitle = (Element)nTitle.item(0);
				title = eeTitle.getTextContent();

				NodeList nDuracio = eEpisodi.getElementsByTagName("duracio");
				Element eeDuracio = (Element)nDuracio.item(0);
				duration = eeDuracio.getTextContent();

				NodeList nIdioma = eEpisodi.getElementsByTagName("idioma");
				Element eeIdioma = (Element)nIdioma.item(0);
				idioma = eeIdioma.getTextContent();

				NodeList nDescription = eEpisodi.getElementsByTagName("description");
				Element eeDescription = (Element)nDescription.item(0);
				description = eeDescription.getTextContent();

				NodeList nData = eEpisodi.getElementsByTagName("data");
				Element eeData = (Element)nData.item(0);
				data = eeData.getTextContent();

				daoXml.loadEpisodi(title,duration,idioma,description, data, idSerie, numTemporada);
			}
		}
	}

	/**
	 * Obte informacio sobre les valoracions
	 *
	 * @param doc fitxer XML del que obtenir les dades
	 */
	private void obtenirValoracions(Document doc) {
		NodeList valoracions = doc.getElementsByTagName("valoracio");
		String id, client, subscripcio, puntuacio, data, serie, temporada, episodi;
		int numValoracions = valoracions.getLength();

		// Parsejo tots els elements valoracio
		for(int i=0; i<numValoracions; i++) {
			Node valoracio = valoracions.item(i);

			if(valoracio.getNodeType() == Node.ELEMENT_NODE){

				id = valoracio.getAttributes().getNamedItem("id").getTextContent();
				client = valoracio.getAttributes().getNamedItem("client").getTextContent();
				puntuacio = valoracio.getAttributes().getNamedItem("puntuacio").getTextContent();
				data = valoracio.getAttributes().getNamedItem("data").getTextContent();
				serie = valoracio.getAttributes().getNamedItem("serie").getTextContent();
				temporada = valoracio.getAttributes().getNamedItem("temporada").getTextContent();
				episodi = valoracio.getAttributes().getNamedItem("episodi").getTextContent();

				daoXml.loadValoracio(id,client, serie, temporada, episodi, puntuacio, data);
			}
		}
	}

	/**
	 * Obte informacio sobre els administradors 
	 *
	 * @param doc fitxer XML del que obtenir les dades
	 */
	private void obtenirAdministradors(Document doc) {
		NodeList admins = doc.getElementsByTagName("admin");
		String id, nom, usuari, password;
		int numAdmins = admins.getLength();

		// Parsejo tots els elements admin
		for(int i=0; i<numAdmins; i++) {
			Node admin = admins.item(i);

			if(admin.getNodeType() == Node.ELEMENT_NODE){
				id = admin.getAttributes().getNamedItem("id").getTextContent();
				Element eAdmin = (Element)admin;

				NodeList nNom = eAdmin.getElementsByTagName("nom");
				Element eNom = (Element)nNom.item(0);
				nom = eNom.getTextContent();

				NodeList nUsuari = eAdmin.getElementsByTagName("usuari");
				Element eUsuari = (Element)nUsuari.item(0);
				usuari = eUsuari.getTextContent();

				NodeList nPassword = eAdmin.getElementsByTagName("password");
				Element ePassword = (Element)nPassword.item(0);
				password = ePassword.getTextContent();

				// Creem l'admin
				daoXml.loadAdmin(id, nom, usuari, password);
			}
		}
	}

	/**
	 * Obte informacio sobre els clients
	 *
	 * @param doc fitxer XML del que obtenir les dades
	 */
	private void obtenirClients(Document doc) {
		NodeList clients = doc.getElementsByTagName("client");
		String id, nom, usuari, password, vip, dni, adreca;
		int numClients = clients.getLength();

		// Parsejo tots els elements client
		for(int i=0; i<numClients; i++) {
			Node client = clients.item(i);

			if(client.getNodeType() == Node.ELEMENT_NODE){
				id = client.getAttributes().getNamedItem("id").getTextContent();
				Element eClient = (Element)client;

				NodeList nNom = eClient.getElementsByTagName("nom");
				Element eNom = (Element)nNom.item(0);
				nom = eNom.getTextContent();

				NodeList nDni = eClient.getElementsByTagName("dni");
				Element eDni = (Element)nDni.item(0);
				dni = eDni.getTextContent();

				NodeList nAdreca = eClient.getElementsByTagName("adreca");
				Element eAdreca = (Element)nAdreca.item(0);
				adreca = eAdreca.getTextContent();

				NodeList nUsuari = eClient.getElementsByTagName("usuari");
				Element eUsuari = (Element)nUsuari.item(0);
				usuari = eUsuari.getTextContent();

				NodeList nPassword = eClient.getElementsByTagName("password");
				Element ePassword = (Element)nPassword.item(0);
				password = ePassword.getTextContent();

				// Creem el client
				daoXml.loadClient(id, nom, dni, adreca, usuari, password);
			}
		}
	}

	/**
	 * Obte informacio sobre les subscripcions
	 *
	 * @param doc fitxer XML del que obtenir les dades
	 */
	private void obtenirSubcripcions(Document doc) {
		NodeList subscripcions = doc.getElementsByTagName("subscripcio");
		String id, client, serie, temporada, episodi;
		int numSubscripcions = subscripcions.getLength();

		// Parsejo tots els elements subscripcio
		for(int i=0; i<numSubscripcions; i++) {
			Node subscripcio = subscripcions.item(i);

			if(subscripcio.getNodeType() == Node.ELEMENT_NODE){

				id = subscripcio.getAttributes().getNamedItem("id").getTextContent();
				client = subscripcio.getAttributes().getNamedItem("client").getTextContent();
				serie = subscripcio.getAttributes().getNamedItem("serie").getTextContent();
				temporada = subscripcio.getAttributes().getNamedItem("temporada").getTextContent();
				episodi = subscripcio.getAttributes().getNamedItem("episodi").getTextContent();

				daoXml.loadSubscripcio(id, client, serie, temporada, episodi);
			}
		}
	}

	/**
	 * Obte informacio sobre les visualitzacions dels episodis
	 *
	 * @param doc fitxer XML del que obtenir les dades
	 */
	private void obtenirVisualitzacions(Document doc) {
		NodeList visualitzacions = doc.getElementsByTagName("visualitzacio");
		String id, client, serie, temporada, episodi, data;
		int numVisualitacions = visualitzacions.getLength();

		// Parsejo tots els elements visualitzacio
		for(int i=0; i<numVisualitacions; i++) {
			Node visualitzacio = visualitzacions.item(i);

			if(visualitzacio.getNodeType() == Node.ELEMENT_NODE){

				id = visualitzacio.getAttributes().getNamedItem("id").getTextContent();
				client = visualitzacio.getAttributes().getNamedItem("client").getTextContent();
				serie = visualitzacio.getAttributes().getNamedItem("serie").getTextContent();
				temporada = visualitzacio.getAttributes().getNamedItem("temporada").getTextContent();
				episodi = visualitzacio.getAttributes().getNamedItem("episodi").getTextContent();
				data = visualitzacio.getAttributes().getNamedItem("data").getTextContent();

				daoXml.loadVisualització(id, client, serie, temporada, episodi, data);
			}
		}
	}
}
