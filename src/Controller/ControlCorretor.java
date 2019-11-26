package Controller;

import View.CorretorView;
import Model.Corretor;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControlCorretor {
    private CorretorView objACorretorLimite = new CorretorView();
    private Corretor objACorretorEntidade;
    private String[] dadosForm;
    private ArrayList<Corretor> vecACorretor = new ArrayList();    
    private final String arquivo = "corretor.dat";
    
    public ControlCorretor() throws Exception{
        desserializeCorretor();
    }
    
    public boolean cadCorretor(){
        //inserindo um corretor vazio e setando seuda dos posteriormente
        cadastra();
        //objACorretorEntidade = new Corretor(dadosForm[4], Double.parseDouble(dadosForm[5]), dadosForm[0], dadosForm[1], dadosForm[2], dadosForm[3]);
        
//        objACorretorEntidade.setNome(dadosForm[0]);
//        objACorretorEntidade.setCpf(dadosForm[1]);
//        objACorretorEntidade.setEmail(dadosForm[2]);
//        objACorretorEntidade.setFone(dadosForm[3]);
//        objACorretorEntidade.setCreci(dadosForm[4]);
//        objACorretorEntidade.setPercCorretagem(Double.parseDouble(dadosForm[5]));
        
//        addVetor(objACorretorEntidade);
        
        try {
            salvaCorretor();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    
    }
    
    private void cadastra(){
        dadosForm = objACorretorLimite.form();
    }
    
    public void addVetor(Corretor pcorretor){
        vecACorretor.add(pcorretor);
    }
    
    private void serializaDisciplina() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("corretores.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecACorretor);
        objOS.flush();
        objOS.close();
    }
     
    private void desserializeCorretor() throws Exception {
        File objFile = new File("corretores.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("corretores.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecACorretor = (ArrayList) objIS.readObject();
            objIS.close();
        }
    }
    
    public  ArrayList getListaCorretores(){
        return vecACorretor;
    }
    
    
     public void salvaCorretor() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("corretores.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecACorretor);
        objOS.flush();
        objOS.close();
    }
    
     public void finalize() throws Exception {
        serializaDisciplina();
    }
}
