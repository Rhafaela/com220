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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
    private Imovel imovelItem;

    JPanel panel = new JPanel(new BorderLayout());
    
    JTextField codigo = new JTextField();
    JTextField tipo = new JTextField(); 
    JTextField preco = new JTextField(); 
    JTextArea descricao = new JTextArea(50,60);
    
    JLabel cod = new JLabel("Código");
    JLabel type = new JLabel("Tipo");
    JLabel price = new JLabel("Preço");
    JLabel description = new JLabel("descrição");
   
    
    
    JButton btnProposta = new JButton("Fazer Proposta");
    JButton btnAgendarVisita = new JButton(" Agendar Visita");
    
    JPanel infos = new JPanel(new GridBagLayout());
    
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

        codigo.setEditable(false);
        codigo.setBorder(null);
        
        tipo.setEditable(false);  
        tipo.setBorder(null);
        
        preco.setEditable(false);
        preco.setBorder(null);
        
        descricao.setEditable(false);
        descricao.setBorder(null);

        for(Imovel i : vecAImovel){
            if(i.getCodigo() == a){                                
                codigo.setText(Integer.toString(i.getCodigo()));
                tipo.setText(i.getTipo());
                foto = i.getArquivoFoto();                
                preco.setText(Double.toString(i.getPreco()));
                descricao.setText(i.getDescricao());
                
                temImovel = true;
                this.imovelItem = i;
            }
        }
              
        if(!temImovel){
            JOptionPane.showMessageDialog(null, "Não possui o codigo digitado cadastrado","Atenção", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
                        
        JPanel imgPanel = new JPanel();        
        ImageIcon imagem = new ImageIcon(foto);
        
        JLabel imgLabel = new JLabel(imagem);
        imgPanel.add(imgLabel);
        
//        JPanel escolhas = new JPanel( new BorderLayout());
//        escolhas.setBackground(white);
//        escolhas.setBorder(BorderFactory.createTitledBorder("teste"));
//        escolhas.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createEmptyBorder(35, 55, 35, 55),
//                BorderFactory.createEmptyBorder()));

        codigo.setPreferredSize(new Dimension(100, 30));
        System.out.println(foto);
        
//        JPanel codigoPanel = new JPanel();
//        codigoPanel.add(cod);
//        codigoPanel.add(codigo);
        
//        JPanel tipoPanel = new JPanel();
//        tipoPanel.add(type);
//        tipoPanel.add(tipo);
//        
//        codigoPanel.add(tipoPanel);

        adicionarComponente(infos, cod, 0, 0, 1, 1);
        adicionarComponente(infos, codigo, 1, 0, 1, 1);
        
        adicionarComponente(infos, type, 0, 1, 1, 1);
        adicionarComponente(infos, tipo, 1, 1, 1, 1);
        
        adicionarComponente(infos, type, 0, 2, 1, 1);
        adicionarComponente(infos, tipo, 1, 2, 1, 1);
        
        adicionarComponente(infos, description, 0, 3, 1, 1);
        adicionarComponente(infos, descricao, 1, 3, 1, 1);
        
        
        
        JPanel buttons = new JPanel();        
        buttons.add(btnAgendarVisita);
        buttons.add(btnProposta);
        
        panel.add(new JLabel("DETALHES DO IMÓVEL", JLabel.CENTER), BorderLayout.NORTH);
        panel.add(imgPanel, BorderLayout.WEST);
        panel.add(infos, BorderLayout.CENTER);       
        panel.add(buttons, BorderLayout.SOUTH);

//        escolhas.add(tipo);
        
//       panel.add(escolhas);
        
        // button actions
        this.btnAgendarVisita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                AgendarVisita av = new AgendarVisita(imovelItem);
                System.out.println(imovelItem);
                //av.setVisible(true);
                //av.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        this.btnProposta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cod;
                cod = Integer.parseInt(codigo.getText());
                ViewProposta vp = null;
                try {
                    vp = new ViewProposta(cod);
                } catch (Exception ex) {
                    Logger.getLogger(DetalhesImoveis.class.getName()).log(Level.SEVERE, null, ex);
                }
                vp.setVisible(true);
                vp.setSize(400, 300);
//                vp.setResizable(false);
                vp.setLocationRelativeTo(null);
                vp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
               
        
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
    
    
    private void adicionarComponente(JPanel painel, JComponent componente,
        int gridx, int gridy, int height, int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
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
