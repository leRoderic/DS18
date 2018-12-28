package app.controller;

import app.model.*;
import app.resources.DAO_XML_STUB;
import java.util.ArrayList;

public class Controller implements Observer{

    private static Controller controller = new Controller();
    private Catalog catalog;
    private ArrayList<User> users;

    /**
     * Contructor of Controller.
     *
     */
    private Controller(){
        DAO_XML_STUB data = new DAO_XML_STUB("src/app/resources/StUB.xml");
        this.catalog = data.getCatalog();
        this.users = data.getUsers();
    }

    /**
     * Getter for controller's instance.
     *
     * @return controller's instace
     */
    public static Controller getInstance(){
        return controller;
    }

    /**
     * Adds a new user to the system.
     *
     * @param id        user's id
     * @param nom       user's name
     * @param dni       user's DNI
     * @param adreca    user's adress
     * @param usuari    user's user
     * @param password  user's password
     */
    public void addNewUser(String id, String nom, String dni, String adreca, String usuari, String password){
        User user = new User(usuari, nom, password, adreca, "Not provided", id);
        if(!this.users.contains(user)) {
            this.users.add(user);
        }
    }

    /**
     * Adds a new episode to the system.
     *
     * @param title         episode's title
     * @param duration      episode's duration
     * @param idioma        episode's language
     * @param description   episode's description
     * @param data          episode's screened date
     * @param idSerie       episode's Series' id
     * @param numTemporada  episode's season number
     */
    public void addNewEpisode(String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada) {
        Episode epi = new Episode(title, duration, idioma, description, data, idSerie, numTemporada);
        this.catalog.getSeries(idSerie).getSeason(Integer.parseInt(numTemporada)).addEpisode(epi);
    }

    /**
     * Checks if an episode's exists in the system.
     *
     * @param t         episode's title
     * @param idSerie   episode's Series' id
     * @param nSeason   episode's season number
     * @return  true: exists    false: doesn't exist
     */
    public boolean episodeExists(String t, String idSerie, int nSeason){
        return catalog.episodeExists(t, idSerie, nSeason);
    }

    /**
     * Getter for system's catalog.
     *
     * @return the catalog
     */
    public Catalog getCatalog(){
        return this.catalog;
    }

    /**
     * Checks if a user exists.
     *
     * @param nick      user's nick
     * @return  true: exists    false: doesn't exist
     */
    public boolean userExists(String nick){
        for (User user : this.users)
            if (new FacadeUser(user).getNick().equals(nick)) {
                return true;
            }
        return false;
    }

    /**
     * Login of a User.
     *
     * @param nick          user's nick
     * @param password      user's password
     * @return  true: login succesful   false: login failed
     */
    public boolean loginSuccesful(String nick, String password){
        User tmp;
        for (User user : this.users) {
            if (new FacadeUser(user).getNick().equals(nick)) {
                tmp = user;
                return tmp.getPassword().equals(password);
            }
        }
        return false;
    }

    /**
     * Getter for User's array.
     *
     * @return  user's array
     */
    public ArrayList<User> getUsers(){
        return this.users;
    }

    /**
     * Returns a user given it's nickname.
     *
     * @param nick  user's nickname
     * @return  the user
     */
    public User getUserInst(String nick){

        for (User user : this.users) {
            if (new FacadeUser(user).getNick().equals(nick)){
                return user;
            }
        }
        return null;
    }

    /**
     * Getter for catalog.
     *
     * @return the catalog
     */
    public ArrayList<Series> getSeriesCatalog(){
        return this.catalog.getSeries();
    }

    /**
     * Getter for Series.
     *
     * @param id    series' id
     * @return      series
     */
    public Series getSeries(String id){
        return this.catalog.getSeries(id);
    }

    /**
     * Getter for Series given its title.
     *
     * @param title series' title
     * @return series
     */
    public Series title2Series(String title){
        return this.catalog.title2Series(title);
    }

    /**
     * Subscribe a User to a given episode.
     *
     * @param tEpisode      episode's title
     * @param idSerie       episode's series' id
     * @param nSeason       episode's season number
     * @param name          user's name
     * @return  true: subscribed    false: subscription failed
     */
    public boolean subscribeToEpisode(String tEpisode, String idSerie, int nSeason, String name){
        Episode tmp = getEpisode(tEpisode, idSerie, nSeason);
        return this.getUser(name).addToSubscribedList(tmp);
    }

    /**
     * Getter for user.
     *
     * @param id    user's id
     * @return  the user
     */
    public User getUser(String id){
        for (User user : this.users) {
            if (new FacadeUser(user).getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Getter for episode.
     *
     * @param tEpisode      episode's title
     * @param idSerie       episode's series id
     * @param nSeason       episode's season number
     * @return  the episode
     */
    public Episode getEpisode(String tEpisode, String idSerie, int nSeason){
        return this.catalog.getEpisode(tEpisode, idSerie, nSeason);
    }

    /**
     * Plays an episode.
     *
     * @param title     episode's title
     * @param id        episode's series' id
     * @param nSeason   episode's season number
     * @param idUser    user's id
     */
    public void viewEpisode(String title, String id, String nSeason, String idUser){
        User tmp = getUser(idUser);
        Episode e = getEpisode(title, id, Integer.parseInt(nSeason));
        tmp.addToWatchedList(e);
        tmp.addToWatchNext(catalog.getSeries(e.getIdSerie()));
    }

    /**
     * Rates an episode
     *
     * @param id                user's id
     * @param idSerie           episode's series' id
     * @param numTemporada      episode's season number
     * @param episodi           episode's title
     * @param puntuacio         point
     */
    public void rateEpisode(String id, String idSerie, String numTemporada, String episodi, String puntuacio) {
        User tmp = this.getUser(id);
        Rating rating = new Rating(Integer.parseInt(puntuacio), "Not provided", null, tmp);
        Episode e = this.catalog.getEpisode(episodi, idSerie, Integer.parseInt(numTemporada));
        if(tmp.isWatched(e)) {
            e.addRating(rating);
        }
    }

    /**
     * Checks if a user has his WatchedList empty.
     *
     * @param id        user's id
     * @return  true: empty     false: not empty
     */
    public String hasEmptyWatchedList(String id){
        User tmp = getUser(id);
        if (tmp.getWatchedSeriesList().isEmpty()){
            return "Watched List Vacía";
        }else{
            return"Watched List con series completas";
        }

    }

    /**
     * Adds Series to user's WatchedList.
     *
     * @param id            user's id
     * @param idSerie       series' id
     */
    public void addWatchedList(String id, String idSerie){
        User tmp = getUser(id);
        Series serieToAdd = this.getSeries(idSerie);
        tmp.addWatchedList(serieToAdd);
    }

    /**
     * Checks if a user has his Not Started Yet list empty.
     *
     * @param id        user's id
     * @return          string with the status
     */
    public String hasNonStartedYet(String id){
        User tmp = getUser(id);
        if (tmp.getNonStartedYetSeriesList().isEmpty()){
            return"No existen series acabadas";
        }else{
            return "Non Started Yet vacía";
        }
    }

    /**
     * Adds Series to user's Not Started Yet list.
     *
     * @param id            user's id
     * @param idSerie       series' id
     */
    public void addNonStartedYet(String id, String idSerie){
        User tmp = getUser(id);
        Series serieToAdd = this.getSeries(idSerie);
        tmp.addToNonStartedYet(serieToAdd);
    }

    /**
     * Checks if a user has his Watch Next list empty.
     *
     * @param id            user's id
     * @return              string with the list status
     */
    public String hasEmptyWatchNext(String id) {
        User tmp = getUser(id);
        if (tmp.getWatchNextSeriesList().isEmpty()){
            return"Tiene series incompletas";
        }else{
            return "No tiene ninguna serie a medias";
        }
    }

    /**
     * Adds Series to user's Watch Next list.
     *
     * @param id            user's id
     * @param idSerie       series' id
     */
    public void addWatchNextList(String id, String idSerie){
        User tmp = getUser(id);
        Series serieToAdd = this.getSeries(idSerie);
        tmp.addToWatchNext(serieToAdd);
    }

    /**
     * Adds upcoming episodes if the user is watching an specific Series.
     *
     * @param id            user's id
     * @param tEpisode      episode's title
     * @param idSerie1      series' id from user
     * @param nSeason       episode's season number
     * @param idSerie2      series' id from the episode to be added
     */
    public void addComingEpisode(String id, String tEpisode, String idSerie1, int nSeason, String idSerie2) {
        User tmp = getUser(id);
        Episode comingEpisode = getEpisode(tEpisode, idSerie1, nSeason);
        if(comingEpisode.getIdSerie().equals(idSerie2)){
            tmp.addComingEpisode(comingEpisode);
        }
    }

    /**
     * Checks if there's an upcoming episode.
     *
     * @param id    user's id
     * @return      string with the result
     */
    public String hasComingEpisode(String id) {
        User tmp = getUser(id);
        if (tmp.getComingEpisodes().isEmpty()){
            return "No saldrán episodios próximamente";
        }else{
            return"Tendrá episodios disponibles próximamente";
        }
    }

    /**
     * Getter for specific user's WatchedList.
     *
     * @param userID        user's id
     * @return              user's watched list
     */
    public ArrayList<Series> viewWatchedList(String userID){
        User tmp  = getUser(userID);
        return tmp.getWatchedSeriesList();
    }

    /**
     * Getter for specific user's WatchNext list.
     *
     * @param userID        user's id
     * @return              user's watch next list
     */
    public ArrayList<Series> viewWatchNext(String userID){
        User tmp  = getUser(userID);
        return tmp.getWatchNextSeriesList();
    }

    /**
     * Getter for specific user's NotStartedYet list.
     *
     * @param userID        user's id
     * @return              user's not started yet list
     */
    public ArrayList<Series> viewNotStartedYet(String userID){
        User tmp  = getUser(userID);
        return tmp.getNonStartedYetSeriesList();
    }

    /**
     * Update method from Observer interface.
     *
     * @param s series
     * @param u user
     */
    @Override
    public void update(Series s, User u) {
        u.removeFromWatchNext(s);
        u.addWatchedList(s);
    }
}
