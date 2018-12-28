package app.model;

import javax.swing.DefaultListModel;
import java.util.ArrayList;

public class UpdateCatalogStrategy implements Strategy {

    /**
     * Creates a list of Series in the catalog.
     *
     * @param catalogList catalog
     * @return the list
     */
    @Override
    public DefaultListModel update(ArrayList catalogList) {
        DefaultListModel list = new DefaultListModel();
        for (int i = 0; i < catalogList.size(); i++) {
            Series series = (Series) catalogList.get(i);
            list.addElement(series.getTitle());
        }
        return list;
    }
}