package org.opensim.logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.openide.ErrorManager;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
* Copyright (c)  2005-2008, Stanford University
 * Use of the OpenSim software in source form is permitted provided that the following
 * conditions are met:
 * 	1. The software is used only for non-commercial research and education. It may not
 *     be used in relation to any commercial activity.
 * 	2. The software is not distributed or redistributed.  Software distribution is allowed 
 *     only through https://simtk.org/home/opensim.
 * 	3. Use of the OpenSim software or derivatives must be acknowledged in all publications,
 *      presentations, or documents describing work in which OpenSim or derivatives are used.
 * 	4. Credits to developers may not be removed from executables
 *     created from modifications of the source.
 * 	5. Modifications of source code must retain the above copyright notice, this list of
 *     conditions and the following disclaimer. 
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 *  EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 *  SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 *  TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 *  HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 *  OR BUSINESS INTERRUPTION) OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 *  WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
final class LoggerTopComponent extends TopComponent {
   
   private static LoggerTopComponent instance;
   /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
   
   private static final String PREFERRED_ID = "LoggerTopComponent";
      
   private LoggerTopComponent() {
      initComponents();
      setName(NbBundle.getMessage(LoggerTopComponent.class, "CTL_LoggerTopComponent"));
      setToolTipText(NbBundle.getMessage(LoggerTopComponent.class, "HINT_LoggerTopComponent"));
//        setIcon(Utilities.loadImage(ICON_PATH, true));
      jPopupMenu1.removeAll();
      addPopupCommands();
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setComponentPopupMenu(jPopupMenu1);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jTextArea1.setTabSize(4);
        jScrollPane1.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized LoggerTopComponent getDefault() {
       if (instance == null) {
          instance = new LoggerTopComponent();
       }
       return instance;
    }
    
    /**
     * Obtain the LoggerTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized LoggerTopComponent findInstance() {
       TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
       if (win == null) {
          ErrorManager.getDefault().log(ErrorManager.WARNING, "Cannot find Logger component. It will not be located properly in the window system.");
          return getDefault();
       }
       if (win instanceof LoggerTopComponent) {
          return (LoggerTopComponent)win;
       }
       ErrorManager.getDefault().log(ErrorManager.WARNING, "There seem to be multiple components with the '" + PREFERRED_ID + "' ID. That is a potential source of errors and unexpected behavior.");
       return getDefault();
    }
    
    public int getPersistenceType() {
       return TopComponent.PERSISTENCE_ALWAYS;
    }
    
    public void componentOpened() {
       // TODO add custom code on component opening
    }
    
    public void componentClosed() {
       // TODO add custom code on component closing
    }
    
    /** replaces this in object stream */
    public Object writeReplace() {
       return new ResolvableHelper();
    }
    
    protected String preferredID() {
       return PREFERRED_ID;
    }
    
    final static class ResolvableHelper implements Serializable {
       private static final long serialVersionUID = 1L;
       public Object readResolve() {
          return LoggerTopComponent.getDefault();
       }
    }
    
    public void log(String str)
    {
      // While the user has the vertical scrollbar at the bottom, automatically scroll down as additional text is added
      // NOTE: not quite working yet...
      //JScrollBar vbar = jScrollPane1.getVerticalScrollBar();
      //boolean autoScroll = ((vbar.getValue() + vbar.getVisibleAmount()) == vbar.getMaximum());
      //System.out.println("val="+vbar.getValue()+" vis="+vbar.getVisibleAmount()+" max="+vbar.getMaximum()+" res="+autoScroll);
      jTextArea1.append(str);
      //if(autoScroll) jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    }

    private void addPopupCommands() {
        JMenuItem clearItem = jPopupMenu1.add("Clear");
        clearItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jTextArea1.setText("");
            }});
    }
}