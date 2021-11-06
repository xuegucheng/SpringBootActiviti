package com.activiti.common.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码
 */
@AllArgsConstructor
@Getter
public enum ResultCode {

    SUCCESS(200, "Success"),

    ERROR(500, "Error"),
    PARAMETER_ERROR(102, "Invalid Parameter"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),


    AUDIT_PR(10001, "待审核"),
    AUDIT_RE(10002, "审核拒绝"),
    AUDIT_CO(10003, "审核通过");

    private final int code;

    private final String description;

}
