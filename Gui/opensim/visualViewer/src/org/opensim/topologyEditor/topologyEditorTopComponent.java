/* -------------------------------------------------------------------------- *
 * OpenSim: topologyEditorTopComponent.java                                   *
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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opensim.topologyEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import javax.swing.JScrollPane;
import org.openide.util.LookupEvent;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.action.EditProvider;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.graph.layout.GraphLayout;
import org.netbeans.api.visual.graph.layout.GraphLayoutFactory;
import org.netbeans.api.visual.graph.layout.GraphLayoutSupport;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.layout.SceneLayout;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.Widget;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import org.openide.util.LookupListener;
import org.opensim.modeling.Body;
import org.opensim.modeling.JointSet;
import org.opensim.modeling.Joint;
import org.opensim.modeling.Model;
import org.opensim.modeling.OpenSimObject;
import org.opensim.view.ModelEvent;
import org.opensim.view.ObjectSetCurrentEvent;
import org.opensim.view.ObjectsChangedEvent;
import org.opensim.view.pub.OpenSimDB;
import org.opensim.view.pub.ViewDB;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//org.opensim.graphlEditor//topologyEditorTopComponent//EN",
autostore = false)
@TopComponent.Description(preferredID = "topologyEditorTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "osimRightMode", openAtStartup = false)
@ActionID(category = "Window", id = "org.opensim.graphlEditor.topologyEditorTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_visualTopComponentAction",
preferredID = "topologyEditorTopComponent")
public final class topologyEditorTopComponent extends TopComponent implements Observer, LookupListener{
    ModelGraphScene scene;
    GraphLayout<String,String> graphLayout = GraphLayoutFactory.createTreeGraphLayout (50, 50, 25, 20, true);
    Model currentModel;
    Lookup.Result<OpenSimObject> r;
    ArrayList<String> selectedObjects = new ArrayList<String>();
    
    public topologyEditorTopComponent() {
        initComponents();
        setLayout(new BorderLayout());
        setName(NbBundle.getMessage(topologyEditorTopComponent.class, "CTL_visualTopComponentTopComponent"));
        setToolTipText(NbBundle.getMessage(topologyEditorTopComponent.class, "HINT_visualTopComponentTopComponent"));
        scene = new ModelGraphScene();
        JScrollPane sPane = new JScrollPane(scene.createView());
        String toolTip = "<html>Tree nodes with borders are bodies <br><br>";
        toolTip = toolTip.concat(". You can drag nodes around <br>. Double click background for default layout<br>");
        toolTip = toolTip.concat(". Double-click a body node to select<br></html>");
        scene.setToolTipText(toolTip);
        add(sPane, BorderLayout.CENTER); 
        OpenSimDB.getInstance().addObserver(this);
        r = ViewDB.getLookup().lookupResult(OpenSimObject.class);
        r.addLookupListener (this);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setToolTipText(org.openide.util.NbBundle.getMessage(topologyEditorTopComponent.class, "topologyEditorTopComponent.toolTipText")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
        scene.clearAll();
        populateDefault();
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    private void populateDefault() {
        currentModel = OpenSimDB.getInstance().getCurrentModel();
        if (currentModel == null) return;
        scene.addNode("ground");
        GraphLayoutSupport.setTreeGraphLayoutRootNode (graphLayout, "ground");
        final SceneLayout sceneGraphLayout = LayoutFactory.createSceneGraphLayout (scene, graphLayout);
        WidgetAction editAction = ActionFactory.createEditAction (new MyEditProvider (sceneGraphLayout));
        scene.getActions().addAction (editAction);
        JointSet jnts = currentModel.getJointSet();
        int numJoints = jnts.getSize();
        for (int j=0; j<numJoints; j++ ){
            Joint jnt = jnts.get(j);
            String childFrameName = jnt.getChildFrame().findBaseFrame().getName();
            String parentFrameName = jnt.getParentFrame().findBaseFrame().getName();
            //LabelWidget bodyWidget= new LabelWidget(scene, "Body:"+bod.getName());
            Widget bodyWidget = scene.addNode(childFrameName);
            //bodyWidget.setPreferredLocation (new Point (b*30, b*50));
            bodyWidget.getActions().addAction (editAction);
            Widget jntWidget = scene.addNode(jnt.getName());
            jntWidget.setBorder(ModelGraphScene.getBORDER_0());
            //String edgeID = bod.getJoint().getName();
            String jntToParent = parentFrameName+ "_"+jnt.getName();
            scene.addEdge(jntToParent);
            scene.setEdgeSource (jntToParent, parentFrameName);
            scene.setEdgeTarget (jntToParent, jnt.getName());
            String jntToChild = childFrameName+ "_"+jnt.getName();
            scene.addEdge(jntToChild);
            scene.setEdgeSource (jntToChild, jnt.getName());
            scene.setEdgeTarget (jntToChild, childFrameName);
    }
        scene.validate();
        
        
        //add(scene.createSatelliteView(), BorderLayout.EAST); 
        sceneGraphLayout.invokeLayoutImmediately ();
        scene.validate();
        scene.getActions ().addAction (ActionFactory.createEditAction (new EditProvider() {
            public void edit (Widget widget) {
                // new implementation
                sceneGraphLayout.invokeLayoutImmediately ();
                // old implementation
//                new TreeGraphLayout<String, String> (TreeGraphLayoutTest.this, 100, 100, 50, 50, true).layout ("root");
            }
        }));

    }

    @Override
    public void update(Observable o, Object o1) {
        if (o1 instanceof ObjectsChangedEvent) // if no structural change, do nothing
            return;
        if (o1 instanceof ObjectSetCurrentEvent){
            ObjectSetCurrentEvent evt = (ObjectSetCurrentEvent)o1;
            Vector<OpenSimObject> objs = evt.getObjects();
            // If any of the event objects is a model not equal to the current one, this means there is a new
            // current model. So update the panel.
            for (int i=0; i<objs.size(); i++) {
               if (objs.get(i) instanceof Model) {
                  if (currentModel == null || !currentModel.equals(objs.get(i))) {
                     scene.clearAll();
                     populateDefault();
                     break;
                  }
               }
            }
        }
        else if (o1 instanceof ModelEvent){
            if (((ModelEvent)o1).getOperation()==ModelEvent.Operation.Close ||
                    (((ModelEvent)o1).getOperation()==ModelEvent.Operation.Open)){
                scene.clearAll();
                populateDefault();
                return;
            }
        }
    }

    @Override
    public void resultChanged(LookupEvent ev) {
        Collection<? extends OpenSimObject> allSelected = r.allInstances();
        for (String previouslySelected: selectedObjects){
            Widget widget = scene.findWidget(previouslySelected);
            if (widget != null){
                widget.setBackground (Color.WHITE);
                widget.setForeground (Color.BLACK);
            }               
        }
        if (!allSelected.isEmpty()) {
            for (OpenSimObject sel:allSelected){
                Widget widget = scene.findWidget(sel.getName());
                if (widget != null){
                    widget.setBackground (Color.WHITE);
                    widget.setForeground (Color.RED);
                    selectedObjects.add(sel.getName());
                    repaint();
                }
            }
        }
        
    }

   private static class MyEditProvider implements EditProvider {
       SceneLayout sceneGraphLayout;
       MyEditProvider(SceneLayout sceneGraphLayout){
           this.sceneGraphLayout = sceneGraphLayout;
       }
       /*
        public void edit(Widget widget) {
            if (widget != null) {
                //widget.setBackground (Color.WHITE);
                //widget.setForeground (Color.BLACK);
                LabelWidget selected = ((LabelWidget)widget);
                Body b = OpenSimDB.getInstance().getCurrentModel().getBodySet().get(selected.getLabel());
                ViewDB.getInstance().removeObjectFromSelectedList(b);
            }
        }
        */
        public void edit(Widget widget) {
            if (widget != null) {
                //widget.setBackground (new Color (52, 124, 150));
                //widget.setForeground (Color.RED);
                if (widget instanceof LabelWidget){
                    LabelWidget selected = ((LabelWidget)widget);
                    Body b = OpenSimDB.getInstance().getCurrentModel().getBodySet().get(selected.getLabel());
                    ViewDB.getInstance().replaceSelectedObject(b);
                }
                else
                    sceneGraphLayout.invokeLayoutImmediately ();
            }
        }

    }
       
    public static synchronized topologyEditorTopComponent getDefault() {
       if (instance == null) {
          instance = new topologyEditorTopComponent();
       }
       return instance;
    }
    private static topologyEditorTopComponent instance;

}
