/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8p1_sebastiancastillo;//fila 3 asiento 1

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Lab8P1_SebastianCastillo {

    static Scanner leer = new Scanner(System.in);
    static Random rng = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("***** M E N U *****");
        System.out.println("1. Juego de la vida");
        System.out.println("2. Salir");
        int opcion = leer.nextInt();
        while (opcion != 2) {
            switch (opcion) {
                case 1:
                    Game pepe = new Game();
                    int fila = 10;
                    int columna = 10;
                    System.out.println("Ingrese el numero de rondas");
                    int rondas = leer.nextInt();
                    int tablero[][] = tablero(fila, columna);
                    ArrayList<String> vivas = new ArrayList<>();
                    System.out.println("Tablero inicial: ");
                    vivas = pepe.Print(tablero);
                    pepe.jugar(rondas, vivas, tablero);
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
            System.out.println("***** M E N U *****");
            System.out.println("1. Juego de la vida");
            System.out.println("2. Salir");
            opcion = leer.nextInt();
        }
    }

    public static int[][] tablero(int filas, int columnas) {
        int[][] tablero = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == 0 || i == filas - 1 || j == 0 || j == filas - 1) {
                    tablero[i][j] = 0;
                } else {
                    tablero[i][j] = rng.nextInt((1 - 0) + 1) + 0;
                }
            }
        }
        return tablero;
    }
}
