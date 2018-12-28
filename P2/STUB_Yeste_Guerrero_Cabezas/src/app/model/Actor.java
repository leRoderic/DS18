package app.model;

public class Actor extends Staff {

    private String country;

    /**
     * Constructor of Actor's Class.
     *
     * @param name      actor's name
     * @param country   actor's country
     */
    public Actor(String name, String country) {
        super(name);
        this.country = country;
    }

    /**
     * Getter for Actor's country.
     *
     * @return actor's country
     */
    public String getCountry(){
        return this.country;
    }

    /**
     * Setter for Actor's country.
     *
     * @param c actor's country
     */
    public void setCountry(String c){
        this.country = c;
    }
}
