package video;

import java.util.Date;

public class SubtitleFilter {
    public static void main(String[] args) {
        filter();

    }

    public static void filter() {
        //  Вначале метод - получить субитры в диапазоне
        //  как по времени >= start  и <end
        //  00:24:19 до 00:26:09 -
        //  вывести в консоль
        //  скопировать в буфер обмена (для вставки)


        Date startTime = SubtitleTime.getNullDateWithTime(0,24,19);
        Date endTime = SubtitleTime.getNullDateWithTime(0,26,9);

        String content= new SubtitleMap().getFromDiapason(startTime,endTime);
        System.out.println(content);
    }


}
