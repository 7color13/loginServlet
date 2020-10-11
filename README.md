# login Servlet

http://www.liurui13.cn:8080/login.html   
登录成员候选(密码用md5加密，解码后均为1234)
![avatar](http://www.liurui13.cn/img/t_users.png)
改进后的github链接： https://github.com/7color13/cookie-filter   

### 一、文件目录

![avatar](http://www.liurui13.cn/img/source.png)



### 二、数据库结构

![avatar](http://www.liurui13.cn/img/sql.png)


### 三、部分解释

1. 项目设置了拦截器，检测用户登录状态
2. 主页部分未要求超链接（如论坛等），自己随意加了超链接
3. 项目启动状态是默认80端口映射路径/loginWeb
4. 首页未做变更
5. 为更生动形象展现，进行了http端口映射，可直接访问http://www.liurui13.cn:8080/login.html  查看
6. 下载功能在Windows端正常

![avatar](http://www.liurui13.cn/img/download.png)
在服务器端文件名有下划线

