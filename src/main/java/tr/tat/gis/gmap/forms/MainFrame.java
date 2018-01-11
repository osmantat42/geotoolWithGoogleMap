/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.tat.gis.gmap.forms;

import java.awt.RenderingHints;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.geotools.map.MapContent;
import org.geotools.referencing.CRS;
import org.geotools.renderer.GTRenderer;
import org.geotools.renderer.lite.StreamingRenderer;
import org.geotools.tile.util.TileLayer;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import tr.tat.gis.gmap.google.GoogleService;

/**
 *
 * @author otat
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
       initMap();
    }
    
    private void initMap(){
        try {
            MapContent mapContent=new MapContent(CRS.decode("EPSG:3857",true));
            ReferencedEnvelope ref=new ReferencedEnvelope(3072396.120328562,5239415.39800297,3176673.821231725,5240053.448136033, mapContent.getCoordinateReferenceSystem());
            mapContent.getViewport().setBounds(ref);
            this.jMapPane1.setMapContent(mapContent);
           
            
        } catch (FactoryException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGMap = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        radioStandartNoMap = new javax.swing.JRadioButton();
        radioStandartGMap = new javax.swing.JRadioButton();
        radioHypridGMap = new javax.swing.JRadioButton();
        jMapPane1 = new org.geotools.swing.JMapPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Geotools with Google Map");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setRollover(true);

        btnGroupGMap.add(radioStandartNoMap);
        radioStandartNoMap.setSelected(true);
        radioStandartNoMap.setText("No Map");
        radioStandartNoMap.setFocusable(false);
        radioStandartNoMap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        radioStandartNoMap.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        radioStandartNoMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapChangeAction(evt);
            }
        });
        jToolBar1.add(radioStandartNoMap);

        btnGroupGMap.add(radioStandartGMap);
        radioStandartGMap.setText("GMap Standart");
        radioStandartGMap.setFocusable(false);
        radioStandartGMap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        radioStandartGMap.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        radioStandartGMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapChangeAction(evt);
            }
        });
        jToolBar1.add(radioStandartGMap);

        btnGroupGMap.add(radioHypridGMap);
        radioHypridGMap.setText("GMap Hyprid");
        radioHypridGMap.setFocusable(false);
        radioHypridGMap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        radioHypridGMap.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        radioHypridGMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapChangeAction(evt);
            }
        });
        jToolBar1.add(radioHypridGMap);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jMapPane1Layout = new javax.swing.GroupLayout(jMapPane1);
        jMapPane1.setLayout(jMapPane1Layout);
        jMapPane1Layout.setHorizontalGroup(
            jMapPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );
        jMapPane1Layout.setVerticalGroup(
            jMapPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        getContentPane().add(jMapPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        System.out.println("shown1");
        System.out.println("shown");

    }//GEN-LAST:event_formWindowOpened

    private void mapChangeAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapChangeAction
        if (this.jMapPane1.getMapContent().layers().size() > 0) {
            this.jMapPane1.getMapContent().layers().remove(0);
        }
        if (evt.getSource().equals(this.radioStandartGMap)) {
            String gMapStandartURL = "https://mt2.google.com/vt/lyrs=m&hl=en&x={x}&y={y}&z={z}&s=Ga";
            GoogleService service = new GoogleService("gMapStandart", gMapStandartURL);
            TileLayer gTileLayer = new TileLayer(service);
            this.jMapPane1.getMapContent().addLayer(gTileLayer);

        }else if(evt.getSource().equals(this.radioHypridGMap)){
            String gMapHyridURL = "https://mt2.google.com/vt/lyrs=y&hl=en&x={x}&y={y}&z={z}&s=Ga";
            GoogleService service = new GoogleService("gMapStandart", gMapHyridURL);
            TileLayer gTileLayer = new TileLayer(service);
            this.jMapPane1.getMapContent().addLayer(gTileLayer);
        }
    }//GEN-LAST:event_mapChangeAction

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupGMap;
    private org.geotools.swing.JMapPane jMapPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JRadioButton radioHypridGMap;
    private javax.swing.JRadioButton radioStandartGMap;
    private javax.swing.JRadioButton radioStandartNoMap;
    // End of variables declaration//GEN-END:variables
}
