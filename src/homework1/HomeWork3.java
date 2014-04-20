/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

/**
 *
 * @author Mark
 */
public class HomeWork3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //10. Дан двумерный массив целых чисел. Сформировать одномерный 
        //массив, каждый элемент которого равен наибольшему по модулю 
        //элементу соответствующего столбца двумерного массива. 
        System.out.println("*** Задание 10 ***");
        int count_line = 3;
        int count_column = 8;
        int[][] arr = new int[count_line][count_column];
        int[] abarr = new int[count_column];
        for (int line = 0; line < arr.length; line++) {
            arr[line] = fillRandomInt(count_column, -10, 10, 1);

        }
        //////////
        int num=0;
        for (int j = 0; j < arr[0].length; j++) {
            for (int[] arr1 : arr) {
                if (Math.abs(arr1[j]) >= num) {
                    abarr[j] = arr1[j];                
                }
                num = Math.abs(arr1[j]);
            }
        }
        show(arr);
        System.out.println("");
        show(abarr);

    }

    public static void show(int array[][]) {
        for (int line = 0; line < array.length; line++) {
            //Цикл по столбцам
            for (int column = 0; column < array[line].length; column++) {
                //нужные нам операции для array[line][column];
                System.out.print("\t" + array[line][column]);

            }
            System.out.println("");
        }
    }

    public static void show(int[] array) {
        //Вывод на экран элементов масива
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t"+array[i]);
        }
        System.out.println();
    }

    public static int[] fillRandomInt(int length, int min, int max, int count) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) random(min, max, count);
        }
        return array;
    }

    public static double random(double min, double max, double count) {
        double k = max - min;
        double random = (min + Math.random() * (k + 1));
        return round(random, count);

    }

    public static double round(double value, double count) {

        double roundValue = Math.rint(value * (Math.pow(10, count))) / Math.pow(10, count);
        return roundValue;
    }

}
