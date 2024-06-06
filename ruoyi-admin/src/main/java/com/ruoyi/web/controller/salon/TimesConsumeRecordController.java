package com.ruoyi.web.controller.salon;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.service.ItemService;
import com.ruoyi.salon.service.TimesConsumeRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author pywang
 * @description 充次消费记录控制器
 * @create 2024-06-06 21:17
 */
@Controller
@RequestMapping(value = "/salon/timesConsumeRecord")
public class TimesConsumeRecordController extends BaseController {

    @Resource
    private TimesConsumeRecordService timesConsumeRecordService;
    @Resource
    private ItemService itemService;

    private static final String prefix = "salon/record";

    @GetMapping(value = "/list")
    public String list(ModelMap model) {
        model.put("items", itemService.list());
        return prefix + "/times_consume_record";
    }

    /**
     * 列表查询
     * @param searchDto 查询参数
     * @return 消费记录列表
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public TableDataInfo list(RecordSearchDto searchDto) {
        startPage();
        return getDataTable(timesConsumeRecordService.queryVoList(searchDto));
    }

    /**
     * 详情查询
     * @param recordId 记录编号
     * @param model model
     * @return 记录详情
     */
    @GetMapping(value = "/view/{recordId}")
    public String view(@PathVariable("recordId") Long recordId, ModelMap model) {
        model.put("record", timesConsumeRecordService.queryVoById(recordId));
        return prefix + "/times_consume_record_view";
    }
}
