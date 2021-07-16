package com.example.demospringservice.service;

import com.example.demospringservice.entity.Product;
import com.example.demospringservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@WebService
@Component(value = "productService")
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @WebMethod
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getAllById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id)
                ;
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;
    }

    @WebMethod
    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    @WebMethod
    public Product sellProduct(Long productId, Long quantity) {
        Product product = getAllById(productId);
        if (product != null) {
            if (product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                Product result = productRepository.save(product);
                return result;
            }
        }
        return null;
    }

}
//package com.example.demospringservice;
//
//import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ImportResource;
//
//@ImportResource(locations = "jaxws-config.xml")
//@SpringBootApplication
//public class DemoSpringServiceApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(DemoSpringServiceApplication.class, args);
//    }
//
//
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        return new ServletRegistrationBean(new WSSpringServlet(), "/ws/*");
//    }
//}