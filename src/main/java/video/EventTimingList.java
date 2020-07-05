package video;

import java.util.*;

public class EventTimingList {
    List<TupleEventTiming<Integer, Date, String>> eventTimingList;

    public EventTimingList() {
        initStructure();
    }

    private void initStructure() {
        if (this.eventTimingList == null) {
            this.eventTimingList = new LinkedList<>(); //TreeMap
        }
    }

    private void prepareStructureIfNeed() {
        boolean blnNeedPrepare = false;

        if (eventTimingList.size()==0) {blnNeedPrepare = true;}
        if (blnNeedPrepare) {
            this.getStructureFromFile();
        }
    }

    public static void main(String[] args) {
        EventTimingList eventTimingList = new EventTimingList();
        eventTimingList.getStructureFromFile();
    }

    private void getStructureFromFile() {
        // Считаем текст из файла
        new ExcelParser().getEventTimingList(eventTimingList);
    }


    public String goByMap(
    ) {

        prepareStructureIfNeed();

        String result="";
//        result = SubtitleTime.timeToStringShort(startTime)
//                + " --> "
//                + SubtitleTime.timeToStringShort(endTime)
//                + "\n\n";


        //проход по Map
//        for (Map.Entry<Integer, TupleEventTiming<Integer, Date, String>> entry : eventTimingList.entrySet()) {
//            Integer numRow = entry.getValue().getNumRow();
//            Date timeYoutube = entry.getValue().getTimeYoutube();
//            String description = entry.getValue().getDescription();

//        }

        return result;

    }



}
