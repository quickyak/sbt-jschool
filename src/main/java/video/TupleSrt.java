package video;

public class TupleSrt<S1 extends String, S2 extends String> {
    private S1 first;
    private S2 second;

    public TupleSrt(S1 first, S2 second) {
        this.first = first;
        this.second = second;
    }

    public S1 getFirst() {
        return first;
    }
    //00:00:00,000 --> 00:00:10,019


    public S2 getSecond() {
        return second;
    }
}
