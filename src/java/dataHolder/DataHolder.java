package dataHolder;

import java.util.ArrayList;

public class DataHolder {
    private static DataHolder dataHolderInstance;
    private int[] sizesOfArrays;
    private long[][][] testTime ;
    private ArrayList<String> namesOfSortedMethods;
    private ArrayList<String> namesOfFillerMethods;

    private DataHolder(){
        namesOfSortedMethods = new ArrayList<>();
        namesOfFillerMethods = new ArrayList<>();
    }

    public static DataHolder getDataHolderInstance(){
        if (dataHolderInstance == null){
            dataHolderInstance = new DataHolder();
        }
        return dataHolderInstance;
    }

    public void setSizesOfArrays(int[]sizes){
        this.sizesOfArrays = sizes;
    }

    public void setTestTime(long[][][] testTime){
        this.testTime = testTime;
    }

    public void setNameOfSortedMethod(String name){
        this.namesOfSortedMethods.add(name);
    }

    public void setNameOfFillerMethod(String name){
        this.namesOfFillerMethods.add(name);
    }

    public int[]getSizesOfArrays(){return sizesOfArrays;}

    public long[][][] getTestTime(){
        return this.testTime;
    }

    public ArrayList<String> getNamesOfSortedMethods(){
        return namesOfSortedMethods;
    }

    public ArrayList<String> getNamesOfFillerMethods(){
        return namesOfFillerMethods;
    }

}
