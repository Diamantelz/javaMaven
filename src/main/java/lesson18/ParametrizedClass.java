package lesson18;

public class ParametrizedClass {
    public static void main(String[] args) {
        Param<String, Integer> parameter = new Param<>("test", 13);
        Integer print = parameter.print();
        System.out.println(print);
    }
}

class Param<T, R> {
    private T value;
    private R variable;

    public Param() {
    }

    public Param(T value, R variable) {
        this.value = value;
        this.variable = variable;
    }

    public R print() {
        System.out.println(value);
        return variable;
    }
}