package com.ruoyi.web.controller.salon;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.service.BalanceRechargeRecordService;
import com.ruoyi.salon.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    private ItemService itemService;

    private final String prefix = "salon/record";

    @GetMapping(value = "/list")
    public String list() {
        return prefix + "/balance_recharge_record";
    }

    @GetMapping(value = "/view/{recordId}")
    public String view(@PathVariable("recordId") Long recordId, ModelMap mmap) {
        mmap.put("record", balanceRechargeRecordService.queryRecordById(recordId));
        return prefix + "/balance_recharge_record_view";
    }

    /**
     * 查询记录列表
     * @param searchDto 查询参数
     * @return 记录列表
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public TableDataInfo list(RecordSearchDto searchDto) {
        startPage();
        return getDataTable(balanceRechargeRecordService.selectList(searchDto));
    }

}
