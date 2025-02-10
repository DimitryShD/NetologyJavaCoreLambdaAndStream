import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();


        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        int c = calc.devide.apply(a, b);

        calc.println.accept(c);

        int d = calc.pow.apply(a);
        calc.println.accept(d);
//        System.out.println("Hello world!");

    }
}

class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> {
//        if (y==0) {
//            throw new ArithmeticException("Деление на ноль");
//        } else {
//            return x / y;
//        }
        try {
            int i = x / y;
            return i;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }
        return 0;
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

}