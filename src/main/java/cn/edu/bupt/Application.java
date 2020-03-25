package cn.edu.bupt;

import cn.bupt.edu.base.log.ElasticsearchRestClient;
import cn.bupt.edu.server.ChannelServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2018/4/14.
 */
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@ComponentScan({"cn.edu.bupt", "cn.edu.bupt.websocket"})
//@PropertySource({"classpath:disconf.properties"})
//@ImportResource({"classpath:disconf.xml"})//引入disconf
public class Application {
    public static void main(String[] args) {
        ElasticsearchRestClient.initElasticsearchRestClient("device-access");
        SpringApplication.run(Application.class, args);
        System.out.println("8888888888888888888888888888888888888");
        ChannelServer.getInstance().initChannelServer(7000);
    }
}
