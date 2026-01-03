package org.example.checkout;

import org.example.shipping.ShippingInfoDto;

import java.util.List;

public class CheckOutInfoDto {

    ShippingInfoDto shippingInfoDto;
    List<CheckOutItemDto> checkOutItemDtoList;
    double subTotal;
    double total;


    public CheckOutInfoDto(ShippingInfoDto shippingInfoDto,
                           List<CheckOutItemDto> checkOutItemDtoList,
                           double subTotal,
                           double total) {
        this.shippingInfoDto = shippingInfoDto;
        this.checkOutItemDtoList = checkOutItemDtoList;
        this.subTotal = subTotal;
        this.total = total;
    }

    public ShippingInfoDto getShippingInfoDto() {
        return shippingInfoDto;
    }

    public void setShippingInfoDto(ShippingInfoDto shippingInfoDto) {
        this.shippingInfoDto = shippingInfoDto;
    }

    public List<CheckOutItemDto> getCheckOutItemDtoList() {
        return checkOutItemDtoList;
    }

    public void setCheckOutItemDtoList(List<CheckOutItemDto> checkOutItemDtoList) {
        this.checkOutItemDtoList = checkOutItemDtoList;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "CheckOutInfoDto{" +
                "shippingInfoDto=" + shippingInfoDto +
                ", checkOutItemDtoList=" + checkOutItemDtoList +
                ", subTotal=" + subTotal +
                ", total=" + total +
                '}';
    }
}
