package app.model;

public interface Staff {

    public String getName();
    public void setName(String newName);
    public void addActor(Actor actor);
    public void removeActor(Actor actor);
    public Actor getActor(int i);
}
