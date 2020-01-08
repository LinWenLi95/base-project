package com.lwl.project.admin.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

/**
 * @author linwenli
 * @date 2020-01-08 10:54
 */
@Data
@ApiModel(description = "操作结果实体，含操作结果码、操作结果消息、返回数据。")
public class Result<T> {

    @ApiModelProperty(value = "操作结果码", example = "200")
    private Integer code;
    @ApiModelProperty(value = "提示消息", example = "操作成功")
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private T data;

    public Result() {}

    public Result(ResultCode resultCode, String msg, T data) {
        this.code = resultCode.getCode();
        this.msg = StringUtils.isEmpty(msg) ? resultCode.getReasonPhrase() : msg;
        this.data = data;
    }

    /*获取Result实例*/
    public static <T> Result<T> getInstance(ResultCode resultCode, String msg, T data) {
        return new Result<>(resultCode, msg, data);
    }

    public static <T> Result<T> getInstance(ResultCode resultCode, String msg, Class<T> t) {
        return new Result<>(resultCode, msg,null);
    }

    /*请求成功*/
    public static <T> ResponseEntity<Result<T>> success(ResultCode resultCode, String msg, T data) {
        if (resultCode == null) {
            resultCode = ResultCode.OK;
        }
        return ResponseEntity.ok(Result.getInstance(resultCode, msg, data));
    }

    public static <T> ResponseEntity<Result<T>> success(ResultCode resultCode) {
        return success(resultCode, null, null);
    }

    public static <T> ResponseEntity<Result<T>> success(T data) {
        return success(ResultCode.OK, null, data);
    }

    public static <T> ResponseEntity<Result<T>> success() {
        return success(ResultCode.OK);
    }

    /*请求失败*/
    /**接口请求失败时并不会返回data，为了编译器不显示黄色代码警告，加上了反射类型参数，并在接口不返回指定实体时将返回类型指定为Object*/
    public static <T> ResponseEntity<Result<T>> failure(HttpStatus httpStatus, ResultCode resultCode, String msg, Class<T> t) {
        return ResponseEntity.status(httpStatus).body(Result.getInstance(resultCode, msg, t));
    }

    public static <T> ResponseEntity<Result<T>> failure(HttpStatus httpStatus, ResultCode resultCode, Class<T> t) {
        return ResponseEntity.status(httpStatus).body(Result.getInstance(resultCode, null, t));
    }
}
