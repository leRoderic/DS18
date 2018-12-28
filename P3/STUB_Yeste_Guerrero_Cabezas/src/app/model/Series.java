package app.model;

import java.util.ArrayList;

public class Series {

    private String title;
    private String id;
    private String description;
    private int year;
    private String imagePath;
    private ArrayList<SeriesSeason> seasons;
    private Producer producer;
    private Director director;
    private ArrayList<Staff> people;

    /**
     * Series class contructor.
     *
     * @param title             series' title
     * @param description       series' description
     * @param id                series' id
     */
    public Series(String title, String description, String id){
        this.title = title;
        this.description = description;
        this.id = id;
        this.seasons = new ArrayList<>();
        this.people = new ArrayList<>();
    }

    /**
     * Adds Staff to Series.
     *
     * @param s staff to be added
     */
    public void addStaff(Staff s){
        if(!this.people.contains(s)){
            this.people.add(s);
        }
    }

    /**
     * Adds a Season to Series.
     *
     * @param s season to be added
     */
    public void addSeason(SeriesSeason s){
        if(!this.seasons.contains(s)) {
            this.seasons.add(s);
        }
    }

    /**
     * Getter for number of seasons in Series.
     *
     * @return number of seasons
     */
    public int getNumberOfSeasons(){
        return this.seasons.size();
    }

    /**
     * Finds a Season by it's number.
     *
     * @param nSeas season number
     * @return season
     */
    public SeriesSeason getSeason(int nSeas){
        for (SeriesSeason season : this.seasons) {
            if (season.getSeasonNumber() == nSeas) {
                return season;
            }
        }
        return null;
    }

    /**
     * Getter for series' producer.
     *
     * @return series' producer
     */
    public Producer getProducer(){
        return this.producer;
    }

    /**
     * Getter for series' director.
     *
     * @return series' director
     */
    public Director getDirector(){
        return this.director;
    }

    /**
     * Getter for Series's title.
     *
     * @return series's title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Getter for series' id.
     *
     * @return series' id
     */
    public String getID(){
        return this.id;
    }

    /**
     * Getter for series's description.
     *
     * @return series's description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Getter for series's year.
     *
     * @return series's year
     */
    public int getYear(){
        return this.year;
    }

    /**
     * Getter for series's picture.
     *
     * @return  series's picture path
     */
    public String getPicturePath(){
        return this.imagePath;
    }

    /**
     * Getter for season.
     *
     * @return season
     */
    public ArrayList<SeriesSeason> getSeason(){
        return this.seasons;
    }

    /**
     * Setter for series season
     *
     * @param newSeason new season
     */
    public void setSeason(ArrayList<SeriesSeason> newSeason){
        this.seasons = newSeason;
    }

    /**
     * Setter for Series' producer.
     *
     * @param p producer
     */
    public void setProducer(Producer p){
        this.producer = p;
    }

    /**
     * Setter for Series' director.
     *
     * @param d director
     */
    public void setDirector(Director d){
        this.director = d;
    }
}
