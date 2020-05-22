package hometask04;

public class GenericTest {
//    private static final Logger logger = LoggerFactory

    interface BoxAware<T> {
        T getValue();

        void setValue (T value);
    }

    class Box <T, V> {
        private T value;
        private V message;

        


    }



}
