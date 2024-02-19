package com.fatma.ecommerce.model.dto;

import com.fatma.ecommerce.model.entity.Category;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int id;
    @NotNull(message = "enter productName")
    private  String name;
    @Size(min = 8,max = 25,message = "enter your description between 8 and 25 character")
    private  String description;
    private double price;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime LastUpdate;
    @ManyToOne
    private Category category;
    public static ProductDto fromEntityTODto(ProductDto entity){
        return ProductDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .dateCreated(entity.getDateCreated())
                .LastUpdate(entity.getLastUpdate())
                .category(entity.getCategory()).
                build();

    }
}
