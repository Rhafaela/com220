package View;

import Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Relatorio4 /*extends JFrame implements ActionListener*/{

    /*private Imovel imovel;
    private Calendar dataInicial, dataFinal;
    private ArrayList<Visita> visitas;
    private Comprador comprador;
    private Corretor corretor;
    private Proposta propostas;*/
    
    /*private JFrame evtImovel;
    private JLabel dataI, dataF;
    private JTextField dtIni, dtFin;
    private JTextArea taRelatorio;
    private JPanel p1;*/

    private Calendar dataI, dataF;
    private Imovel codIm;
    private Corretor nomeCorr;
    private Comprador nomeCompr;
    private Proposta valorProp;
    private Proposta estadoP;
    private Visita visita;
    
    
   /* public Relatorio4() {
        /*JFrame evtImovel = new JFrame();
        evtImovel.setTitle("Eventos por Imóvel");
        JLabel dataI = new JLabel();
        dataI.setText("data inicial: "+dataInicial);
        JLabel dataF = new JLabel();
        dataI.setText("data inicial: "+dataFinal);
        JTextField dtIni = new JTextField();
        dtIni.addActionListener(this);
        this.dtIni.getToolTipText();
        JTextField dtFin = new JTextField();
        dtFin.addActionListener(this);
        this.dtFin.getToolTipText();
        JPanel p1 = new JPanel();
        this.evtImovel.setContentPane(this);
        JTextArea taRelatorio = new JTextArea();
        
        this.getContentPane().add(p1);
        this.getContentPane().add();*/
        
        //System.out.println("Entre com a data  inicial e final da consulta: \n");
       // System.out.println("Entre com o código do imóvel: \n");
        
   // }*/
    
    
    
    
    
    /*@Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    
    public Relatorio4(Calendar dataI, Calendar dataF, Imovel codIm) {
        this.dataI = dataI;
        this.dataF = dataF;
        this.codIm = codIm;
        
    }
    
    public void pegaDados(){
        System.out.println("Entre com o código do imovel: "+ codIm.getCodigo());
        System.out.println("Entre com a data inicial: "+ dataI.getTime());
        System.out.println("Entre com a data final: "+ dataF.getTime());
    }
    
    public void listaDados(){
        System.out.println("data da visita no imovel: "+ visita.getData());
        System.out.println("nome do corretor: "+ visita.getCorretor().getNome());
        System.out.println("nome do comprador: "+ visita.getComprador().getNome());
        System.out.println("proposta do comprador: "+ estadoP.getComprador());
        System.out.println("proposta recebida pelo corretor: "+ estadoP.getCorretor());
        System.out.println("valor da proposta: "+ estadoP.getValor());
        System.out.println("estado da proposta: "+ estadoP.getEstado());
    }
    
    public static void main(String[] args) {
        /*JFrame r = new Relatorio4();
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setVisible(true);*/
        //Relatorio2 r = new Relatorio4(23-02-2019,04-12-2019,1234);
    }
}
