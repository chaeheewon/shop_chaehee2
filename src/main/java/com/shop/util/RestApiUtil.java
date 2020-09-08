package com.shop.util;

import java.util.Map;
import java.util.Base64;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class RestApiUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(RestApiUtil.class);
	
    /**
     *    Header정보 세팅
     */
	public MultiValueMap<String, String> apiClientHttpEntity(String Token) {
        
        MultiValueMap<String, String> makingHeaders = new LinkedMultiValueMap<String, String>();
        try {
        	String encoding = Base64.getEncoder().encodeToString(("63993c9e-be7a-43c7-b15d-f7a31b9350c1:b70d82bf-9504-4705-b95c-15f2ac2b8924").getBytes());
        	String Authorization =  "Basic "+encoding;
            
        	makingHeaders.add("Authorization", Authorization);
        	makingHeaders.add("apiKey", "a189952c-3b42-490a-9107-7f2fc7ec25b0");
        	makingHeaders.add("Accept", "application/json");
        	makingHeaders.add("Content-Type","application/json; charset=UTF-8");            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return makingHeaders;
    }
    
    /**
     *    통신 후 응답data json 변환 (json 파싱)
     */
	 public JsonArray apiSuccessJsonParse(Map<String,Object> orgResponseValue) throws Exception{

		 //통신 후 받은 Map타입을 String타입으로 변환후 저장
		 String ResponseValueStr =  orgResponseValue.get("data").toString(); // 응답전문
		 
		 //(gson 라이브러리) JsonParser 객체 생성
         JsonParser jsonParser = new JsonParser();
        
         // JsonParser 로 문자열 파싱 후 jsonArray 객체에 저장
         JsonArray jsonArray = (JsonArray) jsonParser.parse(ResponseValueStr);
		 
		 return jsonArray;
	 }
    
    /**
     * <pre>
     * 1. MethodName : APIAccess
     * 2. ClassName  : StrategySvcImpl.java
     * 3. Comment    : API연동 (공통함수)
     * </pre>
     *
     * @param baseUrl
     * @param APIParamString
     * @param method
     * @param headUrl
     * @return result
     * @throws Exception
     */
    public Map<String, Object> APIAccess(String baseUrl, JSONObject APIParamString, HttpMethod method){
        
    	//결과값을 담을 객체 생성
    	Map<String,Object> result = new HashMap<String,Object>(); 
    	
        try{
            RestTemplate restTemplate = new RestTemplate();
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            restTemplate.getMessageConverters().add(converter);
            String accessToken = "";
            
            // header 정보
            MultiValueMap<String, String> headers = this.apiClientHttpEntity(accessToken);
            
            // request 정보
            HttpEntity requestEntity = new HttpEntity<String>(APIParamString.toString(), headers);
            
            logger.info("========requestEntity==========");
            logger.info("requestEntity= "+requestEntity);
            logger.info("===============================");
            
            // request에 의한 response 정보
            ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl, method, requestEntity, String.class);
            
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                logger.info("=============통신성공==================");
                logger.info("{}",responseEntity.getBody());
                
                // body에 담긴 결과값을 getBody함수를 이용해서 map 타입 result변수에 저장 
                result.put("data", responseEntity.getBody());
                
            }else{
                //오류코드
                logger.info("{}",responseEntity.getBody());
                result.put("data", responseEntity.getBody());

            }
        }
        catch (HttpStatusCodeException httpError) 
        {
            logger.info("=========Header: {}, Body: {}", httpError.getResponseHeaders(), httpError.getStatusText());
        }
        catch (Exception e)
        {
        	
            logger.error(e.getMessage());
        }
        
        return result;
    }

    
	/*
	 * public MultiValueMap<String, String> apiClientHttpEntityToken(String method)
	 * {
	 * 
	 * MultiValueMap<String, String> headers = new LinkedMultiValueMap<String,
	 * String>(); try { String accessID = ""; String accessPassword = "";
	 * 
	 * headers.add("X-IB-Client-Id", accessID); headers.add("X-IB-Client-Passwd",
	 * accessPassword);
	 * headers.add("Content-Type","application/json; charset=UTF-8");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return headers; }
	 */
    
    /**
     * <pre>
     * 1. MethodName : APIAccess
     * 2. ClassName  : CoupangProductServiceImpl.java
     * 3. Comment    : API연동 (공통함수)
     * </pre>
     *
     * @param baseUrl
     * @param APIParamString
     * @param method
     * @param headUrl
     * @return result
     * @throws Exception	
     */
	/*
	 * public Map<String, Object> APIAccessToken(String baseUrl, HttpMethod method,
	 * Map<String, Object> result){
	 * 
	 * try{
	 * 
	 * RestTemplate restTemplate = new RestTemplate();
	 * MappingJackson2HttpMessageConverter converter = new
	 * MappingJackson2HttpMessageConverter();
	 * restTemplate.getMessageConverters().add(converter);
	 * 
	 * MultiValueMap<String, String> headers =
	 * this.apiClientHttpEntityToken(method.name());
	 * 
	 * HttpEntity requestEntity = new HttpEntity<String>(headers);
	 * 
	 * //System.out.println("========requestEntity==========");
	 * //System.out.println(requestEntity);
	 * //System.out.println("===============================");
	 * 
	 * ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl,
	 * method, requestEntity, String.class);
	 * 
	 * if (responseEntity.getStatusCode() == HttpStatus.OK) {
	 * logger.debug("=============통신성공==================");
	 * logger.debug("{}",responseEntity.getBody());
	 * 
	 * //sellerProductId 값 result에 담음 result.put("data", responseEntity.getBody());
	 * 
	 * //System.out.println(result); //System.out.println(result.get("data"));
	 * }else{ //오류코드 logger.debug("{}",responseEntity.getBody()); result.put("data",
	 * responseEntity.getBody());
	 * 
	 * //System.out.println(result); //System.out.println(result.get("data")); } }
	 * catch (HttpStatusCodeException httpError) {
	 * logger.debug("=========Header: {}, Body: {}", httpError.getResponseHeaders(),
	 * httpError.getStatusText()); } catch (Exception e) {
	 * logger.error(e.getMessage()); } return result; }
	 */
}
