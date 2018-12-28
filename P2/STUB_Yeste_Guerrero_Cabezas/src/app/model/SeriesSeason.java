package app.model;

import java.util.ArrayList;

public class SeriesSeason {

    private Series series;
    private int seasonNumber;
    private int nEpisodes;
    private ArrayList<Episode> seasonEpisodes;

    /**
     * SeriesSeason contructor.
     *
     * @param series        series of the season
     * @param seasonNumber  season number
     * @param nEpisodes     number of episodes in the season
     */
    public SeriesSeason(Series series, int seasonNumber, int nEpisodes){
        this.series = series;
        this.seasonNumber = seasonNumber;
        this.seasonEpisodes = new ArrayList<>();
        this.nEpisodes = nEpisodes;
    }

    /**
     * Finds an episode by it's title.
     *
     * @param title episode's title
     * @return the episode
     */
    public Episode getEpisode(String title){
        for (Episode seasonEpisode : this.seasonEpisodes) {
            if (seasonEpisode.getTitle().equals(title)) {
                return seasonEpisode;
            }
        }
        return null;
    }

    /**
     * Adds an episode to Season.
     *
     * @param e the episode
     */
    public void addEpisode(Episode e){
        if(!this.seasonEpisodes.contains(e)){
            this.seasonEpisodes.add(e);
        }
    }

    /**
     * Getter for season number.
     *
     * @return  season's number
     */
    public int getSeasonNumber(){
        return this.seasonNumber;
    }

    /**
     * Getter for number of episodes.
     *
     * @return number of episodes
     */
    public int getnEpisodes(){
        return this.nEpisodes;
    }

    /**
     * Getter for season's episodes.
     *
     * @return season's episodes
     */
    public ArrayList<Episode> getSeasonEpisodes(){
        return this.seasonEpisodes;
    }

    /**
     * Setter for season's episodes
     *
     * @param newEpisodes new episodes
     */
    public void setSeasonEpisodes(ArrayList<Episode> newEpisodes){
        this.seasonEpisodes = newEpisodes;
    }
}
