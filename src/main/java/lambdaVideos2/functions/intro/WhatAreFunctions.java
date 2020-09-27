package lambdaVideos2.functions.intro;

/**
 * @author yongot
 * @created 2020-09-27 : 5:35 PM
 */
interface Movie {
    boolean isClassic(int movieId);
}

interface Person {
    boolean isEmployee(int empId);
}

interface Hospital {
    void admin(Patient patient);
}

interface Predicate<T> {
    boolean test(T t);
}

public class WhatAreFunctions {
}
