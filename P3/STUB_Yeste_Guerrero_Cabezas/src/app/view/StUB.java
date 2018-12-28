package app.view;

import app.controller.Controller;
import app.model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;

public class StUB extends javax.swing.JFrame {

    private Controller controller;
    private User user;
    private LogInUser parent;
    private int selISeason;
    private String selICatalog;

    /**
     * Constructor of StUB.
     *
     * @param u
     * @param parent
     */
    public StUB(User u, LogInUser parent) {
        this.controller = Controller.getInstance();
        this.parent = parent;
        this.user = u;
        user.addObserver(controller);
        initComponents();
        getContentPane().setBackground(new Color(153, 204, 255));
        setVisible(true);
    }

    /**
     * Updates the catalog list.
     *
     * @param a list to be shown in the list
     */
    private void updateCatalogList(ArrayList<Series> a){
        if(a == null) {
            a = controller.getSeriesCatalog();
        }
        allList.setModel(new UpdateCatalogStrategy().update(a));
    }

    /**
     * Clears a given list.
     *
     * @param list the list to be cleared
     */
    private void clearList(JList list){
        list.setModel(new DefaultListModel());
    }

    /**
     * Updates the seasons list.
     *
     */
    private void updateSeasonList(){
        ArrayList<SeriesSeason> s = controller.title2Series(selICatalog).getSeason();
        allSeasons.setModel(new UpdateSeasonStrategy().update(s));
    }

    /**
     * Updates the episodes list.
     *
     */
    private void updateEpisodesList(){
        ArrayList<Episode> s = controller.title2Series(selICatalog).getSeason(selISeason).getSeasonEpisodes();
        allEpisodes.setModel(new UpdateEpisodeStrategy().update(s));
    }

    /**
     * Getter for User.
     *
     * @return the user
     */
    public User getUser(){
        return this.user;
    }

    /**
     * Logs out and allows user change.
     *
     * @param e event
     */
    private void mChangeuserActionPerformed(ActionEvent e) {
        this.parent.setVisible(true);
        this.dispose();
        JOptionPane.showMessageDialog(this,
                "Sesión cerrada correctamente.",
                "StUB",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Series from catalog list selected.
     *
     * @param e event
     */
    private void allListValueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting() && allList.getSelectedIndex() >= 0){
            selICatalog = allList.getSelectedValue();
            selISeason = 1;
            updateSeasonList();
            clearList(allEpisodes);
        }
    }

    /**
     * Episode from episodes list selected.
     *
     * @param e event
     */
    private void allEpisodesValueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting() && allSeasons.getSelectedIndex() >= 0 && allList.getSelectedIndex() >= 0){
            Episode ep = controller.title2Series(selICatalog).getSeason(selISeason).getSeasonEpisodes().get(allEpisodes.getSelectedIndex());
            ViewEpisode view = new ViewEpisode(this, ep, user);
        }
    }

    /**
     * Season from season list selected.
     *
     * @param e event
     */
    private void allSeasonsValueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting() && allSeasons.getSelectedIndex() >= 0 && allList.getSelectedIndex() >= 0){
            selISeason = java.lang.Math.max(allSeasons.getSelectedIndex() + 1, 1);
            updateEpisodesList();
        }
    }

    /**
     * Loads watch next list.
     *
     */
    private void loadWatchNext(){
        ArrayList<Series> tmp = user.getWatchNextSeriesList();
        if(tmp.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "La lista \"WatchNext\" está vacía.",
                    "StUB - Error",
                    JOptionPane.WARNING_MESSAGE);
        }else {
            clearList(allList);
            mAllCatalog.setBackground(Color.WHITE);
            mNotStarted.setBackground(Color.WHITE);
            mWatched.setBackground(Color.WHITE);
            mWatchNext.setBackground(Color.CYAN);
            DefaultListModel list = new DefaultListModel();
            for (int i = 0; i < tmp.size(); i++) {
                list.addElement(tmp.get(i).getTitle());
            }
            allList.setModel(list);
        }
    }

    /**
     * Loads watched list.
     *
     */
    private void loadWatched(){
        ArrayList<Series> tmp = user.getWatchedSeriesList();
        if(tmp.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "La lista \"Watched\" está vacía.",
                    "StUB - Error",
                    JOptionPane.WARNING_MESSAGE);
        }else {
            clearList(allList);
            mAllCatalog.setBackground(Color.WHITE);
            mNotStarted.setBackground(Color.WHITE);
            mWatched.setBackground(Color.CYAN);
            mWatchNext.setBackground(Color.WHITE);
            DefaultListModel list = new DefaultListModel();
            for (int i = 0; i < tmp.size(); i++) {
                list.addElement(tmp.get(i).getTitle());
            }
            allList.setModel(list);
        }
    }

    /**
     * Loads not started yet list.
     *
     */
    private void loadNotStartedYet(){
        ArrayList<Series> tmp = user.getNonStartedYetSeriesList();
        if(tmp.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "La lista \"NotStartedYet\" está vacía.",
                    "StUB - Error",
                    JOptionPane.WARNING_MESSAGE);
        }else {
            clearList(allList);
            mAllCatalog.setBackground(Color.WHITE);
            mNotStarted.setBackground(Color.CYAN);
            mWatched.setBackground(Color.WHITE);
            mWatchNext.setBackground(Color.WHITE);
            DefaultListModel list = new DefaultListModel();
            for (int i = 0; i < tmp.size(); i++) {
                list.addElement(tmp.get(i).getTitle());
            }
            allList.setModel(list);
        }
    }

    /**
     * Shows all Series in the catalog.
     *
     * @param e event
     */
    private void mAllCatalogActionPerformed(ActionEvent e) {
        mAllCatalog.setBackground(Color.CYAN);
        mNotStarted.setBackground(Color.WHITE);
        mWatched.setBackground(Color.WHITE);
        mWatchNext.setBackground(Color.WHITE);
        clearList(allEpisodes);
        updateCatalogList(controller.getSeriesCatalog());
    }

    /**
     * Shows series in watch next list.
     *
     * @param e event
     */
    private void mWatchNextActionPerformed(ActionEvent e) {
        clearList(allEpisodes);
        loadWatchNext();
    }

    /**
     * Shows series in watched list.
     *
     * @param e event
     */
    private void mWatchedActionPerformed(ActionEvent e) {
        clearList(allEpisodes);
        loadWatched();
    }

    /**
     * Shows series in not started yet list.
     *
     * @param e event
     */
    private void mNotStartedActionPerformed(ActionEvent e) {
        clearList(allEpisodes);
        loadNotStartedYet();
    }

    /**
     * Searches in the catalog.
     *
     * @param e event
     */
    private void btSearchActionPerformed(ActionEvent e) {
        if(controller.title2Series(txtSearch.getText()) != null){
            ArrayList<Series> tmp =  new ArrayList<>();
            tmp.add(controller.title2Series(txtSearch.getText()));
            updateCatalogList(tmp);
        }else{
            JOptionPane.showMessageDialog(this,
                    "No se ha encontrado ninguna serie por ese nombre. Vuelve a probar.",
                    "StUB - Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Exits StUB app.
     *
     * @param e event
     */
    private void mLogOutActionPerformed(ActionEvent e) {
        System.exit(0);
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - sasdfgty
    private void initComponents() {
        menuBar = new JMenuBar();
        mAllCatalog = new JButton();
        mWatchNext = new JButton();
        mWatched = new JButton();
        mNotStarted = new JButton();
        txtSearch = new JTextField();
        btSearch = new JButton();
        mAccOpt = new JMenu();
        this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        mLogOut = new JMenuItem();
        mChangeuser = new JMenuItem();
        scrollPaneSeries = new JScrollPane();
        allList = new JList<>();
        scrollPaneSeasons = new JScrollPane();
        allSeasons = new JList<>();
        scrollPaneEpisodes = new JScrollPane();
        allEpisodes = new JList<>();
        lblSeries = new JLabel();
        lblSeasons = new JLabel();
        lblEpisodes = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("StUB - P\u00e1gina principal");
        setBackground(new Color(255, 51, 51));
        setResizable(false);
        Container contentPane = getContentPane();

        //======== menuBar ========
        {
            menuBar.setFont(new Font("Dialog", Font.BOLD, 16));

            //---- mAllCatalog ----
            mAllCatalog.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 102, 255), new Color(51, 102, 255), null, null));
            mAllCatalog.setText("Catalogo");
            mAllCatalog.setFont(new Font("Dialog", Font.BOLD, 16));
            mAllCatalog.setBackground(Color.cyan);
            mAllCatalog.setToolTipText("Muestra el cat\u00e1logo.");
            mAllCatalog.addActionListener(e -> mAllCatalogActionPerformed(e));
            menuBar.add(mAllCatalog);

            //---- mWatchNext ----
            mWatchNext.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 102, 255), new Color(51, 102, 255), null, null));
            mWatchNext.setText("Watch Next");
            mWatchNext.setFont(new Font("Dialog", Font.BOLD, 16));
            mWatchNext.setBackground(Color.white);
            mWatchNext.setToolTipText("Muestra la lista WatchNext.");
            mWatchNext.addActionListener(e -> mWatchNextActionPerformed(e));
            menuBar.add(mWatchNext);

            //---- mWatched ----
            mWatched.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 102, 255), new Color(51, 102, 255), null, null));
            mWatched.setText("Watched");
            mWatched.setFont(new Font("Dialog", Font.BOLD, 16));
            mWatched.setBackground(Color.white);
            mWatched.setToolTipText("Muestra la lista Watched.");
            mWatched.addActionListener(e -> mWatchedActionPerformed(e));
            menuBar.add(mWatched);

            //---- mNotStarted ----
            mNotStarted.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 102, 255), new Color(51, 102, 255), null, null));
            mNotStarted.setText("Not Started");
            mNotStarted.setFont(new Font("Dialog", Font.BOLD, 16));
            mNotStarted.setBackground(Color.white);
            mNotStarted.setToolTipText("Muestra la lista NotStartedYet.");
            mNotStarted.addActionListener(e -> mNotStartedActionPerformed(e));
            menuBar.add(mNotStarted);

            //---- txtSearch ----
            txtSearch.setFont(new Font("Dialog", txtSearch.getFont().getStyle() | Font.BOLD, 16));
            menuBar.add(txtSearch);

            //---- btSearch ----
            btSearch.setText("Buscar");
            btSearch.setFont(new Font("Dialog", btSearch.getFont().getStyle() | Font.BOLD, 16));
            btSearch.setBackground(Color.white);
            btSearch.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED, new Color(51, 102, 255), new Color(51, 102, 255), null, null));
            btSearch.setToolTipText("Busca por el nombre de la serie.");
            btSearch.addActionListener(e -> btSearchActionPerformed(e));
            menuBar.add(btSearch);

            //======== mAccOpt ========
            {
                mAccOpt.setText("Cuenta");
                mAccOpt.setFont(new Font("Dialog", Font.BOLD, 16));
                mAccOpt.setHorizontalAlignment(SwingConstants.RIGHT);
                mAccOpt.setHorizontalTextPosition(SwingConstants.RIGHT);
                mAccOpt.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(51, 102, 255), new Color(51, 102, 255), null, null));
                mAccOpt.setBackground(Color.white);
                mAccOpt.setToolTipText("Opciones de usuario.");

                //---- mLogOut ----
                mLogOut.setText("Cerrar sesi\u00f3n");
                mLogOut.setFont(new Font("Dialog", mLogOut.getFont().getStyle() | Font.BOLD, 16));
                mLogOut.addActionListener(e -> mLogOutActionPerformed(e));
                mAccOpt.add(mLogOut);

                //---- mChangeuser ----
                mChangeuser.setText("Cambiar de usuario");
                mChangeuser.setFont(new Font("Dialog", mChangeuser.getFont().getStyle() | Font.BOLD, 16));
                mChangeuser.addActionListener(e -> mChangeuserActionPerformed(e));
                mAccOpt.add(mChangeuser);
            }
            menuBar.add(mAccOpt);
        }
        setJMenuBar(menuBar);

        //======== scrollPaneSeries ========
        {

            //---- allList ----
            allList.setBackground(new Color(51, 153, 255));
            allList.setFont(new Font("Dialog", allList.getFont().getStyle() | Font.BOLD, 16));
            allList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            allList.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "Error carga cat\u00e1logo"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            allList.addListSelectionListener(e -> allListValueChanged(e));
            updateCatalogList(null);
            scrollPaneSeries.setViewportView(allList);
        }

        //======== scrollPaneSeasons ========
        {

            //---- allSeasons ----
            allSeasons.setBackground(new Color(51, 153, 255));
            allSeasons.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "Selecciona una serie"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            allSeasons.setFont(new Font("Dialog", allSeasons.getFont().getStyle(), 16));
            allSeasons.addListSelectionListener(e -> allSeasonsValueChanged(e));
            scrollPaneSeasons.setViewportView(allSeasons);
        }

        //======== scrollPaneEpisodes ========
        {

            //---- allEpisodes ----
            allEpisodes.setBackground(new Color(51, 153, 255));
            allEpisodes.setFont(new Font("Dialog", allEpisodes.getFont().getStyle() | Font.BOLD, 16));
            allEpisodes.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "Selecciona un episodio"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            allEpisodes.addListSelectionListener(e -> allEpisodesValueChanged(e));
            scrollPaneEpisodes.setViewportView(allEpisodes);
        }

        //---- lblSeries ----
        lblSeries.setText("Series disponibles:");
        lblSeries.setFont(new Font("Dialog", lblSeries.getFont().getStyle() | Font.BOLD, 16));

        //---- lblSeasons ----
        lblSeasons.setText("Temporadas disponibles:");
        lblSeasons.setFont(new Font("Dialog", lblSeasons.getFont().getStyle() | Font.BOLD, 16));

        //---- lblEpisodes ----
        lblEpisodes.setText("Episodios diponibles:");
        lblEpisodes.setFont(new Font("Dialog", lblEpisodes.getFont().getStyle() | Font.BOLD, 16));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(lblSeries)
                        .addComponent(scrollPaneSeries, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPaneSeasons, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSeasons))
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPaneEpisodes, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEpisodes))
                    .addGap(33, 33, 33))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSeries)
                        .addComponent(lblEpisodes)
                        .addComponent(lblSeasons))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPaneSeries, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPaneSeasons, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPaneEpisodes, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(24, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - sasdfgty
    private JMenuBar menuBar;
    private JButton mAllCatalog;
    private JButton mWatchNext;
    private JButton mWatched;
    private JButton mNotStarted;
    private JTextField txtSearch;
    private JButton btSearch;
    private JMenu mAccOpt;
    private JMenuItem mLogOut;
    private JMenuItem mChangeuser;
    private JScrollPane scrollPaneSeries;
    private JList<String> allList;
    private JScrollPane scrollPaneSeasons;
    private JList<String> allSeasons;
    private JScrollPane scrollPaneEpisodes;
    private JList<String> allEpisodes;
    private JLabel lblSeries;
    private JLabel lblSeasons;
    private JLabel lblEpisodes;
    // End of variables declaration//GEN-END:variables
}
