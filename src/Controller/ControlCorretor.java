package Controller;

import Model.Corretor;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControlCorretor {

    String nomeDoArquivo = "corretores.dat";
    private Corretor objACorretorEntidade;
    private String[] dadosForm;
    private ArrayList<Corretor> vecACorretor = new ArrayList();
    private ArrayList<Corretor> corretArr;

    public ControlCorretor() throws Exception {
        desserializeCorretor();
    }

    public boolean cadCorretor(String cpf, Double percentual, String nome, String email, String fone, String creci){
        //inserindo um corretor vazio e setando seuda dos posteriormente
        //cadastra();

        //Criando Objeto
        objACorretorEntidade = new Corretor(cpf,percentual, nome, email, fone, creci );

      // objACorretorEntidade.setCreci(dadosForm[4]);
    //   objACorretorEntidade.setPercCorretagem(Double.parseDouble(dadosForm[5]));

        addVetor(objACorretorEntidade);

        try {
            serializaCorretor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return true;

    }

    public void addVetor(Corretor pcorretor) {
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

    public String listaCorretores() throws Exception {
        String vet = "";
        vecACorretor = getListaCorretores();
        vet = "Código" + "t \t \t \t \t \t \t \t" + "Nome\n";

        String cpf;

        for (int i = 0; i < vecACorretor.size(); i++) {
            //vet += ValidarCPF.imprimeCPF(vecACorretor.get(i).getCpf()) + "\t \t \t \t \t \t \t \t" + vecACorretor.get(i).getNome() + "\n";

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

    public ArrayList getListaCorretores() throws Exception {
        vecACorretor = desserializeCorretor();
        return vecACorretor;
    }

    public Corretor getCorretorByIndex(int pIndex) {
        return this.vecACorretor.get(pIndex);
    }

    public List<Corretor> getCorretores() {
        //
        return this.corretArr;
    }

    public String[] getCorretoresStringList() {
        String[] lst = new String[this.corretArr.size()];
        int i = 0;
        for (i = 0; i < this.corretArr.size(); i++) {
            lst[i] = this.returnCorretorStr(this.corretArr.get(i));
        }
        return lst;
    }

    public String returnCorretorStr(Corretor pCorret) {
        String res = "";
        res = pCorret.getCpf() + " - " + pCorret.getNome() + " - "
                + pCorret.getFone() + " - " + pCorret.getEmail() + "\n";
        return res;
    }

    public void removeCorretor(int pIndex) throws Exception {
        this.corretArr.remove(pIndex);
        try {
            this.salvarNoArquivo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Erro ao salvar.");
        }
    }

    public void editaCorretor(int index, Corretor pCorret) throws Exception {
        this.corretArr.remove(index);
        this.corretArr.set(index, pCorret);
        this.corretArr.add(pCorret);
        try {
            this.salvarNoArquivo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Erro ao editar.");
        }
    }

    public void salvarNoArquivo() throws Exception {
        try {
            FileOutputStream f = new FileOutputStream(new File(nomeDoArquivo));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(this.corretArr);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }

        return;
    }

    public void lerDoArquivo() throws Exception {
        // le do arquivo os Vendedores
        File objFile = new File(this.nomeDoArquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(this.nomeDoArquivo);
            try (ObjectInputStream objIS = new ObjectInputStream(objFileIS)) {
                this.corretArr = (ArrayList<Corretor>) objIS.readObject();
                objIS.close();
            }
        }
        return;
    }

    public void finalize() throws Exception {
        serializaCorretor();
    }
}

