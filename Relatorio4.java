package View;

import Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import java.util.*;
import javax.swing.event.CaretListener;


public class Relatorio4 extends JFrame implements ActionListener{

    private Imovel imovel;
    private Calendar dataInicial, dataFinal;
    private ArrayList<Visita> visitas;
    private Comprador comprador;
    private Corretor corretor;
    private Proposta propostas;
    
    private JFrame evtImovel;
    private JLabel dataI, dataF, codIm;
    private JTextField dtIni, dtFin;
    private JTextArea taRelatorio;
    private JPanel p1;
 
    
   public Relatorio4() {
        JFrame evtImovel = new JFrame();
        evtImovel.setTitle("Eventos por Imóvel");
        JLabel dataI = new JLabel("data INICIAL: ");
        dataI.setText("data inicial: "+dataInicial);
        JLabel dataF = new JLabel("data FINAL: ");
        dataI.setText("data final: "+dataFinal);
        JTextField dtIni = new JTextField();
        dtIni.addActionListener(this);
        this.dtIni.getToolTipText();
        JTextField dtFin = new JTextField();
        dtFin.addActionListener(this);
        this.dtFin.getToolTipText();
        JLabel codIm = new JLabel("código do imóvel: ");
        dataI.setText("código do imóvel: "+this.codIm);
       // this.codIm.addActionListener(this);
        this.codIm.getToolTipText();
        JPanel p1 = new JPanel();
        this.evtImovel.setContentPane(this);
        JTextArea taRelatorio = new JTextArea();
        
        //public void montarLayout(){
            this.getContentPane().setLayout(new FlowLayout());
            this.getContentPane().add(this.p1);
            this.getContentPane().add(this.dataF);
            this.getContentPane().add(this.dataF);
            this.getContentPane().add(this.dataF);
            this.getContentPane().add(this.dtIni);
            this.getContentPane().add(this.dtFin);
            this.getContentPane().add(this.taRelatorio);
            this.dtIni.addActionListener(this);
            this.dtIni.addActionListener(this);
        //}
               
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //if (e.getSource() == this.imovel.getCodigo()) {
            if (e.getSource() == this.dtIni) {
                if (e.getSource() == this.dtIni) {
                    int d1 = this.imovel.getCodigo();
                    ArrayList lp = this.imovel.getListaPropostas();
                    ArrayList lv = this.imovel.getListaVisitas();
                    String cp = this.comprador.getNome();
                    String cr = this.corretor.getNome();
                    double pp = this.propostas.getValor();
                    String est = this.propostas.getEstado();
                    String s = "Relatório: \n" + this.taRelatorio.getText()+ " \n"+d1+" \n"+lp
                            +" \n"+lv+" \n"+cp+" \n"+cr+" \n"+pp+" \n"+est;
                    JOptionPane.showMessageDialog(null, s, "Relatório", JOptionPane.INFORMATION_MESSAGE);
                }
            }
      //  }
    }
   
    
    public static void main(String[] args) {
        JFrame r = new Relatorio4();
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setVisible(true);
        
    }
}
