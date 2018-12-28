package app.model;

import javax.swing.DefaultListModel;
import java.util.ArrayList;

public class UpdateSeasonStrategy implements Strategy {

    /**
     * Creates a list of Seasons.
     *
     * @param seasonList seasons
     * @return the list
     */
    @Override
    public DefaultListModel update(ArrayList seasonList) {
        DefaultListModel list = new DefaultListModel();
        for(int i = 0; i < seasonList.size(); i++){
            SeriesSeason season = (SeriesSeason) seasonList.get(i);
            list.addElement("Temporada " + season.getSeasonNumber());
        }
        return list;
    }
}
