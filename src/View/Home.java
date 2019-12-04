
package View;

import Controller.ControlCorretor;
import Controller.ControleVendedor;
import Controller.CtrlImovel;
//import com.sun.prism.image.Coords;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Home extends JFrame implements ActionListener, WindowListener{
    
    //Pegando tamanho em largura e altura da tela
    Toolkit kit = Toolkit.getDefaultToolkit();  
    Dimension tamTela = kit.getScreenSize();  
    
    private ControleVendedor ctrlVendedor;
    private ControlCorretor ctrlCorretor;
    private CtrlImovel ctrleImovel;
        
    //Painel na pagina inicial de Teste Leitura dos corretores
    private final JPanel painel = new JPanel(new GridBagLayout());
    private final JTextArea resultado = new JTextArea(5, 10);
    
    //METODO CONSTRUTOR
    public Home() throws Exception{
       
        super("Sistema de vendas");
        
        //Pega largura e altura da tela 
        int larg = tamTela.width;  
        int alt = tamTela.height;
        
        ctrlCorretor = new ControlCorretor();
        ctrleImovel = new CtrlImovel();
        
//Mostra resultados dos corretores (teste)
        resultado.setEditable(false);
        String c = ctrlCorretor.listaCorretores();
        String i = ctrleImovel.listaImoveis();
        resultado.setText(c);
        adicionarComponente(painel, resultado, 0, 1, 1, 1);
        this.add(painel);        
//        setLayout(new FlowLayout());
//        textArea = new JTextArea(5,10);
//        textArea.setPreferredSize(new java.awt.Dimension(larg/2, alt/2));
//        add(textArea);
                
/**** ---------- FIM MOSTRA TESTE *-----------------------*/
        
        
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
        cadVendedor.setPreferredSize(new java.awt.Dimension(larg/(4), 20));
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
        
        
        //Setando o JFrame
        this.setSize(larg,alt);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    

    @Override
    public void windowClosed(WindowEvent e) {
//        try {
//            ctrlCorretor.finalize();
//        } catch (Exception ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.exit(0);
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
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowOpened(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
