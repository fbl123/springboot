import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

public class Test {


    public static void main(String[] args) {

        for (int h = 1; h <= 5; h++) {

            for (int i = 1; i <= h; i++){
                System.out.print("*");
            }

            System.out.println();

        }

    }

}

