package ru.newhope.product;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Api(value = "Продукты")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/product")
    @ResponseBody
    public List<ProductEntity> getProductList() {

        List<ProductEntity> productList = productRepository.findAll();
        return productList;
    }
}

