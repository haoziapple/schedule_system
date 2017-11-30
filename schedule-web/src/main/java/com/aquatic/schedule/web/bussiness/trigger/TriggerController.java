package com.aquatic.schedule.web.bussiness.trigger;

import com.aquatic.schedule.bean.*;
import com.aquatic.schedule.dao.TriggerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @className: com.aquatic.schedule.web.bussiness.trigger.TriggerController
 * @description: 触发器Controller
 * @author: wanghao/haozixiaowang@163.com
 * @date: 2017/11/30 14:16
 **/
@RequestMapping("/api/trigger")
@RestController
public class TriggerController {
    @Autowired
    private TriggerMapper triggerMapper;

    private static Logger logger = LoggerFactory.getLogger(TriggerController.class);

    @RequestMapping(value = "/queryTriggers", method = RequestMethod.POST)
    public ResultBean<Page<TriggerBean>> queryTriggers(@RequestBody ReqBean<Page<TriggerBean>> req) {
        logger.info(req.toString());

        List<TriggerBean> list = triggerMapper.queryTriggers(req.getData());
        Page<TriggerBean> page = new Page<>(0, 111, 20, list);
        return new ResultBean<>(page);
    }
}
