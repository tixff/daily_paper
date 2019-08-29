package com.yuewan.paper.data;

import lombok.Data;

@Data
public class ResultData {
    private int status;
    private String message;
    private Object data;
}
