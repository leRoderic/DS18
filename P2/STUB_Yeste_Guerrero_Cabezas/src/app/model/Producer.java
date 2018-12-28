package app.model;

public class Producer extends Staff {

    private String id;
    private int year;

    /**
     * Constructor of Producer Class.
     *
     * @param name      producer's name
     * @param id        producer's id
     * @param year      producer's year of foundation
     */
    public Producer(String name, String id, int year) {
        super(name);
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
}
