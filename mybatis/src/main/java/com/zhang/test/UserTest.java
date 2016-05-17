package com.zhang.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.zhang.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


/**
 * @author zhangxinzheng
 * @Date 2016/4/20
 */
public class UserTest {
    public static void main(String[] args) throws IOException {
        // mybatis的配置文件
        String resource = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(in);
        // 得到SqlSession
        SqlSession sqlSession = sqlFactory.openSession();

        /*
         * 查询一条纪录
         * 通过SQLsession操作数据
         * 第一个参数为Student.xml定义的statement的id
         * 第二个参数：输入参数
         */
        List<User> users = sqlSession.selectList("test.getUsers");
        System.out.println(users.size());
        //释放资源
        sqlSession.close();
    }
    //模糊查询
    @Test
    public void testFindByUsername() throws Exception {
        // 创建会话工厂
        SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        // 得到SqlSession
        SqlSession sqlSession = sqlFactory.openSession();
        //list中的user和映射文件中的resultType所指定的类型一致
        List<User> list =sqlSession.selectList("test.findUserByName", "小明");
        for(User user: list){
            System.out.println(user);
        }
        sqlSession.close();
    }
}
