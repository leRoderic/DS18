package app.model;

import java.util.ArrayList;

public class Catalog {

    private ArrayList<Series> series;

    /**
     * Catalog constructor.
     */
    public Catalog(){
        this.series = new ArrayList<>();
    }

    /**
     * Getter for series.
     *
     * @return season
     */
    public ArrayList<Series> getSeries(){
        return this.series;
    }

    /**
     * Getter for episode.
     *
     * @param t     episode's title
     * @param id    episode's series' id
     * @param n     episode's season number
     * @return  the episode
     */
    public Episode getEpisode(String t, String id, int n){
        return getSeries(id).getSeason(n).getEpisode(t);
    }

    /**
     * Setter for series.
     *
     * @param newSeries new series
     */
    public void setSeries(ArrayList<Series> newSeries){
        this.series= newSeries;
    }

    /**
     * Adds a Series to the catalog.
     *
     * @param serie a
     */
    public void addSerie(Series serie){
        if(!series.contains(serie)) {
            series.add(serie);
        }
    }

    /**
     * Checks if a given episode exists.
     *
     * @param t             episode's title
     * @param idSerie       episode's series' id
     * @param nSeason       episode's season number
     * @return  true: exists        false: doesn't exist
     */
    public boolean episodeExists(String t, String idSerie, int nSeason){
        ArrayList<Episode> s = getSeries(idSerie).getSeason(nSeason).getSeasonEpisodes();
        for (Episode episode : s) {
            if (episode.getTitle().equals(t))
                return true;
        }
        return false;
    }

    /**
     * Getter for Series.
     *
     * @param id    series' id
     * @return  series
     */
    public Series getSeries(String id){
        for (Series series1 : series) {
            if (series1.getID().equals(id)) {
                return series1;
            }
        }
        return null;
    }
}
