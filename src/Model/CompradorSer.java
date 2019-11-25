/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Rhafaela
 */
public class CompradorSer extends Comprador implements Serializable {
    
    public CompradorSer(String cpf, String nome, String email, String fone,
            String contatoPref) {
        super(cpf, nome, email, fone, contatoPref);
    }
    
}
