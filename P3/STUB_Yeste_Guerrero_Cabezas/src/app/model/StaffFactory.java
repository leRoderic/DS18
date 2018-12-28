package app.model;

public class StaffFactory {

    /**
     * StaffFactory constructor.
     *
     * @param name name
     * @param type type of Staff to be created
     * @param country country
     * @return instance of staff type
     */
    public Staff StaffFactory(String name, String type, String country) {
        if ("actor".equals(type)) {
            return new Actor(name, country);
        }
        else {
            return new Director(name, country);
        }
    }
}
