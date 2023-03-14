package com.joaogaino.ecommerce.controllers;

import com.joaogaino.ecommerce.dto.PurchaseDTO;
import com.joaogaino.ecommerce.dto.PurchaseResponseDTO;
import com.joaogaino.ecommerce.services.CheckoutService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
@AllArgsConstructor
public class CheckoutController {
    private CheckoutService checkoutService;

    @PostMapping("/purchase")
    public PurchaseResponseDTO placeOrder(@RequestBody PurchaseDTO purchase) {
        return checkoutService.placeOrder(purchase);
    }

}
