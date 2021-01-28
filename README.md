# admin_scaffolding
General backstage management system scaffold

# 项目简述
该项目是一个由spring boot + JPA + mysql + redis/cache 技术栈组成的通用后台管理系统脚手架，
开发任何一个管理系统可用基于此基础上开发，快速便捷。

# 系统功能
## 1，用户管理
此用户是指系统登录用户，而非业务用户。
用户权限采用Security、Oauth2、JWT实现权限认证。安全程度可直接使用到工作中。
添加用户和配置角色流程：
    1，添加一个用户
    2，添加一个角色
    3，添加一个资源
    4，角色绑定资源
    5，用户绑定角色
至此，业务代码可以根据用户的角色，进行不同业务流程的执行。

## 2，角色管理
角色在管理系统中很重要，不同角色拥有不同的权限。

## 3，资源管理
资源包括，业务，接口，前端等资源。角色绑定资源，即让绑定该角色的用户拥有了这些资源的权限。

## 4，菜单管理
暂无实现

## 5，数据字典
数据字典由开发人员开发，后续可自由调整。比如客户类型定义一个key，value是有普通，高级，顶级等三个，
后续可以由管理员配置value，实现修改客户类型，而不用修改代码。

## 6，日志管理
目前已实现的是，记录用户的访问哪些接口记录，通过aop切面技术实现的。

## 7，文件系统
暂未实现。

## 8，定时任务
暂未实现。


# 程序运行
程序运行步骤：
1，git clone 项目。
2，创建数据库和表结构，sql文件在resources/static/目录下。
3，修改application.yml文件中的redis地址和端口等配置，若访问本地redis，需要下载redis客户端，并启动redis服务。
4，修改application.yml文件中的datasource的配置，数据库地址和用户信息的配置。
5，启动服务。