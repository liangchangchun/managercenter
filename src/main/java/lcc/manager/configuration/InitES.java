package lcc.manager.configuration;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.ClientConfig;
import io.searchbox.client.config.ClientConstants;

import java.util.LinkedHashSet;

import lcc.manager.common.Utils;


/**
 * 
 * @ClassName: ESFactory
 * @Description: es工厂类
 * @author duhai
 * @date 2016年5月10日 下午4:11:43
 */
public class InitES {
	private static  JestClientFactory factory;
	/** 
     * 静态,单例... 
     */  
    private static JestClient JestClient;  
  
    /** 
     * 配置jest客户端,到时使用spring时,可以用配置方式 ,现在暂时使用new ... 
     *  
     * @return 
     */  
    static{  
        // es的服务端地址,暂时我是用我虚拟机的(ubuntu)做服务器  
        String connectionUrl = "http://10.0.1.88:9200";//Utils.PT.getProps("esUrl");// 一般都是9200端口  
        ClientConfig clientConfig = new ClientConfig();  
        // 当你用集群时,就有可能会有多个es的服务端,这里我暂时没有集群  
        LinkedHashSet<String> servers = new LinkedHashSet<String>();  
        servers.add(connectionUrl);  
        clientConfig.getServerProperties().put(ClientConstants.SERVER_LIST, servers);  
        clientConfig.getClientFeatures().put(ClientConstants.IS_MULTI_THREADED, false);  
        factory = new JestClientFactory();  
        factory.setClientConfig(clientConfig);  
    }  
  
    /** 
     * 获取一个jest的对象 
     *  
     * @return 
     */  
    public static JestClient jestClient() {  
        if (JestClient == null) {  
            JestClient = factory.getObject();  
        }  
        return JestClient;  
    }  

}
