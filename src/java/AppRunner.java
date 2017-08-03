import excelDAO.ExcelWriter;
import testSortMethods.TestSortMethods;

public class AppRunner {
    public static void main(String[] args) {
        int[] sizesOfArrays={5000,6000,7000,8000,9000,10000,11000,12000,13000,14000,15000};
        TestSortMethods test = new TestSortMethods(sizesOfArrays);
        test.conducTesting();
        ExcelWriter excelWriter = new ExcelWriter();
        excelWriter.createDataFile();
    }
}
