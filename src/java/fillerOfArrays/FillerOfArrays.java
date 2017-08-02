package fillerOfArrays;


import java.util.Random;

public class FillerOfArrays {

    public int[] randomArray(int length){
        int[] array = new int[length];
        for (int i=0 ; i<length;++i){
            Random random = new Random();
            array[i] = random.nextInt();
        }
        return array;
    }

    public int[] sortArray(int length){
        int[] array = new int[length];
        for (int i=0 ; i<length;++i){
            array[i]=i;
        }
        return array;
    }

    public int[] reverseSortArray(int length){
        int[] array = new int[length];
        for (int i=array.length ; i>0;--i){
            array[array.length-i]=i;
        }
        return array;
    }

    public int[] sortArrayRandomElement(int length){
        int[] array=sortArray(length);
        Random random = new Random();
        array[length-1]=random.nextInt(array.length);
        return array;
    }
}
