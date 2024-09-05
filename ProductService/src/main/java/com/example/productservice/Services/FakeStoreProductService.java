package com.example.productservice.Services;

import com.example.productservice.Dtos.FakeStoreProductDto;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.exceptions.InvalidProductIdException;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpMethod.PUT;

@Service

public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    private Product convertFakeStoreProductDtotoProduct (FakeStoreProductDto fakeStoreProductDto){
        Product product=new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category= new Category();
        category.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(category);
        return product;
        }

    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        //Call the fakestore API to get the product using HTTP protocol.our code make HTTP call to other API.
        // RestTemplate is used to make the HTTP call.
      FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForObject("https://fakestoreapi.com/products/" +id, FakeStoreProductDto.class);
      if(fakeStoreProductDto == null){
          throw new InvalidProductIdException("Invalid ProductId passed",id);
      }
      ///convert Fakestore product DTO to Product DTO.
        return convertFakeStoreProductDtotoProduct(fakeStoreProductDto);



    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtotoProduct(fakeStoreProductDto));

        }
        return products;
    }



    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public   Product replaceProduct(Long id, Product product) {
        //Put Method
        // Replace the product with the given id
        //and return the updated product in the output.
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto =
       restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreProductDtotoProduct(fakeStoreProductDto);
    }


    @Override
    public void deleteProduct() {

    }
}
