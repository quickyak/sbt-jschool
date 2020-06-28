// основа взята из https://devcolibri.com/java-работа-с-файлами/

package hometask03;

import java.io.*;

public class FileWorker {
    private  String dirName;
    private  String fileName;
    private  String text;


    public  String getDirName() {
        return dirName;
    }

    public  void setDirName(String dirName) {
        this.dirName = dirName;
    }


    public  String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public  String getText() {
        return text;
    }

    public  void setText(String text) {
        this.text = text;
    }

    public  void main(String[] args)  {
        //Запись в файл
        FileWorker fileWorker = new FileWorker();
        fileWorker.setFileName(dirName + fileName);
        fileWorker.write(text);
    }

    public  void write(String text) {
        //Определяем файл
        File file = new File(getFileName());

        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст в файл
                out.print(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private  void existsFile() throws FileNotFoundException {
        File file = new File(getFileName());
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public  String read() throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        existsFile();

        //Определяем файл
        File file = new File(getFileName());

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }

    public  String getTextFromFile (String localFileName )   {
//        FileWorker fileWorker = new FileWorker();
        this.setFileName(localFileName);
        String result = null;
        try {
            result = this.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        System.out.println("Содержимое файла " + getFileName());
//        System.out.println(result);

        return result;
    }
}
