package video;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static video.SubtitleTime.getNullDateWithTime;

public class ExcelParser {

    public static Iterator<Row>  getRowIterator(String fileName,
                                               int indexSheet) {
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(indexSheet);
//        Iterator<Row> it = sheet.iterator( );
        return sheet.iterator();
    }

    public static String getDatesFromColumn(String fileName, int columnIndex,
                                            List <Date> dates) {
        //инициализируем потоки
        String result = "";
        Iterator<Row> it = getRowIterator(fileName,0);

        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Cell cell = row.getCell(columnIndex);
            System.out.println(cell);

            CellType cellType = cell.getCellType();

            try {
                    //перебираем возможные типы ячеек
                    switch (cellType) {
                        case STRING:
                            result += cell.getStringCellValue() + "=";
                            break;
                        case FORMULA:
                            Date dateCell;
                            try {
                                dateCell = cell.getDateCellValue();  //пробую считать время
                                //Так как здесь только время, то даты приведем к 1970 году
                                Date dateOnlyTime = getNullDateWithTime(dateCell);

                                //TODO если получилось считать записать значение в TreeMap с датами!
                                dates.add(dateOnlyTime);
                            } catch (IllegalStateException e) {
                                e.printStackTrace();
                                // не получилось - и ладно - значит пустое значение
                            }
                            break;
                    }
            } catch (  IllegalStateException e) {
                    e.printStackTrace();
            }
            result += "\n";
        }
        return result;
    }

    //Найти столбец Время YouTube в первой строке первого листа
    public static int getColumnIndexTimeYoutube(String fileName) {
        //инициализируем потоки
        int result = -1;
        Iterator<Row> it = getRowIterator(fileName,0);

        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();

                try {
                    //перебираем возможные типы ячеек
                    switch (cellType) {
                        case STRING:
                            if (cell.getStringCellValue().equalsIgnoreCase("Время YouTube")) {
                                result = cell.getColumnIndex();
                                return result;
                            }
                            break;
                    }
                } catch (  IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }



    public static String parse(String fileName) {
        //инициализируем потоки
        String result = "";
        Iterator<Row> it = getRowIterator(fileName,0);

        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();

                try {
                    //перебираем возможные типы ячеек
                    switch (cellType) {
                        case STRING:
                            result += cell.getStringCellValue() + "=";
                            break;
                        case NUMERIC:
                            result += "[" + cell.getNumericCellValue() + "]";
                            break;
                        case FORMULA:
//                            result += "[" + cell.getNumericCellValue() + "]";
                            result += "[" + cell.getCellFormula() + "]";
                            break;
                        default:
                            result += "|";
                            break;
                    }
                } catch (  IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(getDates());
    }

    public static List<Date> getDates() {
        String fileNameLocal;
        fileNameLocal= new ExcelTimeYoutube().getFileName();

        int columnIndexTimeYoutube = getColumnIndexTimeYoutube(fileNameLocal);
        List<Date> dates = new ArrayList<>();

        String temp = ExcelParser.getDatesFromColumn(fileNameLocal,columnIndexTimeYoutube,dates);
        System.out.println(temp);
        return dates;
    }
}