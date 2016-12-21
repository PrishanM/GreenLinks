
package com.evensel.greenlinks.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
    "orderNumber",
    "category",
    "orderStatus",
    "pickupDate",
    "pickupTime",
    "address",
    "contactNumber",
    "province",
    "nearestCity",
    "message"
})
public class Order {

    @JsonProperty("orderNumber")
    private String orderNumber;
    @JsonProperty("category")
    private String category;
    @JsonProperty("orderStatus")
    private String orderStatus;
    @JsonProperty("pickupDate")
    private String pickupDate;
    @JsonProperty("pickupTime")
    private String pickupTime;
    @JsonProperty("address")
    private String address;
    @JsonProperty("contactNumber")
    private String contactNumber;
    @JsonProperty("province")
    private String province;
    @JsonProperty("nearestCity")
    private String nearestCity;
    @JsonProperty("message")
    private String message;

    @JsonProperty("orderNumber")
    public String getOrderNumber() {
        return orderNumber;
    }

    @JsonProperty("orderNumber")
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("orderStatus")
    public String getOrderStatus() {
        return orderStatus;
    }

    @JsonProperty("orderStatus")
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @JsonProperty("pickupDate")
    public String getPickupDate() {
        return pickupDate;
    }

    @JsonProperty("pickupDate")
    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    @JsonProperty("pickupTime")
    public String getPickupTime() {
        return pickupTime;
    }

    @JsonProperty("pickupTime")
    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("contactNumber")
    public String getContactNumber() {
        return contactNumber;
    }

    @JsonProperty("contactNumber")
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @JsonProperty("province")
    public String getProvince() {
        return province;
    }

    @JsonProperty("province")
    public void setProvince(String province) {
        this.province = province;
    }

    @JsonProperty("nearestCity")
    public String getNearestCity() {
        return nearestCity;
    }

    @JsonProperty("nearestCity")
    public void setNearestCity(String nearestCity) {
        this.nearestCity = nearestCity;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

}
