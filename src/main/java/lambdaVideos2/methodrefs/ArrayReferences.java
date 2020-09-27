package lambdaVideos2.methodrefs;

/**
 * @author yongot
 * @created 2020-09-27 : 4:55 PM
 */
public class ArrayReferences {
    interface StringArray {
        String[] create(int size);
    }

    private void testArrayConstructorReferences() {
        StringArray sArray = (size) -> new String[size];
        StringArray sArray2 = String[]::new;
    }

    public static void main(String ... args) {

    }
}
