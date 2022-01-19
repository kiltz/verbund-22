package utils;

import java.util.Arrays;
import java.util.Random;

public class Feld {
    private static final Random random = new Random();
    private static int[][] feld;

    private static int[] moeglicheRichtungen;

    public static void main(String[] args) {
        getNewField();
//        Stream.of(getNewField()).map(Arrays::toString).forEach(System.out::println);
    }

    public static int[][] getNewField(){
        feld = new int[10][10];

        generateShip(4);


        return feld;
    }

    private static void generateShip(int laenge) {

        int[] erstePosition = getFirstPosition();
        moeglicheRichtungen = new int[4];
        richtungenFinden(erstePosition[0], erstePosition[1]);
    }

    private static void richtungenFinden(int sp, int zl) {
        for(int[] position: new int[][]{{sp-1, zl}, {sp+1, zl}, {sp, zl-1}, {sp, zl+1}}){

        }
    }

    public static int[] getFirstPosition(){
        while (true) {
            int zeile = random.nextInt(10);
            int spalte = random.nextInt(10);

            for (int i = zeile-1; i <= zeile+1; i++){
                for (int j = spalte-1; j <= spalte+1; j++){
                    try{
                        if (feld[i][j] == 1){ continue;}
                    } catch (ArrayIndexOutOfBoundsException ignore) {}
                }
            }
            return new int[]{zeile, spalte};
        }
    }
}
