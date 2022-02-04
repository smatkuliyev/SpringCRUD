package springbootCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// eger package icinde package acmazsak bunlari yazmaliyiz

//@ComponentScan({"controller","service"})//aradığını bulabilsin diye package leri belirtiyorum. 
////temel olanlar bu şekilde (controller,service). model gibiler alttaki gibi
//@EntityScan("model")
//@EnableJpaRepositories("repository")

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
