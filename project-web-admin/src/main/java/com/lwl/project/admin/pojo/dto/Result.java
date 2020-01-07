package com.lwl.project.admin.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

/**
 * @author admin
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

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> getInstance(Integer code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> getInstance(Integer code, String msg, Class<T> t) {
        return new Result<>(code, msg, null);
    }

    /**
     * 基础版请求成功方法
     */
    public static <T> ResponseEntity<Result<T>> success(Integer code, String msg, T data) {
        // TODO 如果没传自定义code则填入默认code
        if (code == null) {
            code = 200;
        }
        // TODO 如果没传自定义消息则根据code填入默认消息
        if (StringUtils.isEmpty(msg)) {
            msg = "200对应的消息";
        }
        return ResponseEntity.ok(Result.getInstance(code, msg, data));
    }

    public static <T> ResponseEntity<Result<T>> success(Integer code, String msg) {
        return success(code, msg, null);
    }

    public static <T> ResponseEntity<Result<T>> success(T data) {
        return success(null, null, data);
    }

    public static <T> ResponseEntity<Result<T>> success() {
        return success(null);
    }

    public static <T> ResponseEntity<Result<T>> failure(HttpStatus httpStatus, Integer code, String msg, Class<T> t) {
        return ResponseEntity.status(httpStatus).body(Result.getInstance(code, msg, t));
    }
}
