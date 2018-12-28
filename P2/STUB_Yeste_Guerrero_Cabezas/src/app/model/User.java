package app.model;
import java.util.ArrayList;

public class User {

    private String nick;
    private String name;
    private String password;
    private String country;
    private String birth;
    private String id;
    private ArrayList<Episode> subscribedList;
    private ArrayList<Episode> watchedEpisodes;
    private ArrayList<Episode> comingEpisodes;
    private ArrayList<Series> watchedSeriesList;
    private ArrayList<Series> nonStartedYetSeriesList;
    private ArrayList<Series> watchNextSeriesList;

    /**
     * User's class constructor.
     *
     * @param nick          user's nickname
     * @param name          user's name
     * @param password      user's password
     * @param country       user's country
     * @param birth         user's birth date
     * @param id            user's id
     */
    public User(String nick, String name, String password, String country, String birth, String id){
        this.nick = nick;
        this.name = name;
        this.password = password;
        this.country = country;
        this.birth = birth;
        this.id = id;
        this.subscribedList = new ArrayList<>();
        this.watchedEpisodes = new ArrayList<>();
        this.watchedSeriesList = new ArrayList<>();
        this.watchNextSeriesList = new ArrayList<>();
        this.nonStartedYetSeriesList = new ArrayList<>();
        this.comingEpisodes = new ArrayList<>();
    }

    /**
     * Adds an episode to User's subscribed list.
     *
     * @param e     episode to be added
     * @return  true: added successfully    false: error
     */
    public boolean addToSubscribedList(Episode e){
        if(!this.subscribedList.contains(e) && isWatched(e)){
            this.subscribedList.add(e);
            return true;
        } else
            return false;
    }

    /**
     * Getter for User's watched episodes.
     *
     * @return  user's watched episodes
     */
    public ArrayList<Episode> getWatchedEpisodes(){
        return this.watchedEpisodes;
    }

    /**
     * Checks if the User has watch a given episode.
     *
     * @param e     the episode
     * @return  true: watched   false: not watched
     */
    public boolean isWatched(Episode e){
        return this.watchedEpisodes.contains(e);
    }

    /**
     * Adds an episode to the User's watched list.
     *
     * @param e     the episode
     */
    public void addToWatchedList(Episode e){
        if(!isWatched(e))
            this.watchedEpisodes.add(e);
    }

    /**
     * Getter for User's ID.
     *
     * @return user's id
     */
    public String getId(){
        return this.id;
    }

    /**
     * Getter for User's nickname.
     *
     * @return user's nickname
     */
    public String getNick(){
        return this.nick;
    }

    /**
     * Getter for User's name.
     *
     * @return user's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter for User's password.
     *
     * @return user's password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Getter for User's country.
     *
     * @return user's country
     */
    public String getCountry(){
        return this.country;
    }

    /**
     * Getter for User's birth date.
     *
     * @return user's birth date
     */
    public String getBirth(){
        return this.birth;
    }

    /**
     * Getter for subscribed list.
     *
     * @return subscribed list
     */
    public ArrayList<Episode> getSubscribedList(){
        return this.subscribedList;
    }

    /**
     * Setter for User's name.
     *
     * @param newName       user's new name
     */
    public void setName(String newName){
        this.name = newName;
    }

    /**
     * Setter for User's password.
     *
     * @param newPassword   user's new password
     */
    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    /**
     * Adds Series to user's watched list.
     *
     * @param series    series to be added
     */
    public void addWatchedList(Series series) {
        if (!(watchedSeriesList.contains(series))) {
            watchedSeriesList.add(series);
        }
    }

    /**
     * Adds Series to user's not started yet list.
     *
     * @param series    series to be added
     */
    public void addToNonStartedYet(Series series) {
        if (!(nonStartedYetSeriesList.contains(series))) {
            nonStartedYetSeriesList.add(series);
        }
    }

    /**
     * Adds Series to user's watch next list.
     *
     * @param series    series to be added
     */
    public void addToWatchNext(Series series) {
        if (!(watchNextSeriesList.contains(series))) {
            watchNextSeriesList.add(series);
        }
    }

    /**
     * Getter for user's watched list.
     *
     * @return user's watched list
     */
    public ArrayList<Series> getWatchedSeriesList() {
        return watchedSeriesList;
    }

    /**
     * Getter for user's not started yet list.
     *
     * @return user's not started yet list
     */
    public ArrayList<Series> getNonStartedYetSeriesList() {
        return nonStartedYetSeriesList;
    }

    /**
     * Getter for user's watch next list.
     *
     * @return user's watch next list
     */
    public ArrayList<Series> getWatchNextSeriesList() {
        return watchNextSeriesList;
    }

    /**
     * Getter for user's upcoming episodes.
     *
     * @return user's upcoming episodes
     */
    public ArrayList<Episode> getComingEpisodes() {
        return comingEpisodes;
    }

    /**
     * Adds an upcoming episode to user.
     *
     * @param e     episode to be added
     */
    public void addComingEpisode(Episode e) {
        if (!(comingEpisodes.contains(e))) {
            comingEpisodes.add(e);
        }
    }
}

