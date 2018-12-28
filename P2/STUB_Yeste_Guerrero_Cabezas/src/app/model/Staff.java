package app.model;

public abstract class Staff {

    private String name;

    /**
     * Constructor of Staff Class.
     *
     * @param name  staff's name
     */
    public Staff(String name){
        this.name = name;
    }

    /**
     * Getter for Staff's name.
     *
     * @return staff's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Setter for Staff's name.
     *
     * @param newName staff's new name
     */
    public void setName(String newName){
        this.name = newName;
    }
}
