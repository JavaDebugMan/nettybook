package com.phei.netty.protocol.http.json.pojo;

/**
 * Order information.
 */
public class Order {

    /**
     * 订购的商品数量
     */
    private long orderNumber;
    /**
     * 客户信息
     */
    private Customer customer;

    /**
     * 账单地址
     * Billing address information.
     */
    private Address billTo;
    /**
     * 邮寄方式
     */
    private Shipping shipping;

    /**
     * 送货地址
     * Shipping address information. If missing, the billing address is also
     * used as the shipping address.
     */
    private Address shipTo;
    /**
     * 商品总价
     */
    private Float total;

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderId) {
        this.orderNumber = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getBillTo() {
        return billTo;
    }

    public void setBillTo(Address billTo) {
        this.billTo = billTo;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Order [orderNumber=" + orderNumber + ", customer=" + customer
                + ", billTo=" + billTo + ", shipping=" + shipping.toString()
                + ", shipTo=" + shipTo + ", total=" + total + "]";
    }

}