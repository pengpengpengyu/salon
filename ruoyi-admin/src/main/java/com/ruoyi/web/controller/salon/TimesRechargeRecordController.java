package com.ruoyi.web.controller.salon;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.service.ItemService;
import com.ruoyi.salon.service.TimesRechargeRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author pywang
 * @description 次数充值控制器
 * @create 2024-06-05 22:03
 */
@Controller
@RequestMapping(value = "/salon/timesRechargeRecord")
public class TimesRechargeRecordController extends BaseController {

    @Resource
    private TimesRechargeRecordService timesRechargeRecordService;
    @Resource
    private ItemService itemService;

    private final String prefix = "salon/record";

    @GetMapping("/list")
    public String list(ModelMap modelMap) {
        modelMap.put("items", itemService.list());
        return prefix + "/times_recharge_record";
    }

    /**
     * 详情查询
     *
     * @param recordId 记录ID
     * @param modelMap modleMap
     * @return 详情
     */
    @GetMapping("/view/{recordId}")
    public String view(@PathVariable("recordId") Long recordId, ModelMap modelMap) {
        modelMap.put("record", timesRechargeRecordService.queryInfoById(recordId));
        return prefix + "/tiems_recharge_record_view";
    }

    /**
     * 列表查询
     *
     * @param searchDto 查询参数
     * @return 列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecordSearchDto searchDto) {
        startPage();
        return getDataTable(timesRechargeRecordService.queryList(searchDto));
    }

}
