package com.shiku.im;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

/**
 * @author admin
 */
@Data
@ApiModel(value = "Result", description = "操作结果实体，含操作结果码、操作结果消息、返回数据。")
class Result<T> {

    @ApiModelProperty(value = "操作结果码", example = "200", required = true)
    private Integer code;
    @ApiModelProperty(value = "提示消息", example = "操作成功", required = true)
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private T data;

    public Result() {}

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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
        return ResponseEntity.ok(new Result<>(code, msg, data));
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
}
