
import com.it.dao.UserMapper;
import com.it.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Test {

    private UserMapper mapper;
        @Before
        public void Before() throws IOException {
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = SqlSessionFactory.openSession(true);
            mapper = sqlSession.getMapper(UserMapper.class);
        }

         @org.junit.Test
         public void test2() throws IOException {

             InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
             SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
             SqlSession sqlSession = sqlSessionFactory.openSession();
             UserMapper mapper = sqlSession.getMapper(UserMapper.class);

             List<User> userList = mapper.findAll();
             for (User user : userList) {
                 System.out.println(user);
             }
             sqlSession.commit();
             sqlSession.close();
         }

        @org.junit.Test
        public void test1() throws IOException {
            User user1 = new User();
            user1.setId(6);
            user1.setUsername("231");
            user1.setPassword("3429");
            user1.setBirthday(new Date());

            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            mapper.save(user1);
            sqlSession.commit();
            sqlSession.close();
        }
    }


