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
                arreglo2(arreglo);
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
        System.out.print("[");
        for(int i = 0; i < arreglo.length; i++){
            if (i == arreglo.length - 1){
                System.out.print(arreglo[i]);
            }else{
                System.out.print(arreglo[i]+",");
            }
        }
        System.out.print("]");
    }
    
    public static void arreglo2(int [] arreglo){
        int cont1 = 0;
        int cont2 = 0;
        int puntodequi = 0;
        int puntodequi2 = 0;
        int indice = 0;
        int elemento = 0;
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
            System.out.println("\n"+i+" --- "+arreglo[i]+" ----- "+cont1+" iz "+cont2+" der ");
            
            puntodequi = cont1 - cont2;
            puntodequi *= -1;
            
            if (puntodequi < puntodequi2 || i == 0){
                puntodequi2 = puntodequi;
                indice = i;
                elemento = arreglo[i];
            }
            
            System.out.println("El punto de equilibrio esta en el index "+indice+"(#"+elemento+")");
        }
    }
}
