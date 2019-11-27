
package View;

import Controller.ControlCorretor;
import Controller.CtrlImovel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener, WindowListener{
    
    //Pegando tamanho em largura e altura da tela
    Toolkit kit = Toolkit.getDefaultToolkit();  
    Dimension tamTela = kit.getScreenSize();  
    
    private ControlCorretor ctrlCorretor;
    private CtrlImovel ctrleImovel;
    
    
    //METODO CONSTRUTOR
    public Home() throws Exception{
       
        super("Sistema de vendas");
        
        //Pega largura e altura da tela 
        int larg = tamTela.width;  
        int alt = tamTela.height;
        
        ctrlCorretor = new ControlCorretor();
        ctrleImovel = new CtrlImovel();
        
        /*------- MENU -------------*/
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        menu.setBackground(new java.awt.Color(204,204,255));
        menu.setBorder(null);
        menu.setPreferredSize(new java.awt.Dimension(56, 50));
        
        
        
        /*Menu de Cadastros */
        JMenu cadastro = new JMenu("Cadastrar");
        cadastro.setPreferredSize(new java.awt.Dimension(larg/3, alt/3));
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
        catalogo.setPreferredSize(new java.awt.Dimension(larg/3, alt/3));
        catalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/page_white_picture.png")));
        menu.add(catalogo);
        /*Fim Menu de Catalogo*/

        
        /*Menu de Propostas Pendentes */
        JMenu proposta_pend = new JMenu("Propostas Pendentes");
        proposta_pend.setPreferredSize(new java.awt.Dimension(larg/3, alt/3));
        proposta_pend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/money.png")));
        menu.add(proposta_pend);
        /*Fim Menu de Propostas Pendentes*/
        
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
        
        
        //Setando o JFrame
        this.setSize(larg,alt);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        System.exit(0);
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
