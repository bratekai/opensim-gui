/* -------------------------------------------------------------------------- *
 * OpenSim: ModelSaveSelectedAction.java                                      *
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
package org.opensim.view.nodes;

import java.util.ArrayList;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CallableSystemAction;
import org.opensim.modeling.Model;
import org.opensim.view.ExplorerTopComponent;
import org.opensim.view.FileSaveModelAction;

public final class ModelSaveSelectedAction extends CallableSystemAction {
   
    public void performAction() {
        Node[] selected = ExplorerTopComponent.findInstance().getExplorerManager().getSelectedNodes();
        // Action shouldn't be available otherwise'
        // Cycle thru selected models and cache referenes since closing a model changes selected nodes
        ArrayList<Model> modelsToSave = new ArrayList<Model>();
        for(int i=0; i<selected.length; i++){
            if (selected[i] instanceof OneModelNode){
                OneModelNode modelNode = (OneModelNode) selected[i];
                Model mdl = modelNode.getModel();
                modelsToSave.add(mdl);
            }
        }
        for(int i=0; i<modelsToSave.size(); i++){
            // Piggyback on common code in FileCloseAction
            FileSaveModelAction.saveOrSaveAsModel(modelsToSave.get(i), false);
        }
    }
   
   public String getName() {
      return NbBundle.getMessage(ModelSaveSelectedAction.class, "CTL_ModelSaveSelectedAction");
   }
   
   protected void initialize() {
      super.initialize();
      // see org.openide.util.actions.SystemAction.iconResource() javadoc for more details
      putValue("noIconInMenu", Boolean.TRUE);
   }
   
   public HelpCtx getHelpCtx() {
      return HelpCtx.DEFAULT_HELP;
   }
   
   protected boolean asynchronous() {
      return false;
   }
   
   public boolean isEnabled() {
      Node[] selected = ExplorerTopComponent.findInstance().getExplorerManager().getSelectedNodes();
      return selected.length>=1;
   }
}
