package video;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

public class ExcelParser {

    public static String parseColumn(String fileName, int columnIndex) {
        //инициализируем потоки
        String result = "";
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator( );
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
                        case NUMERIC:
//                            result += "[" + cell.getNumericCellValue() + "]";
                            break;
                        case FORMULA:
//                            result += "[" + cell.getNumericCellValue() + "]";

                            Date dateCell;
                            try {
                                dateCell = cell.getDateCellValue();  //пробую считать время

                                //TODO если получилось считать записать значение в TreeMap с датами!



                                System.out.println(dateCell);
                                result += "[" + dateCell + "]";
                            } catch (IllegalStateException e) {
                                e.printStackTrace();
                                // не получилось - и ладно - значит пустое значение
                            }

//
                            break;
                        default:
                            result += "|";
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
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
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
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator( );
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
        String fileNameLocal;
        fileNameLocal= new ExcelTimeYoutube().getFileName();

        int columnIndexTimeYoutube = getColumnIndexTimeYoutube(fileNameLocal);
        System.out.println(ExcelParser.parseColumn(fileNameLocal,columnIndexTimeYoutube));
    }





}