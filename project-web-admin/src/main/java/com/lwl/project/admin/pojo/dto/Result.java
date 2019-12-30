package com.lwl.project.admin.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author admin
 */
@Data
@ApiModel(value = "Result", description = "操作结果实体，含操作结果码、操作结果消息、返回数据。")
public class Result<T> {

    @ApiModelProperty(value = "操作结果码", example = "200", required = true)
    private Integer code;
    @ApiModelProperty(value = "提示消息", example = "操作成功", required = true)
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private T data;

    public Result(){}

    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        if (data != null) {
           this.data = data;
        }
    }

    public static <T> Result<T> retResult(Integer code,String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> success(T data) {
        return retResult(ResultCode.OK, "Success!", data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return retResult(ResultCode.OK, msg, data);
    }

    public static Result success(String msg) {
        return success(msg, null);
    }

    public static Result success() {
        return success("Success!");
    }

    public static Result failure(Integer code, String msg) {
        return retResult(code, msg, null);
    }

    public static Result failure(Integer code) {
        return failure(code, null);
    }

    public static Result failure(String msg) {
        return failure(100, msg);
    }

    public static Result failure() {
        return failure(100, null);
    }
}
