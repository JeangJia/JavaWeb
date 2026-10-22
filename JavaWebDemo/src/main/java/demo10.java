import com.alibaba.fastjson.JSON;
import com.jeang.pojo.User;

public class demo10 {
    public static void main(String[] args) {
        User user = new User(1, "jeang", "123456");
        // 将对象转换为json字符串
        String json = JSON.toJSONString(user);
        System.out.println(json);
        // 将json字符串转换为对象
        User user1 = JSON.parseObject(json, User.class);
        System.out.println(user1.toString());
    }
}
