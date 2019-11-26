
package View;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener, WindowListener{
     Toolkit kit = Toolkit.getDefaultToolkit();  
     Dimension tamTela = kit.getScreenSize();  
    public Home(){
       
        super("Sistema de vendas");
        //Pega largura e altura da tela 
        int larg = tamTela.width;  
        int alt = tamTela.height;
        
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        
        
        /*Menu de Cadastrar */
        JMenu cadastro = new JMenu("Cadastrar");
        menu.add(cadastro);
        
        JMenuItem cadVendedor = new JMenuItem("Vendedor");
        JMenuItem cadCorretor = new JMenuItem("Corretor");
        JMenuItem cadCompador = new JMenuItem("Comprador");
        JMenuItem cadImovel = new JMenuItem("Imovel");
        
        cadastro.add(cadVendedor);
        cadastro.add(cadCorretor);
        cadastro.add(cadCompador);
        cadastro.add(cadImovel);
        
        /*Menu de Cadastrar */
        JMenu catalogo = new JMenu("Catalogo");
        menu.add(catalogo);
        
        /*Menu de Cadastrar */
        JMenu proposta_pend = new JMenu("Propostas Pendentes");
        menu.add(proposta_pend);
        
        
        
        cadCompador.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               CompradorAdd cv = new CompradorAdd();
               cv.setVisible(true);
               cv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        
        
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
