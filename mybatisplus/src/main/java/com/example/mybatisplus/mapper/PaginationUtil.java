package com.example.mybatisplus.mapper;

import java.util.Collections;
import java.util.List;

public class PaginationUtil {

    public static <T> PageResult<T> paginate(List<T> allData, int page, int size) {
        if (allData == null || allData.isEmpty()) {
            return new PageResult<>(Collections.emptyList(), page, size, 0);
        }

        int fromIndex = (page - 1) * size;
        if (fromIndex >= allData.size()) {
            return new PageResult<>(Collections.emptyList(), page, size, allData.size());
        }

        int toIndex = Math.min(fromIndex + size, allData.size());
        List<T> pageData = allData.subList(fromIndex, toIndex);
        return new PageResult<>(pageData, page, size, allData.size());
    }
}