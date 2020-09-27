package lambdaVideos2.scope;

/**
 * @author yongot
 * @created 2020-09-27 : 4:22 PM
 */
public class LambdaScope extends SuperScope {

    private String member = "GRANDPA";

    interface Family {
        String who(String member);
    }

    public void testMember(String member) {
        System.out.println("Local member: " + member);
        System.out.println("Family this.member " + this.member);
        System.out.println("Family super.member " + super.member);

        Family familyLambda = (familyMember) -> {
            System.out.println("Local Lambda member: " + familyMember);
            System.out.println("Local Lambda member " + member);
            System.out.println("Local Lambda this.member " + this.member);
            System.out.println("Local Lambda super.member " + super.member);
            return familyMember;
        };

        familyLambda.who(member);

    }

    public static void main(String ... args) {
        new LambdaScope().testMember("SON");
    }

}
