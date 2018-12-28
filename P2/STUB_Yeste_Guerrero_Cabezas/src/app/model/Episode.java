package app.model;

import java.util.ArrayList;

public class Episode {

    private String title;
    private String duration; // In minutes
    private String oLanguage;
    private String description;
    private String link;
    private String screenedDate;
    private String idSerie;
    private String numTemporada;
    private ArrayList<Rating> ratings;

    /**
     * Constructor of episode's class.
     *
     * @param title             episode's title
     * @param duration          episode's duration
     * @param oLanguage         episode's language
     * @param description       episode's description
     * @param screenedDate      episode's screened date
     * @param idSerie           episode's series' id
     * @param numTemporada      episode's season number
     */
    public Episode(String title, String duration, String oLanguage, String description, String screenedDate, String idSerie, String numTemporada){
        this.title = title;
        this.duration = duration;
        this.oLanguage = oLanguage;
        this.description = description;
        this.link = link;
        this.screenedDate = screenedDate;
        this.idSerie = idSerie;
        this.numTemporada = numTemporada;
        this.ratings = new ArrayList<>();
    }

    /**
     * Adds a Rating to the episode
     *
     * @param r the rating
     */
    public void addRating(Rating r){
        if(!this.ratings.contains(r)){
            this.ratings.add(r);
        }
    }

    /**
     * Checks the Episode's rating made by User.
     *
     * @param idUser the user,
     *
     * @return episode's ratings
     */

    public Rating findRating(String idUser){
        for (Rating rating : this.ratings) {
            if (rating.getUser().getId().equals(idUser)) {
                return rating;
            }
        }
        return null;
    }

    /**
     * Getter for Episode's title.
     *
     * @return episode's title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Getter for all the Episode's ratings.
     *
     * @return episode's ratings
     */
    public ArrayList<Rating> getRatings(){
        return this.ratings;
    }

    /**
     * Getter for episode's duration.
     *
     * @return episode's duration
     */
    public String getDuration(){
        return  this.duration;
    }

    /**
     * Getter for episode's original language.
     *
     * @return episode's original language
     */
    public String getoLanguage(){
        return this.oLanguage;
    }

    /**
     * Getter for episode's description.
     *
     * @return episode's description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Getter for episode's link.
     *
     * @return  link to episode
     */
    public String getLink(){
        return this.link;
    }

    /**
     * Getter for first screened date of episode.
     *
     * @return  episode's screened date
     */
    public String getScreenedDate(){
        return this.screenedDate;
    }

    /**
     * Getter for episode's series' id.
     *
     * @return  series' id
     */
    public String getIdSerie() {
        return idSerie;
    }

}
