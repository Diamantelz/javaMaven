package lesson18;

public class ParametrizedMethod {
    public static void main(String[] args) {
        ParamMethod method = new ParamMethod();
        method.print("text", 13);
    }
}

class ParamMethod {
    private int i = 0;
    public <K, V> void print(K key, V value) {
        System.out.println(key + " " + value);
    }
}
