package Model;

import java.io.Serializable;

public class Corretor extends Pessoa implements Serializable{
    private String creci;
    private double percCorretagem;
          
    public Corretor(String creci, double percCorretagem, String cpf, String nome, String email, String fone) {
        super(cpf, nome, email, fone);
        this.creci = creci;
        this.percCorretagem = percCorretagem;
   }
       
    public void setPercCorretagem(double percCorretagem) {
        this.percCorretagem = percCorretagem;
    }
    public void setCreci(String creci) {
        this.creci = creci;
    }

    public double getPercCorretagem() {
        return percCorretagem;
    }
    public String getCreci() {
        return creci;
    }
}
