package com.spring.boot.consumer.aws;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boot.consumer.model.SQSMessage;
import com.spring.boot.consumer.model.WeatherAlert;
import com.spring.boot.consumer.service.AlertService;

import java.util.List;

@Component
public class WeatherAlertsListenerSqs {

    @Value("${sqs.url}")
    private String sqsUrl;

    @Value("${cloud.aws.credentials.accessKey}")
    private String awsAccessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String awsSecretKey;

    @Value("${cloud.aws.region.static}")
    private String awsRegion;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private AlertService alertService;

    private AmazonSQS amazonSQS;

    @Autowired
    public WeatherAlertsListenerSqs(@Value("${sqs.url}") String sqsUrl,
						    		@Value("${cloud.aws.credentials.accessKey}") String awsAccessKey,
						    		@Value("${cloud.aws.credentials.secretKey}") String awsSecretKey,
						    		@Value("${cloud.aws.region.static}") String awsRegion,
						    		ObjectMapper objectMapper,
						    		AlertService alertService,
						    		AmazonSQS amazonSQS) {
    	this.sqsUrl = sqsUrl;
    	this.awsAccessKey = awsAccessKey;
    	this.awsSecretKey = awsSecretKey;
    	this.awsRegion = awsRegion;
		this.objectMapper = objectMapper;
		this.alertService = alertService;
		this.amazonSQS = amazonSQS;
	}
    
    @PostConstruct
    private void postConstructor() {

        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(awsAccessKey, awsSecretKey)
        );

        this.amazonSQS = AmazonSQSClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withRegion(awsRegion)
                .build();
    }

    public void startListeningToMessages() throws JsonMappingException, JsonProcessingException {

        final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(sqsUrl)
                .withMaxNumberOfMessages(1)
                .withWaitTimeSeconds(3);

        while (true) {

            final List<Message> messages = amazonSQS.receiveMessage(receiveMessageRequest).getMessages();

            for (Message messageObject : messages) {
                String message = messageObject.getBody();

                //message processing
                SQSMessage sqsMessage = objectMapper.readValue(message, SQSMessage.class);
                WeatherAlert weatherAlert = objectMapper.readValue(sqsMessage.getMessage() , WeatherAlert.class);
                
                
                System.out.println(weatherAlert);
                alertService.addAlerts(weatherAlert);
                deleteMessage(messageObject);
            }
        }
    }

    private void deleteMessage(Message messageObject) {

        final String messageReceiptHandle = messageObject.getReceiptHandle();
        amazonSQS.deleteMessage(new DeleteMessageRequest(sqsUrl, messageReceiptHandle));

    }
}