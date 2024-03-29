
package src.GUI;

import src.com.mycompany.addressbook.MainHelperClass;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author ss
 */
public class ComapreAge extends javax.swing.JFrame {

    /**
     * Creates new form ComapreAge
     */
    public ComapreAge() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        oneName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        twoName = new javax.swing.JTextField();
        comapre = new javax.swing.JButton();
        result = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Person One Full Name");

        jLabel2.setText("Person Two Full Name");

        comapre.setText("Compare");
        comapre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comapreActionPerformed(evt);
            }
        });

        result.setText("Result ");

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(comapre)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(36, 36, 36))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(oneName, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(twoName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(result)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(oneName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(twoName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(result)
                .addGap(29, 29, 29)
                .addComponent(comapre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comapreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comapreActionPerformed


        try{
            String name1=oneName.getText().trim().toLowerCase();
        String name2=twoName.getText().trim().toLowerCase();
       
        
        if(name1.equals("")){
            printErrorDialog("Name1 cannot be empty");
            return;
        }else if(name2.equals("")){
            
            printErrorDialog("Name1 cannot be empty");
            return;
            
            
        }
        
        
       String resultx= MainHelperClass.compareAges(name1.toLowerCase(), name2.toLowerCase());
       
       if(resultx==null)
       {
          printErrorDialog("No Record Found"); 
       }else{
           
           result.setText(resultx);
           oneName.setText("");
           twoName.setText("");
           
       }
        
        

        }catch(Exception e){
            
            
             printErrorDialog("Error"+e.getMessage());  
            
            
        }
    }//GEN-LAST:event_comapreActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setDefaultCloseOperation(ComapreAge.DISPOSE_ON_CLOSE);  
        Home h=new Home();
        h.setVisible(true);
        this.close();
    }//GEN-LAST:event_backActionPerformed

 
    
    
    
    
     private void printErrorDialog(String message){
        
       JOptionPane.showMessageDialog(null, message,"ERROR", JOptionPane.ERROR_MESSAGE); 
      
        
    }
     
         public void close(){
 
 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
     }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton comapre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField oneName;
    private javax.swing.JLabel result;
    private javax.swing.JTextField twoName;
    // End of variables declaration//GEN-END:variables
}
