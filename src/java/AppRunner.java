import excelDAO.ExcelWriter;
import testSortMethods.TestSortMethods;

public class AppRunner {
    public static void main(String[] args) {
        int[] sizesOfArrays={4000,6000,8000,10000};
        TestSortMethods test = new TestSortMethods(sizesOfArrays);
        test.conducTesting();
        ExcelWriter excelWriter = new ExcelWriter();
        excelWriter.createDataFile();
    }
}
