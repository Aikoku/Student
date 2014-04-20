/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

//import static homework1.HomeWork1.fillRandomInt;
import static homework1.HomeWork1.show;
//import static homework1.HomeWork1.summ;

/**
 *
 * @author Mark
 */
public class HomeWork2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //7. Фирма имеет три магазина. Известен доход каждого магазина за каждый, 
        //из десяти дней. Определить: 
        //а) какой из магазинов получил максимальный общий доход за 10 дней; 
        //б) какого числа фирма получила максимальный общий доход; 
        //в) какой магазин и какого числа получил максимальный доход за день. 
        System.out.println("*** Задание 7 ***");
        int count_line = 3;
        int count_column = 10;
        int a = 0, b = 0, c = 0; //Название магазинов
        int max;
        int count;
        int[][] arr = new int[count_line][count_column];
        int countCol = 0, countLine = 0;
        int num = 0;
        for (int line = 0; line < arr.length; line++) {
            arr[line] = fillRandomInt(count_column, 3000, 10000, 1);
            a = summ(arr[0]);
            b = summ(arr[1]);
            c = summ(arr[2]);
            
            for(int j = 0;j<arr[line].length;j++){
                if(arr[line][j]>=num){
                    countLine=j;
                    countCol=line;                    
                    num = arr[line][j];
                }
            }
        }
        show(arr);
        System.out.println("\n\t= A ="
                + "\nКакой из магазинов получил максимальный общий доход за 10 дней");
        System.out.println("\tМагазин А продал товара на = " + a);
        System.out.println("\tМагазин В продал товара на = " + b);
        System.out.println("\tМагазин С продал товара на = " + c);
        max = Math.max(a, Math.max(b, c));
        if (a < c & b < c) {
            System.out.println("\tМагазин С заработал больше всех, а именно: " + max);
        } else if (a < b & c < b) {
            System.out.println("\tМагазин B заработал больше всех, а именно: " + max);
        } else if (c < a & b < a) {
            System.out.println("\tМагазин A заработал больше всех, а именно: " + max);
        } //Добавить условия когда несколько магазинов заработали одинакого много!
        else {
            System.out.println("\tЧто-то пошло не так!");
        }

        System.out.println("\n\t= B ="
                + "\nКакого числа фирма получила максимальный общий доход");
        int sum;
        max = 0;
        count = 0;
        int maxCount = 0;
        for (int j = 0; j < arr[0].length; j++) {
            sum = 0;
            count++;
            for (int[] arr1 : arr) {
                sum += arr1[j];
            }
            if (max < sum) {
                max = Math.max(sum, max);
                maxCount = count;
            }
        }
        System.out.println("\tфирма больше всего заработала "+maxCount+" числа и прибыль составила "+max);
        
        System.out.println("\n\t= С ="
                + "\nКакой магазин и какого числа получил максимальный доход за день.");
        
        System.out.println("\tБольше всего заработал "+(countCol+1)+" магазин, "+(countLine+1)+" числа, а именно "+arr[countCol][countLine]);
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

    public static int summ(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i]; //sum = sum+array[i]
        }//System.out.println("Сумма элеметнов массива = "+sum);
        return sum;
    }
}
