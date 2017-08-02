import excelDAO.ExcelWriter;
import testSortMethods.TestSortMethods;

public class AppRunner {
    public static void main(String[] args) {
        int[] sizesOfArrays={40000,60000,80000,100000};
        TestSortMethods test = new TestSortMethods(sizesOfArrays);
        test.conducTesting();
        ExcelWriter excelWriter = new ExcelWriter();
        excelWriter.createDataFile();
    }
}
