
package lab6_p1_jonatanvallecillo;

import java.util.Random;
import java.util.Scanner;

public class Lab6_P1_JonatanVallecillo {

    static Scanner leer = new Scanner (System.in);
    static Scanner teclado = new Scanner (System.in);
    static Random random = new Random ();
    
    public static void main(String[] args) {
        System.out.println("----------Menu------------");
        System.out.println("1. Conjuntos");
        System.out.println("2. Cuantos primos tienes?");
        System.out.println("3. Salir");
        System.out.print("Elija su opcion: ");
        int opcion = leer.nextInt();
        System.out.println();
        
        while (opcion > 0 && opcion < 3){
            switch(opcion){
                case 1:
                    System.out.print("Ingrese el tamano del primer arreglo: ");
                    int size = leer.nextInt();
                    char [] SET1 = arreglo1(size);
                    imprimir1(SET1);
                    System.out.println();
                    System.out.println();
                    System.out.print("Ingrese el tamano del segundo arreglo: ");
                    size = leer.nextInt();
                    char [] SET2 = arreglo1(size);
                    imprimir2(SET2);
                    System.out.println();
                    System.out.println();
                    System.out.println("Operaciones:");
                    System.out.println("1. Interseccion");
                    System.out.println("2. Diferencia");
                    System.out.print("Ingrese la opcion: ");
                    int subopcion = leer.nextInt();
                    while (subopcion > 0 && subopcion < 3){
                        switch(subopcion){
                            case 1:
                                imprimir_interseccion(interseccion(SET1, SET2));
                                subopcion = 3;
                                break;
                            case 2:
                                imprimir_diferencia(diferencia(SET1, SET2));
                                subopcion = 3;
                                break;
                        }
                    }
                    
                    break;
                case 2:
                    System.out.print("Ingrese el tamano del arreglo a generar: ");
                    size = leer.nextInt();
                    System.out.print("Ingrese el limite inferior: ");
                    int limiteinf = leer.nextInt();
                    System.out.print("Ingrese el limite superior: ");
                    int limitesup = leer.nextInt();
                    System.out.println();
                    if (limitesup > limiteinf){
                        getTotalPrimeCount(countPrimeFactors(isPrime(getRandArray(size,limiteinf, limitesup))));
                        System.out.println();
                        System.out.println();
                    }else{
                        System.out.print("Ingrese otro limite inferior: ");
                        limiteinf = leer.nextInt();
                        System.out.print("Ingrese otro limite superior: ");
                        limitesup = leer.nextInt();
                        getRandArray(size, limiteinf, limitesup);
                    }
                    break;
            }
        }
    }
    
    public static char [] arreglo1(int size){
        int [] arreglo1 = new int [size]; 
        char [] arreglo1_2 = new char [size];
        String acum = "";
        char carac = ' ';
        for (int i = 0; i < size; i++){
            arreglo1[i] = random.nextInt(9-0)+ 65;
            carac = (char) arreglo1[i];
            arreglo1_2[i] = carac;
        }
        return arreglo1_2;
    }
    
    public static void imprimir1(char [] SET1){
        System.out.print("SET1: ");
        for(int m = 0; m < SET1.length; m++){
            System.out.print("["+SET1[m]+"]");
        }
    }
    
    public static void imprimir2(char [] SET2){
        System.out.print("SET2: ");
        for(int m = 0; m < SET2.length; m++){
        System.out.print("["+SET2[m]+"]");
        }
    }
    
    public static char [] interseccion(char [] SET1, char [] SET2){
        String cadena = "";
        char [] mayor;
        char [] menor;
        if (SET1.length > SET2.length){
            mayor = SET1;
            menor = SET2;
        }else{
            mayor = SET2;
            menor = SET1;
        }
        
        for(int o = 0; o < mayor.length; o++){
            for(int p = 0; p < menor.length; p++){
                if (SET1[o] == SET2[p]){
                    cadena += SET1[o];
                }
            }
        }
        
        /*String cadena2 = "";
        
        for(int a = 0; a < cadena.length(); a++){
            for (int b = 0; b < cadena.length(); b++){
                if (cadena.charAt(a) != cadena.charAt(b)){ 
                    cadena2 += cadena.charAt(a) + cadena.charAt(b);
                }else{
                    
                }
            }
        }*/
        
        char [] acum = new char [cadena.length()];
       
        for (int q = 0; q < acum.length; q++){
            acum[q] = cadena.charAt(q);
        }                        
        return acum;
    }
    
    public static void imprimir_interseccion(char [] interseccion){
        System.out.print("Interseccion(SET1, SET2): ");
        for (int i = 0; i < interseccion.length; i++){           
            System.out.print("["+ interseccion[i]+ "]");
        }
        System.out.println();
        System.out.println();
    }
    
    public static char [] diferencia(char [] SET1, char [] SET2){
        String cadena = "";
        char [] mayor;
        char [] menor;
        if (SET1.length > SET2.length){
            mayor = SET1;
            menor = SET2;
        }else{
            mayor = SET2;
            menor = SET1;
        }
        
        for(int o = 0; o < mayor.length; o++){
            for(int p = 0; p < menor.length; p++){
                if (SET1[o] != SET2[p]){
                    cadena += SET1[p];
                }
            }
        }
        char [] acum = new char [cadena.length()];
        for (int q = 0; q < acum.length; q++){
            acum[q] = cadena.charAt(q);
        }                        
        return acum;
    }
    
    public static void imprimir_diferencia(char [] diferencia){
        System.out.print("Diferencia(SET1, SET2): ");
        for (int i = 0; i < diferencia.length; i++){           
            System.out.print("["+ diferencia[i]+ "]");
        }
        System.out.println();
        System.out.println();
    }
    
    public static int [] getRandArray(int size, int limiteinf, int limitesup){
        int [] array = new int [size];
        for (int i = 0; i < array.length; i++){
            array [i] = random.nextInt(limitesup)+ limiteinf;
        }
        
        System.out.print("Arreglo generado: ");
        for(int j = 0; j < array.length; j++){
            System.out.print("["+array[j]+"]");
        }
        System.out.println();
        
        /*int numero;
        int multiplo = 0;
        int [] multiplos = new int [array.length];
        for (int i = 0; i < array.length; i++){
            numero = array[i];
            for(int j = 1; j <= numero; j++){
                if (array[i] % j == 0){
                    multiplo += 1;
                }
            }
            if(multiplo == 2){
                multiplos [i] = 1;
            }else{
                multiplos [i] = multiplo;
            }
        }
        
        System.out.println();*/
        return array; 
    }
    
    public static boolean [] isPrime(int [] getRandArray){
        /*for(int m = 0; m < getRandArray.length; m++){
            System.out.print("["+getRandArray[m]+"]");
        }*/
        
        int multiplos = 0;
        int numero = 0;
        boolean [] primo = new boolean [getRandArray.length];
        
        for (int i = 0; i < getRandArray.length; i++){
            numero = getRandArray[i];
            multiplos = 0;
            for(int j = 1; j <= numero; j++){
                if (getRandArray[i] % j == 0){
                    multiplos += 1;
                }
            }
            if (multiplos == 2){
                primo [i] = true;
            }else if (multiplos > 2){
                primo [i] = false;
            }
        }
        
        /*for(int j = 0; j < primo.length; j++){
            System.out.print("["+primo[j]+"]");
        }*/
        return primo;
    }
    
    public static int [] countPrimeFactors(boolean [] isPrime){
        /*for(int m = 0; m < isPrime.length; m++){
            System.out.print("["+isPrime[m]+"]");
        }*/
        int multiplos = 0;
        int [] contador = new int [isPrime.length];
        for (int i = 0; i < isPrime.length; i++){
                if (isPrime[i] == true){
                    multiplos = 1;
                }else if(isPrime[i] == false){                    
                    multiplos = 2;
                }
                contador [i] = multiplos;
        }
        return contador;
    }
    
    public static int [] getTotalPrimeCount(int [] countPrimeFactors){
        System.out.print("No. divisores primos: ");
        for (int i = 0; i < countPrimeFactors.length; i++){
            System.out.print("["+countPrimeFactors[i]+"]");
        }
        return countPrimeFactors;
    }
}
