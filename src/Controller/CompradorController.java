/*
 */
package Controller;

import Model.CompradorSer;
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
    
    static final String nomeDoArquivo = "compradores.dat";
    CompradorSer c1;
    private ArrayList<CompradorSer> comprArr;
    
    public CompradorController(){
        comprArr = new ArrayList<CompradorSer>();
        //c1 = new CompradorSer();
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
    
    public List<CompradorSer> consultaCompradores(){
        comprArr.clear();
        this.lerDoArquivo();
        // lerDoArquivo escreve na variavel comprArr
        return comprArr;
    }
    
    public CompradorSer consultaComprador(){
        comprArr.clear();
        this.lerDoArquivo();
        
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

            o.flush();
            o.close();

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
    
    public void lerDoArquivo(){
//        try {
//            FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
//            ObjectInputStream in = new ObjectInputStream(arquivo);
//            String res = in.readObject().toString();
////            comprArr = (ArrayList<CompradorSer>) in.readObject();
//            in.close();
//        } catch (Exception ex) {
//            comprArr.clear();
//        }
        
        try {
            FileInputStream fi = new FileInputStream(new File(nomeDoArquivo));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            CompradorSer pr1 = (CompradorSer) oi.readObject();

            System.out.println(pr1.toString());

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
