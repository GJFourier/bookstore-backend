package com.example.bookstorebackend.controller;


import com.example.bookstorebackend.entity.CartItem;
import com.example.bookstorebackend.service.CartItemService;
import com.example.bookstorebackend.util.request.ChangeCartItemForm;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Transactional
public class CartItemController {
    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "api/cartItem/change", method = RequestMethod.POST)
    void changeCountByUserIdAndBookId(@RequestBody @NotNull ChangeCartItemForm changeCartItemForm){
        cartItemService.changeCountByUserIdAndBookId(changeCartItemForm);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "api/cartItem/add", method = RequestMethod.PUT)
    boolean addCart(@RequestBody @NotNull ChangeCartItemForm changeCartItemForm){
        return cartItemService.addCartItem(changeCartItemForm);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "api/cartItem/get/{userId}", method = RequestMethod.GET)
    List<CartItem> getCartItemByUserId(@PathVariable Long userId) {
        return cartItemService.getCartItemByUserId(userId);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "api/cartItem/delete", method = RequestMethod.DELETE)
    void deleteCartItemByBookId(@PathParam("userId") Long userId, @PathParam("bookId") Long bookId){
        cartItemService.deleteCartItemByUserIdAndBookId(userId, bookId);
    }
}
