package com.example.mybatisplus.mapper;

import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PageResult<T> {
    private List<T> data;
    private int page;
    private int size;
    private long total;

    // 构造方法、getter和setter省略

    public PageResult(List<T> data, int page, int size, long total) {
        this.data = data;
        this.page = page;
        this.size = size;
        this.total = total;
    }

    // Getter 和 Setter
    public List<T> getData() {
        return data;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public long getTotal() {
        return total;
    }
}