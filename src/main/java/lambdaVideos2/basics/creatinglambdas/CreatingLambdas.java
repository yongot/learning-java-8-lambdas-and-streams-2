package lambdaVideos2.basics.creatinglambdas;

/**
 * Creating a lambda expression
 *
 * @author yongot
 */
public class CreatingLambdas {

    interface Greeting{
        String sayHello(String name);
    }

    public void testGreeting(String name, Greeting g) {
        String result = g.sayHello(name);
        System.out.println("Result:" + result);
    }

    public static void main(String ... args) {
        // input -> body
       // (String s) -> "Hello, "+s;
        new CreatingLambdas().testGreeting("Harry", (String s) -> "Hello, "+s);

        new CreatingLambdas().testGreeting("Miss Pingu", (String s) -> "Hello, "+s);

        // (String p) -> !p.isEmpty()? "Howdy, "  + p : "Did you miss something?"
        new CreatingLambdas().testGreeting("", (String p) -> !p.isEmpty()? "Howdy, "  + p : "Did you miss something?");

    }
}
