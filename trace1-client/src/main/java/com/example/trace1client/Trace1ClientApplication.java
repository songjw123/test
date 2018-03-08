package com.example.trace1client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * song
 */
@RestController
@SpringBootApplication
@EnableBinding(Source.class)
public class Trace1ClientApplication implements CommandLineRunner{

	@Autowired
	Source source;

	public static void main(String[] args) {
		SpringApplication.run(Trace1ClientApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		source.output().send(MessageBuilder.withPayload("大家好").build());
		System.out.println("信息发送======");
	}


	/**
	 * ============================================================================
	 * 下面属于zipkin服务链调用
	 */
	@Autowired
	private RestTemplate restTemplate;
	private static final Logger LOG = Logger.getLogger(Trace1ClientApplication.class.getName());


	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hi")
	public String callHome(){
		LOG.log(Level.INFO, "calling trace service-hi  ");
		return restTemplate.getForObject("http://localhost:8989/miya", String.class);
	}

	@RequestMapping("/hih")
	public String info2(){
		LOG.log(Level.INFO,"calling trace service-hi ");
		return "i'm service-hi";

	}

	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}
