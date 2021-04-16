package top.xiongmingcai.aop.dao;

public class UserDao {
    public void insert(){
       if (true){
         throw  new RuntimeException("用户已存在") ;
       }
        System.out.println("新增用户数据");
    }
}
