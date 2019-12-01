/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CtrlImovel;
import Model.Util;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
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
    BufferedImage imagem;
    //Pegando tamanho em largura e altura da tela
    Toolkit kit = Toolkit.getDefaultToolkit();  
    Dimension tamTela = kit.getScreenSize();  
    
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextField tfCodigo = new JTextField(20);
//    private final JTextField tfTipo = new JTextField(20);
    private final JTextField tfDescricao = new JTextField(20);
    private final JTextField tfArquivoFoto = new JTextField(20);
    private final JTextField tfEstado = new JTextField(20);
    private final JTextField tfPreco = new JTextField(20);
    private final JTextField tfComissao = new JTextField(20);
    private final JTextField tfDataInclusao = new JTextField(20);
    private final JTextField tfVendedor = new JTextField(20);

    private final JButton btnInsertImg = new JButton("Selecionar imagem");
    private final JButton btnCadastrar = new JButton("Cadastrar");
    
    private final JComboBox tipoImovel;
//    private final JComboBox estadoImovel;
//    private final JComboBox combo2;
//    private final JComboBox combo3;
    
    public ImovelAdd(CtrlImovel ctrleImovel){
        super("Cadastrar Imovel");
        
        this.ctrleImovel = ctrleImovel;
        
        //Pega largura e altura da tela 
        int larg = tamTela.width;  
        int alt = tamTela.height;
        
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(35, 55, 35, 55),
                BorderFactory.createEmptyBorder()));
        btnInsertImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnImageActionPerformed(e);
            }
        });
        adicionarComponente(painel, new JLabel("Código"), 0, 0, 1, 1);
        adicionarComponente(painel, tfCodigo, 1, 0, 1, 1);
        
        this.tipoImovel = new JComboBox();
        tipoImovel.addItem(Util.LOTE);
        tipoImovel.addItem(Util.CASA);
        tipoImovel.addItem(Util.APTO);
        tipoImovel.addItem(Util.SALA);
        tipoImovel.addItem(Util.RURAL);       
        adicionarComponente(painel, new JLabel("Tipo"), 0, 1, 1, 1);
        adicionarComponente(painel, (JComponent) new JLabel("Tipo").add(tipoImovel), 1, 1, 1, 1);
//        adicionarComponente(painel, tfTipo, 1, 1, 1, 1);
        
        adicionarComponente(painel, new JLabel("Descrição"), 0, 2, 1, 1);
        adicionarComponente(painel, tfDescricao, 1, 2, 1, 1);
        
        adicionarComponente(painel, new JLabel("Arquivo Foto"), 0, 3, 1, 1);
        adicionarComponente(painel, btnInsertImg, 1, 3, 1, 1);
//        adicionarComponente(painel, tfArquivoFoto, 1, 3, 1, 1);
        
//        this.estadoImovel = new JComboBox();
//        estadoImovel.addItem(Util.ATIVO);
//        estadoImovel.addItem(Util.INATIVO);
//        estadoImovel.addItem(Util.VENDIDO);        
//        adicionarComponente(painel, new JLabel("Estado"), 0, 4, 1, 1);
//        adicionarComponente(painel, (JComponent) new JLabel("Estado").add(estadoImovel), 1, 4, 1, 1);
//        adicionarComponente(painel, tfEstado, 1, 4, 1, 1);
        
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
        boolean possuiCodigo = false;
        try{
            int codigo = Integer.parseInt(tfCodigo.getText());
//            String tipo = tfTipo.getText();
            String tipo = (String) tipoImovel.getSelectedItem();            
            String descricao = tfDescricao.getText();
            
            //Pegamos o caminho da pasta criada para a imagem do imovel
            String caminho = getClass().getResource("../image/"+tfCodigo.getText()+"/").toString().substring(5);
            String arquivoFoto = caminho+"image.jpg";
//            String estado = tfEstado.getText();
//            String estado = (String) estadoImovel.getSelectedItem();
            Double preco = Double.parseDouble(tfPreco.getText());
            Double comissao = Double.parseDouble(tfComissao.getText());
            String dataInclusao = tfDataInclusao.getText();
            String vendedor = tfVendedor.getText();
            
            possuiCodigo = ctrleImovel.verificaCodigo(codigo);
            
            if(possuiCodigo == false){
                ctrleImovel.cadImovel(codigo, tipo, descricao, arquivoFoto, preco, comissao, dataInclusao, vendedor);
                JOptionPane.showMessageDialog(this, "Cadastro feito com êxito!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "já possui imóvel com esse códgio inserido!","Erro", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
            
            
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
    
    
    private void btnImageActionPerformed(java.awt.event.ActionEvent e){
        JFileChooser file = new JFileChooser();
        
        int window = file.showOpenDialog(null);
        
        if (window == JFileChooser.APPROVE_OPTION) {
            File arquivo = file.getSelectedFile();

            try {
                //imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);
                imagem = ImageIO.read(arquivo);
//                lblImagem.setIcon(new ImageIcon(imagem));

            } catch (Exception ex) {
               // System.out.println(ex.printStackTrace().toString());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
        
        
        //img salvando
        try {
            if(tfCodigo.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, Preencha o código para poder inserir  imagem!");
            }else{
                
                //pegando diretorio da pasta image
                String dir = getClass().getResource("../image/").toString().substring(5);
                //diretorio recebe o codigo da imagem
                dir = dir+tfCodigo.getText();
                
                //Criamos uma pasta com o codigo do imovel
                File diretorio = new File(dir);
                diretorio.mkdir();
                
                //Pegamos o caminho da pasta criada para a imagem do imovel
                String caminho = getClass().getResource("../image/"+tfCodigo.getText()+"/").toString().substring(5);
                

                File outputfile = new File(caminho+"image.jpg");
                ImageIO.write(imagem, "jpg", outputfile);
                JOptionPane.showMessageDialog(rootPane, "Imagem escolhida");
                
            }
             
         } catch (IOException ex) {
//             Logger.getLogger(EnviarImagem.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
}
