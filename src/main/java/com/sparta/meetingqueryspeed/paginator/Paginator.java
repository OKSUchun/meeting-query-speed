package com.sparta.meetingqueryspeed.paginator;

import java.util.List;

public interface Paginator<T> {
    boolean hasNextPage(List<T> list, int pageSize);
}
