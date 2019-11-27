package Controller;

import View.CompradorView;
import View.CorretorView;
import View.MainView;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import javax.swing.JOptionPane;

public class ControlPrincipal {
    int op = -1;
    private MainView objPrincipalLimite;
    private ControlCorretor objAControlCorretor;
    private CorretorView  objACorretorLimite;

    public ControlPrincipal() {
        objPrincipalLimite = new MainView();
        try{
            objAControlCorretor = new ControlCorretor();
        }catch(Exception  e){
            System.out.println("Erro na abertura de arquivo");
        }
    }

    public ControlCorretor getObjAControlCorretor() {
        return objAControlCorretor;
    }

    public void run(){
        while(true){
            op = objPrincipalLimite.menu();
             
            switch (op) {
                case 1:
                    cadCorretor();
                    break;
                case 2:
                   JOptionPane.showMessageDialog(null, "Escolheu Cadastrar Vendedor");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Escolheu Cadastrar Comprador");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Escolheu Cadastrar Imóvel");
                    break;
                case 5:
                    listaCorretor();
                break;
                case 6:
                    finalize();
            }                                   
        }
    }
    
    private boolean cadCorretor(){
        return false;
        //return objAControlCorretor.cadCorretor(String cpf, String nome, String email, String fone, String creci, Double percentual);
    }
        
    private boolean listaCorretor(){
        return objACorretorLimite.mostraCorretores();
    }
    public void finalize(){
        System.exit(0);
    }
}
