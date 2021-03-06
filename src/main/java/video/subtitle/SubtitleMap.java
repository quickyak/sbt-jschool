package video.subtitle;

import java.util.*;

public class SubtitleMap {
    Map<Integer, TupleSrt<String, String>> mapSrt;

    public SubtitleMap() {
        initMap();
    }

    private void initMap() {
        if (this.mapSrt == null) {
            this.mapSrt = new TreeMap<>();
        }
    }

    private void prepareMapIfNeed() {
        boolean blnNeedPrepare = false;

        if (mapSrt.size()==0) {blnNeedPrepare = true;}
        if (blnNeedPrepare) {
            this.getMapFromFile();
        }
    }

    public static void main(String[] args) {
        SubtitleMap subtitleMap = new SubtitleMap();
//        subtitleMap.printMap();
        subtitleMap.testGetFromDiapason();





        // Сохраним содержимое мапы в Базу данных

    }

    private void getMapFromFile() {
        // Считаем текст из файла
        String content = new SubtitleFile().getTextFromFile();

        // Перееведем текст в мапу
        textToMap(content);
    }

    private void testGetFromDiapason() {
        //  Вначале метод - получить субитры в диапазоне
        //  как по времени >= start  и <end
        //  00:24:19 до 00:26:09 -
        //  вывести в консоль
        //  скопировать в буфер обмена (для вставки)


        Date startTime = SubtitleTime.getNullDateWithTime(0, 24, 19);
        Date endTime = SubtitleTime.getNullDateWithTime(0, 26, 9);

        String content = getFromDiapason(startTime, endTime);
        System.out.println(content);
    }

    public String getFromDiapason(
            Date startTime,
            Date endTime
    ) {

        prepareMapIfNeed();

        StringBuilder result;
        result = new StringBuilder(SubtitleTime.timeToStringShort(startTime)
                + " --> "
                + SubtitleTime.timeToStringShort(endTime)
                + "\n\n");


        //проход по Map
        for (Map.Entry<Integer, TupleSrt<String, String>> entry : mapSrt.entrySet()) {
            SubtitleTime subtitleTime = new SubtitleTime(entry.getValue().getFirst());


            boolean isStart = false;
            boolean isEnd = false;


//            date1.compareTo(date2) > 0) {
//                System.out.println("Date1 is after Date2");

            // Основная доля субтитров
            // S<=s (S - диапазон, s - субтитры)
            if (subtitleTime.getStartTime().compareTo(startTime) >= 0) {
                isStart = true;
            }
            // e<=E
            if (subtitleTime.getEndTime().compareTo(endTime) <= 0) {
                isEnd = true;
            }

            //Граничные субтитры по началу s<=S<=e
            if ((subtitleTime.getStartTime().compareTo(startTime) <= 0) &&
                 (subtitleTime.getEndTime().compareTo(startTime) >= 0))
            {
                isStart = true;
                isEnd = true;
            }


            if (isStart && isEnd) {
                //в нужной записи
                String entryText = getEntrySubtitle(entry, subtitleTime);
                result.append(entryText).append("\n");
//                System.out.println(entryText);
            }
        }

        return result.toString();

    }

    private String getEntry(Map.Entry<Integer, TupleSrt<String, String>> entry, SubtitleTime subtitleTime) {
        return
        entry.getKey()
//                                + " (" + timeSrt.toStringStart() + ") "
                        + " (" + subtitleTime.toStringMiddle() + ") "
                        + entry.getValue().getSecond()
//                                + " || " + timeSrt.toStringStart()
                //                       + entry.getValue().getFirst()
        ;
    }

    private String getEntrySubtitle(Map.Entry<Integer, TupleSrt<String, String>> entry, SubtitleTime subtitleTime) {
        return
//                entry.getKey()
//                                + " (" + timeSrt.toStringStart() + ") "
//                        + " (" + subtitleTime.toStringMiddle() + ") "
                entry.getValue().getSecond()
//                                + " || " + timeSrt.toStringStart()
                //                       + entry.getValue().getFirst()
        ;
    }

    private void printMap() {
        for (Map.Entry<Integer, TupleSrt<String, String>> entry : mapSrt.entrySet()) {
            SubtitleTime subtitleTime = new SubtitleTime(entry.getValue().getFirst());
            System.out.println(
                    getEntry(entry, subtitleTime)
            );
        }
    }


    public void textToMap(String text) {
        //? Как напечатать только 1,5,9 строки
//        Stream

//        System.out.println("Текст ");
//        System.out.println(text);


        //? Сколько строк \n
        // https://ru.stackoverflow.com/questions/725999/Как-посчитать-количество-вхождений-символа-в-строку
//        long occurence = text.codePoints().filter(ch -> ch == '\n').count();
//        System.out.println("Количество строк в файле = " + occurence);
//        long occurenceBlock = occurence/4;

        List<String> strings;
        strings = Arrays.asList(text.split("\n"));

//        int numRow=0;
        int idxBlock = 0;

        int key = 0;
        String first = "";
        String second = "";


        for (String string : strings
        ) {
            switch (idxBlock) {
                //0 - is key
                //1 - is String diapason
                //2 - is Caption
                //3 - is empty String
                case 0:
                    key = Integer.parseInt(string);
                    break;
                case 1:
                    first = string;
                    break;
                case 2:
                    second = string;
                    break;
                case 3:
                    //empty string
                    //populate map
                    mapSrt.put(key,
                            new TupleSrt<>(first, second)
                    );
                    break;
            }

//            numRow++;
            idxBlock++;
            if (idxBlock == 4) idxBlock = 0; //далее идет новый блок
        }
    }


}
