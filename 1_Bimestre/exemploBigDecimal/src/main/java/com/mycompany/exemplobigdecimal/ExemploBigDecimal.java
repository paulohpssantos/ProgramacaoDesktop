/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exemplobigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 *
 * @author paulodossantos
 */
public class ExemploBigDecimal {

    public static void main(String[] args) {
        
        new FramePrincipal().setVisible(true);

        
        BigDecimal valor = new BigDecimal("1.0");
        
        //somar
        valor = valor.add(new BigDecimal("2.0"));
        System.out.println("Soma: "+valor);
        
        //subtrair
        valor = valor.subtract(new BigDecimal("2.0"));
        System.out.println("Subtrair: "+valor);
        
        //dividir
        valor = new BigDecimal("10");
        valor = valor.divide(new BigDecimal("2.0"));
        System.out.println("Divisão: "+valor);
        
        //Multiplicar
        valor = new BigDecimal("2");
        valor = valor.multiply(new BigDecimal("2.0"));
        System.out.println("Multiplicar: "+valor);
        
        //Compare
        //-1 = menor
        //0 = igual
        //1 = maior
        // >, <, >=, <=, ==
        valor = new BigDecimal("3");
        int compara = valor.compareTo(new BigDecimal("2"));
        System.out.println("Comparação: "+compara);
        
        //Retorna maior entre 2 números
        valor = new BigDecimal("2");
        BigDecimal max = valor.max(new BigDecimal("5"));
        System.out.println("Maior: "+ max);
        
        //Retorna menor entre 2 números
        valor = new BigDecimal("2");
        BigDecimal min = valor.min(new BigDecimal("5"));
        System.out.println("Menor: "+ min);
        
        //Potência
        BigDecimal potencia = valor.pow(2);
        System.out.println("Potencia: "+potencia);
        
        /************ Arredondamentos *************************/
        valor = new BigDecimal("111.5555555555");
        valor = valor.setScale(3, 
                RoundingMode.CEILING);
        System.out.println("CEILING: "+valor);
        
        valor = new BigDecimal("111.5555555555");
        valor = valor.setScale(3, 
                RoundingMode.DOWN);
        System.out.println("DOWN: "+valor);
        
        valor = new BigDecimal("111.5555555555");
        valor = valor.setScale(3, 
                RoundingMode.UP);
        System.out.println("UP: "+valor);
        
        
        valor = new BigDecimal("111.5555");
        valor = valor.setScale(3, 
                RoundingMode.HALF_UP);
        System.out.println("HALF_UP: "+valor);
        
        valor = new BigDecimal("111.5556 ");
        valor = valor.setScale(3, 
                RoundingMode.HALF_DOWN);
        System.out.println("HALF_DOWN: "+valor);
        
        
    }
}
