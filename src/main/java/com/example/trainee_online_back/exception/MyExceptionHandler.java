package com.example.trainee_online_back.exception;


import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.utils.ResponseUtil;
import net.sf.jsqlparser.util.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
;

/**
 * @description:
 * @author: wunan
 * @company: Pactera Technology Co.,Ltd
 * @since: 2021/8/20 11:25
 * @version: V1.0
 **/
@ControllerAdvice
public class MyExceptionHandler {

    private static final Throwable RequestParameterException = null;
    private Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);

    /**
     * 处理基本信息相关的异常
     */
    @ExceptionHandler({BasicInfoException.class})
    @ResponseBody
    public JSONObject handleBasicInfoException(BasicInfoException ex) {
        return ResponseUtil.returnFail(String.valueOf(ex.getCode()), ex.getMessage());
    }


    /**
     * 处理断言异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    @ResponseBody
    public JSONObject handleAssertException(Exception ex) {
        log.error(ex.getMessage());
        return ResponseUtil.returnFail("-99", ex.getMessage());
    }

    /**
     * @description: NPE处理
     * @param:
     * @return:
     * @exception:
     * @author: shiliqiang
     * @company: CTY Technology Co.,Ltd
     * @since: 2021/9/2 10:49
     * @version: V1.0
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public JSONObject exceptionHandler(NullPointerException e) {
        log.error("发生空指针异常！原因是:", e);
        return ResponseUtil.returnFail("-1000", e.toString());
    }


    /**
     * 处理未知异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONObject handleUnKnowException(Exception ex) {
//        ex.printStackTrace();
        log.error("系统异常", ex);
        return ResponseUtil.returnFail("-999", ex.toString());
    }
}
