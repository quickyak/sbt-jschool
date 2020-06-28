package video;

public class TupleSrt<S1, S2> {
    private S1 first;
    private S2 second;

    public TupleSrt(S1 first, S2 second) {
        this.first = first;
        this.second = second;
    }

    public S1 getFirst() {
        return first;
    }

    public void setFirst(S1 first) {
        this.first = first;
    }

    public S2 getSecond() {
        return second;
    }

    public void setSecond(S2 second) {
        this.second = second;
    }




}
