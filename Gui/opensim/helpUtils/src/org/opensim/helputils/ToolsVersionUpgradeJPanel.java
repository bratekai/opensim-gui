/* -------------------------------------------------------------------------- *
 * OpenSim: ToolsVersionUpgradeJPanel.java                                    *
 * -------------------------------------------------------------------------- *
 * OpenSim is a toolkit for musculoskeletal modeling and simulation,          *
 * developed as an open source project by a worldwide community. Development  *
 * and support is coordinated from Stanford University, with funding from the *
 * U.S. NIH and DARPA. See http://opensim.stanford.edu and the README file    *
 * for more information including specific grant numbers.                     *
 *                                                                            *
 * Copyright (c) 2005-2017 Stanford University and the Authors                *
 * Author(s): Ayman Habib                                                     *
 *                                                                            *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may    *
 * not use this file except in compliance with the License. You may obtain a  *
 * copy of the License at http://www.apache.org/licenses/LICENSE-2.0          *
 *                                                                            *
 * Unless required by applicable law or agreed to in writing, software        *
 * distributed under the License is distributed on an "AS IS" BASIS,          *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 * See the License for the specific language governing permissions and        *
 * limitations under the License.                                             *
 * -------------------------------------------------------------------------- */

/*
 * ToolsVersionUpgradeJPanel.java
 *
 * Created on July 21, 2007, 9:37 AM
 */

package org.opensim.helputils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.opensim.swingui.FileTextFieldAndChooser;
import org.opensim.utils.FileUtils;

/**
 *
 * @author  Ayman
 */
public class ToolsVersionUpgradeJPanel extends javax.swing.JPanel 
        implements ChangeListener{
    
    private String inputFileName="";
    private String outputFileName="";
    private boolean writeDefaults = false;

    private boolean markInDegrees=false;
    /**
     * Creates new form ToolsVersionUpgradeJPanel
     */
    public ToolsVersionUpgradeJPanel() {
        initComponents();
        oldVersionfileTextFieldAndChooser.setExtensionsAndDescription(".xml,.osim,.sto", "OpenSim model, setup or storage file");
        oldVersionfileTextFieldAndChooser.setCheckIfFileExists(true);
        oldVersionfileTextFieldAndChooser.setTreatEmptyStringAsValid(false);
        oldVersionfileTextFieldAndChooser.addChangeListener(this);
        oldVersionfileTextFieldAndChooser.setFileName("");
        newVersionfileTextFieldAndChooser.setExtensionsAndDescription(".xml,.osim,.sto", "Updated OpenSim file");
        newVersionfileTextFieldAndChooser.setSaveMode(true);
        newVersionfileTextFieldAndChooser.setTreatEmptyStringAsValid(false);
        newVersionfileTextFieldAndChooser.addChangeListener(this);
        newVersionfileTextFieldAndChooser.setFileName("");
        updateBasedOnExtension("");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jWriteDefaultsCheckBox = new javax.swing.JCheckBox();
        angleUnitsButtonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        newVersionfileTextFieldAndChooser = new org.opensim.swingui.FileTextFieldAndChooser();
        oldVersionfileTextFieldAndChooser = new org.opensim.swingui.FileTextFieldAndChooser();
        jLabel4 = new javax.swing.JLabel();
        jMarkFileInDegreesCheckBox = new javax.swing.JCheckBox();

        jWriteDefaultsCheckBox.setSelected(true);
        jWriteDefaultsCheckBox.setText("Write \"defaults\" section (if apprpriate)");
        jWriteDefaultsCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jWriteDefaultsCheckBox.setEnabled(false);
        jWriteDefaultsCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jWriteDefaultsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWriteDefaultsCheckBoxActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Convert a model, storage, or setup file to the latest version"));

        jLabel3.setText("New file");

        newVersionfileTextFieldAndChooser.setToolTipText("location of .jnt file");
        newVersionfileTextFieldAndChooser.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                newVersionfileTextFieldAndChooserStateChanged(evt);
            }
        });
        newVersionfileTextFieldAndChooser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                newVersionfileTextFieldAndChooserFocusLost(evt);
            }
        });

        oldVersionfileTextFieldAndChooser.setToolTipText("location of .jnt file");
        oldVersionfileTextFieldAndChooser.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                oldVersionfileTextFieldAndChooserStateChanged(evt);
            }
        });
        oldVersionfileTextFieldAndChooser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                oldVersionFocusLost(evt);
            }
        });

        jLabel4.setText("Old version file");

        jMarkFileInDegreesCheckBox.setText("Mark file as in degrees  (if storage)");
        jMarkFileInDegreesCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jMarkFileInDegreesCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jMarkFileInDegreesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMarkFileInDegreesCheckBoxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(218, 218, 218)
                        .add(jMarkFileInDegreesCheckBox))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(jLabel4))
                        .add(11, 11, 11)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(oldVersionfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .add(newVersionfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel4))
                    .add(oldVersionfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel3)
                    .add(newVersionfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(15, 15, 15)
                .add(jMarkFileInDegreesCheckBox)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newVersionfileTextFieldAndChooserStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_newVersionfileTextFieldAndChooserStateChanged
// TODO add your handling code here:
        outputFileName = newVersionfileTextFieldAndChooser.getFileName();        
    }//GEN-LAST:event_newVersionfileTextFieldAndChooserStateChanged

    private void jMarkFileInDegreesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMarkFileInDegreesCheckBoxActionPerformed
// TODO add your handling code here:
       setMarkInDegrees(jMarkFileInDegreesCheckBox.isSelected());
    }//GEN-LAST:event_jMarkFileInDegreesCheckBoxActionPerformed

    private void oldVersionfileTextFieldAndChooserStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_oldVersionfileTextFieldAndChooserStateChanged
// TODO add your handling code here:
        inputFileName = oldVersionfileTextFieldAndChooser.getFileName();
        updateBasedOnExtension(getExtension());
    }//GEN-LAST:event_oldVersionfileTextFieldAndChooserStateChanged

    private void jWriteDefaultsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWriteDefaultsCheckBoxActionPerformed
// TODO add your handling code here:
      JCheckBox defaultsCheckbox = (JCheckBox)evt.getSource();
      writeDefaults = defaultsCheckbox.isSelected();
    }//GEN-LAST:event_jWriteDefaultsCheckBoxActionPerformed

    private void newVersionfileTextFieldAndChooserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newVersionfileTextFieldAndChooserFocusLost
        // TODO add your handling code here:
       inputFileName = oldVersionfileTextFieldAndChooser.getFileName();
       outputFileName = newVersionfileTextFieldAndChooser.getFileName();   
    }//GEN-LAST:event_newVersionfileTextFieldAndChooserFocusLost

    private void oldVersionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldVersionFocusLost
       inputFileName = oldVersionfileTextFieldAndChooser.getFileName();
       outputFileName = newVersionfileTextFieldAndChooser.getFileName();   
        // TODO add your handling code here:
    }//GEN-LAST:event_oldVersionFocusLost
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup angleUnitsButtonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JCheckBox jMarkFileInDegreesCheckBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox jWriteDefaultsCheckBox;
    private org.opensim.swingui.FileTextFieldAndChooser newVersionfileTextFieldAndChooser;
    private org.opensim.swingui.FileTextFieldAndChooser oldVersionfileTextFieldAndChooser;
    // End of variables declaration//GEN-END:variables
    String getOldFilename()
    {
       String osimfile = oldVersionfileTextFieldAndChooser.getFileName();
        if (osimfile==null || osimfile.length()==0)
           return null;
       // Appennd ".osim if not there"
       boolean validFile = (osimfile.endsWith(".osim")||osimfile.endsWith(".xml")||osimfile.endsWith(".sto"));
       oldVersionfileTextFieldAndChooser.setFileIsValid(validFile);
       if (validFile) updateBasedOnExtension(getExtension());
        return osimfile;
    }

   public void stateChanged(ChangeEvent e) {
      // Listen to file name change
      Object obj = e.getSource();
      if (obj instanceof FileTextFieldAndChooser){
         if (obj.equals(oldVersionfileTextFieldAndChooser)){
            // If a non empty string is available in the jOpenSimFilenameTextField try to use it, otherwsie makeup one.
            String oldFilename= getOldFilename();
            if (oldFilename==null || !oldVersionfileTextFieldAndChooser.getFileIsValid()) return;
            inputFileName = oldFilename;
            // Here we have a real jnt file, make up a name for the .osim file if none specified
            outputFileName = oldFilename;
            // Here we know we have a valid name, show the name as default
            newVersionfileTextFieldAndChooser.setFileName(outputFileName);

            newVersionfileTextFieldAndChooser.setFileFilter(FileUtils.getFileFilter(getExtension(), "Output file"));
         }
      }
   }

   ActionListener getActionListener() {
      return new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            Object sourceButton= e.getSource();
            int x=0;
          }
         
      };
   }

    public String getInputFileName() {
        return inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public boolean isWriteDefaults() {
        return writeDefaults;
    }

    public boolean isMarkInDegrees() {
        return markInDegrees;
    }

    public void setMarkInDegrees(boolean markInDegrees) {
        this.markInDegrees = markInDegrees;
    }
    String getExtension()
    {
        String extension=".*";
        int lastDotLocation  = inputFileName.lastIndexOf(".");
        if (lastDotLocation!=-1)
            extension = inputFileName.substring(lastDotLocation);
        return extension;
    }

    private void updateBasedOnExtension(String extension) {
        jMarkFileInDegreesCheckBox.setEnabled(false);
        jWriteDefaultsCheckBox.setEnabled(false);
        if (extension.toLowerCase().equals(".sto")){
            jMarkFileInDegreesCheckBox.setEnabled(true);
        }
        else if(extension.toLowerCase().equals(".xml") || extension.toLowerCase().equals(".osim")){
            jWriteDefaultsCheckBox.setEnabled(true);            
        }
    }
}
