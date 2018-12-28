package app.model;

import java.util.ArrayList;

public class FacadeUser {

    private User user;

    /**
     * Constructor for User's facade.
     *
     * @param user user
     */
    public FacadeUser(User user){
        this.user = user;
    }

    /**
     * Adds an observer.
     *
     * @param o the observer
     */
    public void addObserver(Observer o){
        user.removeObserver(o);
    }

    /**
     * Removes an observer.
     *
     * @param o the observer
     */
    public void removeObserver(Observer o){
        user.removeObserver(o);
    }

    /**
     * Notifies observers in observers list.
     *
     * @param serie serie
     * @param user user
     */
    public void notifyObservers(Series serie, User user){
        user.notifyObservers(serie,user);
    }

    /**
     * Adds an episode to User's subscribed list.
     *
     * @param e     episode to be added
     * @return  true: added successfully    false: error
     */
    public boolean addToSubscribedList(Episode e){
        return user.addToSubscribedList(e);
    }

    /**
     * Getter for User's watched episodes.
     *
     * @return  user's watched episodes
     */
    public ArrayList<Episode> getWatchedEpisodes(){
        return user.getWatchedEpisodes();
    }

    /**
     * Checks if the User has watch a given episode.
     *
     * @param e     the episode
     * @return  true: watched   false: not watched
     */
    public boolean isWatched(Episode e){
        return user.isWatched(e);
    }

    /**
     * Adds an episode to the User's watched list.
     *
     * @param e     the episode
     */
    public void addToWatchedList(Episode e){
        user.addToWatchedList(e);
    }

    /**
     * Removes series from the User's watch next list.
     *
     * @param s series
     */
    public void removeFromWatchNext(Series s){
        user.removeFromWatchNext(s);
    }

    /**
     * Getter for User's ID.
     *
     * @return user's id
     */
    public String getId(){
        return user.getId();
    }

    /**
     * Getter for User's nickname.
     *
     * @return user's nickname
     */
    public String getNick(){
        return user.getNick();
    }

    /**
     * Getter for User's name.
     *
     * @return user's name
     */
    public String getName(){
        return user.getName();
    }

    /**
     * Getter for User's password.
     *
     * @return user's password
     */
    public String getPassword() {
        return this.getPassword();
    }

    /**
     * Getter for User's country.
     *
     * @return user's country
     */
    public String getCountry(){
        return user.getCountry();
    }

    /**
     * Getter for User's birth date.
     *
     * @return user's birth date
     */
    public String getBirth(){
        return user.getBirth();
    }

    /**
     * Getter for subscribed list.
     *
     * @return subscribed list
     */
    public ArrayList<Episode> getSubscribedList(){
        return user.getSubscribedList();
    }

    /**
     * Setter for User's name.
     *
     * @param newName       user's new name
     */
    public void setName(String newName){
        user.setName(newName);
    }

    /**
     * Setter for User's password.
     *
     * @param newPassword   user's new password
     */
    public void setPassword(String newPassword){
        user.setPassword(newPassword);
    }

    /**
     * Adds Series to user's watched list.
     *
     * @param series    series to be added
     */
    public void addWatchedList(Series series) {
        user.addWatchedList(series);
    }

    /**
     * Adds Series to user's not started yet list.
     *
     * @param series    series to be added
     */
    public void addToNonStartedYet(Series series) {
        user.addToNonStartedYet(series);
    }

    /**
     * Adds Series to user's watch next list.
     *
     * @param series    series to be added
     */
    public void addToWatchNext(Series series){
        user.addToWatchNext(series);
    }

    /**
     * Getter for user's watched list.
     *
     * @return user's watched list
     */
    public ArrayList<Series> getWatchedSeriesList() {
        return user.getWatchedSeriesList();
    }

    /**
     * Getter for user's not started yet list.
     *
     * @return user's not started yet list
     */
    public ArrayList<Series> getNonStartedYetSeriesList() {
        return user.getNonStartedYetSeriesList();
    }

    /**
     * Getter for user's watch next list.
     *
     * @return user's watch next list
     */
    public ArrayList<Series> getWatchNextSeriesList() {
        return user.getWatchNextSeriesList();
    }

    /**
     * Getter for user's upcoming episodes.
     *
     * @return user's upcoming episodes
     */
    public ArrayList<Episode> getComingEpisodes() {
        return user.getComingEpisodes();
    }

    /**
     * Adds an upcoming episode to user.
     *
     * @param e     episode to be added
     */
    public void addComingEpisode(Episode e) {
        user.addComingEpisode(e);
    }

    /**
     * Checks if all episodes in Series have been watched.
     *
     * @param s series
     * @return true: all watched    false: pending episodes
     */
    public boolean isSeriesFinished(Series s) {
        return user.isSeriesFinished(s);
    }
}
