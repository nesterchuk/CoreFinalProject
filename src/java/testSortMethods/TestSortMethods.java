package testSortMethods;

import dataHolder.DataHolder;
import reader.ReaderOfMethods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestSortMethods {
    private int[] sizesArrays;
    Method[] sortMethods;
    Method[] fillerMehtods;

    public TestSortMethods(int[] sizesArrays){
        this.sizesArrays = sizesArrays;
        ReaderOfMethods reader = new ReaderOfMethods();
        sortMethods = reader.getAllSortMetods();
        fillerMehtods = reader.getAllArrayFillingMethods();
    }

    public void conducTesting(){

        DataHolder dataHolder = DataHolder.getDataHolderInstance();
        Object instansSorter = null;
        Object instansFiller = null;
        long[][][] rethult = new long[fillerMehtods.length][sortMethods.length][sizesArrays.length];
        dataHolder.setSizesOfArrays(sizesArrays);
        try {
            instansSorter = Class.forName("sorter.ArrayHolderSorter").newInstance();
            instansFiller = Class.forName("fillerOfArrays.FillerOfArrays").newInstance();
        }catch (ClassNotFoundException|InstantiationException|IllegalAccessException e){}

        for (int i = 0;i<fillerMehtods.length;++i){
            dataHolder.setNameOfFillerMethod(fillerMehtods[i].getName());

            for (int j = 0; j <sortMethods.length ; j++) {
                dataHolder.setNameOfSortedMethod(sortMethods[j].getName());

                for (int k = 0; k < sizesArrays.length ; k++) {
                    int[] testArray = new int[sizesArrays[k]];
                    try {
                        testArray = (int[])fillerMehtods[i].invoke(instansFiller, sizesArrays[k]);
                    }catch (IllegalAccessException|InvocationTargetException e){}
                    long startTime = System.currentTimeMillis();
                    try {
                        sortMethods[j].invoke(instansSorter,testArray);
                    }catch (IllegalAccessException|InvocationTargetException e){}
                    long finishTime = System.currentTimeMillis();
                    rethult[i][j][k] = finishTime-startTime;
                }
            }
        }
        dataHolder.setTestTime(rethult);
    }
}
