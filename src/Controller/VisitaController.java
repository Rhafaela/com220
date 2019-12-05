/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Comprador;
import Model.Corretor;
import Model.Visita;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author john
 */
public class VisitaController {
    String nomeDoArquivo = "visitas.dat";
    Visita c1;
    private ArrayList<Visita> visitaArr;
    
    public VisitaController(){
        this.visitaArr = new ArrayList<Visita>();
        //c1 = new Visita();
        try {
            this.lerDoArquivo();
            int a = 0;
        } catch (Exception e) {
            // could not read file
            System.out.println("Could not read visitas.dat");
        }
    }
    
    public Visita addVisita(Calendar pData, Comprador pCompr, Corretor pCorr) throws Exception {
        c1 = new Visita(pData, pCompr, pCorr);
        visitaArr.add(c1);
        try {
            this.salvarNoArquivo();
        } catch (Exception e) {
            System.out.println("\nNão pode salvar no arquivo\n");
            System.out.println(e.getMessage() + "\n");
            throw new Exception("Erro ao salvar.");
        }
        return c1;
    }
    
    public Visita getVisitaByIndex(int pIndex){
        return this.visitaArr.get(pIndex);
    }
    
    public List<Visita> getVisitas(){
        //
        return this.visitaArr;
    }
    
    public String[] getVisitasStringList(){
        String[] lst = new String[this.visitaArr.size()];
        int i = 0;
        for (i = 0; i < this.visitaArr.size(); i++){
            lst[i] = this.returnVisitaStr(this.visitaArr.get(i));
        }
        return lst;
    }
    
    public String returnVisitaStr(Visita pCom){
        String res = "";
        res = pCom.getData().toString() + " - " 
                + pCom.getComprador().getNome() + " - "
                + pCom.getCorretor().getNome() + "\n";
        return res;
    }
    
    public void removeVisita(int pIndex) throws Exception {
        this.visitaArr.remove(pIndex);
        try {
            this.salvarNoArquivo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Erro ao salvar.");
        }
    }
    
    public ArrayList<Visita> consultaPorPeriodo(Calendar pIni, Calendar pEnd){
        ArrayList<Visita> tmp = new ArrayList<Visita>();
        for(Visita el: this.visitaArr){
            if (el.getData().getTimeInMillis() >= pIni.getTimeInMillis() 
                    && el.getData().getTimeInMillis() <= pEnd.getTimeInMillis() ){
                tmp.add(el);
            }
        }
        return tmp;
    }
    
    public void editaVisita(int index, Visita pComp) throws Exception {
//        this.visitaArr.remove(index);
        this.visitaArr.set(index, pComp);
//        this.visitaArr.add(pComp);
        try {
            this.salvarNoArquivo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Erro ao editar.");
        }
    }
    
    public void salvarNoArquivo() throws Exception {
        try {
            FileOutputStream f = new FileOutputStream(new File(nomeDoArquivo));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(this.visitaArr);

            o.close();
            f.close();

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
            try (ObjectInputStream objIS = new ObjectInputStream(objFileIS)) {
                this.visitaArr = (ArrayList<Visita>) objIS.readObject();
                objIS.close();
            }
        }
        return;
    }
}
