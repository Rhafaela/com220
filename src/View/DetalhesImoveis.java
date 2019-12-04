/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CtrlImovel;
import Model.Imovel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author deeen
 */
public class DetalhesImoveis extends JFrame implements ActionListener{
    
    private CtrlImovel imovCtrl;
    private int op;

    public DetalhesImoveis(int op){
        try {
            imovCtrl = new CtrlImovel();
        } catch (Exception ex) {
            Logger.getLogger(DetalhesImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.op = op;
        
        Imovel aux = this.imovCtrl.getImovelrByIndex(op);
        
        JTextField codigo = new JTextField();
        JTextField tipo = new JTextField();
        
        codigo.setText(Integer.toString(aux.getCodigo()));
        tipo.setText(aux.getTipo());
        
        JPanel panel = new JPanel(new BorderLayout());
        
        panel.add(codigo, BorderLayout.CENTER);
        panel.add(tipo, BorderLayout.LINE_END);
        
        this.add(panel);         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        
        //verificar pq ta tudo indo apartamento
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
