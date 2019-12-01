package Controller;

import Model.Corretor;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControlCorretor {    
    private Corretor objACorretorEntidade;
    private String[] dadosForm;
    private ArrayList<Corretor> vecACorretor = new ArrayList();    
    private final String arquivo = "corretor.dat";
    
    public ControlCorretor() throws Exception{
        desserializeCorretor();
    }
    
    public boolean cadCorretor(String cpf, String nome, String email, String fone, String creci, Double percentual){
        //inserindo um corretor vazio e setando seuda dos posteriormente
        //cadastra();
        
        //Criando Objeto
        objACorretorEntidade = new Corretor(creci, percentual, cpf, nome, email, fone);
        
//        objACorretorEntidade.setNome(dadosForm[0]);
//        objACorretorEntidade.setCpf(dadosForm[1]);
//        objACorretorEntidade.setEmail(dadosForm[2]);
//        objACorretorEntidade.setFone(dadosForm[3]);
//        objACorretorEntidade.setCreci(dadosForm[4]);
//        objACorretorEntidade.setPercCorretagem(Double.parseDouble(dadosForm[5]));
        
        addVetor(objACorretorEntidade);
        
        try {
            serializaCorretor();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    
    }
    
    public void addVetor(Corretor pcorretor){
        vecACorretor.add(pcorretor);
    }
    
    private void serializaCorretor() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("corretores.dat");
        try (ObjectOutputStream objOS = new ObjectOutputStream(objFileOS)) {
            objOS.writeObject(vecACorretor);
            objOS.flush();
            objOS.close();
        }
    }
       
     public String listaCorretores() throws Exception{
        String vet = "";
        vecACorretor = getListaCorretores();
        vet = "Código" + "t \t \t \t \t \t \t \t" + "Nome\n";
         String cpf;
                
        for(int i =0; i < vecACorretor.size();i++){
            vet += ValidarCPF.imprimeCPF(vecACorretor.get(i).getCpf()) + "\t \t \t \t \t \t \t \t" + vecACorretor.get(i).getNome() +"\n";
        }
        return vet;
    }
    
    private ArrayList desserializeCorretor() throws Exception {        
        File objFile = new File("corretores.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("corretores.dat");
            try (ObjectInputStream objIS = new ObjectInputStream(objFileIS)) {
                vecACorretor = (ArrayList<Corretor>) objIS.readObject();
                objIS.close();
            }
        }
        return vecACorretor;
    }
    
    public  ArrayList getListaCorretores() throws Exception{
        vecACorretor = desserializeCorretor();
        return vecACorretor;
    }
                   
     public void finalize() throws Exception {
//        serializaCorretor();
    }
}
