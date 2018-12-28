package app.model;

public class SCharacter {

    public Actor actor;

    /**
     * Constructor for Series Character class-
     *
     * @param actor character's actor
     */
    public SCharacter(Actor actor){
        this.actor = actor;
    }

    /**
     * Getter for character actor.
     *
     * @return character's actor
     */
    public Actor getActor() {
        return actor;
    }

    /**
     * Setter for Series Character actor.
     *
     * @param act actor
     */
    public void setActor(Actor act){
        this.actor = act;
    }
}
