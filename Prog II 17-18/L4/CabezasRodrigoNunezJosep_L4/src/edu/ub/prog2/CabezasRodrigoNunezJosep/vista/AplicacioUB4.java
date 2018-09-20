package edu.ub.prog2.CabezasRodrigoNunezJosep.vista;

import edu.ub.prog2.CabezasRodrigoNunezJosep.controlador.Controlador;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public final class AplicacioUB4 extends javax.swing.JFrame {
    
    private final Controlador controlador;
    private final FrmGestioReproductor repro;
    private final FrmAfegirFitxerMultimedia fitxer;
    private final FrmNouAlbum album;
    private final JFileChooser cercador;
    
    public AplicacioUB4() {
        initComponents();
        this.controlador=new Controlador();
        this.repro=new FrmGestioReproductor(this,controlador);
        this.fitxer=new FrmAfegirFitxerMultimedia(this,controlador);
        this.album=new FrmNouAlbum(this,controlador);
        this.cercador = new javax.swing.JFileChooser();
        cercador.setCurrentDirectory(new File(System.getProperty("user.home")));
        cercador.setApproveButtonText("Seleccionar");
        cercador.setApproveButtonToolTipText("Selecciona l'actual");
        cercador.setDialogTitle("Selecciona...");
        listAlbum.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listCarpeta.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ompleBiblio();
        opcionsComboBox();        
        setVisible(true);
    }
    
    protected void ompleBiblio(){
        DefaultListModel model = new DefaultListModel();
        model.clear();
        List<String> llista=controlador.mostrarCamins();
        for(int i=0;i<llista.size();i++){
            model.addElement(llista.get(i));
        }
        listCarpeta.setModel(model);
        ompleAlbum();
        if(listCarpeta.getModel().getSize() == 0){
            this.btnEliminar.setEnabled(false);
            this.btnReproFitxer.setEnabled(false);
            this.btnReproBiblio.setEnabled(false);
        }else{
            this.btnEliminar.setEnabled(true);
            this.btnReproFitxer.setEnabled(true);
            this.btnReproBiblio.setEnabled(true);
        }
    }
    
    protected void ompleAlbum(){
        try {
            if(!(selecAlbum.getSelectedItem().toString().equals("No hi ha cap àlbum"))){                
                DefaultListModel model = new DefaultListModel();
                model.clear();
                List<String> llista=controlador.mostrarCaminsAlbum(selecAlbum.getSelectedItem().toString().substring(4));
                for(int i=0;i<llista.size();i++){
                    model.addElement(llista.get(i));
                }
                listAlbum.setModel(model);            
            }
            if(listAlbum.getModel().getSize() != 0){
                this.btnReproAlbum.setEnabled(true);
                this.btnEliminarAlbum.setEnabled(true);
            }else{
                this.btnReproAlbum.setEnabled(false);
                this.btnEliminarAlbum.setEnabled(false);
            }
        } catch (Exception ex) {            
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());    
        }
    }
    
    protected void opcionsComboBox(){
        List<String> llista=controlador.mostrarLlistatAlbums();
        String[] items = new String[llista.size()];
        for(int i=0;i<llista.size();i++){
            items[i]=llista.get(i);
        }
        DefaultComboBoxModel opcions = new DefaultComboBoxModel(items);
        selecAlbum.setModel(opcions);
        if(selecAlbum.getSelectedItem().toString().equals("No hi ha cap àlbum")){
            this.btnNoAlbum.setEnabled(false);
            this.btnAfegirAlbum.setEnabled(false);
        }
        else{
            this.btnNoAlbum.setEnabled(true);
            this.btnAfegirAlbum.setEnabled(true);
        }
        ompleAlbum();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCarpeta = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAlbum = new javax.swing.JList<>();
        selecAlbum = new javax.swing.JComboBox<>();
        btnNewAlbum = new javax.swing.JButton();
        btnNoAlbum = new javax.swing.JButton();
        btnReproAlbum = new javax.swing.JButton();
        btnAfegir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnReproBiblio = new javax.swing.JButton();
        btnReproFitxer = new javax.swing.JButton();
        btnAfegirAlbum = new javax.swing.JButton();
        txtBiblio = new javax.swing.JLabel();
        btnEliminarAlbum = new javax.swing.JButton();
        btnReproGestor = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        gestioDades = new javax.swing.JMenu();
        btnCarregar = new javax.swing.JMenuItem();
        btnGuardar = new javax.swing.JMenuItem();
        gestioHelp = new javax.swing.JMenu();
        btnInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca de fitxers multimèdia");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.orange);

        listCarpeta.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(listCarpeta);

        listAlbum.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(listAlbum);

        selecAlbum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        selecAlbum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No hi ha cap àlbum" }));
        selecAlbum.setToolTipText("Selecciona un àlbum...");
        selecAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecAlbumActionPerformed(evt);
            }
        });

        btnNewAlbum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnNewAlbum.setText("Crear àlbum");
        btnNewAlbum.setToolTipText("Crea un nou àlbum");
        btnNewAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAlbumActionPerformed(evt);
            }
        });

        btnNoAlbum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnNoAlbum.setText("Eliminar àlbum");
        btnNoAlbum.setToolTipText("Elimina l'àlbum seleccionat");
        btnNoAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoAlbumActionPerformed(evt);
            }
        });

        btnReproAlbum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnReproAlbum.setText("Reproduir àlbum");
        btnReproAlbum.setToolTipText("Reprodueix l'àlbum seleccionat");
        btnReproAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproAlbumActionPerformed(evt);
            }
        });

        btnAfegir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAfegir.setText("Afegir fitxer");
        btnAfegir.setToolTipText("Afegeix un nou fitxer a la biblioteca");
        btnAfegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar fitxer");
        btnEliminar.setToolTipText("Elimina un dels fitxers de la biblioteca");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnReproBiblio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnReproBiblio.setText("Reproduir biblioteca");
        btnReproBiblio.setToolTipText("Reprodueix la biblioteca de fitxers sencera");
        btnReproBiblio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproBiblioActionPerformed(evt);
            }
        });

        btnReproFitxer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnReproFitxer.setText("Reproduir fitxer");
        btnReproFitxer.setToolTipText("Reprodueix un únic fitxer");
        btnReproFitxer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproFitxerActionPerformed(evt);
            }
        });

        btnAfegirAlbum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAfegirAlbum.setText("Afegir fitxer a l'àlbum");
        btnAfegirAlbum.setToolTipText("Afegeix un fitxer a l'àlbum seleccionat");
        btnAfegirAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirAlbumActionPerformed(evt);
            }
        });

        txtBiblio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBiblio.setText("Biblioteca:");

        btnEliminarAlbum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEliminarAlbum.setText("Eliminar fitxer de l'àlbum");
        btnEliminarAlbum.setToolTipText("Elimina un dels fitxers de l'àlbum seleccionat");
        btnEliminarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlbumActionPerformed(evt);
            }
        });

        btnReproGestor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnReproGestor.setText("Reproducció en curs");
        btnReproGestor.setToolTipText("Gestiona la reproducció en curs");
        btnReproGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproGestorActionPerformed(evt);
            }
        });

        gestioDades.setText("Dades");
        gestioDades.setToolTipText("Gestió de les dades a disc");
        gestioDades.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        btnCarregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        btnCarregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCarregar.setText("Carregar");
        btnCarregar.setToolTipText("Carrega dades del disc");
        btnCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarActionPerformed(evt);
            }
        });
        gestioDades.add(btnCarregar);

        btnGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guarda dades al disc");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        gestioDades.add(btnGuardar);

        jMenuBar1.add(gestioDades);

        gestioHelp.setText("Ajuda");
        gestioHelp.setToolTipText("Informació sobre l'aplicació");
        gestioHelp.setActionCommand("Sobre");
        gestioHelp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        btnInfo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnInfo.setText("Informació");
        btnInfo.setActionCommand("btInfo");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        gestioHelp.add(btnInfo);

        jMenuBar1.add(gestioHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAfegir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAfegirAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReproBiblio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReproFitxer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBiblio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNoAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarAlbum)
                            .addComponent(btnReproAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReproGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(selecAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBiblio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewAlbum)
                        .addGap(18, 18, 18)
                        .addComponent(btnNoAlbum)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarAlbum)
                        .addGap(18, 18, 18)
                        .addComponent(btnReproAlbum)
                        .addGap(18, 18, 18)
                        .addComponent(btnReproGestor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAfegir)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAfegirAlbum)
                        .addGap(18, 18, 18)
                        .addComponent(btnReproBiblio)
                        .addGap(18, 18, 18)
                        .addComponent(btnReproFitxer))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReproAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproAlbumActionPerformed
        try {
            if(!(selecAlbum.getSelectedItem().toString().equals("No hi ha cap àlbum"))){
                controlador.reproduirCarpeta(selecAlbum.getSelectedItem().toString().substring(4));            
            }
        } catch (AplicacioException ex) {            
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());    
        }
    }//GEN-LAST:event_btnReproAlbumActionPerformed

    private void btnEliminarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlbumActionPerformed
        if (listAlbum.getSelectedIndex()>=0){
            int[] asd = listAlbum.getSelectedIndices();
            for(int i : asd){
                controlador.esborrarFitxer(selecAlbum.getSelectedItem().toString().substring(4),i);
                ompleBiblio();
                ompleAlbum();
                /*
                Cada vegada que elimina un fitxer, s'avançen tots una posició
                endavant, per tant cal decremenetar els seguënts índexs seleccionats
                per tal de que s'eliminin correctament.
                */
                for(int s = 0; s < asd.length; s++){
                    asd[s] = asd[s] - 1;
                }
            }
            if (asd.length>1)
                JOptionPane.showMessageDialog(null, String.valueOf(asd.length) +  " fitxers eliminats correctament de l'àlbum.", "Operació completada", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, String.valueOf(asd.length) +  " fitxer eliminat correctament de l'àlbum.", "Operació completada", JOptionPane.INFORMATION_MESSAGE);
        }else
            JOptionPane.showMessageDialog(rootPane, "No s'ha seleccionat cap fitxer.");
    }//GEN-LAST:event_btnEliminarAlbumActionPerformed

    private void btnReproGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproGestorActionPerformed
        repro.pack();
        repro.setVisible(true);
    }//GEN-LAST:event_btnReproGestorActionPerformed

    private void btnAfegirAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegirAlbumActionPerformed
        if ((listCarpeta.getSelectedIndex()<0)&&(selecAlbum.getSelectedItem().toString().equals("No hi ha cap àlbum"))){
            JOptionPane.showMessageDialog(rootPane, "No s'ha seleccionat cap fitxer i no hi cap àlbum on afegir-ne.");
        }else if(listCarpeta.getSelectedIndex()<0){
            JOptionPane.showMessageDialog(rootPane, "No s'ha seleccionat cap fitxer.");
        }else if(selecAlbum.getSelectedItem().toString().equals("No hi ha cap àlbum")){
            JOptionPane.showMessageDialog(rootPane, "No hi cap àlbum on afegir fitxers.");
        }else{
            int i = 0;
            /*
            Permet afegir més d'un fitxer alhora a un àlbum.
            */
            int[] asd = listCarpeta.getSelectedIndices();
            while(i < listCarpeta.getSelectedIndices().length){
                try {
                    controlador.afegirFitxer(selecAlbum.getSelectedItem().toString().substring(4),asd[i]);
                } catch (AplicacioException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
                i++;
                ompleAlbum();    
            }
        }       
    }//GEN-LAST:event_btnAfegirAlbumActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (listCarpeta.getSelectedIndex()>=0){
            int[] asd = listCarpeta.getSelectedIndices();
            for(int i : asd){
                controlador.esborrarFitxer(i);
                ompleBiblio();
                ompleAlbum();
                /*
                Cada vegada que elimina un fitxer, s'avançen tots una posició
                endavant, per tant cal decremenetar els seguënts índexs seleccionats
                per tal de que s'eliminin correctament.
                */
                for(int s = 0; s < asd.length; s++){
                    asd[s] = asd[s] - 1;
                }
            }
            if (asd.length>1)
                JOptionPane.showMessageDialog(null, String.valueOf(asd.length) +  " fitxers eliminats correctament de la biblioteca.", "Operació completada", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, String.valueOf(asd.length) +  " fitxer eliminat correctament de la biblioteca.", "Operació completada", JOptionPane.INFORMATION_MESSAGE);
        }else
            JOptionPane.showMessageDialog(rootPane, "No s'ha seleccionat cap fitxer.");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnReproBiblioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproBiblioActionPerformed
        try {
            controlador.reproduirCarpeta();
        } catch (AplicacioException ex) {            
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());    
        }
    }//GEN-LAST:event_btnReproBiblioActionPerformed

    private void btnReproFitxerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproFitxerActionPerformed
        try {
            if (listCarpeta.getSelectedIndex()>=0){
                int[] asd = listCarpeta.getSelectedIndices();
                controlador.reproduirFitxers(asd);
            }else
                JOptionPane.showMessageDialog(rootPane, "No s'ha seleccionat cap fitxer.");
        } catch (AplicacioException ex) {            
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());    
        }
    }//GEN-LAST:event_btnReproFitxerActionPerformed

    private void btnNoAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoAlbumActionPerformed
        if(selecAlbum.getSelectedItem().toString().equals("No hi ha cap àlbum")){
            JOptionPane.showMessageDialog(rootPane, "No hi ha cap àlbum a eliminar.");            
        }else{
            controlador.esborrarAlbum(selecAlbum.getSelectedItem().toString().substring(4));
            opcionsComboBox();
        }
    }//GEN-LAST:event_btnNoAlbumActionPerformed

    private void selecAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecAlbumActionPerformed
        ompleAlbum();
    }//GEN-LAST:event_selecAlbumActionPerformed

    private void btnAfegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegirActionPerformed
        fitxer.pack();
        fitxer.setVisible(true);
    }//GEN-LAST:event_btnAfegirActionPerformed

    private void btnNewAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAlbumActionPerformed
        album.pack();
        album.setVisible(true);
    }//GEN-LAST:event_btnNewAlbumActionPerformed

    private void btnCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarActionPerformed
        cercador.setSelectedFile(new File(""));
        cercador.setFileSelectionMode(JFileChooser.FILES_ONLY);        
        cercador.setCurrentDirectory(new File(System.getProperty("user.home")));
        cercador.showOpenDialog(this);
        try {
            this.controlador.carregarDadesDisc(cercador.getSelectedFile().getAbsolutePath());
            ompleBiblio();
            opcionsComboBox();
            ompleAlbum();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_btnCarregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        cercador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);                
        cercador.setSelectedFile(new File(""));        
        cercador.setCurrentDirectory(new File(System.getProperty("user.home")));
        cercador.showOpenDialog(this);
        try {
            this.controlador.guardarDadesDisc(cercador.getSelectedFile().getAbsolutePath());
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        JOptionPane.showMessageDialog(null, "Versió:    1.0 [08/06/2018] \nFet per:\n               Josep Núñez Riba\n               Rodrigo Cabezas Quirós", "Informació del reproductor", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnInfoActionPerformed

    public JFileChooser getCercador(){
        return this.cercador;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfegir;
    private javax.swing.JButton btnAfegirAlbum;
    private javax.swing.JMenuItem btnCarregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarAlbum;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JMenuItem btnInfo;
    private javax.swing.JButton btnNewAlbum;
    private javax.swing.JButton btnNoAlbum;
    private javax.swing.JButton btnReproAlbum;
    private javax.swing.JButton btnReproBiblio;
    private javax.swing.JButton btnReproFitxer;
    private javax.swing.JButton btnReproGestor;
    private javax.swing.JMenu gestioDades;
    private javax.swing.JMenu gestioHelp;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listAlbum;
    private javax.swing.JList<String> listCarpeta;
    private javax.swing.JComboBox<String> selecAlbum;
    private javax.swing.JLabel txtBiblio;
    // End of variables declaration//GEN-END:variables
}