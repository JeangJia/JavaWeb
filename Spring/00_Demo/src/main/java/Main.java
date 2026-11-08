import com.jeang.config.SpringConfig;
import com.jeang.dao.UserImpl;
import com.jeang.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//        UserImpl ctxBean1 = ctx.getBean(UserImpl.class);
//        UserImpl ctxBean2 = ctx.getBean(UserImpl.class);
//        ctxBean1.save();
//        System.out.println(ctxBean1 + "\n" + ctxBean2);
//        ctx.close();
        UserService userService = ctx.getBean(UserService.class);
        userService.save();
    }
}
