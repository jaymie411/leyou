package com.leyou.common.vo;

import com.leyou.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * Created with IDEA
 *
 * @author：JiangYuzhen
 * @date：2019/7/23
 * @time: 17:15
 * @description: TODO
 */
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum exceptionEnum){
        this.status = exceptionEnum.getCode();
        this.message = exceptionEnum.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
