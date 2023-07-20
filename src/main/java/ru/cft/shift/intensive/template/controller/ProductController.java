package ru.cft.shift.intensive.template.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;
import ru.cft.shift.intensive.template.service.impl.ProductServiceImpl;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@Validated
@RestController
@RequestMapping(value = "store", produces = APPLICATION_JSON_VALUE)
@Tag(name = "api.product.tag.name", description = "api.product.tag.description")
public class ProductController {
    private final ProductServiceImpl service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "api.product.products.summary")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "api.product.products.api-responses.200.description"),
        @ApiResponse(responseCode = "500", description = "api.server.error", 
            content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
    })
    @GetMapping
    public ResponseEntity<List<ProductDto>> AllProducts() { //все товары в каталоге
        return ResponseEntity.ok(service.all());
    }

    @Operation(summary = "api.product.get-by-name.summary")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "api.product.get-by-name.api-responses.200.description"),
        @ApiResponse(responseCode = "404", description = "api.product.get-by-name.api-responses.404.description", 
            content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))}),
        @ApiResponse(responseCode = "500", description = "api.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
    })
    @GetMapping("{name}")
    public ResponseEntity<ProductDto> ProductByName(@PathVariable String name) { //поиск товара по имени
        ProductDto foundProduct = service.findByName(name);
        if (foundProduct == null) {
            // throw new RuntimeException("Продукт не найден");
        }

        return ResponseEntity.ok(foundProduct);

    }

//    @Operation(summary = "api.product.products.summary")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "api.product.products.api-responses.200.description"),
//            @ApiResponse(responseCode = "500", description = "api.server.error",
//                    content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
//    })
//    @PostMapping("addproduct")
//    public ResponseEntity<List<ProductDto>> addProduct(@RequestBody @Valid ProductDto product) { //все товары в каталоге
//
//
//    }
}
