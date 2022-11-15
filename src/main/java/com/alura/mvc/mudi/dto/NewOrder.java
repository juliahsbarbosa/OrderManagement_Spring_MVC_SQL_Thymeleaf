package com.alura.mvc.mudi.dto;

import com.alura.mvc.mudi.model.Order;
import com.alura.mvc.mudi.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class NewOrder {
    @NotBlank
    private String productName;
    @NotBlank
    private String urlProduct;
    @NotBlank
    private String urlImages;
    @NotBlank
    private String description;

    public Order toOrder() {
        Order order = new Order();
        order.setProductName(productName);
        order.setUrlProduct(urlProduct);
        order.setUrlImages(urlImages);
        order.setDescription(description);
        order.setStatus(OrderStatus.PROCESSING);

        return order;
    }
}
