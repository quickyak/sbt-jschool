package video;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;


// Сохраним содержимое мапы в Excel
//      Apache POI - the Java API for Microsoft Documents
//      http://poi.apache.org
//      https://javadevblog.com/rabotaem-s-excel-v-java.html
//          подключить библиотеку в maven


public class ExcelTimeYoutube {
    private String fileName;
    private int intNumFileName;

    Date startTimeYoutube;


    Integer numRow;
    String block;

    Date startTimeCorner;
    String description;


//    Для чтения книги из файла можно применить следующий код:
    public static HSSFWorkbook readWorkbook(String filename) {
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filename));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            return wb;
        }
        catch (Exception e) {
            return null;
        }
    }

    private  int getDefaultNumFileName() {
        //номер файла по умолчанию, с которым работаем
        return 0;
    }

    private void setFileName(int intNumFileName) throws FileNotFoundException {
        String fileNameLocal = "";

        switch (intNumFileName) {
            case 0:
                fileNameLocal = "/Users/yaroslav/Desktop/ВремяYouTube.xlsx";
                break;

            default:
                //неясно с каким файлом работать
                throw new FileNotFoundException((intNumFileName) + "Could not find file: int intNumFileName in setFileName");
        }
        setFileName(fileNameLocal);
    }


    public ExcelTimeYoutube()  {
        setFileNameByNumFile(this.getDefaultNumFileName());
    }

    public ExcelTimeYoutube(int intNumFileName){
        setFileNameByNumFile(intNumFileName);
    }

    private void setFileNameByNumFile(int intNumFileName) {
        try {
            this.setFileName(intNumFileName);
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    public ExcelTimeYoutube(String fileName) {
        this.setFileName(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    private void setFileName(String fileName) {
        this.fileName = fileName;
    }






    public static void main(String[] args) {
        System.out.println(new ExcelTimeYoutube().getFromFile());
    }

    public  String getFromFile ()   {

        String result = getFileName();

        return result;
    }


}
