package com.company.util;

/**
 * @author zy
 * @category 订单状态工具类
 */
public enum OrderStatusEnum {
    CANCELED(0,"已取消"),
    NO_PAY(10,"未付款"),
    PAID(20,"已付款"),
    SEND(30,"已发货"),
    RECEIVED(40,"收货成功"),
    CLOSE(50,"交易关闭");

    private int code;
    private String value;
    OrderStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
    public static OrderStatusEnum codeOf(int code) {
        for (OrderStatusEnum orderStatusEnum : values()) {
            if(orderStatusEnum.getCode() == code) {
                return orderStatusEnum;
            }
        }
        throw new RuntimeException("未找到对于应的枚举类");
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
