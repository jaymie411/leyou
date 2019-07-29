package com.leyou.common.vo;

import lombok.Data;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author：JiangYuzhen
 * @date：2019/7/27
 * @time: 23:02
 * @description: TODO
 */
@Data
public class PageResult<T> {
    private Long total;// 总条数
    private Long totalPage;// 总页数
    private List<T> items;// 当前页数据

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Long totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }
}
