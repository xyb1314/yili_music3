package com.bilitech.yilimusic.exception;

import lombok.Data;
import org.apache.logging.log4j.message.StringFormattedMessage;

@Data
public class ErrorResponse {

    private Integer code ;

    private String message ;

    private Object trace ;


}
