/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControlCorretor;
import Controller.ValidarCPF;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author deeen
 */
public class CorretorAddView extends JFrame implements ActionListener{
    
    private ControlCorretor controle;
    
//Pegando tamanho em largura e altura da tela
    Toolkit kit = Toolkit.getDefaultToolkit();  
    Dimension tamTela = kit.getScreenSize();  
    
    //private JPanel panel = new JPanel(new BorderLayout());
    private final JPanel painel = new JPanel(new GridBagLayout());
   
    private JLabel cpf = new JLabel("CPF");
    private final JTextField tfcpf = new JTextField(20);
    
    private JLabel nome = new JLabel("Nome");
    private final JTextField tfnome = new JTextField(20);
    
    private JLabel email = new JLabel("Email");
    private final JTextField tfemail = new JTextField(20);
    
    private JLabel fone = new JLabel("Telefone");
    private final JTextField tfFone = new JTextField(20);
    
    private JLabel creci = new JLabel("CRECI");
    private final JTextField tfcreci = new JTextField(20);
    
    private JLabel pctVenda = new JLabel("Percentual de Venda");
    private final JTextField tfPctVenda = new JTextField(20);
    
    private final JButton btnCadastrar = new JButton("Cadastrar");
    
    public CorretorAddView(ControlCorretor controle){
        super("Cadastrar Corretor");
        
        this.controle = controle;
        
        //Pega largura e altura da tela 
        int larg = tamTela.width;  
        int alt = tamTela.height;
        
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(35, 55, 35, 55),
                BorderFactory.createEmptyBorder()));
        
        
        adicionarComponente(painel, new JLabel("CPF"), 0, 0, 1, 1);
        adicionarComponente(painel, tfcpf, 1, 0, 1, 1);
        
        adicionarComponente(painel, new JLabel("Nome"), 0, 1, 1, 1);
        adicionarComponente(painel, tfnome, 1, 1, 1, 1);
        
        adicionarComponente(painel, new JLabel("Email"), 0, 2, 1, 1);
        adicionarComponente(painel, tfemail, 1, 2, 1, 1);
        
        adicionarComponente(painel, new JLabel("Telefone"), 0, 3, 1, 1);
        adicionarComponente(painel, tfFone, 1, 3, 1, 1);
        
        adicionarComponente(painel, new JLabel("CRECI"), 0, 4, 1, 1);
        adicionarComponente(painel, tfcreci, 1, 4, 1, 1);
        
        adicionarComponente(painel, new JLabel("Percentual de Vendas"), 0, 5, 1, 1);
        adicionarComponente(painel, tfPctVenda, 1, 5, 1, 1);
        
        btnCadastrar.addActionListener(this);
        adicionarComponente(painel, btnCadastrar, 0, 6, 1, 2);
        
        super.add(painel);
        //super.pack();
        //super.setLocationRelativeTo(null);
        //super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //super.setVisible(true);
    
    }
    
     private void adicionarComponente(JPanel painel, JComponent componente,
            int gridx, int gridy, int height, int width) { 
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = height;
        c.gridwidth = width;
        painel.add(componente, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String cpf = tfcpf.getText();
            String nome = tfnome.getText();
            String email = tfemail.getText();
            String fone = tfFone.getText();
            String creci = tfcreci.getText();
            Double porcentagem = Double.parseDouble(tfPctVenda.getText());
            
            if(ValidarCPF.isCPF(cpf) == true){
                controle.cadCorretor(cpf, nome, email, fone, creci, porcentagem);
                JOptionPane.showMessageDialog(this, "Cadastro feito com êxito!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "CPF digitado nao eh valido!","Erro", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
            
        }catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(this, "Erro na entrada de parâmetros!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, exc.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
