
package View;

import javax.swing.*;

public class CorretorView {

   public String[] form(){
       String dadosForm[] = new String[6];
       
       dadosForm[0] = JOptionPane.showInputDialog("Digite Nome do Corretor");
       dadosForm[1] = JOptionPane.showInputDialog("Digite o CPF do Corretor");
       dadosForm[2] = JOptionPane.showInputDialog("Digite o E-mail do Corretor");
       dadosForm[3] = JOptionPane.showInputDialog("Digite o Telefone do Corretor");
       dadosForm[4] = JOptionPane.showInputDialog("Digite o CRECI do Corretor"); 
       dadosForm[5] = JOptionPane.showInputDialog("Digite a porcentagem de venda do corretor");
       
       return dadosForm;
   }
    
   public boolean  mostraCorretores(){
        return true;
   }
}
