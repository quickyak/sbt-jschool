package video;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import video.subtitle.SubtitleTime;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static video.subtitle.SubtitleTime.getNullDate;
import static video.subtitle.SubtitleTime.getNullDateWithTime;

public class ExcelParser {
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        if ((this.fileName == null) || (this.fileName.length() == 0)) {
            // если не было инициализровано ранее - инициализируем
            setFileName(new ExcelTimeYoutube().getFileName());
        }
        return this.fileName;
    }

    public static void main(String[] args) {
        int indexSheet;
        indexSheet = 2;
//        System.out.println(new ExcelParser().getDates(indexSheet));
        System.out.println(new ExcelParser().getDescriptionForYoutubeVideo(indexSheet));
    }

    public List<Date> getDates(int indexSheet) {
        int columnIndexTimeYoutube = getColumnIndexTimeYoutube(indexSheet);
        System.out.println("columnIndexTimeYoutube Время YouTube  = " + columnIndexTimeYoutube);

        List<Date> dates = new ArrayList<>();

        getDatesFromColumn(true,
                indexSheet,
                columnIndexTimeYoutube, dates);
        return dates;
    }

    public String getDescriptionForYoutubeVideo(int indexSheet) {
        int columnIndexTimeYoutube = getColumnIndexTimeYoutube(indexSheet);
        System.out.println("columnIndexTimeYoutube Время YouTube  = " + columnIndexTimeYoutube);
        int columnIndexTextDescription = getColumnIndexDescription(indexSheet);
        System.out.println("columnIndexTextDescription Описание = " + columnIndexTextDescription);

        List<Date> dates = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();

        getDatesDescriptionsFromColumn(true,
                indexSheet,
                columnIndexTimeYoutube, dates,
                columnIndexTextDescription, descriptions);

        String sTime;
        boolean isNextDateAfterNullDate = false;
        StringBuilder descriptionForYoutubeVideo = new StringBuilder();

        for (int i = 0; i < dates.size(); i++) {

            if (dates.get(i).after(getNullDate())) {
                sTime = SubtitleTime.timeToStringShort(dates.get(i));
            } else {
                sTime ="";
            }

            if (sTime.length() == 0) {
                if (!isNextDateAfterNullDate) {
                    //по факту последнее нулевое время перед первым ненулевым
                    if ((i+1) < dates.size()) {
                        if (dates.get(i + 1).after(getNullDate())) {
                            sTime = SubtitleTime.timeToStringShort(dates.get(i));
                            isNextDateAfterNullDate = true; //один раз должно сработать
                        }
                    }
                }
            }

            descriptionForYoutubeVideo.append(sTime).append(" ").append(descriptions.get(i)).append("\n");
        }
        return descriptionForYoutubeVideo.toString();

//        List<TupleEventTiming<Integer, Date, String>> tuplesEventTiming;
//        //TODO
//        TupleEventTiming
    }

    public void getEventTimingList(
            List<TupleEventTiming<Integer, Date, String>> tuplesEventTiming
    ) {
        int indexSheet = 2;
//
//        TupleEventTiming tupleEventTiming;
//        tupleEventTiming = new TupleEventTiming<Integer, Date, String>(cell.getRowIndex(), dateOnlyTime, "Тест");
//        tuplesEventTiming.add(tupleEventTiming);
//
//        getDatesDescriptions()
    }

    public void getDatesFromColumn(
            boolean blnSkipFirstRow
            , int indexSheet
            , int columnIndexDate
            , List<Date> dates
    ) {
        //инициализируем потоки - получим итератор
        Iterator<Row> it = getRowIterator(indexSheet);

        //Пропустим первую строку - заголовков
        if (blnSkipFirstRow) {
            if (it.hasNext()) {
                it.next();
            }
        }

        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();

            Date dateOnlyTime = getNullDate();
            boolean blnDate = false;
            try {
                Cell cell = row.getCell(columnIndexDate);
                blnDate = getDateFromCell(cell, dateOnlyTime);
//                if (blnDate) blnDate = dateOnlyTime.after(getNullDate()); //только ненулевые даты со временем
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            if (blnDate) dates.add(dateOnlyTime);
        }
    }

    public void getDatesDescriptionsFromColumn(
            boolean blnSkipFirstRow
            , int indexSheet
            , int columnIndexDate
            , List<Date> dates
            , int columnIndexString
            , List<String> descriptions
    ) {
        //инициализируем потоки - получим итератор
        Iterator<Row> it = getRowIterator(indexSheet);

        //Пропустим первую строку - заголовков
        if (blnSkipFirstRow) {
            if (it.hasNext()) {
                it.next();
            }
        }

        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();

            Date dateOnlyTime = getNullDate();
            boolean blnDate = false;
            try {
                Cell cell = row.getCell(columnIndexDate);
                blnDate = getDateFromCell(cell, dateOnlyTime);
//                if (blnDate) blnDate = dateOnlyTime.after(getNullDate()); //только ненулевые даты со временем
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
//            if (blnDate) dates.add(dateOnlyTime);

            String sDescription = "";
            boolean blnDescription = false;
            try {
                Cell cell = row.getCell(columnIndexString);
                sDescription = getStringFromCell(cell);
                blnDescription = (sDescription.length() > 0);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
//            if (blnDescription) descriptions.add(sDescription);

            if (blnDate || blnDescription) {
                //синхронизированные по индексу массивы
                dates.add(dateOnlyTime);
                descriptions.add(sDescription);
            }
        }
    }

    public boolean getDateFromCell(Cell cell, Date dateFromCell) {
        Date dateOnlyTime = getNullDate();
        boolean result = false;

        try {
            if (cell == null) {
                dateFromCell.setTime(getNullDate().getTime());
                return false;
            }

            CellType cellType = cell.getCellType();

            //перебираем возможные типы ячеек
            switch (cellType) {
                case STRING:
                    break;

                case FORMULA:
                case NUMERIC:
                    try {
                        Date dateCell = cell.getDateCellValue();  //пробую считать время
                        //Так как здесь только время, то даты приведем к 1970 году
                        dateOnlyTime = getNullDateWithTime(dateCell);
                        result = true;
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                        // не получилось - и ладно - значит пустое значение
                    }
                    break;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        if (result) {
            dateFromCell.setTime(dateOnlyTime.getTime());
        }
        return result;
    }

    public String getStringFromCell(Cell cell) {
//        boolean result = false;
        String s = "";

        try {
            if (cell == null) {
                return s;
            }

            CellType cellType = cell.getCellType();

            //перебираем возможные типы ячеек
            switch (cellType) {
                case STRING:
                    try {
                        s = cell.toString();
//                        result = true;
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                        // не получилось - и ладно - значит пустое значение
                    }
                    break;

                case FORMULA:
                case NUMERIC:
                    break;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return s;
    }

    public Iterator<Row> getRowIterator(int indexSheet) {
        InputStream inputStream;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(getFileName());
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем indexSheet лист входного файла на объектную модель (начинается с 0 индексы)
        assert workBook != null;
        Sheet sheet = workBook.getSheetAt(indexSheet);
        return sheet.iterator();
    }

    public int getColumnIndexTimeYoutube(int indexSheet) {
        return getColumnIndexBySearchString(indexSheet, "Время YouTube");
    }

    public int getColumnIndexDescription(int indexSheet) {
        return getColumnIndexBySearchString(indexSheet, "Описание");
    }

    //Найти столбец searchString в первой строке первого листа
    public int getColumnIndexBySearchString(int indexSheet, String searchString) {
//        searchString = "Время YouTube"

        //инициализируем потоки
        int result = -1;
        Iterator<Row> it = getRowIterator(indexSheet);

        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            for (Cell cell : row) {
                CellType cellType = cell.getCellType();

                try {
                    //перебираем возможные типы ячеек
                    switch (cellType) {
                        case STRING:
                            if (cell.getStringCellValue().equalsIgnoreCase(searchString)) {
                                result = cell.getColumnIndex();
                                return result;
                            }
                            break;
                    }
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}