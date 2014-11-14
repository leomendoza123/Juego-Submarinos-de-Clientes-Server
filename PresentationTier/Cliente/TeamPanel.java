/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationTier.Cliente;

import LogicTier.InGame.Players.Player;
import LogicTier.InGame.Players.Team;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 *
 * @author Leo
 */
public class TeamPanel extends javax.swing.JPanel {

    Team newTeam; 
    ArrayList<Team> playerTeam; 
    Player currentPlayer; 
    
    /**
     * Creates new form Team
     */
    public TeamPanel() {
        initComponents();
        Combo_TeamList.removeAllItems();
        combo_myTeam.removeAllItems();
        combo_request.removeAllItems();
        
    }
    
    

    public JComboBox getCombo_TeamList() {
        return Combo_TeamList;
    }

    public void setCombo_TeamList(JComboBox Combo_TeamList) {
        this.Combo_TeamList = Combo_TeamList;
    }

    public JComboBox getCombo_myTeam() {
        return combo_myTeam;
    }

    public void setCombo_myTeam(JComboBox combo_myTeam) {
        this.combo_myTeam = combo_myTeam;
    }

    public JComboBox getCombo_request() {
        return combo_request;
    }

    public void setCombo_request(JComboBox combo_request) {
        this.combo_request = combo_request;
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel_MyTeamDef = new javax.swing.JPanel();
        Combo_TeamList = new javax.swing.JComboBox();
        text_creatteam = new javax.swing.JTextField();
        button_creatteam = new javax.swing.JButton();
        button_jointeam = new javax.swing.JButton();
        jPanel_teamManager = new javax.swing.JPanel();
        button_acceptPlayer = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        combo_request = new javax.swing.JComboBox();
        combo_myTeam = new javax.swing.JComboBox();

        jTextField1.setText("jTextField1");

        jLabel1.setText("My team");

        Combo_TeamList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        text_creatteam.setText("Team Name");
        text_creatteam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_creatteamActionPerformed(evt);
            }
        });

        button_creatteam.setText("Creat");
        button_creatteam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_creatteamActionPerformed(evt);
            }
        });

        button_jointeam.setText("Join");
        button_jointeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_jointeamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_MyTeamDefLayout = new javax.swing.GroupLayout(jPanel_MyTeamDef);
        jPanel_MyTeamDef.setLayout(jPanel_MyTeamDefLayout);
        jPanel_MyTeamDefLayout.setHorizontalGroup(
            jPanel_MyTeamDefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MyTeamDefLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_MyTeamDefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_creatteam, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(Combo_TeamList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_MyTeamDefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_jointeam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_creatteam, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel_MyTeamDefLayout.setVerticalGroup(
            jPanel_MyTeamDefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MyTeamDefLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_MyTeamDefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Combo_TeamList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_jointeam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_MyTeamDefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_creatteam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_creatteam))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        button_acceptPlayer.setText("Acept player");
        button_acceptPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_acceptPlayerActionPerformed(evt);
            }
        });

        jLabel3.setText("Team requests");

        combo_request.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel_teamManagerLayout = new javax.swing.GroupLayout(jPanel_teamManager);
        jPanel_teamManager.setLayout(jPanel_teamManagerLayout);
        jPanel_teamManagerLayout.setHorizontalGroup(
            jPanel_teamManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_teamManagerLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel_teamManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_acceptPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_teamManagerLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(247, 247, 247)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel_teamManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_request, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_teamManagerLayout.setVerticalGroup(
            jPanel_teamManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_teamManagerLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_request, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_acceptPlayer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        combo_myTeam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_teamManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel1))
                            .addComponent(combo_myTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_MyTeamDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_myTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel_MyTeamDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_teamManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void text_creatteamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_creatteamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_creatteamActionPerformed

    private void button_creatteamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_creatteamActionPerformed

        this.newTeam.name = text_creatteam.getText(); 
        this.newTeam.leader = currentPlayer;
        
    }//GEN-LAST:event_button_creatteamActionPerformed

    private void button_jointeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_jointeamActionPerformed
        Team joiningTeam = (Team) Combo_TeamList.getSelectedItem(); 
        joiningTeam.request.add(currentPlayer); 
    }//GEN-LAST:event_button_jointeamActionPerformed

    private void button_acceptPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_acceptPlayerActionPerformed
        Player newPlayer = (Player)combo_request.getSelectedItem(); 
        for (Team currentTeam: playerTeam){
            if (currentTeam.leader.name == currentPlayer.name){
                currentTeam.aceptedRequest.add(newPlayer); 
                                
            }
        }
        
    }//GEN-LAST:event_button_acceptPlayerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Combo_TeamList;
    private javax.swing.JButton button_acceptPlayer;
    private javax.swing.JButton button_creatteam;
    private javax.swing.JButton button_jointeam;
    private javax.swing.JComboBox combo_myTeam;
    private javax.swing.JComboBox combo_request;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel_MyTeamDef;
    private javax.swing.JPanel jPanel_teamManager;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField text_creatteam;
    // End of variables declaration//GEN-END:variables
}
