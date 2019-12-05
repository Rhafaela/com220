
package View;

import Controller.ControlCorretor;
import Controller.ControleVendedor;
import Controller.CtrlImovel;
import Model.Imovel;
import Model.Util;
import java.awt.BorderLayout;
//import com.sun.prism.image.Coords;

import java.awt.CardLayout;
import static java.awt.Color.red;
import static java.awt.Color.white;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Home extends JFrame implements ActionListener, WindowListener{
    
    //Pegando tamanho em largura e altura da tela
    Toolkit kit = Toolkit.getDefaultToolkit();  
    Dimension tamTela = kit.getScreenSize();  
    
     String sel;
     int aux;
    
    private ControleVendedor ctrlVendedor;
    private ControlCorretor ctrlCorretor;
    private CtrlImovel ctrleImovel;
        
    //Painel na pagina inicial de Teste Leitura dos corretores
    private final JPanel painel = new JPanel(new GridBagLayout());
    JPanel tiposImoveis = new JPanel(new BorderLayout());  
    JPanel listaImoveisPorTipo = new JPanel();
    JPanel listaImoveisPorTipoCasa = new JPanel();
    JPanel listaImoveisTipoLote = new JPanel();
    JPanel listaImoveisTipoSalaComercial = new JPanel();
    JPanel listaImoveisPropiedadeRural = new JPanel();
    private final JTextArea resultado = new JTextArea(5, 10);
    
    private final JTextArea re = new JTextArea(5,10);
    
    private Container pane;
    CardLayout layout;
    
    private JComboBox tiposImoveisJComboBox;
    
    //METODO CONSTRUTOR
    public Home() throws Exception{
       
        super("Sistema de vendas");
        
        //Pega largura e altura da tela 
        int larg = tamTela.width;  
        int alt = tamTela.height;
        
        ctrlCorretor = new ControlCorretor();
        ctrleImovel = new CtrlImovel();
        
        //setando layout
        layout = new CardLayout();
        setLayout(layout);
        pane = this.getContentPane();
        
        //Criando painel tipoImoveis
//        JPanel tiposImoveis = new JPanel(new BorderLayout());
         
        tiposImoveis.setBackground(white);
                  
        tiposImoveisJComboBox = new JComboBox();
        tiposImoveisJComboBox.setPreferredSize( new Dimension(300,25) );
        
        tiposImoveisJComboBox.addItem(Util.LOTE);
        tiposImoveisJComboBox.addItem(Util.CASA);
        tiposImoveisJComboBox.addItem(Util.APTO);
        tiposImoveisJComboBox.addItem(Util.SALA);
        tiposImoveisJComboBox.addItem(Util.RURAL);
        tiposImoveisJComboBox.addActionListener(this);
       
        JPanel panelTipoImovel = new JPanel();
        panelTipoImovel.setBackground(white);
        panelTipoImovel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(35, 55, 35, 55),
                BorderFactory.createEmptyBorder()));
  
        //        adicionarComponente(teste, new JLabel("Tipo"), 0, 0, 1, 1);
        JLabel nameTipo = new JLabel();
        nameTipo.setSize(50,20);
        nameTipo.setText("Tipo");
        nameTipo.setFont(new Font("Serif", Font.BOLD, 15));
        nameTipo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(35, 40, 35, 40),
                BorderFactory.createEmptyBorder()));
        panelTipoImovel.add(nameTipo);
        panelTipoImovel.add(tiposImoveisJComboBox);
        
        
        
        
        
        listaImoveisPorTipo.setBackground(white);        
        listaImoveisPorTipo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(35, 55, 35, 55),
                BorderFactory.createEmptyBorder()));
        listaImoveisPorTipo.setVisible(false);

        listaImoveisPorTipoCasa.setBackground(white); 
        listaImoveisPorTipoCasa.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(35, 55, 35, 55),
                BorderFactory.createEmptyBorder()));
        listaImoveisPorTipoCasa.setVisible(false);
        
        listaImoveisTipoLote.setBackground(white);        
        listaImoveisTipoLote.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(35, 55, 35, 55),
                BorderFactory.createEmptyBorder()));
        listaImoveisTipoLote.setVisible(false);
        
        listaImoveisTipoSalaComercial.setBackground(white); 
        listaImoveisTipoSalaComercial.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(35, 55, 35, 55),
                BorderFactory.createEmptyBorder()));
        listaImoveisTipoSalaComercial.setVisible(false);
        
        listaImoveisPropiedadeRural.setBackground(white); 
        listaImoveisPropiedadeRural.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(35, 55, 35, 55),
                BorderFactory.createEmptyBorder()));
        listaImoveisPropiedadeRural.setVisible(false);
        
        tiposImoveis.add(panelTipoImovel, BorderLayout.NORTH);
        
        
        
//Mostra resultados dos corretores (teste)
        resultado.setEditable(false);
        String c = ctrlCorretor.listaCorretores();
        String i = ctrleImovel.listaImoveis();
        resultado.setText(i);
        adicionarComponente(painel, resultado, 0, 1, 1, 1);
//        this.add(painel);        
//        setLayout(new FlowLayout());
//        textArea = new JTextArea(5,10);
//        textArea.setPreferredSize(new java.awt.Dimension(larg/2, alt/2));
//        add(textArea);
                
/**** ---------- FIM MOSTRA TESTE *-----------------------*/
     pane.add("Home", painel);  
     pane.add("Tipos", tiposImoveis);  
     
        
        /*------- MENU -------------*/
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        menu.setBackground(new java.awt.Color(204,204,255));
        menu.setBorder(null);
        menu.setPreferredSize(new java.awt.Dimension(56, 50));
        
        
        
        /*Menu de Cadastros */
        JMenu cadastro = new JMenu("Cadastrar");
        cadastro.setPreferredSize(new java.awt.Dimension(larg/4, alt/4));
        cadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/group_add.png")));
        menu.add(cadastro);
        
        JMenuItem cadVendedor = new JMenuItem("Vendedor", new ImageIcon(getClass().getResource("/image/user_add.png")));
        cadVendedor.setPreferredSize(new java.awt.Dimension(larg/(5), 20));
        cadVendedor.setBorder(null);
        
        JMenuItem cadCorretor = new JMenuItem("Corretor", new ImageIcon(getClass().getResource("/image/user_suit.png")));
        cadCorretor.setBorder(null);
        
        JMenuItem cadCompador = new JMenuItem("Comprador", new ImageIcon(getClass().getResource("/image/user_gray.png")));
        cadCompador.setBorder(null);
        
        JMenuItem cadImovel = new JMenuItem("Imovel",  new ImageIcon(getClass().getResource("/image/house.png")));
        cadImovel.setBorder(null);
        
        cadastro.add(cadVendedor);
        cadastro.add(cadCorretor);
        cadastro.add(cadCompador);
        cadastro.add(cadImovel);
        /*Fim Menu de Cadastro*/
        
        /*Menu de Catalogo */
        JMenu catalogo = new JMenu("Catalogo");
        catalogo.setPreferredSize(new java.awt.Dimension(larg/4, alt/4));
        catalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/page_white_picture.png")));
        menu.add(catalogo);
        
        JMenuItem listaCatalogo = new JMenuItem("Lista Catálogo", new ImageIcon(getClass().getResource("/image/user_add.png")));
        listaCatalogo.setPreferredSize(new java.awt.Dimension(larg/(5), 20));
        listaCatalogo.setBorder(null);
        
        catalogo.add(listaCatalogo);
        /*Fim Menu de Catalogo*/

        
        /*Menu de Propostas Pendentes */
        JMenu proposta_pend = new JMenu("Propostas Pendentes");
        proposta_pend.setPreferredSize(new java.awt.Dimension(larg/4, alt/4));
        proposta_pend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/money.png")));
        menu.add(proposta_pend);
        /*Fim Menu de Propostas Pendentes*/
        
        /*Menu Editar dados cadastrados */
        JMenu editar = new JMenu("Editar");
        editar.setPreferredSize(new java.awt.Dimension(larg/4, alt/4));
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_edit.png")));
        menu.add(editar);
       
        JMenuItem listaComprador = new JMenuItem("Compradores", new ImageIcon(getClass().getResource("/image/user_gray.png")));
        listaComprador.setBorder(null);
        editar.add(listaComprador);
        
        JMenuItem listaVendedor = new JMenuItem("Vendedores", new ImageIcon(getClass().getResource("/image/user_gray.png")));
        listaVendedor.setBorder(null);
        editar.add(listaVendedor);
        /*------- FIM MENU --------*/
        
        // JMenu relatorios
        JMenu relatorios = new JMenu("Relatórios");
        relatorios.setPreferredSize(new java.awt.Dimension(larg/4, alt/4));
        relatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_edit.png")));
        menu.add(relatorios);
       
        JMenuItem relatorio3 = new JMenuItem("Relatório 3", new ImageIcon(getClass().getResource("/image/user_gray.png")));
        relatorio3.setBorder(null);
        relatorios.add(relatorio3);
        relatorio3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Relatorio3 rel3 = new Relatorio3();
                rel3.setVisible(true);
                rel3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        
/* --------- AÇÕES DOS MENUS ----------*/
        
        
        //ação Menu Cadastrar Corretor
        cadCorretor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                CorretorAddView cAdd = new CorretorAddView(ctrlCorretor);
                cAdd.setVisible(true);
                cAdd.setSize(larg/2, 380);
                cAdd.setLocationRelativeTo(null);
                cAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        //Ação Menu de Cdastrar Comprado
        cadCompador.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               CompradorAdd cv = new CompradorAdd();
               cv.setVisible(true);
               cv.setSize(larg/2, alt/2);
               cv.setLocationRelativeTo(null);
               cv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        //Ação Menu de Cdastrar Vendedor
        cadVendedor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               VendedorAdd vv = new VendedorAdd();
               vv.setVisible(true);
               vv.setSize(larg/2, alt/2);
               vv.setLocationRelativeTo(null);
               vv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
                
        //Acao no menu para cadastrar imovel
        cadImovel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ImovelAdd im = new ImovelAdd(ctrleImovel);
                im.setVisible(true);
                im.setSize(larg/2, 480);
                im.setLocationRelativeTo(null);
                im.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }                    
        });
        
        listaVendedor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               VendedorList vl = new VendedorList();
               vl.setVisible(true);
               vl.setSize(larg/2, alt/2);
               vl.setLocationRelativeTo(null);
               vl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        listaComprador.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               CompradorList cl = new CompradorList();
               cl.setVisible(true);
               cl.setSize(larg/2, alt/2);
               cl.setLocationRelativeTo(null);
               cl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        listaCatalogo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              layout.show(pane,"Tipos");
            }
        });
      
        
        //Setando o JFrame
        this.setSize(larg,alt);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tiposImoveisJComboBox){
            String op = (String) tiposImoveisJComboBox.getSelectedItem();
             ArrayList<Imovel> vecAImovel = new ArrayList();
             DefaultListModel list = new DefaultListModel();
             JList lista = new JList();
//             File file;
//             Image imgs;
             JScrollPane scrollPane = new JScrollPane();
             JPanel panel = new JPanel();
                         
             JButton btnMostra = new JButton();
             
             //Pega largura e altura da tela 
            int larg = tamTela.width;  
            int alt = tamTela.height;

            if(op.equals("Apartamento")){
                try {
                    listaImoveisPorTipo.removeAll();
                    listaImoveisPorTipo.updateUI();
                    sel="";
                    
                    vecAImovel = ctrleImovel.getListaImoveisPorTipo(op);                    
                    for(Imovel i : vecAImovel){
//                        System.out.println(i.getCodigo());
    //                        file = new File(i.getArquivoFoto());
    //                        imgs = new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(50, 75, Image.SCALE_DEFAULT);

                        list.addElement(i.getCodigo());

                    }
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }

                lista.setModel(list);
                lista.setPreferredSize( new Dimension(400,300) );
                scrollPane.setViewportView(lista);

                btnMostra.setText("Detalhes");
                panel.add(scrollPane);
                panel.add(btnMostra);
                panel.setPreferredSize( new Dimension(larg,300) );

                listaImoveisPorTipo.add(panel);
                tiposImoveis.add(listaImoveisPorTipo, BorderLayout.CENTER);
                                               
                listaImoveisPorTipoCasa.setVisible(false);
                listaImoveisTipoLote.setVisible(false);
                listaImoveisTipoSalaComercial.setVisible(false);
                listaImoveisPropiedadeRural.setVisible(false);
                listaImoveisPorTipo.setVisible(true);
            }
            
            if(op.equals("Casa")){
                try {
                    listaImoveisPorTipoCasa.removeAll();
                    listaImoveisPorTipoCasa.updateUI();
                    sel="";
                    
                    
                    vecAImovel = ctrleImovel.getListaImoveisPorTipo(op);
                    for(Imovel i : vecAImovel){
//                        System.out.println(i.getCodigo());
    //                        file = new File(i.getArquivoFoto());
    //                        imgs = new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(50, 75, Image.SCALE_DEFAULT);

                        list.addElement(i.getCodigo());
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }

                lista.setModel(list);
                lista.setPreferredSize( new Dimension(400,300) );
                scrollPane.setViewportView(lista);

                btnMostra.setText("Detalhes");
                panel.add(scrollPane);
                panel.add(btnMostra);
                panel.setPreferredSize( new Dimension(larg,300) );

                listaImoveisPorTipoCasa.add(panel);
                tiposImoveis.add(listaImoveisPorTipoCasa, BorderLayout.CENTER);
                                
                listaImoveisPorTipo.setVisible(false);
                listaImoveisTipoLote.setVisible(false);
                listaImoveisTipoSalaComercial.setVisible(false);
                listaImoveisPropiedadeRural.setVisible(false);
                listaImoveisPorTipoCasa.setVisible(true);
            }
                        
            if(op.equals("Lote")){
                try {
                    listaImoveisTipoLote.removeAll();
                    listaImoveisTipoLote.updateUI();
                    sel="";
                    
                    vecAImovel = ctrleImovel.getListaImoveisPorTipo(op);
                    for(Imovel i : vecAImovel){
//                        System.out.println(i.getCodigo());
    //                        file = new File(i.getArquivoFoto());
    //                        imgs = new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(50, 75, Image.SCALE_DEFAULT);

                        list.addElement(i.getCodigo());
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }

                lista.setModel(list);
                lista.setPreferredSize( new Dimension(400,300) );
                scrollPane.setViewportView(lista);

                btnMostra.setText("Detalhes");
                panel.add(scrollPane);
                panel.add(btnMostra);
                panel.setPreferredSize( new Dimension(larg,300) );

                listaImoveisTipoLote.add(panel);
                tiposImoveis.add(listaImoveisTipoLote, BorderLayout.CENTER);
                                
                listaImoveisPorTipo.setVisible(false);
                listaImoveisPorTipoCasa.setVisible(false);
                listaImoveisTipoSalaComercial.setVisible(false);
                listaImoveisPropiedadeRural.setVisible(false);
                listaImoveisTipoLote.setVisible(true);
            }
            if(op.equals("Sala Comercial")){
                try {
                    listaImoveisTipoSalaComercial.removeAll();
                    listaImoveisTipoSalaComercial.updateUI();
                    
                    sel="";
                    
                    
                    vecAImovel = ctrleImovel.getListaImoveisPorTipo(op);
                    for(Imovel i : vecAImovel){
//                        System.out.println(i.getCodigo());
    //                        file = new File(i.getArquivoFoto());
    //                        imgs = new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(50, 75, Image.SCALE_DEFAULT);

                        list.addElement(i.getCodigo());
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }

                lista.setModel(list);
                lista.setPreferredSize( new Dimension(400,300) );
                scrollPane.setViewportView(lista);

                btnMostra.setText("Detalhes");
                panel.add(scrollPane);
                panel.add(btnMostra);
                panel.setPreferredSize( new Dimension(larg,300) );

                listaImoveisTipoSalaComercial.add(panel);
                tiposImoveis.add(listaImoveisTipoSalaComercial, BorderLayout.CENTER);
                                
                listaImoveisPorTipo.setVisible(false);
                listaImoveisPorTipoCasa.setVisible(false);
                listaImoveisTipoLote.setVisible(false);
                listaImoveisPropiedadeRural.setVisible(false);
                listaImoveisTipoSalaComercial.setVisible(true);
            }
            if(op.equals("Propriedade Rural")){
                try {
                    listaImoveisPropiedadeRural.removeAll();
                    listaImoveisPropiedadeRural.updateUI();
                    
                    vecAImovel = ctrleImovel.getListaImoveisPorTipo(op);
                    for(Imovel i : vecAImovel){
//                        System.out.println(i.getCodigo());
    //                        file = new File(i.getArquivoFoto());
    //                        imgs = new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(50, 75, Image.SCALE_DEFAULT);

                        list.addElement(i.getCodigo());
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }

                lista.setModel(list);
                lista.setPreferredSize( new Dimension(400,300) );
                scrollPane.setViewportView(lista);

                btnMostra.setText("Detalhes");
                panel.add(scrollPane);
                panel.add(btnMostra);
                panel.setPreferredSize( new Dimension(larg,300) );

                listaImoveisPropiedadeRural.add(panel);
                tiposImoveis.add(listaImoveisPropiedadeRural, BorderLayout.CENTER);
                                
                listaImoveisPorTipo.setVisible(false);
                listaImoveisPorTipoCasa.setVisible(false);
                listaImoveisTipoLote.setVisible(false);
                listaImoveisTipoSalaComercial.setVisible(false);
                listaImoveisPropiedadeRural.setVisible(true);
            }
           
            btnMostra.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                   int select = -1;                                                                            
                   select = lista.getSelectedIndex();
                                                         
                   if(select == -1){
                       JOptionPane.showMessageDialog(null, "É necessário selecionar um item antes","Atenção", JOptionPane.INFORMATION_MESSAGE);
                        return;
                   }
                   
//                   lista.addListSelectionListener(new ListSelectionListener() {
//                      
//                       @Override
//                       public void valueChanged(ListSelectionEvent e) {
                           sel = (String)lista.getSelectedValue().toString();
                           aux = Integer.parseInt(sel);
//                       }
//                   });
                                                        
                    System.out.println(op);
                    DetalhesImoveis det = null;
                    try {
                        det = new DetalhesImoveis(aux);
                    } catch (Exception ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    det.setVisible(true);
                    det.setSize(740, 300);
                    det.setLocationRelativeTo(null);
                    det.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            });
            
        }
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

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
