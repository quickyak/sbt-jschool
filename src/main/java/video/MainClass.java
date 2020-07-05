package video;

import java.util.Date;
import java.util.List;

import static video.SubtitleTime.getNullDate;

public class MainClass {
    public static void main(String[] args){

        new MainClass().getSubtitleByEventTiming(0); //200

    }

    private void getSubtitleByEventTiming(int maxLength) {
        //даты из реестра
        int indexSheet = 2;
        List<Date> datesEventTiming =  new ExcelParser().getDates(indexSheet);
        //TODO дополнить datesEventTiming последней датой от SubtitleMap - последнего значения и в идеале в начале от первого значения 0 времени

        System.out.println("===============================================");
        System.out.println(new SubtitleFile().getFileName());
        System.out.println("===============================================");

        //в цикле получать содержимое
        Date startTime = getNullDate();
        Date endTime;
        for (Date date:datesEventTiming
             ) {
            endTime = date;

            String content = new SubtitleMap().getFromDiapason(startTime,endTime);
            String contentSubstring;
            if (maxLength > 0) {
                contentSubstring = content.substring(0,Math.min(maxLength, content.length()-1)); //часть подстроки - не более N символов ...
            } else {contentSubstring = content;}
            System.out.println(contentSubstring);

            startTime = endTime;
        }
    }
}
