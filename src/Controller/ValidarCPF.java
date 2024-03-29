package Controller;

import java.util.InputMismatchException;

public class ValidarCPF {
    public static boolean isCPF(String CPF){
        
        if(CPF.length() != 11)
            return false;
        
        char dig10, dig11;
        int sm, i, r, num, peso;
        
        
        try{
            sm = 0;
            peso = 10;
            
            for(i = 0; i<9; i++){
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num*peso);
                peso = peso - 1;
            }
            
            r = 11 - (sm % 11);
            if((r == 10) || (r == 11)){
                dig10 = '0';
            } else {
                dig10 = (char)(r + 48);
            }
            
            sm = 0;
            peso = 11;
            for(i=0; i < 10; i++){
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num*peso);
                peso = peso - 1;
            }
            
            r = 11 - (sm % 11);
            if((r == 10) || (r == 11)){
                dig11 = '0';
            } else {
                dig11 = (char)(r + 48);
            }
            
            if(dig10 == CPF.charAt(9) && dig11 == CPF.charAt(10)){
                return true;
            }else{
                return false;
            }
        }catch(InputMismatchException e){
            return false;
        }
    }
    
    public static String imprimeCPF(String CPF){
        return (CPF.substring(0,3) + "." + CPF.substring(3,6) + "." + CPF.substring(6,9) + "-" + CPF.substring(9,11));
    }
    
}
