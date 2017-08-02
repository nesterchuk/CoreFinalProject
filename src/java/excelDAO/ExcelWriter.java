package excelDAO;


import dataHolder.DataHolder;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;


import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {

    public void createDataFile(){

        DataHolder dataHolder = DataHolder.getDataHolderInstance();
        Workbook workbook = new XSSFWorkbook();
        for (int i = 0; i< dataHolder.getTestTime().length; ++i){
            Sheet sheet = workbook.createSheet(dataHolder.getNamesOfFillerMethods().get(i));
            Drawing drawing=sheet.createDrawingPatriarch();
            int numbOfSortMethods = dataHolder.getNamesOfSortedMethods().size();
            ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, numbOfSortMethods, 10, numbOfSortMethods + 30);
            Chart chart = drawing.createChart(anchor);
            ChartLegend legend = chart.getOrCreateLegend();
            legend.setPosition(LegendPosition.TOP_RIGHT);
            LineChartData data = chart.getChartDataFactory().createLineChartData();
            ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
            ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
            ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 0, dataHolder.getSizesOfArrays().length));

            Row serviseRow = sheet.createRow(0);

            for (int l = 0; l < dataHolder.getSizesOfArrays().length ; l++) {
                Cell cell = serviseRow.createCell(l+1);
                cell.setCellValue(dataHolder.getSizesOfArrays()[l]);
            }

            for (int j = 0; j < dataHolder.getTestTime()[i].length; j++) {
                Row row = sheet.createRow(j+1);
                for (int k = 0; k < dataHolder.getTestTime()[i][j].length; k++) {
                    if (k == 0){
                        Cell cell =row.createCell(k);
                        cell.setCellValue(dataHolder.getNamesOfSortedMethods().get(j));
                    }
                    Cell cell = row.createCell(k + 1);
                    cell.setCellValue(dataHolder.getTestTime()[i][j][k]);
                }
                ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(row.getRowNum(),row.getRowNum(), 0, dataHolder.getTestTime()[i][j].length));
                data.addSeries(xs, ys1);

            }
            chart.plot(data, bottomAxis, leftAxis);
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("src/excelFiles/data.xlsx");
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();
        }catch (IOException e){
            return;
        }
    }
}
