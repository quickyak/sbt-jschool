package video;

import java.util.Date;

public class Srt {
    public static void main(String[] args) {

        //  Вначале метод - получить субитры в диапазоне
        //  как по времени >= start  и <end
        //  00:24:19 до 00:26:09 -
        //  вывести в консоль
        //  скопировать в буфер обмена (для вставки)


        Date startTime = SubtitleTime.getNullDateWithTime(0,24,19);
        Date endTime = SubtitleTime.getNullDateWithTime(0,26,9);


        Srt srt = new Srt();
        String test= srt.getFromDiapazon(startTime,endTime);
        System.out.println(test);

    }

    public String getFromDiapazon(
            Date startTime,
            Date endTime
    ) {
        String result;


        result = startTime + " --> " + endTime;
        return result;

    };
}
