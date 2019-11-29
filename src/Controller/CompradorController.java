/*
teste commit
 */
package Controller;

import Model.CompradorSer;
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
    CompradorSer c1 = new CompradorSer("", "", "", "", "");
    private ArrayList<CompradorSer> comprArr;
    
    public CompradorController(){
        this.comprArr = new ArrayList<CompradorSer>();
        //c1 = new CompradorSer();
        try {
            this.lerDoArquivo();
            int a = 0;
        } catch (Exception e) {
            // could not read file
            System.out.println("Could not read compradores.dat");
        }
    }
    
    public CompradorSer addComprador(CompradorSer comParam){
        c1 = new CompradorSer(c1.getCpf(), c1.getNome(),
            c1.getEmail(), c1.getFone(), c1.getContatoPref());
        try {
            this.salvarNoArquivo();
        } catch (Exception e) {
            System.out.println("\nNão pode salvar no arquivo\n");
        }
        
        return c1;
    }
    
    public CompradorSer addComprador(String pCpf, String pNome, 
            String pEmail, String pFone, String pContatoPref){
        c1 = new CompradorSer(pCpf, pNome, pEmail, pFone, pContatoPref);
        comprArr.add(c1);
        try {
            this.salvarNoArquivo();
        } catch (Exception e) {
            System.out.println("\nNão pode salvar no arquivo\n");
        }
        return c1;
    }
    
    public CompradorSer consultaComprador(){
        comprArr.clear();
//        this.lerDoArquivo();
        
        return null;
    }
    
    public void removeComprador(){
        
    }
    
    public void salvarNoArquivo() throws Exception {
//        try {
//            FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
//            ObjectOutputStream out = new ObjectOutputStream(arquivo);
//            out.writeObject(c1);
//            out.flush();
//            out.close();
//            arquivo.close();
//        } catch (Exception exc) {
//            throw new Exception("Arquivo Compradores não encontrado!");
//        }

            try {
            FileOutputStream f = new FileOutputStream(new File(nomeDoArquivo));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(c1);

            o.close();
            f.close();

//            FileInputStream fi = new FileInputStream(new File(nomeDoArquivo));
//            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
//            Person pr1 = (Person) oi.readObject();
//            Person pr2 = (Person) oi.readObject();

//            System.out.println(c1.toString());
//
//            oi.close();
//            fi.close();

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
                    this.c1 = (CompradorSer) objIS.readObject();
                    this.comprArr.add(this.c1);
                }
                catch (EOFException exc) {
                    break;
                }
            }
//            this.comprArr = (ArrayList) objIS.readObject();
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
