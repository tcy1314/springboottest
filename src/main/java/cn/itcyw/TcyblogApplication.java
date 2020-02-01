package cn.itcyw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @Description: 启动类
 * @author tcy
 * @date 2020-01-14
 */
@MapperScan(basePackages = {"cn.itcyw.mapper"})
@SpringBootApplication
public class TcyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcyblogApplication.class, args);
	}

}
