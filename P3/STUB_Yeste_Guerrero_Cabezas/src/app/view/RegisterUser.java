package app.view;

import app.controller.Controller;
import java.awt.*;
import java.util.UUID;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;

public class RegisterUser extends javax.swing.JFrame {

    private Controller controller;
    private LogInUser parent;

    /**
     * Creates new form RegisterUser
     */
    public RegisterUser(LogInUser fparent) {
        this.controller = Controller.getInstance();
        this.parent = fparent;
        initComponents();
        this.parent.setVisible(false);
        getContentPane().setBackground(new Color(153, 204, 255));
        setVisible(true);
    }

    /**
     * Clears input of text fields.
     *
     */
    private void clearInput(){
        txtCountry.setText("");
        txtName.setText("");
        txtNick.setText("");
        txtPassWord.setText("");
    }

    /**
     * Cancels the operation.
     *
     * @param evt cancel button clicked event
     */
    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        this.parent.setVisible(true);
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    /**
     * Creates a new User.
     *
     * @param evt accept button clicked event
     */
    private void btAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAcceptActionPerformed
        String birthD = selDay.getSelectedItem().toString() + " " + selMonth.getSelectedItem().toString() + " " + selYear.getSelectedItem().toString();
        String name = txtName.getText();
        String nick = txtNick.getText();
        String passWord = String.valueOf(txtPassWord.getPassword());
        String country = txtCountry.getText();
        if(birthD.isEmpty() || name.isEmpty() || nick.isEmpty() || passWord.isEmpty() || country.isEmpty() || controller.userExists(nick)){
            JOptionPane.showMessageDialog(this,
                    "Por favor, revisa todos los campos.",
                    "StUB - Error en el registro",
                    JOptionPane.WARNING_MESSAGE);
        }else{
            controller.addNewUser(UUID.randomUUID().toString(), name, "", country, nick, passWord);
            parent.setVisible(true);
            clearInput();
            dispose();
        }
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
        lblTitle = new JLabel();
        jScrollPane1 = new JScrollPane();
        txtNick = new JTextPane();
        lblNick = new JLabel();
        lblName = new JLabel();
        jScrollPane2 = new JScrollPane();
        txtName = new JTextPane();
        lblPassWord = new JLabel();
        txtPassWord = new JPasswordField();
        lblBirth = new JLabel();
        lblBDay = new JLabel();
        lblBMonth = new JLabel();
        lblBYear = new JLabel();
        lblCountry = new JLabel();
        jScrollPane6 = new JScrollPane();
        txtCountry = new JTextPane();
        btAccept = new JButton();
        btCancel = new JButton();
        selYear = new JComboBox<>();
        selDay = new JComboBox<>();
        selMonth = new JComboBox<>();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("StUB - Alta");
        Container contentPane = getContentPane();

        //---- lblTitle ----
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        lblTitle.setText("Registro usuario nuevo");

        //======== jScrollPane1 ========
        {

            //---- txtNick ----
            txtNick.setFont(new Font("Dialog", Font.PLAIN, 16));
            txtNick.setToolTipText("Nombre de usuario");
            jScrollPane1.setViewportView(txtNick);
        }

        //---- lblNick ----
        lblNick.setFont(new Font("Dialog", Font.BOLD, 16));
        lblNick.setText("Nick:");

        //---- lblName ----
        lblName.setFont(new Font("Dialog", Font.BOLD, 16));
        lblName.setText("Nombre:");
        lblName.setToolTipText("Nombre completo.");

        //======== jScrollPane2 ========
        {

            //---- txtName ----
            txtName.setFont(new Font("Dialog", Font.PLAIN, 16));
            txtName.setToolTipText("Nombre completo");
            jScrollPane2.setViewportView(txtName);
        }

        //---- lblPassWord ----
        lblPassWord.setFont(new Font("Dialog", Font.BOLD, 16));
        lblPassWord.setText("Contrase\u00f1a:");

        //---- txtPassWord ----
        txtPassWord.setFont(new Font("Dialog", Font.PLAIN, 16));
        txtPassWord.setToolTipText("No compartas tu contrase\u00f1a con nadie");

        //---- lblBirth ----
        lblBirth.setFont(new Font("Dialog", Font.BOLD, 16));
        lblBirth.setText("Fecha nacimiento:");

        //---- lblBDay ----
        lblBDay.setFont(new Font("Dialog", Font.PLAIN, 16));
        lblBDay.setText("D\u00eda:");

        //---- lblBMonth ----
        lblBMonth.setFont(new Font("Dialog", Font.PLAIN, 16));
        lblBMonth.setText("Mes:");

        //---- lblBYear ----
        lblBYear.setFont(new Font("Dialog", Font.PLAIN, 16));
        lblBYear.setText("A\u00f1o:");

        //---- lblCountry ----
        lblCountry.setFont(new Font("Dialog", Font.BOLD, 16));
        lblCountry.setText("Pa\u00eds:");

        //======== jScrollPane6 ========
        {

            //---- txtCountry ----
            txtCountry.setFont(new Font("Dialog", Font.PLAIN, 16));
            jScrollPane6.setViewportView(txtCountry);
        }

        //---- btAccept ----
        btAccept.setFont(new Font("Dialog", Font.BOLD, 16));
        btAccept.setText("Aceptar");
        btAccept.addActionListener(e -> {
			btAcceptActionPerformed(e);
		});

        //---- btCancel ----
        btCancel.setFont(new Font("Dialog", Font.BOLD, 16));
        btCancel.setText("Cancelar");
        btCancel.setBorder(new MatteBorder(1, 1, 1, 1, Color.red));
        btCancel.addActionListener(e -> btCancelActionPerformed(e));

        //---- selYear ----
        selYear.setModel(new DefaultComboBoxModel<>(new String[] {
            "1920",
            "1921",
            "1922",
            "1923",
            "1924",
            "1925",
            "1926",
            "1927",
            "1928",
            "1929",
            "1930",
            "1931",
            "1932",
            "1933",
            "1934",
            "1935",
            "1936",
            "1937",
            "1938",
            "1939",
            "1940",
            "1941",
            "1942",
            "1943",
            "1944",
            "1945",
            "1946",
            "1947",
            "1948",
            "1949",
            "1950",
            "1951",
            "1952",
            "1953",
            "1954",
            "1955",
            "1956",
            "1957",
            "1958",
            "1959",
            "1960",
            "1961",
            "1962",
            "1963",
            "1964",
            "1965",
            "1966",
            "1967",
            "1968",
            "1969",
            "1970",
            "1971",
            "1972",
            "1973",
            "1974",
            "1975",
            "1976",
            "1977",
            "1978",
            "1979",
            "1980",
            "1981",
            "1982",
            "1983",
            "1984",
            "1985",
            "1986",
            "1987",
            "1988",
            "1989",
            "1990",
            "1991",
            "1992",
            "1993",
            "1994",
            "1995",
            "1996",
            "1997",
            "1998",
            "1999",
            "2000",
            "2001",
            "2002",
            "2003",
            "2004",
            "2005",
            "2006",
            "2007",
            "2008",
            "2009",
            "2010",
            "2011",
            "2012",
            "2013",
            "2014",
            "2015",
            "2016",
            "2017",
            "2018"
        }));
        selYear.setFont(new Font("Dialog", selYear.getFont().getStyle(), 16));

        //---- selDay ----
        selDay.setModel(new DefaultComboBoxModel<>(new String[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31"
        }));
        selDay.setFont(new Font("Dialog", selDay.getFont().getStyle(), 16));

        //---- selMonth ----
        selMonth.setModel(new DefaultComboBoxModel<>(new String[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12"
        }));
        selMonth.setFont(new Font("Dialog", selMonth.getFont().getStyle(), 16));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(lblPassWord)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(lblNick)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblName)
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPassWord, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(27, 27, 27)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addComponent(lblBDay)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(selDay, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblBMonth)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(selMonth, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(lblBYear, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(selYear, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(lblBirth)
                                                .addComponent(lblCountry)
                                                .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(btAccept, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btCancel, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)))))
                            .addGap(0, 55, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(lblTitle)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNick)
                        .addComponent(lblBirth))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBDay)
                        .addComponent(selDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBMonth)
                        .addComponent(selMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBYear)
                        .addComponent(selYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblName)
                        .addComponent(lblCountry))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblPassWord)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPassWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btAccept, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btCancel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(61, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    //GEN-LAST:event_btAcceptActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - sasdfgty
    private JLabel lblTitle;
    private JScrollPane jScrollPane1;
    private JTextPane txtNick;
    private JLabel lblNick;
    private JLabel lblName;
    private JScrollPane jScrollPane2;
    private JTextPane txtName;
    private JLabel lblPassWord;
    private JPasswordField txtPassWord;
    private JLabel lblBirth;
    private JLabel lblBDay;
    private JLabel lblBMonth;
    private JLabel lblBYear;
    private JLabel lblCountry;
    private JScrollPane jScrollPane6;
    private JTextPane txtCountry;
    private JButton btAccept;
    private JButton btCancel;
    private JComboBox<String> selYear;
    private JComboBox<String> selDay;
    private JComboBox<String> selMonth;
    // End of variables declaration//GEN-END:variables
}