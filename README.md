#iServer_Example
##iServer_Example是什么?
iServer_Example包含一个扩展iServer REST资源的maven工程，该示例工程扩展一个简单算法资源，示范通过maven项目扩展iServer。     


##maven工程扩展iServer步骤：

###1、新建maven工程
###2、添加maven仓库
在maven工程的pom文件的添加repositories标签：
```
<repositories>
    <repository>
      <id>supermap</id>
      <url>http://maven.supermap.io/</url>
    </repository>
</repositories>
```
###3、添加iserver依赖
在pom文件的dependencies标签中添加依赖iserver-all：
```
<dependency>
  <groupId>com.supermap.iserver</groupId>
  <artifactId>iserver-all</artifactId>
  <version>8.0.2</version>
</dependency>
```
###4、编程扩展iServer
按maven工程要求编写程序扩展iServer，若需要添加 FreeMarker 模板文件，则在src/main/resources/templates文件夹下添加模板文件{sources.name}.ftl；若需要添加资源配置文件，请将资源配置文件放到目录src/main/resources/下，下级目录参见：[功能模块、资源配置文件对应表](http://support.supermap.com.cn:8090/iserver/help/html/DevelopGuide/Extend_iServer/Extend_JAX-RS/ConfigFile.htm#表_功能模块_资源配置文件对应表)

###5、加入iServer
运行maven命令生成Jar包，将Jar包放入%SuperMap iServer_HOME%/webapps/iserver/WEB-INF/lib 目录下，重启iServer服务就可以通过URL访问资源页面了。如ExtendREST工程扩展的算法资源的URL为：http://localhost:8090/iserver/services/maps/rest/maps/世界地图/rectangleArea.html

#####PS：若需要查看更多iServer扩展示例，参考：[Supermap iServer在线帮助文档.扩展iServer](http://support.supermap.com.cn:8090/iserver/help/html/DevelopGuide/Extend_iServer/Extend_iServer.htm)