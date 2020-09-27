package lambdaVideos2.functions.predicate;

/**
 * @author yongot
 * @created 2020-09-27 : 8:03 PM
 */
public class Employee {
    private String id = null;
    private int ratings = 10;
    public Employee(String empId) {
        this.setId(empId);
    }

    public int getRatings() {
        return ratings;
    }
    public void setRatings(int rating) {
        this.ratings = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
