package br.com.gabriel.cache.services;

import br.com.gabriel.cache.records.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    Map<Long, Product> products = new HashMap<>() {
        {
            put(1L, new Product(1L, "Notebook", "Mackbook Pro"));
            put(2L, new Product(2L, "Notebook", "XPS"));
            put(3L, new Product(3L, "Notebook", "Alienware"));
            put(4L, new Product(4L, "Notebook", "Thinkpad"));
            put(5L, new Product(5L, "Notebook", "Zenbook"));
        }
    };

    /*
    * To use in memory cache just add the Spring Cache dependency and the following annotation to the method you want to use cache
    * @Cacheable("products")
    * Also you need to enable cache annotating the Project Class with:
    * @EnableCaching
    * */
    @Cacheable("products")
    public Product getById(Long id) {
        System.out.println("buscando produtos...");
        simulateLatency();
        return products.get(id);
    }

    private void simulateLatency() {
        try {
            long time = 1000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
