/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CtrlProposta;
import Model.Imovel;
import Model.Proposta;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author deeen
 */
public class DetalhesPropostas extends JFrame implements ActionListener{
    
    String name = "";
    
     private ArrayList<Proposta> vecPropostas = new ArrayList();
    
    private CtrlProposta crtlProp;
    private String op;
    private int a;
    boolean temImovel = false;
    
    JPanel panel = new JPanel(new BorderLayout());
    
    JTextField hora = new JTextField();
    JTextField comprador = new JTextField(); 
    JTextField vendedor = new JTextField(); 
    JTextField preco = new JTextField();
    JTextField estado = new JTextField();
    
    JLabel data = new JLabel("Data");
    JLabel comp = new JLabel("Comprador");
    JLabel price = new JLabel("Preço");
    JLabel vend = new JLabel("Vendedor");
    JLabel est = new JLabel("Estado");
   
    
    JButton aceitar = new JButton("Aceitar Proposta");
    JButton Recusar = new JButton(" Recusar");    
    JButton cancelar = new JButton("Cancelar");
    
    JPanel infos = new JPanel(new GridBagLayout());
    
    Calendar aux;
    
    DetalhesPropostas(String sel) throws Exception {
        super(sel);
        
        crtlProp = new CtrlProposta();
        
        vecPropostas = crtlProp.getListaPropostas();
        
        hora.setEditable(false);
        hora.setBorder(null);
        
        comprador.setEditable(false);  
        comprador.setBorder(null);
        
        vendedor.setEditable(false);
        vendedor.setBorder(null);
        
        preco.setEditable(false);
        preco.setBorder(null);
        
        estado.setEditable(false);
        estado.setBorder(null);
        
        int ano;
        int mes;
        int day;
        
        boolean tempro = false;
        //System.out.println(sel);
        for(Proposta p : vecPropostas){
            if(p.getComprador().getNome().equals(sel)){                                
                aux = p.getData();
                ano = aux.get(Calendar.YEAR);
                mes = aux.get(Calendar.MONTH);
                day = aux.get(Calendar.DAY_OF_MONTH);                
                hora.setText(day+"/"+mes+"/"+ano);
                
                comprador.setText(p.getComprador().getNome());
                vendedor.setText(p.getCorretor().getNome());
                preco.setText(Double.toString(p.getValor()));
                estado.setText(p.getEstado());
                
                tempro = true;                
            }
        }
        
        if(!tempro){
            JOptionPane.showMessageDialog(null, "Não Nome cadastrado","Atenção", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        adicionarComponente(infos, data, 0, 0, 1, 1);
        adicionarComponente(infos, hora, 1, 0, 1, 1);
        
        adicionarComponente(infos, comp, 0, 1, 1, 1);
        adicionarComponente(infos, comprador, 1, 1, 1, 1);
        
        adicionarComponente(infos, vend, 0, 2, 1, 1);
        adicionarComponente(infos, vendedor, 1, 2, 1, 1);
        
        adicionarComponente(infos, price, 0, 3, 1, 1);
        adicionarComponente(infos, preco, 1, 3, 1, 1);
        
        adicionarComponente(infos, est, 0, 4, 1, 1);
        adicionarComponente(infos, estado, 1, 4, 1, 1);
        
        
        JPanel buttons = new JPanel();        
        buttons.add(aceitar);
        buttons.add(Recusar);
        buttons.add(cancelar);
        
      
        
        panel.add(new JLabel("DETALHES DA PROPSOTA", JLabel.CENTER), BorderLayout.NORTH);        
        panel.add(infos, BorderLayout.CENTER);       
        panel.add(buttons, BorderLayout.SOUTH);
        
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void adicionarComponente(JPanel painel, JComponent componente,
        int gridx, int gridy, int height, int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets( 9, 9, 9, 9);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = height;
        c.gridwidth = width;
        painel.add(componente, c);

    }
    
}
