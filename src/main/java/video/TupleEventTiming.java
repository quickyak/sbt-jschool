package video;

import java.util.Date;

public class TupleEventTiming<S1 extends Integer, S2 extends Date, S3 extends String> {
    private S1 numRow;
    private S2 timeYoutube;
    private S3 description;
//    String block;
//    Date timeCorner;
//    String description;

    public TupleEventTiming(S1 numRow, S2 timeYoutube, S3 description) {
        this.numRow = numRow;
        this.timeYoutube = timeYoutube;
        this.description = description;
    }

    public S1 getNumRow() {
        return numRow;
    }
    //номер строки Excel файла (из OneNote)


    public S2 getTimeYoutube() {
        return timeYoutube;
    }

    public S3 getDescription() {
        return description;
    }





    //методы
    //  считать из OneNote  (как бы предварительно не пришлось сохранять в Excel для обработки)
    //  ? в какую структуру данных? - можно в TreeMap
    //  сохранить в БД?

    //  далее нарезка по стартовому времени YouTube с субтитрами - и здесь основная работа
    //  там нужны отсечки по времени YouTube

    //  Хорошо бы текст из SRT получить в виде оформленных предложений.... (чтобы не сплошным текстом)
    //  Можно ли получить ключевые слова из текста (этого блока) - частотную статистику слов?


    //  Вначале метод - получить субитры в диапазоне
    //  как по времени >= start  и <end
    //  00:24:19 до 00:26:09 -
    //  вывести в консоль
    //  скопировать в буфер обмена (для вставки)


    //  так и по номерам комментариев? - нужно как промежуточный пункт ...
}
