package ru.newhope.productcategory;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Api(value = "Категории продуктов")
public class ProductCategoryController {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @GetMapping(value = "/product_category")
    @ResponseBody
    public List<ProductCategoryEntity> getProductCategoryList() {

        List<ProductCategoryEntity> productCategoryList = productCategoryRepository.findAll();
        return productCategoryList;
    }
}

