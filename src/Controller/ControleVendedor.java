
/*
teste commit
 */
package Controller;

import Model.Vendedor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anthony
 *
 */
public class ControleVendedor {

    String nomeDoArquivo = "vendedores.dat";
    Vendedor v1 = new Vendedor("", "", "", "", "");
    private ArrayList<Vendedor> vendArr;

    public ControleVendedor() {
        this.vendArr = new ArrayList<Vendedor>();
        //v1 = new Vendedor();
        try {
            this.lerDoArquivo();
            int a = 0;
        } catch (Exception e) {
            // could not read file
            System.out.println("Could not read compradores.dat");
        }
    }


      public Vendedor addVendedor(String pCpf, String pNome,
            String pEmail, String pFone, String pContatoPref) throws Exception {
        v1 = new Vendedor(pCpf, pNome, pEmail, pFone, pContatoPref);
        vendArr.add(v1);
        try {
            this.salvarNoArquivo();
        } catch (Exception e) {
            System.out.println("\nNão pode salvar no arquivo\n");
            System.out.println(e.getMessage() + "\n");
            throw new Exception("Erro ao salvar.");
        }
        return v1;
    }

    public Vendedor getVendedorByIndex(int pIndex) {
        return this.vendArr.get(pIndex);
    }

    public List<Vendedor> getVendedores() {
        //
        return this.vendArr;
    }

    public String[] getVendedoresStringList() {
        String[] lst = new String[this.vendArr.size()];
        int i = 0;
        for (i = 0; i < this.vendArr.size(); i++) {
            lst[i] = this.returnVendedorStr(this.vendArr.get(i));
            
        }
        return lst;
    }

    public String returnVendedorStr(Vendedor pVend) {
        String res = "";
        res = pVend.getCpf() + " - " + pVend.getNome() + " - "
                + pVend.getFone() + " - " + pVend.getContatoPref() + "\n";
        return res;
    }

    public void removeVendedor(int pIndex) throws Exception {
        this.vendArr.remove(pIndex);
        try {
            this.salvarNoArquivo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Erro ao salvar.");
        }
    }

    public void editaVendedor(int index, Vendedor pVend) throws Exception {
//        this.vendArr.remove(index);
        this.vendArr.set(index, pVend);
//        this.vendArr.add(pvend);
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
            o.writeObject(this.vendArr);

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
                this.vendArr = (ArrayList<Vendedor>) objIS.readObject();
                objIS.close();
            }
        }
        return;
    }

    //

    public void cadVendedor(String cpf, String nome, String email, String fone, String contatoPref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

