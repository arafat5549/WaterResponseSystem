package com.jqmkj.WaterResponseSystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import tk.mybatis.spring.annotation.MapperScan;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(scanBasePackageClasses = {
		com.jqmkj.WaterResponseSystem.CodeGeneratorUtil.class}) //,scanBasePackages = {"com.jqmkj.WaterResponseSystem.websocket"}
//@ComponentScan(basePackages = {"com.jqmkj.WaterResponseSystem.websocket"})
@MapperScan(basePackages = { "com.jqmkj.WaterResponseSystem.basemapper.mapper" })
public class App extends SpringBootServletInitializer {
	private static Logger log = LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		try {
			String home = "8088/WaterResponseSystem/login";
			log.info("\n----------------------------------------------------------\n\t" +
							"Application '{}' is running! Access URLs:\n\t" +
							"Local: \t\thttp://localhost:{}\n\t" +
							"External: \thttp://{}:{}\n----------------------------------------------------------",
					"金钱猫水质监测",
					home ,
					InetAddress.getLocalHost().getHostAddress(),
					home);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		/** 设置视图路径的前缀 */
		resolver.setPrefix("/");
		/** 设置视图路径的后缀 */
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return super.configure(builder);
	}
}
