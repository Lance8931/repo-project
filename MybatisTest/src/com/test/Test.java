package com.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import static org.apache.ibatis.jdbc.SqlBuilder.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.user.bean.Article;
import com.user.bean.User;
import com.user.mapper.MyResultHandler;
import com.user.mapper.UserMapper;

/**
 *	测试类
 *
 * @author siping-L.J.H
 * @date 2016年3月7日上午11:02:59
 * @version 1.0
 */
public class Test {
	private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader; 

    static{
        try{
            reader  = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    
    public void selectUserByID(SqlSession session, UserMapper userOperation, int id){
    	
        User user = userOperation.selectUserByID(id);
        System.out.println(user.getUserAddress());
        System.out.println(user.getUserName());
    }
    
    public void selectUsers(SqlSession session, UserMapper userOperation, String name){
    	List<User> users = userOperation.selectUsers("%");
        for(User use:users){
            System.out.println(use.getId()+":"+use.getUserName()+":"+use.getUserAddress());
        }
    }
    
    public void addUser(SqlSession session, UserMapper userOperation){
    	User user= new User();
        user.setUserAddress("人民广场");
        user.setUserName("飞鸟");
        user.setUserAge(80);
        userOperation.addUser(user);
        session.commit();
        System.out.println("当前增加的用户 id为:"+user.getId());
    }
    
    public void updateUser(SqlSession session, UserMapper userOperation){
    	User user2 = userOperation.selectUserByID(2);            
        user2.setUserAddress("原来是魔都的浦东创新园区");
        userOperation.updateUser(user2);
        session.commit();
    }
    
    public void deleteUser(SqlSession session, UserMapper userOperation, int id){
    	userOperation.deleteUser(id);
        session.commit();
    }
    
    public void getUserArticle(SqlSession session, UserMapper userOperation, int userid){
    	  List<Article> articles = userOperation.getUserArticles(userid);
          for(Article article:articles){
              System.out.println(article.getTitle()+":"+article.getContent()+
                      ":作者是:"+article.getUser().getUserName()+":地址:"+
                       article.getUser().getUserAddress());
          }
    }
    
    public void selectUsersByHandler(SqlSession session, UserMapper userOperation, String name){
    	//失败
    	List<User> users = userOperation.selectUsersByHandler(name, new MyResultHandler());
        for(User use:users){
            System.out.println(use.getId()+":"+use.getUserName()+":"+use.getUserAddress()+":"+use.getUserAge());
        }
    }
    
    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
	        User user = (User) session.selectOne("com.user.mapper.UserMapper.selectUserByID", 1);
	        System.out.println(user.getUserAddress());
	        System.out.println(user.getUserName());
	        
	        Test test = new Test();
	        UserMapper userOperation= session.getMapper(UserMapper.class);

	        
	       // test.selectUserByID(session, userOperation, 1);
	        
            //test.selectUsers(session, userOperation, "%");
            
            //test.addUser(session, userOperation);
            
            //test.updateUser(session, userOperation);
            
            //test.deleteUser(session, userOperation, 2);
            
            //test.getUserArticle(session, userOperation, 1);
	        
	        test.selectUsersByHandler(session, userOperation, "%");
        } finally {
        	session.close();
        }
    }
}
