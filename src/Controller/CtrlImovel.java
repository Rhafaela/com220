
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
        desserializeCorretor();
    }
    
    public boolean cadImovel(int codigo, String tipo, String descricao, String arquivoFoto, String estado, Double preco, Double comissao, String dataInclusao, String vendedor) {
        objAImovelEntidade = new Imovel(codigo, tipo, descricao, arquivoFoto, estado, preco, comissao, vendedor);
        
         try {
            salvaImovel();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    
    private void desserializeCorretor() throws Exception {
        File objFile = new File("imoveis.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("imoveis.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecAImovel = (ArrayList) objIS.readObject();
            objIS.close();
        }
    }
     
     public void salvaImovel() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("imoveis.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecAImovel);
        objOS.flush();
        objOS.close();
    }

    
    
}
