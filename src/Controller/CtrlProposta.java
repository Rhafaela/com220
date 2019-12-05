package Controller;

import Model.Comprador;
import Model.Corretor;
import Model.Imovel;
import Model.Proposta;
import Model.Util;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CtrlProposta{

    private Proposta objAProposta;
    private ArrayList<Proposta> vecProposta = new ArrayList<>();
   

    public CtrlProposta() throws Exception {
        desserializeProposta();
    }
    
    public boolean cadProposta(Calendar data, Comprador omprador, Corretor corretor, Double valor){
        objAProposta = new Proposta(data, omprador, corretor, valor);
        
        addVetor(objAProposta);
        
        try {
            serializaCorretor();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    
      public void addVetor(Proposta pPropostas){
        vecProposta.add(pPropostas);
    }
    
    private void serializaCorretor() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("propostas.dat");
        try (ObjectOutputStream objOS = new ObjectOutputStream(objFileOS)) {
            objOS.writeObject(vecProposta);
            objOS.flush();
            objOS.close();
        }
    }
    
    public String lista() throws Exception{
        String vet = "";
        vecProposta = getListaPropostas();
        vet = "Código" + "t \t \t \t \t \t \t \t" + "Nome\n";
         String cpf;
                
        for(int i =0; i < vecProposta.size();i++){
            vet +=  vecProposta.get(i).getValor() + "\t \t \t \t \t \t \t \t \n";
        }
        return vet;
    }
    
     private ArrayList desserializeProposta() throws Exception {        
        File objFile = new File("propostas.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("propostas.dat");
            try (ObjectInputStream objIS = new ObjectInputStream(objFileIS)) {
                vecProposta = (ArrayList<Proposta>) objIS.readObject();
                objIS.close();
            }
        }
        return vecProposta;
    }
     
     public ArrayList getListaPropostas() throws Exception{
         vecProposta = desserializeProposta();
         return vecProposta;
     }
        
}

