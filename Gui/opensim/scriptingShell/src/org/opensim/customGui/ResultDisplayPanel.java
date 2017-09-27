/* -------------------------------------------------------------------------- *
 * OpenSim: ResultDisplayPanel.java                                           *
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
 * ResultDisplayPanel.java
 *
 * Created on August 17, 2010, 2:53 PM
 */

package org.opensim.customGui;

/**
 *
 * @author  ayman
 */
public class ResultDisplayPanel extends javax.swing.JPanel {
    
    /** Creates new form ResultDisplayPanel */
    public ResultDisplayPanel() {
        initComponents();
    }

    public javax.swing.JLabel getResultLabel() {
        return resultLabel;
    }

    public void setResultLabel(javax.swing.JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

    public javax.swing.JTextField getResultTextField() {
        return resultTextField;
    }

    public void setResultTextField(javax.swing.JTextField resultTextField) {
        this.resultTextField = resultTextField;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        resultLabel = new javax.swing.JLabel();
        resultTextField = new javax.swing.JTextField();

        resultLabel.setText("jLabel1");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(resultLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(resultTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(resultLabel)
                .add(resultTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel resultLabel;
    private javax.swing.JTextField resultTextField;
    // End of variables declaration//GEN-END:variables
    
}
