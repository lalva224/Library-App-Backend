package com.example.mysqlDemo.Service;


import com.example.mysqlDemo.Model.WishList;
import com.example.mysqlDemo.Model.WishListBooks;
import com.example.mysqlDemo.Repo.WishListBooksRepo;
import com.example.mysqlDemo.Repo.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class WishListService {

    @Autowired
    private  WishListRepo wishListRepository;

    @Autowired
    private WishListBooksRepo wishListBooksRepository;
    public String saveWishList(WishList wishListEntity) {
        Long totalWishListCountByUser = this.wishListRepository.countByUserId(wishListEntity.getUserId());

        if (totalWishListCountByUser < 3) {

            List<WishList> byUserId = this.wishListRepository.findByUserId(wishListEntity.getUserId());

            WishList isAlready = byUserId.stream().filter(wishItem -> wishListEntity.getWishListName().equals(wishItem.getWishListName())).findAny().orElse(null);

            if (isAlready == null) {

                this.wishListRepository.save(wishListEntity);
                return "Successfully added wishlist!!";
            } else {
             return "Please don't enter duplicate wishlist name";
            }

        } else {

            return "You can't add more than 3 wish list";
        }
    }

    public String addBookInWishList(WishListBooks wishListBooks) {
        WishListBooks save = this.wishListBooksRepository.save(wishListBooks);
        if(ObjectUtils.isEmpty(save))
        {
            return "Failed to add book";
        }
        return "Book successfully added";
    }
    public String deleteBookByBookIdAndWishListId(Integer isbn,Integer wishListId)
    {
       Long aLong = this.wishListBooksRepository.deleteByIsbnAndWishListId(isbn, wishListId);
        if(aLong !=0)
        {
            return "Entry deleted successfully";
        }
        return "Failed to deleted successfully";
    }

    public List<WishList> getBookListByWishList(Integer wishlistId)
    {
        return this.wishListRepository.findByWishListId(wishlistId);
    }
}
