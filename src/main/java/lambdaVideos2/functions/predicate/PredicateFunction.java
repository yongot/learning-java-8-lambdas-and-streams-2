package lambdaVideos2.functions.predicate;

import java.util.function.Predicate;

/**
 * @author yongot
 * @created 2020-09-27 : 8:01 PM
 */
// java.util.function.Predicate functional interface
public class PredicateFunction {

    Predicate<Employee> bonusLambda = (emp) -> emp.getRatings() > 10? true: false;
    Predicate<Employee> execLambda = (emp) -> emp.getId().startsWith("E99")?true:false;
    Predicate<String> emptyString = s -> s.isEmpty();

}
