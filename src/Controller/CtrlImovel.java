
package Controller;

import Model.Corretor;
import Model.Imovel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CtrlImovel {
    private Imovel objAImovelEntidade;
    private ArrayList<Imovel> vecAImovel = new ArrayList();    
    private final String arquivo = "imovel.dat";
    
    public CtrlImovel() throws Exception{
        desserializeImovel();
    }
    
    public boolean cadImovel(int codigo, String tipo, String descricao, String arquivoFoto, Double preco, Double comissao, String dataInclusao, String vendedor) {
        objAImovelEntidade = new Imovel(codigo, tipo, descricao, arquivoFoto, preco, comissao, vendedor);
        
        addVetor(objAImovelEntidade);
        
         try {
            salvaImovel();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    
    public void addVetor(Imovel pImovel){
        vecAImovel.add(pImovel);
    }
    
    public void salvaImovel() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("imoveis.dat");
        try (ObjectOutputStream objOS = new ObjectOutputStream(objFileOS)) {
            objOS.writeObject(vecAImovel);
            objOS.flush();
            objOS.close();
        }
    }
    
     public String listaImoveis() throws Exception{
        String vet = "";
        vecAImovel = getListaImoveis();
        vet = "Código" + "t \t \t \t \t \t \t \t" + "Nome\n";
                
        for(int i =0; i < vecAImovel.size();i++){
            vet += vecAImovel.get(i).getCodigo()+ "\t \t \t \t \t \t \t \t" + vecAImovel.get(i).getTipo()+"\n";            
        }
 
        return vet;        
    }
    
                 
    private ArrayList desserializeImovel() throws Exception {        
        File objFile = new File("imoveis.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("imoveis.dat");
            try (ObjectInputStream objIS = new ObjectInputStream(objFileIS)) {
                vecAImovel = (ArrayList<Imovel>) objIS.readObject();
                objIS.close();
            }
        }
        return vecAImovel;
    } 
    
     public  ArrayList getListaImoveis() throws Exception{
        vecAImovel = desserializeImovel();
        return vecAImovel;
    }
     
    public boolean verificaCodigo(int cod) throws Exception{
        
        boolean possuiImovel = false;
        int codigo;
        
        vecAImovel = getListaImoveis();
        
        
        for (Imovel i : vecAImovel) {
            if(i.getCodigo() == cod){               
                possuiImovel = true;
                break;
            }
        }
                      
        return possuiImovel;
    }
}
