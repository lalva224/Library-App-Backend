package com.greek.text.wishlist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListRepository wishListRepository;

    private final WishListBooksRepository wishListBooksRepository;

    public void saveWishList(WishListEntity wishListEntity) {
        Long totalWishListCountByUser = this.wishListRepository.countByUserId(wishListEntity.getUserId());

        if (totalWishListCountByUser < 3) {

            List<WishListEntity> byUserId = this.wishListRepository.findByUserId(wishListEntity.getUserId());

            WishListEntity isAlready = byUserId.stream().filter(wishItem -> wishListEntity.getWishListName().equals(wishItem.getWishListName())).findAny().orElse(null);

            if (isAlready == null) {

                this.wishListRepository.save(wishListEntity);
            } else {
                System.out.println("Please don't enter duplicate wishlist name");
            }

        } else {

            System.out.println("You can't add more than 3 wish list");
        }
    }

    public void addBookInWishList(WishListBooks wishListBooks) {
        this.wishListBooksRepository.save(wishListBooks);
    }
    public void deleteBookByBookIdAndWishListId(Integer bookId,Integer wishListId)
    {
        this.wishListBooksRepository.deleteByBookIdAndWishListId(bookId,wishListId);
    }

    public List<WishListEntity> getBookListByWishList(Integer wishlistId)
    {
       return this.wishListRepository.findByWishListId(wishlistId);
    }
}
