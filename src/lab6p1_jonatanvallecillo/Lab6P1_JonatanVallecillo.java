package lab6p1_jonatanvallecillo;

import java.util.Random;
import java.util.Scanner;

public class Lab6P1_JonatanVallecillo {

    static Scanner leer = new Scanner(System.in);
    static Scanner leer1 = new Scanner(System.in);
    static Random rand = new Random();
    
    public static void main(String[] args) {
        int menu = 1;
        int opcion = 0;
        while(menu == 1){
            System.out.print("****** MENU ******\n"
                    + "1. Indice de balance\n"
                    + "2. Alternados\n"
                    + "3. Torneo de pelea\n"
                    + "4. Salir\n"
                    + "Ingerese la opcion que desea: ");
            opcion = leer.nextInt();
            
            if(opcion > 0 && opcion < 5){
                menu = 0;
            }
        }
        
        switch(opcion){
            case 1:
                System.out.print("Ingrese el tamano del array: ");
                int tamaño = leer.nextInt();
                int [] arreglo = arreglo(tamaño);
                imprimir(arreglo);
                int [] parametros = parametros(arreglo);
                System.out.println("\nEl punto de equilibrio esta en el index       "+parametros[2]+"(#"+parametros[3]+")");
                System.out.println("Porque la suma en la izquierda es "+parametros[0]+" y en la derecha es "+parametros[1]+".");
                break;
            case 3:
                Torneo();
                break;
        }
    }
    
    public static int [] arreglo(int tamaño){
        int [] arreglo = new int [tamaño];
        for(int i = 0; i < tamaño; i++){
            arreglo[i] = rand.nextInt(100);
        }
        return arreglo;
    }
    
    public static void imprimir(int [] arreglo){
        System.out.print("Array generado:                               [");
        for(int i = 0; i < arreglo.length; i++){
            if (i == arreglo.length - 1){
                System.out.print(arreglo[i]);
            }else{
                System.out.print(arreglo[i]+",");
            }
        }
        System.out.print("]");
    }
    
    public static int [] parametros(int [] arreglo){
        int cont1 = 0;
        int cont2 = 0;
        int puntodequi = 0;
        int puntodequi2 = 0;
        int indice = 0;
        int elemento = 0;
        int iz = 0;
        int der = 0;
        int [] parametros = new int [4];
        for(int i = 0; i < arreglo.length; i++){
            cont1 = 0;
            cont2 = 0;
            for(int j = 0; j < arreglo.length; j++){
                if(i - 1 >= 0 && i != arreglo.length - 1){
                    if(j < i){
                        cont1 += arreglo[j];
                    }else if(j > i){
                        cont2 += arreglo[j];
                    }
                }
            }
            
            
            puntodequi = cont1 - cont2;
            if(puntodequi < 0){
                puntodequi *= -1;
            }
            
            if ((puntodequi < puntodequi2 || i == 1) && i < arreglo.length - 1){
                puntodequi2 = puntodequi;
                indice = i;
                elemento = arreglo[i];
                iz = cont1;
                der = cont2;
                parametros[0] = iz;
                parametros[1] = der;
                parametros[2] = indice;
                parametros[3] = elemento;
            }
        }
        
        return parametros;
    }
    
    public static void Torneo(){
        String [] nombres = new String[8];
        int [] vid = new int [8];
        nombres[0] = "Diego";
        nombres[1] = "Darian";
        nombres[2] = "Carlos";
        nombres[3] = "Hector";
        nombres[4] = "Josue";
        nombres[5] = "Daniel";
        nombres[6] = "Andre";
        nombres[7] = "Victor";
        
        vid[0] = nombres[0].length();
        vid[1] = nombres[1].length();
        vid[2] = nombres[2].length();
        vid[3] = nombres[3].length();
        vid[4] = nombres[4].length();
        vid[5] = nombres[5].length();
        vid[6] = nombres[6].length();
        vid[7] = nombres[7].length();
        
        int contador = 8;
        int rondas = 1;
        String nom1 = "";
        String nom2 = "";
        
        while(contador > 1){
            System.out.println("Round "+rondas+"\n"
                    + "------------------------");
            for(int i = 0; i < nombres.length; i+= 2){
                nom1 = nombres[i];
                char carac1 = ' ';
                char carac2 = ' ';
                int cont = 0;
                int cont2 = 0;
                int ataque1 = 0;
                int ataque2 = 0;
                for(int w = 0; w < nom1.length(); w++){
                    carac1 = nom1.charAt(i);
                    for(int v = 0; v < nom1.length(); v++){
                        carac2 = nom1.charAt(i);
                        if(carac1 == carac2){
                            cont ++;
                        }
                    }
                }
                ataque1 = cont;
                
                nom2 = nombres[i+1];
                for(int w = 0; w < nom2.length(); w++){
                    carac1 = nom2.charAt(i);
                    for(int v = 0; v < nom2.length(); v++){
                        carac2 = nom2.charAt(i);
                        if(carac1 == carac2){
                            cont2 ++;
                        }
                    }
                }
                ataque2 = cont2;
                
                vid[i] -= cont2;
                vid[i+1] -= cont;
                
                System.out.println(nom1+" (Vida: "+vid[i]+") VS "+nom2+" (Vida: "+vid[i+1]+")");
            }
        }
    }
}
