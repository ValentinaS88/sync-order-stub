package org.example.orderstubsyn.models;

public class OrderResponse {
    private String orderId;
    private String productName;
    private String status;

    public OrderResponse() {};

    public OrderResponse(String orderId, String productName, String status) {
        this.orderId = orderId;
        this.productName = productName;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
