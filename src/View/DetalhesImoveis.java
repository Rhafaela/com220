/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CtrlImovel;
import Model.Imovel;
import java.awt.BorderLayout;
import static java.awt.Color.red;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

/**
 *
 * @author deeen
 */
public class DetalhesImoveis extends JFrame implements ActionListener{
    
    private CtrlImovel imovCtrl;
    private String op;
    private int a;
    boolean temImovel = false;
    
    JPanel panel = new JPanel(new BorderLayout());
    
    JTextField codigo = new JTextField();
    JTextField tipo = new JTextField(); 
    
    JLabel cod = new JLabel("Código");
    JLabel type = new JLabel("Tipo");
   
    JButton btnProposta = new JButton("Fazer Proposta");
    JButton btnAgendarVisita = new JButton(" Agendar Visita");
    
    String foto;
    
    
    
    private ArrayList<Imovel> vecAImovel = new ArrayList();

    public DetalhesImoveis(int aux) throws Exception{
        try {
            imovCtrl = new CtrlImovel();
        } catch (Exception ex) {
            Logger.getLogger(DetalhesImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.a = aux;
        
//        a = Integer.parseInt(op);
        
        vecAImovel = imovCtrl.getListaImoveis();
//        Imovel aux = this.imovCtrl.getImovelrByIndex(a);
        
        for(Imovel i : vecAImovel){
            if(i.getCodigo() == a){                                
                codigo.setText(Integer.toString(i.getCodigo()));
                tipo.setText(i.getTipo());
                foto = i.getArquivoFoto();
                temImovel = true;
            }
        }
              
        if(!temImovel){
            JOptionPane.showMessageDialog(null, "Não possui o codigo digitado cadastrado","Atenção", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        JPanel imgPanel = new JPanel();
        imgPanel.setBackground(red);
//        ImageIcon imagem = new ImageIcon(getClass().getResource(foto));
        
        JLabel imgLabel = new JLabel("Imagem");
        imgPanel.add(imgLabel);
        
//        JPanel escolhas = new JPanel( new BorderLayout());
//        escolhas.setBackground(white);
//        escolhas.setBorder(BorderFactory.createTitledBorder("teste"));
//        escolhas.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createEmptyBorder(35, 55, 35, 55),
//                BorderFactory.createEmptyBorder()));

        codigo.setPreferredSize(new Dimension(100, 30));
        System.out.println(foto);
        
        JPanel codigoPanel = new JPanel();
        codigoPanel.add(cod);
        codigoPanel.add(codigo);
        
        JPanel tipoPanel = new JPanel();
        tipoPanel.add(type);
        tipoPanel.add(tipo);
        
        codigoPanel.add(tipoPanel);
        
        JPanel buttons = new JPanel();        
        buttons.add(btnAgendarVisita);
        buttons.add(btnProposta);
        
        panel.add(new JLabel("DETALHES DO IMÓVEL", JLabel.CENTER), BorderLayout.NORTH);
        panel.add(imgPanel, BorderLayout.WEST);
        panel.add(codigoPanel, BorderLayout.CENTER);       
        panel.add(buttons, BorderLayout.SOUTH);

//        escolhas.add(tipo);
        
//       panel.add(escolhas);         
               
        
        this.add(panel);         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        
        //verificar pq ta tudo indo apartamento
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setBorder(CompoundBorder createCompoundBorder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
