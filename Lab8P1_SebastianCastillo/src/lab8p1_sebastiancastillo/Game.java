/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p1_sebastiancastillo;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Game {
    int[][] tablero;
    int[][] nextgen;
    int rondas;
    ArrayList<String> coordenadas;
    public int[][] getTablero() {
        return tablero;
    } 

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
    public int rondas() {
        return rondas;
    } 

    public void rondas(int rondas) {
        this.rondas = rondas;
    }
     public int[][] nextgen() {
        return nextgen;
    }

    public void nextgen(int[][] nextgen) {
        this.nextgen = nextgen;
    }
      public ArrayList<String> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<String> coordenadas) {
        this.coordenadas = coordenadas;
    }
        
  public void jugar(int rond,ArrayList<String> nums, int[][]matrices){
        for(int i=1;i<=rond;i++){
                System.out.println("Ronda: "+i);
                int[][] temp=generacion2( matrices);
                Print(temp);
                cambiotablero();
        }
  }
  
    public void cambiotablero() {
        int[][] temp = tablero;
        tablero = nextgen;
        nextgen = temp;
    }

    public void actualizarvivos() {
        coordenadas.clear();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == 1) {
                    coordenadas.add(i + ":" + j);
                }
            }
        }
    }
    
    public  ArrayList<String> Print(int[][] matriz) {
        ArrayList<String> coordenadas = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
                if (matriz[i][j] == 1) {
                    coordenadas.add(i + ":" + j);
                }
            }
            System.out.println();
        }
        System.out.println("Celda vivas:"+coordenadas);
        return coordenadas;
    }

    public int[][] generacion2(int[][] matriz) {
        int[][] tablero = new int[matriz.length][matriz[0].length];
        int cont_vivo = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(i == 0 || i == matriz.length - 1 || j == 0 || j == matriz.length - 1){
                    
                }else{
                tablero[i][j]=0;
                    tablero[i][j] = 0;                
                if (matriz[i][j] == 1) {
                    if (matriz[i - 1][j] == 1) {
                        cont_vivo++;
                    } else if (matriz[i - 1][j - 1] == 1) {
                        cont_vivo++;
                    } else if (matriz[i - 1][j + 1] == 1) {
                        cont_vivo++;
                    } else if (matriz[i + 1][j - 1] == 1) {
                        cont_vivo++;
                    } else if (matriz[i + 1][j + 1] == 1) {
                        cont_vivo++;
                    } else if (matriz[i + 1][j] == 1) {
                        cont_vivo++;
                    } else if (matriz[i][j + 1] == 1) {
                        cont_vivo++;
                    } else if (matriz[i][j - 1] == 1) {
                        cont_vivo++;
                    }
                } else if (matriz[i][j] == 0) {
                    if (matriz[i - 1][j] == 1) {
                        cont_vivo++;
                    } else if (matriz[i - 1][j - 1] == 1) {
                        cont_vivo++;
                    } else if (matriz[i - 1][j + 1] == 1) {
                        cont_vivo++;
                    } else if (matriz[i + 1][j - 1] == 1) {
                        cont_vivo++;
                    } else if (matriz[i + 1][j + 1] == 1) {
                        cont_vivo++;
                    } else if (matriz[i + 1][j] == 1) {
                        cont_vivo++;
                    } else if (matriz[i][j + 1] == 1) {
                        cont_vivo++;
                    } else if (matriz[i][j - 1] == 1) {
                        cont_vivo++;
                    }
                }
                if(matriz[i][j]==1&&cont_vivo<2){
                    matriz[i][j]=0;
                }else if(matriz[i][j]==1&&cont_vivo>3){
                    matriz[i][j]=0;
                }else if(matriz[i][j]==0&&cont_vivo==3){
                    matriz[i][j]=1;
                }else if(matriz[i][j]==1&&cont_vivo==2){
                    matriz[i][j]=1;
                }
                cont_vivo=0;
                }
                
                }
            }
        return tablero;
    }

}
