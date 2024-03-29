
package View;

import Controller.CompradorController;
import Controller.ControlCorretor;
import Controller.ControleVendedor;
import Controller.CtrlProposta;
import Model.Comprador;
import Model.Corretor;
import Model.Vendedor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ViewProposta extends JFrame implements ActionListener{
    private ArrayList<Comprador> vecComprador = new ArrayList<>();
    private ArrayList<Corretor> vecCorretor = new ArrayList<>();
    
    private CtrlProposta proposta = new CtrlProposta();
    
    private CompradorController ctrolComprador = new CompradorController();
    private ControlCorretor ctrolCorretor;
    
    private JComboBox comboBoxComprador = new JComboBox();
    private JComboBox comboBoxCorretor = new JComboBox();
    
  
    Calendar hoje = Calendar.getInstance();
    
    int codigo;
    
    private JButton b1;
    private JTextField tf1;
    private JTextField tf2;
    
    private JLabel jl1;
    private JLabel jl2;
    private JLabel jl3;
   
    
    private JPanel panel;

    //Pegando tamanho em largura e altura da tela
    Toolkit kit = Toolkit.getDefaultToolkit();  
    Dimension tamTela = kit.getScreenSize();  
    
    
    public ViewProposta(int cod) throws Exception {
        this.codigo = cod;
        this.ctrolCorretor = new ControlCorretor();
        
//Pega largura e altura da tela 
        int larg = tamTela.width;  
        int alt = tamTela.height;
        
        
        vecComprador = (ArrayList<Comprador>) this.ctrolComprador.getCompradores();
        vecCorretor =  ctrolCorretor.getListaCorretores();
        
        comboBoxComprador.setPreferredSize(new Dimension(250, 20));
        comboBoxCorretor.setPreferredSize(new Dimension(250, 20));
        
        jl2 = new JLabel("Comprador: ");
        jl3 = new JLabel("Corretor: ");
        
//        for(Comprador v : vecComprador){
//            comboBoxComprador.addItem(v.getNome());
//        }
        
        for(Corretor c : vecCorretor){
            comboBoxCorretor.addItem(c.getNome());
        }
        
        //CONTINUAR DAQUI AMANHA CONSIGO A DATA, SÓ PRECISO SALVAR ELA NO BACK
        
        //ISSO AKI EH TESTE
//        int ano = hoje.get(Calendar.YEAR);
//        int mes = hoje.get(Calendar.MONTH);
//        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        
        //TESTE
//        String str = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(ano);
        
        //criando e setando atributos de b1
        b1 = new JButton("Enviar");        
        b1.setEnabled(true);        
        b1.addActionListener(this);
        
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT,30,40));

        //criando e setando atributos de tf1
        tf1 = new JTextField();
        tf1.setPreferredSize(new Dimension(250, 25));
        
        tf2 = new JTextField();
        tf2.setPreferredSize(new Dimension(250, 25));
        
        jl1 = new JLabel("Valor: " +tf1.getText()+" ");
        
//        JTextField ho = new JTextField();
//        JLabel hoP = new JLabel("Horas: ");
//        ho.setPreferredSize(new Dimension(250, 25));                        
//        ho.setText(str);
        
        panel.add(jl1);
        panel.add(tf1);
        panel.add(jl2);
//        panel.add(comboBoxComprador);
        panel.add(tf2);
        panel.add(jl3);
        panel.add(comboBoxCorretor);
//        panel.add(hoP); //TESTE
//        panel.add(ho); //TESTE        
        panel.add(b1);
        
        this.add(panel);
        
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1){       
            String preco = tf1.getText();
            String nomeComprador = tf2.getText();
            String nomeCorretor = (String) comboBoxCorretor.getSelectedItem();
            Corretor cor = null;
            boolean possuiComp = false;
            
            Double pre = Double.parseDouble(preco);
            
            //pegando o corretor
            for(Corretor co : vecCorretor){
                if(co.getNome().equals(nomeCorretor)){
                    cor = co;
                }
            }
            
            for(Comprador c : vecComprador){
                if(c.getNome().equals(nomeComprador)){
                    
                    proposta.cadProposta(hoje, c, cor, pre);
                    JOptionPane.showMessageDialog(this, "Proposta feita com sucessos!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    dispose();    
                    possuiComp = true;
                    break;
                }
            }
            
            if(!possuiComp){
                JOptionPane.showMessageDialog(this, "Cadastre um Comprador Primeiro!","Erro", JOptionPane.ERROR_MESSAGE);
                    dispose();
                    
                    int larg = tamTela.width;  
                    int alt = tamTela.height;

                    CompradorAdd cv = new CompradorAdd();
                    cv.setVisible(true);
                    cv.setSize(larg/2, alt/2);
                    cv.setLocationRelativeTo(null);
                    cv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
            }
            
            
//            JOptionPane.showMessageDialog(null, "proposta Enviada para imovel"+ codigo);
//            dispose();
        }
    }
    
//    public static void main(String[] args) {
//        JFrame janela = new ViewProposta();
//        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        janela.setVisible(true);
//        
//        
//    }

}

