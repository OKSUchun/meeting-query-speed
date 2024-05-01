package com.sparta.meetingqueryspeed.paginator;

import java.util.List;

public class ListPaginator<T> implements Paginator<T> {
    @Override
    public boolean hasNextPage(List<T> list, int pageSize) {
        return list.size() > pageSize;
    }
}
