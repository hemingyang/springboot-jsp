# springboot-jsp 介绍 #

<pre>它是一个典型的MVC三层框架，快速简单的上手。</pre>

#### springboot-jsp

+ 包含框架有：SpringBoot、SpringMVC、MyBaits、Bootstrap3、Druid,Swagger；
+ 集成示例有：增删改查及分页;防XSS、SQL注入, SpringAop ,热加载；
+ 前端采用的jsp、springboot对jsp支持不是很友好，建议编译打包成war；

#### 数据库配置
+ 默认是连接的MySQL数据库，支持多数据源，分别连接的db1,db2 ，在项目工程的db文件夹下有数据库初始化脚本；
+ 如果切换至sqlite数据库时，则application.properties当中的mybatis分页插件需要改成支持sqlite；

#### 示例启动

+ 启动工程；
+ 运行cn.springboot.Application当中的main方法；
+ 浏览器访问http://localhost:8090, 测试账号是admin/123456，即可看示例效果；
+ Druid:<http://localhost:8090/druid/login.html>  admin/123456
+ swagger:<http://localhost:8090/swagger-ui.html#/> 

#### 关于编译打包
+ 采用maven编译打包后，会在target目录下生成springboot-jsp.war；
+ 采用命令：java -jar springboot-jsp.war , 即可运行；
