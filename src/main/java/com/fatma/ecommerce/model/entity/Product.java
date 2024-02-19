package com.fatma.ecommerce.model.entity;

import com.fatma.ecommerce.model.dto.ProductDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "products")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "enter productName")
    private String name;
    @Size(min = 8, max = 25, message = "enter your description between 8 and 25 character")
    private String description;
    private double price;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime LastUpdate;
    @ManyToOne
    private Category category;
    public static Product ToEntity(ProductDto dto){
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .dateCreated(dto.getDateCreated())
                .LastUpdate(dto.getLastUpdate())
                .category(dto.getCategory()).
                build();

    }

}
