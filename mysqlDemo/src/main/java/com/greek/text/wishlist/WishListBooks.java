package com.greek.text.wishlist;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wish_list_books")
public class WishListBooks {
    @Id
    @GeneratedValue
    private Integer wishListBookId;

    private Integer bookId;
    private Integer wishListId;






}
