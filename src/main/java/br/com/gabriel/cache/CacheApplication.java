package br.com.gabriel.cache;

import br.com.gabriel.cache.services.ProductService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/*
* @EnableCaching
* */
@EnableCaching
public class CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(ProductService productService) {
		return args -> {
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Id: 1: " + productService.getById(1L));
			System.out.println("Id: 2: " + productService.getById(2L));
			System.out.println("Id: 1: " + productService.getById(1L));
			System.out.println("Id: 1: " + productService.getById(1L));
			System.out.println("Id: 1: " + productService.getById(1L));
			System.out.println("Id: 1: " + productService.getById(1L));
		};
	}

}
