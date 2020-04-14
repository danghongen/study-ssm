package com.myself.study.common.Vo;

import lombok.Data;
import org.apache.ibatis.annotations.Param;

@Data
public class ResultInfo {

    private String Msg;

    private Object Rows;
}
