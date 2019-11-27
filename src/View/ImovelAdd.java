/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CtrlImovel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
 * @author André
 */
public class ImovelAdd extends JFrame implements ActionListener{
    private CtrlImovel ctrleImovel;
    
    //Pegando tamanho em largura e altura da tela
    Toolkit kit = Toolkit.getDefaultToolkit();  
    Dimension tamTela = kit.getScreenSize();  
    
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextField tfCodigo = new JTextField(20);
    private final JTextField tfTipo = new JTextField(20);
    private final JTextField tfDescricao = new JTextField(20);
    private final JTextField tfArquivoFoto = new JTextField(20);
    private final JTextField tfEstado = new JTextField(20);
    private final JTextField tfPreco = new JTextField(20);
    private final JTextField tfComissao = new JTextField(20);
    private final JTextField tfDataInclusao = new JTextField(20);
    private final JTextField tfVendedor = new JTextField(20);

    private final JButton btnCadastrar = new JButton("Cadastrar");
    
    public ImovelAdd(CtrlImovel ctrleImovel){
        super("Cadastrar Imovel");
        
        this.ctrleImovel = ctrleImovel;
        
        //Pega largura e altura da tela 
        int larg = tamTela.width;  
        int alt = tamTela.height;
        
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(35, 55, 35, 55),
                BorderFactory.createEmptyBorder()));
        
        adicionarComponente(painel, new JLabel("Código"), 0, 0, 1, 1);
        adicionarComponente(painel, tfCodigo, 1, 0, 1, 1);
        
        adicionarComponente(painel, new JLabel("Tipo"), 0, 1, 1, 1);
        adicionarComponente(painel, tfTipo, 1, 1, 1, 1);
        
        adicionarComponente(painel, new JLabel("Descrição"), 0, 2, 1, 1);
        adicionarComponente(painel, tfDescricao, 1, 2, 1, 1);
        
        adicionarComponente(painel, new JLabel("Arquivo Foto"), 0, 3, 1, 1);
        adicionarComponente(painel, tfArquivoFoto, 1, 3, 1, 1);
        
        adicionarComponente(painel, new JLabel("Estado"), 0, 4, 1, 1);
        adicionarComponente(painel, tfEstado, 1, 4, 1, 1);
        
        adicionarComponente(painel, new JLabel("Preço"), 0, 5, 1, 1);
        adicionarComponente(painel, tfPreco, 1, 5, 1, 1);
        
        adicionarComponente(painel, new JLabel("Comissao"), 0, 6, 1, 1);
        adicionarComponente(painel, tfComissao, 1, 6, 1, 1);
        
        adicionarComponente(painel, new JLabel("Data Inclusao"), 0, 7, 1, 1);
        adicionarComponente(painel, tfDataInclusao, 1, 7, 1, 1);
        
        adicionarComponente(painel, new JLabel("Vendedor"), 0, 8, 1, 1);
        adicionarComponente(painel, tfVendedor, 1, 8, 1, 1);
        
        btnCadastrar.addActionListener(this);
        adicionarComponente(painel, btnCadastrar, 0, 9, 1, 2);
    
        super.add(painel);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            int codigo = Integer.parseInt(tfCodigo.getText());
            String tipo = tfTipo.getText();
            String descricao = tfDescricao.getText();
            String arquivoFoto = tfArquivoFoto.getText();
            String estado = tfEstado.getText();
            Double preco = Double.parseDouble(tfPreco.getText());
            Double comissao = Double.parseDouble(tfComissao.getText());
            String dataInclusao = tfDataInclusao.getText();
            String vendedor = tfVendedor.getText();
            
            ctrleImovel.cadImovel(codigo, tipo, descricao, arquivoFoto, estado, preco, comissao, dataInclusao, vendedor);
            
        }catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(this, "Erro na entrada de parâmetros!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, exc.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void adicionarComponente(JPanel painel, JComponent componente,
            int gridx, int gridy, int height, int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
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
