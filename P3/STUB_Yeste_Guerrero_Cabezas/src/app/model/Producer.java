package app.model;

public class Producer implements Staff {

    private String id;
    private int year;
    private String name;

    /**
     * Constructor of Producer Class.
     *
     * @param name      producer's name
     * @param id        producer's id
     * @param year      producer's year of foundation
     */
    public Producer(String name, String id, int year) {
        this.name = name;
        this.id = id;
        this.year = year;
    }

    /**
     * Getter for producer's ID.
     *
     * @return producer's id
     */
    public String getID(){
        return this.id;
    }

    /**
     * Setter for Producer's ID.
     *
     * @param i producer's id
     */
    public void setID(String i){
        this.id = i;
    }


    /**
     * Getter for producer's year.
     *
     * @return producer's year
     */
    public int getYear(){
        return this.year;
    }

    /**
     * Setter for producer's year.
     *
     * @param y producer's year
     */
    public void setYear(int y){
        this.year = y;
    }

    /**
     * Getter for producer's name.
     *
     * @return the producer's name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for producer's name.
     *
     * @param newName producer's new name
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
     * Getter for actor.
     *
     * @param i index
     * @return actor
     */
    @Override
    public Actor getActor(int i) {
        return null;
    }
}
