import com.jeang.config.SpringConfig;
import com.jeang.dao.BookDao;
import com.jeang.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
//        bookDao.save();
//        System.out.println(bookDao.update());
        ctx.getBean(AccountService.class).TestService();
    }
}
