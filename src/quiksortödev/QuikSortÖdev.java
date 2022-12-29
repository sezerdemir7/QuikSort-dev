
package quiksortödev;


import java.util.Random;


public class QuikSortÖdev {


    public static int pivotbulma(int[] array, int yüzde) {
        return (int) Math.floor(array.length * yüzde / 100.0);
    }


    public static int quicksort(int[] array, int pivotIndex,int yüzdelik) {
        int gecici = 0;
        if (array.length <= 1) {
            return gecici;
        }
        //System.out.println(array.length);
        int pivot = array[pivotIndex];
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                gecici++;
            }
        }
        int[] left = new int[i];
        int[] right = new int[array.length - i - 1];
        System.arraycopy(array, 0, left, 0, i);
        System.arraycopy(array, i + 1, right, 0, array.length - i - 1);
        int yeniYüzde=100-yüzdelik;
        int yeniSolYüzde=100-yeniYüzde;
        gecici += quicksort(left, pivotbulma(left, yüzdelik),yüzdelik);
        gecici += quicksort(right, pivotbulma(right, yüzdelik),yüzdelik);
        return gecici;//yapılan işlem sayısını geri döndürme
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        Random random = new Random();
        int rand;
        int[] kontrol = new int[100];//Aynı sayı üretilmesin diye kontrol dizisine atıp yeni üretilrn sayıyı kotrol etmek için
        rand = random.nextInt();

        for (int i = 0; i < 100; i++) {
            do {
                rand = random.nextInt(100) + 1;
            } while (kontrol[rand - 1] == 1);

            kontrol[rand - 1] = 1;
            array[i] = rand;
            System.out.print(array[i] + ",");

        }


        int işlemSayısı = Integer.MAX_VALUE;//en iyi işlemi bulmak için
        int EnİyiPivot = 0;
        for (int i = 0; i < 100; i += 10) {
            int pivotIndex = pivotbulma(array, i);
            //System.out.println("ilk pivot"+pivotIndex);
            int gecici = quicksort(array, pivotIndex,i);
            if (gecici < işlemSayısı) {
                işlemSayısı = gecici;
                EnİyiPivot = pivotIndex;
            }
        }

        System.out.println();
        System.out.println(" EN iyi Pivot=%" + EnİyiPivot + " islemsayisi=" + işlemSayısı);
        System.out.println();

       
    }

}
