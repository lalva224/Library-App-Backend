package com.greek.text.wishlist;

import com.greek.text.book.BookEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wish_list")
public class WishListEntity {
    @Id
    @GeneratedValue
    private Integer wishListId;
    private Integer userId;
    private String wishListName;

    @OneToMany(targetEntity = WishListBooks.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "wishListId", referencedColumnName = "wishListId")
    private List<WishListBooks> books;


}
