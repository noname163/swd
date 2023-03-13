package com.example.swd.service.recommendation.impl;

import com.example.swd.service.recommendation.TRecommendService;
import java.util.List;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.*;

public class Client {
    private final String host;
    private final int port;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public Client (String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public void ping() throws TTransportException {
        TTransport transport = new TSocket(host, port);
        TRecommendService.Client client;
        try {
            transport.open();
            logger.info("Connected to {} on {}", host, port);
            TProtocol protocol = new TBinaryProtocol(transport);
            client = new TRecommendService.Client(protocol);
            int result = client.ping();
            logger.info("client.ping() = {}", result);
            transport.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
    }
	
	public List<Integer> getRecommendation(int userId, int targetId) throws TTransportException {        
		TTransport transport = new TSocket(host, port);
        TRecommendService.Client client;
		List<Integer> result = null;
        try {
            transport.open();
            logger.info("Connected to {} on {}", host, port);
            TProtocol protocol = new TBinaryProtocol(transport);
            client = new TRecommendService.Client(protocol);
			result = client.getRecommendation(userId, targetId);
            transport.close();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
			return result;
		}
    }
}
