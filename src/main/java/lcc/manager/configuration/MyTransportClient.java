package lcc.manager.configuration;

import org.elasticsearch.client.node.NodeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.NodeClientFactoryBean;

public class MyTransportClient {
	private static final Logger logger = LoggerFactory.getLogger(MyTransportClient.class);
	//@Autowired
	NodeClientFactoryBean nodeClientFactory;
	private NodeClient client;
	
	public MyTransportClient(){
		
	}

	public NodeClient CreateTransportClient() throws Exception{
		client=nodeClientFactory.getObject();
		return client;
	}
	
}
