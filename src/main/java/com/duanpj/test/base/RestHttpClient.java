package com.duanpj.test.base;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Component
public class RestHttpClient {

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	private boolean initMessageConverter;
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	public RestHttpClient() {
	}

	public RestTemplate getRestTemplate() {
		if (restTemplate != null && !initMessageConverter) {
			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
			messageConverters.add(new ByteArrayHttpMessageConverter());
			messageConverters.add(new StringHttpMessageConverter(DEFAULT_CHARSET));
			messageConverters.add(new ResourceHttpMessageConverter());
			messageConverters.add(new SourceHttpMessageConverter<Source>());
			messageConverters.add(new AllEncompassingFormHttpMessageConverter());
			messageConverters.add(new FastJsonHttpMessageConverter());
			restTemplate.setMessageConverters(messageConverters);
			initMessageConverter = true;
		}
		return restTemplate;
	}

	public <T> T get(String restUrl, Class<T> responseType) {
		return getRestTemplate().getForObject(restUrl, responseType);
	}

	public <T> T get(String restUrl, Class<T> responseType, Object... urlVariables) {
		return getRestTemplate().getForObject(restUrl, responseType, urlVariables);
	}

	public <T> T get(String restUrl, Class<T> responseType, Map<String, ?> urlVariables) {
		return getRestTemplate().getForObject(restUrl, responseType, urlVariables);
	}

	public <T> T post(String restUrl, Object requestBody, Class<T> responseType) {
		if (requestBody == null) {
			requestBody = "";
		}
		return getRestTemplate().postForObject(restUrl, requestBody, responseType);
	}

	public <T> T post(String restUrl, Object requestBody, Class<T> responseType, Object... uriVariables) {
		if (requestBody == null) {
			requestBody = "";
		}
		return getRestTemplate().postForObject(restUrl, requestBody, responseType, uriVariables);
	}

	public <T> T post(String restUrl, Object requestBody, Class<T> responseType, Map<String, ?> uriVariables) {
		if (requestBody == null) {
			requestBody = "";
		}
		return getRestTemplate().postForObject(restUrl, requestBody, responseType, uriVariables);
	}

	public <T> T put(String restUrl, Object requestBody, Class<T> responseType) {
		HttpHeaders headers = new HttpHeaders();
		if (requestBody == null) {
			requestBody = "";
		}
		HttpEntity<Object> entity = new HttpEntity<Object>(requestBody, headers);
		return getRestTemplate().exchange(restUrl, HttpMethod.PUT, entity, responseType).getBody();
	}

	public <T> T put(String restUrl, Object requestBody, Class<T> responseType, Object... uriVariables) {
		HttpHeaders headers = new HttpHeaders();
		if (requestBody == null) {
			requestBody = "";
		}
		HttpEntity<Object> entity = new HttpEntity<Object>(requestBody, headers);
		return getRestTemplate().exchange(restUrl, HttpMethod.PUT, entity, responseType, uriVariables).getBody();
	}

	public <T> T put(String restUrl, Object requestBody, Class<T> responseType, Map<String, ?> uriVariables) {
		HttpHeaders headers = new HttpHeaders();
		if (requestBody == null) {
			requestBody = "";
		}
		HttpEntity<Object> entity = new HttpEntity<Object>(requestBody, headers);
		return getRestTemplate().exchange(restUrl, HttpMethod.PUT, entity, responseType, uriVariables).getBody();
	}

}
