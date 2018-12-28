package app.model;

public class Director extends Staff {

    private String country;

    /**
     * Constructor of Director's Class.
     *
     * @param name actor's name
     * @param country actor's country
     */
    public Director(String name, String country) {
        super(name);
        this.country = country;
    }

    /**
     * Getter for Director's country.
     *
     * @return director's country
     */
    public String getCountry(){
        return this.country;
    }

    /**
     * Setter for Director's country.
     *
     * @param country   director's country
     */
    public void setCountry(String country) {
        this.country = country;
    }
}

