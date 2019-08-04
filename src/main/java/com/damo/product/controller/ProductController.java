package com.damo.product.controller;

import com.damo.product.model.Product;
import com.damo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    final
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    String welcome() {
        return "Welcome to mall";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public @ResponseBody List<Product> getAll() {
        return productService.getAll();
    }

    @RequestMapping(value = "/product/{id}")
    public @ResponseBody Product getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @RequestMapping(value = "/product/name/{name}")
    public List<Product> getByName(@PathVariable String name) {
        return productService.getByName(name);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public HttpStatus create(@RequestBody Product product) {
        return productService.addProduct(product) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }


    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public HttpStatus updata(@RequestBody Product product) {
        return productService.updateProduct(product) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public HttpStatus delete(@PathVariable int id) {
        return productService.deleteProduct(id) ? HttpStatus.OK : HttpStatus.NO_CONTENT;
    }
}
