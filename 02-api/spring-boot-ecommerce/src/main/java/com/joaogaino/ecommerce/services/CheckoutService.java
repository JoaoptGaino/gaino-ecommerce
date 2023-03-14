package com.joaogaino.ecommerce.services;

import com.joaogaino.ecommerce.dto.PurchaseDTO;
import com.joaogaino.ecommerce.dto.PurchaseResponseDTO;

public interface CheckoutService {

    PurchaseResponseDTO placeOrder(PurchaseDTO purchase);
}
