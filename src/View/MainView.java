
package View;
import javax.swing.*;

public class MainView {
    public int menu(){
        int op = -1;
        String escolha = "";
        
        do{
            try{
                escolha = JOptionPane.showInputDialog(
                    "Escolha uma opção do menu:\n"
                    + "[1] Cadastro de Corretor\n"
                    + "[2] Cadastro de Vendedor\n"
                    + "[3] Cadastro de Comprador\n"
                    + "[4] Cadastro de Imóvel\n" 
                    + "[5] Listar Corretor\n"                    
                    + "[6] Finaliza"
                );                               
                op = Integer.parseInt(escolha); 
                
            }catch(Exception exc){                
                JOptionPane.showMessageDialog(null, "Pressione a opção de Finalizar para encerrar o Programa", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }while((op < 1) || (op > 6));
        
        return op;
        
    }
}
