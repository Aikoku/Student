/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Student;

/**
 *
 * @author Mark
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
      public static int bin(int[] a, int from, int to,
            int key) {
        int left = from;
        int right = to - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int mid1 = a[mid];

            if (mid1 < key) {
                left = mid + 1;
            } else if (mid1 > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -(left + 1);
    }
//metod linejnogo poiska
    public static void linejnyj(int[] a,
            int key) {
        double time = -System.currentTimeMillis();
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                System.out.println("pozicija " + (i + 1));
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Rezultat ne najden");
        }
        time += System.currentTimeMillis();
        System.out.println("vremja " + time);

    }

    public static void main(String[] args) {
        int a[] = {2, 5, 7, 10, 17, 17, 17, 17, 19, 23, 24, 25, 25, 36, 39, 43, 47, 53, 59, 61, 64, 68, 74, 76, 79, 79, 79, 85, 88, 93, 95};
        int key = 17;

//variant1 obychnyj, so sluchajnym indeksom
        double timer = -System.currentTimeMillis();
        int rez = bin(a, 0, a.length, key);
        if (rez < 0) {
            System.out.println("Rezultat ne najden");
        } else {
            System.out.println("Chislo " + key + " najdeno v pozicii " + (rez + 1)); //esli vesti otshet ne s 0 a s 1

        }
        timer += System.currentTimeMillis();
        System.out.println("vremja " + timer);

//variant2 s naimenshim indeksom
        timer = -System.currentTimeMillis();
        int numb = -1;
        int rez2 = bin(a, 0, a.length, key);
        while (rez2 >= 0) {
            numb = rez2;
            rez2 = bin(a, 0, (numb + 1), key);
            if (numb == rez2) {
                break;
            }
        }
        if (numb < 0) {
            System.out.println("Rezultat ne najden");
        } else {
            System.out.println("Variant s naimenshim indeksom : Chislo " + key + " najdeno v pozicii " + (numb + 1)); //esli vesti otshet ne s 0 a s 1
        }
        timer += System.currentTimeMillis();
        System.out.println("vremja " + timer);

//linejnyj poisk
        System.out.println("Linejnyj poisk chisla " + key);
        linejnyj(a, key);

    }

}
