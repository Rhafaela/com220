/*
teste commit
 */
package Controller;

import Model.Comprador;
import java.io.EOFException;
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
 * @author Rhafaela
 * 
 */
public class CompradorController {
    
    String nomeDoArquivo = "compradores.dat";
    Comprador c1 = new Comprador("", "", "", "", "");
    private ArrayList<Comprador> comprArr;
    
    public CompradorController(){
        this.comprArr = new ArrayList<Comprador>();
        //c1 = new Comprador();
        try {
            this.lerDoArquivo();
            int a = 0;
        } catch (Exception e) {
            // could not read file
            System.out.println("Could not read compradores.dat");
        }
    }
    
    public Comprador addComprador(String pCpf, String pNome, 
            String pEmail, String pFone, String pContatoPref) throws Exception {
        c1 = new Comprador(pCpf, pNome, pEmail, pFone, pContatoPref);
        comprArr.add(c1);
        try {
            this.salvarNoArquivo();
        } catch (Exception e) {
            System.out.println("\nNão pode salvar no arquivo\n");
            System.out.println(e.getMessage() + "\n");
            throw new Exception("Erro ao salvar.");
        }
        return c1;
    }
    
    public List<Comprador> getCompradores(){
        //
        return this.comprArr;
    }
    
    public String[] getCompradoresStringList(){
        String[] lst = new String[this.comprArr.size()];
        int i = 0;
        for (i = 0; i < this.comprArr.size(); i++){
            lst[i] = this.returnCompradorStr(this.comprArr.get(i));
        }
        return lst;
    }
    
    public String returnCompradorStr(Comprador pCom){
        String res = "";
        res = pCom.getCpf() + "\t" + pCom.getNome() + "\t" + pCom.getFone() + "\n";
        return res;
    }
    
    public void removeComprador(){
        
    }
    
    public void salvarNoArquivo() throws Exception {
        try {
            FileOutputStream f = new FileOutputStream(new File(nomeDoArquivo));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(this.comprArr);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        
        return;
    }
    
    public void lerDoArquivo() throws Exception {
        // le do arquivo os compradores
        File objFile = new File(this.nomeDoArquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(this.nomeDoArquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            for (;;) {
                try {
                    this.c1 = (Comprador) objIS.readObject();
                    this.comprArr.add(this.c1);
                }
                catch (EOFException exc) {
                    break;
                }
            }
            
            objIS.close();
        }
    }
    
    
    //
    public void addTipoImovel(String tipoImovel) throws Exception {
        c1.addTipoImovel(tipoImovel);
    }

    public boolean removeTipoImovel(String tipoImovel) throws Exception {
        boolean res = c1.removeTipoImovel(tipoImovel);
        return res;
    }
    
    
}
