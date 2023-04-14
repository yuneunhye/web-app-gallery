package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//web.xml ��ü 
@Configuration
@PropertySource("classpath:/application.properties")
public class WebConfig implements WebMvcConfigurer {
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
    	//CORS��å���� �ذ� 
        registry.addMapping("/**")
        		.allowedMethods("*")
        		.allowedOriginPatterns("*");
        
    } 
    /*
      registry.addMapping("/**")
        	.allowedOriginPatterns("*")
        	//.allowedOrigins("http://localhost:3000", "http://localhost:8081") // ����� ��ó
            .allowedMethods("GET", "POST") // ����� HTTP method
            .allowCredentials(true) // ��Ű ���� ��û ���
            .maxAge(3000); // ���ϴ� �ð���ŭ pre-flight ������Ʈ�� ĳ��
         */
    
  //application.properties �� �ִ� ���� �о�ͼ� ������ �ֱ�
//  	@Value("${fileUploadPath}")
//  	String fileUploadPath;

  	
  	// /resources/**  ....... �������Ͽ��� ���������� �ܺη� ������״����� �������� 
//  	@Override
//  	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//  		
//  		exposeDirectory(fileUploadPath, registry);
//  	}
//  	
//  	void exposeDirectory(String dirName, 
//  			ResourceHandlerRegistry registry)
//  	{
//  		Path uploadDir = Paths.get(dirName);
//  		//���ε� ������ ������ ����(������Ȯ��)
//  		String uploadPath = uploadDir.toFile().getAbsolutePath();
//  		
//  		if(dirName.startsWith("../"))
//  			dirName = dirName.replace("../", "");
//  		
//  		System.out.println(dirName);
//  		System.out.println(uploadPath);
//  		
//  		registry
//  		  .addResourceHandler("/"+dirName+"/**")
//  		  .addResourceLocations("file:/"+uploadPath + "/");
  		
  		//spring frame 
  		//Ư�������� ���ϼ����� �۵���Ų��. 
  	    //application.properties  ����  fileUploadPath�� 
  		//������ �������� �о �� ������ ������ ���ϼ����� �����
  		
//  	}
}