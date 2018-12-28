package app.model;

import javax.swing.DefaultListModel;
import java.util.ArrayList;

public class UpdateEpisodeStrategy implements Strategy {

    /**
     * Creates a list of episodes.
     *
     * @param episodeList episodes
     * @return the list
     */
    @Override
    public DefaultListModel update(ArrayList episodeList) {
        DefaultListModel list = new DefaultListModel();
        for(int i = 0; i < episodeList.size(); i++){
            Episode episode = (Episode) episodeList.get(i);
            list.addElement(episode.getTitle());
        }
        return list;
    }
}
