package lambdaVideos2.streams.commonops;

import lambdaVideos2.domain.Student;
import lambdaVideos2.domain.Trade;
import lambdaVideos2.util.TradeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author yongot
 * @created 2020-09-28 : 9:21 PM
 */
public class OptionalType {
    List<Trade> trades = TradeUtil.createTrades();

    private void attendeesOptional() {
        List<Integer> attendees = Arrays.asList(22, 34, 56, 19);
        Optional<Integer> attendeesOptional = attendees.stream().reduce(Integer::sum);

        System.out.println("attendeesOptional: " + attendeesOptional.get());
    }

    private void noAttendeesOptional() {
        List<Integer> attendees = Arrays.asList();
        Optional<Integer> attendeesOptional = attendees.stream().reduce(Integer::sum);

        // No Such element exception
        if (attendeesOptional.isPresent()) {
            System.out.println("noAttendeesOptional: " + attendeesOptional.get());
        }
    }

    private void creatingOptionals() {
        Student student = new Student();
        Optional<Student> studentOptional = Optional.of(student);
        System.out.println("creatingOptionals: " + studentOptional.get());

        studentOptional.ifPresent(System.out::println);

        student = null;
        Optional<Student> studentOptional2 = Optional.ofNullable(student);
        System.out.println("Student can't be null: " + studentOptional2);
    }

    private void ifElseOptionals() {
        Student student = null;
        Student defaultStudent = new Student();
        defaultStudent.setName("Default John");
        Optional<Student> studentOptional = Optional.ofNullable(student);
        String name = studentOptional.orElse(defaultStudent).getName();

        System.out.println("ifElseOptionals: " + name);

    }

    private void ifElseThrowOptionals() throws Exception {
        Student student = null;
        Optional<Student> studentOptional = Optional.ofNullable(student);
        studentOptional.orElseThrow(Exception::new);
    }

    private void filterMapOptionals() {
        Student st = new Student();
        st.setName("John Lingham");

        Optional<Student> stOptional = Optional.of(st);
        stOptional.filter(student -> student.hasTeacher())
                .ifPresent(System.out::println);

        stOptional.map(s -> s.getName()).ifPresent(System.out::println);
    }

    public static void main(String ... args) throws Exception {
//        new OptionalType().attendeesOptional();
//        new OptionalType().noAttendeesOptional();
//        new OptionalType().creatingOptionals();
//        new OptionalType().ifElseOptionals();
//        try {
//            new OptionalType().ifElseThrowOptionals();
//        } catch (Exception e) {
//            System.err.println("Exception ");
//            e.printStackTrace();
//        }
        new OptionalType().filterMapOptionals();
    }
}
