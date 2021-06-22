package com.xyhj.demo.base;

public enum RetEnum {
    SUCCESS(200, "success"),
    INTERNAL_ERROR(500, "内部异常"),
    VERIFY_APITOKEN_ERROR(10000, "apitoken不可用"),
    PARAMETER_EMPTY(10001, "参数不能为空"),
    PARAMETER_NOT_ALLOW(10002, "参数不正确"),
    TOKEN_VERIFY_FAIL(10003, "token认证失败"),

    THIRD_PARTY_BUSINESS_ERROR_CODE(299, "第三方信息错误码"),
    STORAGE_CENTER_CODE_ALREADY(10004,"储运中心编号已存在"),
    EXPORT_SIZE_OUTNUMBER(10005, "单次最大支持导出10万条，请分段导出"),
    PERMISSION_ERROR(10006,"您的账号没有查询此数据的权限"),
    PARTS_INBOUND_PLAN_STATUS_ONE_FOUR(10007, "配件入库计划单非新建或部分检验数据"),
    PARTS_OUTBOUND_PLAN_STATUS_ERROR(10008,"配件出库计划单非新建或部分检验数据"),
    DATA_DOSE_NOT_EXIST(10009,"数据不存在"),
    CUSTOMER_ACCOUNT_NOT_EXIST(10010,"配件出库计划单中客户账户不存在"),
    CUSTOMER_ACCOUNT_STATUS_NOT_EFFECTIVE(10011,"客户账户不是有效状态"),
    OUTBOUND_IS_GREATER_THAN_PLANNED(10012,"出库量大于计划量");

    private int code;
    private String message;

    private RetEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static RetEnum getRetEnum(int code) {
        if (code == 0) {
            return null;
        }

        RetEnum[] values = RetEnum.values();
        for (RetEnum e : values) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }
}
