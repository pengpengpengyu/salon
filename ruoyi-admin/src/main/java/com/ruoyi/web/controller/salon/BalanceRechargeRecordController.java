package com.ruoyi.web.controller.salon;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.salon.domain.dto.BalanceRechargeRecordDto;
import com.ruoyi.salon.domain.entity.BalanceRechargeRecord;
import com.ruoyi.salon.service.BalanceRechargeRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * BalanceRechargeRecordController
 *
 * @author pywang
 * @version 1.0
 * @description 余额充值记录控制器
 * @date 2024/5/29 22:06
 */
@Controller
@RequestMapping(value = "/salon/balanceRechargeRecord")
public class BalanceRechargeRecordController extends BaseController {

    @Resource
    private BalanceRechargeRecordService balanceRechargeRecordService;

    private final String prefix = "salon/balanceRechargeRecord";


}
