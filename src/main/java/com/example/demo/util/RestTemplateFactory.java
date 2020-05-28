package com.example.demo.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class RestTemplateFactory {

    private static RestTemplate restTemplate;

    public static RestTemplate getRestTemplate() {
        if (restTemplate==null){
            synchronized (RestTemplateFactory.class){
                if (restTemplate==null){
                    restTemplate=new RestTemplate();

                    ClientHttpRequestInterceptor interceptor= (httpRequest, bytes, clientHttpRequestExecution) -> {
                        HttpHeaders httpHeaders=httpRequest.getHeaders();
                        httpHeaders.add("hello",CustomContext.getHeader());
                        System.out.println("customContext："+CustomContext.getHeader());

                        return clientHttpRequestExecution.execute(httpRequest,bytes);
                    };

                    restTemplate.setInterceptors(Collections.singletonList(interceptor));
                }
            }
        }

        return restTemplate;
    }
}
