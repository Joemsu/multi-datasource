## 一、项目相关博客地址：http://www.cnblogs.com/joemsu/p/8028210.html

## 二、启动说明：
    先在sql目录下获取init.sql文件，然后再mysql数据库执行，修改对应的application.yml，然后运行各个module的Application文件，访问地址

## 三、关于本项目的说明：
    multi-datasource-problem 模块项目是为了演示多数据源的情况下，配置`@Primary`后导致的事务出现的问题
    multi-datasource-jta 模块是采用Atomikos，实现分布式事务，解决上述模块的问题