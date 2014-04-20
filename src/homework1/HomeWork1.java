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
public class HomeWork1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //6. Дан двумерный массив целых чисел.
        //б) Последний нулевой элемент каждою столбца заменить на число 100 
        //(предполагается, что в каждом столбце есть нулевой элемент). 

        System.out.println("*** Задание 6 Б ***");
        int[][] array = {{1, 3, 5, 7, 0, 6}, {3, 5, 7, 0, 1, 2, 0, 2}};
        show(array);
        System.out.println();//Для красоты вывода.
        for (int i = 0; i < array.length; i++) {
            for (int j = array[i].length - 1; j > array.length; j--) {
                if (array[i][j] == 0) {
                    array[i][j] = 100;
                    break;
                }
            }
        }
        show(array);     
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
}
