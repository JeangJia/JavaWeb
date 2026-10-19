import com.jeang.mapper.UserMapper;
import com.jeang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    public static void main(String[] args) throws Exception {
//        showList();
//        selectById(3);
//        String name="";
//        int age=20;
//        filterUsers(name,age);
//        String name = "jeang";
//        int age = 20;
//        String phone = "12345678901";
//        User user = new User(0, name, age, phone);
//        addUser(user);
//        System.out.println(user.getId());
//        deleteUser(7);
        deleteUserList(new int[]{6});
        showList();
    }

    public static void showList() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAllUsers();
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    public static void selectById(int id) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectUserById(id));
        sqlSession.close();
    }

    public static void filterUsers(String name, int age) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.filterUsers(name, age));
        sqlSession.close();
    }

    public static void addUser(User user) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        if (userMapper.addUser(user)) System.out.println("Add user successfully");
        else System.out.println("Add user failed");
        sqlSession.close();
    }
    public static void deleteUser(int id) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        if (userMapper.deleteUser(id)) System.out.println("Delete user successfully");
        else System.out.println("Delete user failed");
        sqlSession.close();
    }

    public static void deleteUserList(int[] ids) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        if (userMapper.deleteUsersList(ids)) System.out.println("Delete users successfully");
        else System.out.println("Delete users failed");
        sqlSession.close();
    }

}
