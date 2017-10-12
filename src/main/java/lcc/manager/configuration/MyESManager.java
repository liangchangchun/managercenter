package lcc.manager.configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

public class MyESManager  {
	private static TransportClient myclient;
	private static ElasticsearchTemplate elasticsearchTemplate;
	private static String clustersName="elasticsearch";
	private static String host1 ="10.0.1.88";
	
	static{
		try {
			Settings settings = Settings.builder()
					.put("client.transport.sniff", true)
			        .put("cluster.name", clustersName).build();
			myclient =new PreBuiltTransportClient(settings);
			
			myclient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host1), 9200));
			//.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host1), 9300));
			elasticsearchTemplate =new ElasticsearchTemplate(myclient);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public MyESManager(){
	}
	
	
	public ElasticsearchTemplate getElasticsearchTemplate(){
		return elasticsearchTemplate;
	}

}
