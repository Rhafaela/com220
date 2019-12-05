package Controller;

import Model.Imovel;
import Model.Proposta;
import Model.Util;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CtrlProposta extends JFrame implements ListSelectionListener, ActionListener {

    private JList<Imovel> propostaSub;
    private Imovel imovel;
    private DefaultListModel<Imovel> propSub;
    private Proposta p;
    private JPanel JP;
    private JButton bAceita, bRejeita;
    private JLabel avalia = new JLabel("Avaliar Proposta");

    public CtrlProposta() {
        super("Propostas Submetidas");
        ArrayList proposta = imovel.getListaPropostas();
        JList propostaSub = new JList(propSub);
        propostaSub.addListSelectionListener(this);
        propSub.addElement((Imovel) proposta.iterator().next());
        /*if (imovel.aceitaProposta(p)) {
            this.imovel.getEstado().equals(Util.VENDIDO);
        } else {
            this.imovel.getEstado().equals(Util.REJEITADA);
        }*/

    }
    
    //setar componentes
     public void setarComponentes(){
        //JButton bAceitar;
        JButton bAceitar = new JButton("Aceitar");
        JButton bRejeitar = new JButton("Rejeitar");
        JOptionPane.showMessageDialog (null, "Atenção", " Proposta " + p.getEstado(), JOptionPane.INFORMATION_MESSAGE);
        JPanel JP = new JPanel();
        FlowLayout fl = new FlowLayout();
     }
     
     public void adicionaComponente(){
         this.add(this.bAceita);
         this.add(this.bRejeita);
         this.add(this.JP);
         this.add(this.avalia);
         //this.JP.getComponent(this.);
         
     }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            if (propostaSub.getSelectedIndex() != -1) {
                int index = propostaSub.getSelectedIndex();
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bAceita){
            imovel.aceitaProposta(p);
            this.imovel.getEstado().equals(Util.VENDIDO);
        }else{
            this.imovel.getEstado().equals(Util.REJEITADA);
        }
    }
}

