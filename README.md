#iServer_Example
##iServer_Example��ʲô?
iServer_Example����һ����չiServer REST��Դ��maven���̣���ʾ��������չһ�����㷨��Դ��ʾ��ͨ��maven��Ŀ��չiServer��     


##maven������չiServer���裺

###1���½�maven����
###2�����maven�ֿ�
��maven���̵�pom�ļ������repositories��ǩ��
```
<repositories>
    <repository>
      <id>supermap</id>
      <url>http://maven.supermap.io/</url>
    </repository>
</repositories>
```
###3�����iserver����
��pom�ļ���dependencies��ǩ���������iserver-all��
```
<dependency>
  <groupId>com.supermap.iserver</groupId>
  <artifactId>iserver-all</artifactId>
  <version>8.0.2</version>
</dependency>
```
###4�������չiServer
��maven����Ҫ���д������չiServer������Ҫ��� FreeMarker ģ���ļ�������src/main/resources/templates�ļ��������ģ���ļ�{sources.name}.ftl������Ҫ�����Դ�����ļ����뽫��Դ�����ļ��ŵ�Ŀ¼src/main/resources/�£��¼�Ŀ¼�μ���[����ģ�顢��Դ�����ļ���Ӧ��](http://support.supermap.com.cn:8090/iserver/help/html/DevelopGuide/Extend_iServer/Extend_JAX-RS/ConfigFile.htm#��_����ģ��_��Դ�����ļ���Ӧ��)

###5������iServer
����maven��������Jar������Jar������%SuperMap iServer_HOME%/webapps/iserver/WEB-INF/lib Ŀ¼�£�����iServer����Ϳ���ͨ��URL������Դҳ���ˡ���ExtendREST������չ���㷨��Դ��URLΪ��http://localhost:8090/iserver/services/maps/rest/maps/�����ͼ/rectangleArea.html

#####PS������Ҫ�鿴����iServer��չʾ�����ο���[Supermap iServer���߰����ĵ�.��չiServer](http://support.supermap.com.cn:8090/iserver/help/html/DevelopGuide/Extend_iServer/Extend_iServer.htm)