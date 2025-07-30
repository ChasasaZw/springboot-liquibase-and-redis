package com.learning.liquibase.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.redis.core.RedisHash;

import java.util.Objects;


@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "products")
@Setter
@Getter
@RedisHash("Product")
public class Product {
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private Integer price;


}
