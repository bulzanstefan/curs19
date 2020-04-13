package ro.fasttrackit.mvnbase.curs19;

public class Main {
    public static void main(String[] args) {
        customLambda();
        standardLambda();
    }

    private static void standardLambda() {

    }


    private static void customLambda() {
        usingOperations(new Increment());
        usingOperations(new Multiply2());
        usingOperations(new MyLambda() {
            @Override
            public int intOperation(final int a) {
                return a + 4;
            }
        });

        usingOperations(x -> x / 2);
        usingOperations(elem -> elem / 2);
        usingOperations((x) -> x / 2);
//        usingOperations((String x) -> x + 2);  //compilation error
//        usingOperations(x -> ""); //compilation error
        usingOperations(x -> {
            int a = 3;
            return x + a;
        });
    }

    public static void usingOperations(MyLambda myLambda) {
        System.out.println(myLambda.intOperation(3));
    }
}

class Increment implements MyLambda {
    @Override
    public int intOperation(int y) {
        return y + 1;
    }
}

class Multiply2 implements MyLambda {

    @Override
    public int intOperation(final int a) {
        return a * 2;
    }
}
