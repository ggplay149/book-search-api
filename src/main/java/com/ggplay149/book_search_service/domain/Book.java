package com.ggplay149.book_search_service.domain;

import com.ggplay149.book_search_service.validator.BookId;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Book {

    @BookId
    @Pattern(regexp = "ISBN[1-9]+")
    private String bookId;

    @Size(min=4,max=50)
    private String name;

    @Min(value=0)
    @Digits(integer = 8,fraction = 2)
    @NotNull
    private BigDecimal unitPrice;

    private String author;
    private String description;
    private String publisher;
    private String category;
    private long unitsInStock;
    private String releaseDate;
    private String condition;
    private String fileName;
    private MultipartFile bookImage;

}
