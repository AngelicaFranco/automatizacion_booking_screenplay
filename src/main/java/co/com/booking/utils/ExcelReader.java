package co.com.booking.utils;

import co.com.booking.models.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public static List<Data> readSheet(String filePath) throws IOException{

        List<Data> data = new ArrayList<>();
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.rowIterator();
        if (rowIterator.hasNext()){
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Data dataReserva = new Data();
            dataReserva.setCorreo(getCellValue(row,0));
            dataReserva.setContrasena(String.valueOf(getCellValue(row,1)));
            dataReserva.setCiudad(getCellValue(row,2));
            dataReserva.setAdultos(Double.valueOf(getCellValue(row,3)).intValue());
            dataReserva.setNinos(Double.valueOf(getCellValue(row,4)).intValue());
            dataReserva.setHabitaciones(Double.valueOf(getCellValue(row,5)).intValue());
            dataReserva.setPrecioMinimo(Double.valueOf(getCellValue(row,6)).intValue());
            dataReserva.setPrecioMaximo(Double.valueOf(getCellValue(row,7)).intValue());
            data.add(dataReserva);
        }

        workbook.close();
        file.close();
        return data;
    }

    private static String getCellValue(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex);
        return cell == null ? "" : cell.toString();
    }
}
