package com.joaogaino.ecommerce.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class PurchaseResponseDTO {
    @NonNull
    private String orderTrackingNumber;
}
