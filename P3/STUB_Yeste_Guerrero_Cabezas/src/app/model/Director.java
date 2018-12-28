package app.model;

import java.util.ArrayList;

public class Director implements Staff {

    private String country;
    private String name;
    private ArrayList<Actor> actors;

    /**
     * Constructor of Director's Class.
     *
     * @param name actor's name
     * @param country actor's country
     */
    public Director(String name, String country) {
        this.name = name;
        this.country = country;
        this.actors  = new ArrayList();
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

    /**
     * Getter for director's name.
     *
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for director's name.
     *
     * @param newName
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
        this.actors.add(actor);
    }

    /**
     * Removes an actor.
     *
     * @param actor
     */
    @Override
    public void removeActor(Actor actor) {
        this.actors.remove(actor);
    }

    /**
     * Getter for actor.
     *
     * @param i index
     * @return actor
     */
    @Override
    public Actor getActor(int i) {
        return actors.get(i);
    }
}

