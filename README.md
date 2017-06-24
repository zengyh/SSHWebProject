# SSHWebProject
SSHWebProject SSH项目（集成其它的框架），集成的框架有：spring、hibernate、strust2、oscache<br>
实现的功能有：<br>
1）用户登陆、查看在线用户列表、导出所用用户列表
2）Oscache缓存页面
3）利用Spring AOP进行日志记录
4）利用Filter和ThreadLocal实现请求上下文，通过该请求上下文可以获取当前用户信息、request、session、cookie等
5）利用Filter进行权限控制，没有登录成功就表示用户没有访问权限，访问没有权限的资源都会拦截并跳转到登陆提示页面，要求用户登陆！
