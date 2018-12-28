package app.model;

public class Actor implements Staff {

    private String country;
    private String name;

    /**
     * Constructor of Actor's Class.
     *
     * @param name      actor's name
     * @param country   actor's country
     */
    public Actor(String name, String country) {
        this.name = name;
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

    /**
     * Getter for Actor's name.
     *
     * @return actor's name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for actor's name.
     *
     * @param newName actor's new name
     */
    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Adds an actor.
     *
     * @param actor actor
     */
    @Override
    public void addActor(Actor actor) {

    }

    /**
     * Removes an actor.
     *
     * @param actor actor
     */
    @Override
    public void removeActor(Actor actor) {

    }

    /**
     * Getter for Actor.
     *
     * @param i index
     * @return the actor
     */
    @Override
    public Actor getActor(int i) {
        return null;
    }
}
