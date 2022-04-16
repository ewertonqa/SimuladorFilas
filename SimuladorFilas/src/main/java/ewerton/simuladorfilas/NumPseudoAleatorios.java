
package ewerton.simuladorfilas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Scanner;

/**
 *
 * @author Ewerton
 */
public class NumPseudoAleatorios {
    int a,m,c,x0;
    
   
    public NumPseudoAleatorios(int a, int m, int c, int x0) {
        this.a = a;
        this.m = m;
        this.c = c;
        this.x0 = x0;
    }
    public ArrayList<Double >gerador(){
        ArrayList<Double> res = new ArrayList<Double>();
        double xi,xa,ui;
        xi = x0;
        xa = x0;
        ui = xi/m;
        for(int i=0;i<1000;i++){
            res.add(ui);
            xi = (a*xa+c)% m;
            ui = xi/m;
            xa=xi;
            
            //System.out.print(xi+" , ");
        }
        
        return res;
    }
     public static void main(String[] args)throws IOException{
        NumPseudoAleatorios npa = new NumPseudoAleatorios(1140671485, 16777216, 12820163, 0);
        List<Double> numList =  npa.gerador();

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("numerosAleatorios.txt"));
        for(int i=0;i<numList.size();i++){
            System.out.print(numList.get(i)+" , ");
            buffWrite.append(numList.get(i) + "\n");
        }
        buffWrite.close();
    }
    

    
}