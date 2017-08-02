package reader;

import java.lang.reflect.Method;

public class ReaderOfMethods {


    public Method[] getAllSortMetods() {
        Class arraySorterClass = null;
        try {
            arraySorterClass = Class.forName("sorter.ArrayHolderSorter");
        }catch (ClassNotFoundException e){
        }
        Method[] sortedMethods = arraySorterClass.getDeclaredMethods();

        return sortedMethods;
    }

    public Method[] getAllArrayFillingMethods(){
        Class fillerClass = null;
        try{
            fillerClass = Class.forName("fillerOfArrays.FillerOfArrays");
        }catch (ClassNotFoundException e){}
        Method[] fillerMethods = fillerClass.getDeclaredMethods();
        return fillerMethods;
    }
}