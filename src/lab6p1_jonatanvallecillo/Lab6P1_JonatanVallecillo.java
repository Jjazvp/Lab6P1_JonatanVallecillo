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
            int menu2 = 1;
            while(menu2 == 1){
                System.out.print("****** MENU ******\n"
                    + "1. Indice de balance\n"
                    + "2. Alternados\n"
                    + "3. Torneo de pelea\n"
                    + "4. Salir\n"
                    + "Ingerese la opcion que desea: ");
                opcion = leer.nextInt();

                if(opcion > 0 && opcion < 5){
                    menu2 = 0;
                }else{
                    System.out.println("ERROR. Intente de nuevo\n.");
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
                    System.out.println();
                    break;
                case 3:
                    Torneo();
                    break;
                case 4:
                    menu = 0;
                    break;
            }
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
        nombres[6] = "Andrea";
        nombres[7] = "Victor";
        
        for(int i = 0; i < nombres.length; i++){
            vid[i] = nombres[i].length();
        }
        
        int contador = 8;
        int rondas = 1;
        String nom = "";
        
        while(contador > 1){
            System.out.println("Round "+rondas+"\n"
                    + "------------------------");
            for(int i = 0; i < nombres.length; i+= 2){
                char carac1 = ' ';
                char carac2 = ' ';
                int cont = 0;
                int contemp = 0;
                int contemp2 = 0;
                int cont2 = 0;
                int ataque1 = 0;
                int ataque2 = 0;
                System.out.println(nombres[i]+" (Vida: "+vid[i]+") VS "+nombres[i+1]+" (Vida: "+vid[i+1]+")");
                
                nom = nombres[i];
                nom = nom.toLowerCase();
                ataque1 = ataque(nom);
                
                nom = nombres[i+1];
                nom = nom.toLowerCase();
                ataque2 = ataque(nom);
                
                vid[i] -= ataque2;
                vid[i+1] -= ataque1;
                
                System.out.println(nombres[i]+" quito "+ataque1+" de vida a "+nombres[i+1]);
                System.out.println(nombres[i+1]+" quito "+ataque2+" de vida a "+nombres[i]);
                System.out.println("------------------------");
                
                /*String [] nombres2 = new String [nombres.length - 1];
                int [] vid2 = new int [vid.length - 1];
                
                if(vid[i] == 0){
                    for(int j = 0; j < nombres2.length; j++){
                        if(i != j){
                            nombres2[i] = nombres[i]; 
                            vid2[i] = vid[i];
                        }
                    }
                }
                nombres = nombres2;*/
            }
            rondas ++;
        }
    }
    
    public static int ataque(String nom){
        char carac1 = ' ';
        char carac2 = ' ';
        int cont = 0;
        int contemp = 0;
        for(int w = 0; w < nom.length(); w++){
            carac1 = nom.charAt(w);
            for(int v = 0; v < nom.length(); v++){
                carac2 = nom.charAt(v);
                if(carac1 == carac2){
                    cont ++;
                    if(cont >= contemp){
                        contemp = cont;
                    }
                }
            }
            cont = 0;
        }
        return contemp;
    }
}
