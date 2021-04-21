#使用Spring MVC拦截器结合日志对用户请求进行拦截，

## 具体需求如下：

 1. 在登录页面进行登录，将请求提交给Controller进行处理

2. 将用户信息写入日志

3. 使用拦截器对用户请求进行拦截，在拦截器中判断用户是否登录，如果已登录就放行，否则重新跳转到登录页面。


##任务：

1, 编写登录页面，将请求提交给Controller

2, 编写实体类User，包括id,name,password字段和get、set方法

3, 编写UserController类,public class UserController {}

1) 定义登录方法,跳转到用户登录页面

2) 获取用户名和密码

3) 获取用户名和密码后进行判断,可以将用户名和密码都定义为admin,如果都正确,将用户对象添加到Session中,并重定向到主页面

4) 如果用户名密码错误,给出提示,重定向到登录页面

5) 编写退出方法,重定向到登录页面

### 4, 编写LoginInterceptor类并实现HandlerInterceptor接口

1) 获取用户信息,写入日志;如:用户ip地址,访问的url地址,客户端环境等

2) 获取请求的url,login页面公开,其余页面进行拦截

3) 获取session,判断session中是否有用户数据，如果有，则返回true，继续向下执行

4) 判断session中是否有用户数据，如果有，则返回true，继续向下执行

5, 结合课程案例完成配置文件的配置以及logback.xml文件的编写

![](11.gif)
