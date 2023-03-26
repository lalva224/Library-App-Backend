package com.greek.text.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookByPriceByPublisherRequest {
    private BigDecimal discount;
    private String publisher;
}
