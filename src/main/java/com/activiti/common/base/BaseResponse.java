package com.activiti.common.base;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * API 应答数据格式
 */
@Getter
@Setter
@ApiModel(value = "通用响应")
public class BaseResponse<T> {

    @ApiModelProperty(value = "结果码")
    private Integer resultCode;

    @ApiModelProperty(value = "响应数据")
    private T data;

    @ApiModelProperty(value = "结果描述")
    private String description;

    public BaseResponse() {
    }

    public BaseResponse(Integer resultCode, T data) {
        this.resultCode = resultCode;
        this.data = data;
    }

    public BaseResponse(Integer resultCode, String description) {
        this.resultCode = resultCode;
        this.description = description;
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(ResultCode.SUCCESS.getCode(), data);
    }

    public static BaseResponse success() {
        return success(null);
    }

    public static <T> BaseResponse<T> error(String description) {
        return new BaseResponse<>(ResultCode.ERROR.getCode(), description);
    }

    public static <T> BaseResponse<T> build(ResultCode code) {
        return new BaseResponse<>(code.getCode(), code.getDescription());
    }

    public static <T> BaseResponse<T> build(ResultCode code, String description) {
        return new BaseResponse<>(code.getCode(), description);
    }

    public boolean isSuccess() {
        return this.resultCode == ResultCode.SUCCESS.getCode();
    }
}
