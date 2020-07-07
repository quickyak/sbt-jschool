package video.subtitle;

import hometask03.FileWorker;

import java.io.FileNotFoundException;


//хорошо бы в ресурсы проекта перенести - чтобы из репозитория можно было работать

public class SubtitleFile {
    private String fileName;
    private int intNumFileName;


    private  int getDefaultNumFileName() {
        //номер файла по умолчанию, с которым работаем
        return 2;
    }

    private void setFileName(int intNumFileName) throws FileNotFoundException {
        String fileNameLocal;

        switch (intNumFileName) {
            case 0:
                fileNameLocal = "/Users/yaroslav/Desktop/2020-06-26 Виктор.srt";
                break;

            case 1:
                fileNameLocal = "/Users/yaroslav/Downloads/Youtube/2020-06-26 Виктор.srt";
                break;

            case 2:
//                fileNameLocal = "/Users/yaroslav/Downloads/Video/ФУБ_Виктор/2020-06-30 Виктор 3_3часть модуль НЛП практик - SCORE - TOTE - Якоря/2020-06-30 Виктор.srt";
                fileNameLocal = "/Users/yaroslav/Desktop/2020-06-30 Виктор.srt";
                break;

            default:
                //неясно с каким файлом работать
                throw new FileNotFoundException((intNumFileName) + "Could not find file: int intNumFileName in setFileName");
        }
        setFileName(fileNameLocal);
    }


    public SubtitleFile()  {
        setFileNameByNumFile(this.getDefaultNumFileName());
    }

    public SubtitleFile(int intNumFileName){
        setFileNameByNumFile(intNumFileName);
    }

    private void setFileNameByNumFile(int intNumFileName) {
        try {
            this.setFileName(intNumFileName);
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    public SubtitleFile(String fileName) {
        this.setFileName(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    private void setFileName(String fileName) {
        this.fileName = fileName;
    }






    public static void main(String[] args) {
//        testConstructor();
        testGetText();
    }

    public static void testGetText() {
        // Считаем текст из файла
        String content = new SubtitleFile().getTextFromFile();
        System.out.println(content);
    }

    public static void testConstructor() {
        // Считаем текст из файла
        System.out.println(new SubtitleFile().getFileName());
    }

    public  String getTextFromFile ()   {
//        System.out.println("Содержимое файла " + getFileName());
        return new FileWorker().getTextFromFile(getFileName());
    }


}
