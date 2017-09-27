/* -------------------------------------------------------------------------- *
 * OpenSim: SimmToOpenSimOptionsJPanel.java                                   *
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
 * SimmToOpenSimOptionsJPanel.java
 *
 * Created on July 21, 2007, 9:37 AM
 */

package org.opensim.simmsupport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.opensim.swingui.FileTextFieldAndChooser;

/**
 *
 * @author  Ayman
 */
public class SimmToOpenSimOptionsJPanel extends javax.swing.JPanel 
        implements ChangeListener{
    String[] DynamicsEngineNames = new String[]{    // internal names corresponding to names exposed in gui
        "SimmKinematicsEngine",
        "Simbody"
    };
    /** Creates new form SimmToOpenSimOptionsJPanel */
    public SimmToOpenSimOptionsJPanel() {
        initComponents();
        jntfileTextFieldAndChooser.setExtensionsAndDescription(".jnt", "SIMM joint file");
        jntfileTextFieldAndChooser.setCheckIfFileExists(true);
        jntfileTextFieldAndChooser.setTreatEmptyStringAsValid(false);
        jntfileTextFieldAndChooser.addChangeListener(this);
        
        mslfileTextFieldAndChooser.setExtensionsAndDescription(".msl", "SIMM muscle file");
        mslfileTextFieldAndChooser.setCheckIfFileExists(true);
        mslfileTextFieldAndChooser.setTreatEmptyStringAsValid(true);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        angleUnitsButtonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jntfileTextFieldAndChooser = new org.opensim.swingui.FileTextFieldAndChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mslfileTextFieldAndChooser = new org.opensim.swingui.FileTextFieldAndChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jOpenSimFilenameTextField = new javax.swing.JTextField();
        jMarkerSetFilenameTextField = new javax.swing.JTextField();
        jSeparateMarkerSetCheckBox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();

        jntfileTextFieldAndChooser.setToolTipText("location of .jnt file");

        jLabel1.setText("Joint file");

        jLabel2.setText("Muscle file");

        mslfileTextFieldAndChooser.setToolTipText("location of .msl file (optional and can be specified in jnt file header)");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("OpenSim Model Options"));
        jLabel3.setText("OpenSim file (.osim)");

        jOpenSimFilenameTextField.setToolTipText("Name of osim model file");

        jMarkerSetFilenameTextField.setToolTipText("Name of xml file to contain model markers");
        jMarkerSetFilenameTextField.setEnabled(false);

        jSeparateMarkerSetCheckBox.setText("Separate markers file (.xml)");
        jSeparateMarkerSetCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jSeparateMarkerSetCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jSeparateMarkerSetCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSeparateMarkerSetCheckBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("Files are generated in the same directory as the Joint file");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(66, 66, 66)
                                .add(jLabel3))
                            .add(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jSeparateMarkerSetCheckBox)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .add(jOpenSimFilenameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jMarkerSetFilenameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel5)
                .add(15, 15, 15)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jOpenSimFilenameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(15, 15, 15)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jMarkerSetFilenameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jSeparateMarkerSetCheckBox))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel2)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(mslfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .add(jntfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .add(17, 17, 17))
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jntfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .add(15, 15, 15)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(mslfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

   private void jSeparateMarkerSetCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSeparateMarkerSetCheckBoxActionPerformed
// TODO add your handling code here:
      JCheckBox markersCheckbox = (JCheckBox)evt.getSource();
      jMarkerSetFilenameTextField.setEnabled(markersCheckbox.isSelected());
   }//GEN-LAST:event_jSeparateMarkerSetCheckBoxActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup angleUnitsButtonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jMarkerSetFilenameTextField;
    private javax.swing.JTextField jOpenSimFilenameTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox jSeparateMarkerSetCheckBox;
    private org.opensim.swingui.FileTextFieldAndChooser jntfileTextFieldAndChooser;
    private org.opensim.swingui.FileTextFieldAndChooser mslfileTextFieldAndChooser;
    // End of variables declaration//GEN-END:variables
    String getJointFilename()
    {
        if (jntfileTextFieldAndChooser.getFileIsValid())
            return jntfileTextFieldAndChooser.getFileName();
        return null;
    }
    String getMslFilename()
    {
        if (mslfileTextFieldAndChooser.getFileIsValid())
            return mslfileTextFieldAndChooser.getFileName();
        return null;        
    }
    String getOsimFilename()
    {
       String osimfile = jOpenSimFilenameTextField.getText();
        if (osimfile==null || osimfile.length()==0)
           return null;
       // Appennd ".osim if not there"
       if (!osimfile.endsWith(".osim"))
          osimfile = osimfile+".osim";
        return osimfile;
    }
    
    boolean getUseSeparateMarkersFile()
    {
       return jSeparateMarkerSetCheckBox.isSelected();
    }
    String getMarkersFileName()
    {
       if (getUseSeparateMarkersFile())
          return jMarkerSetFilenameTextField.getText();
       return null;
    }


   public void stateChanged(ChangeEvent e) {
      // Listen to jnt file name change
      Object obj = e.getSource();
      if (obj instanceof FileTextFieldAndChooser){
         if (obj.equals(jntfileTextFieldAndChooser)){
            // If a non empty string is available in the jOpenSimFilenameTextField try to use it, otherwsie makeup one.
            String jntFilename= getJointFilename();
            if (jntFilename==null || !jntfileTextFieldAndChooser.getFileIsValid()) return;
            // Here we have a real jnt file, make up a name for the .osim file if none specified
            File f = new File(jntFilename);
            String candidateName = getUniqueOsimFilenameForJntFile(f);
            // Here we know we have a valid name, show the name as default
            jOpenSimFilenameTextField.setText(candidateName);
         }
      }
   }

   private String getUniqueOsimFilenameForJntFile(final File f) {
      File jntFileDir = f.getParentFile();
      
      String candidateName = "";
      int candidateNumber=0;
      while(true){
         String nameWithExtension = f.getName();
         
         candidateName=nameWithExtension.substring(0, nameWithExtension.lastIndexOf("."))+"_"+String.valueOf(candidateNumber)+".osim";
         File testExists = new File(jntFileDir+File.separator+candidateName);
         if (testExists.exists())
           candidateNumber++;
         else
            break;
      }
      return candidateName;
   }

   ActionListener getActionListener() {
      return new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            Object sourceButton= e.getSource();
            int x=0;
          }
         
      };
   }
   
}
