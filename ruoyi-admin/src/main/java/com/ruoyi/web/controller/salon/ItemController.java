package com.ruoyi.web.controller.salon;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validation.UpdateGroup;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.salon.domain.dto.ItemDto;
import com.ruoyi.salon.domain.entity.Item;
import com.ruoyi.salon.domain.vo.ItemVo;
import com.ruoyi.salon.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ItemController
 *
 * @author pywang
 * @version 1.0
 * @description 项目控制器
 * @date 2024/5/28 22:21
 */
@Controller
@RequestMapping("/salon/item")
public class ItemController extends BaseController {

    @Resource
    private ItemService itemService;

    private static final String prefix = "salon/item";

    @GetMapping()
    public String item() {
        return prefix + "/item";
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @GetMapping("/edit/{itemId}")
    public String edit(@PathVariable("itemId") Long itemId, ModelMap modelMap) {
        Item item = itemService.getById(itemId);
        modelMap.put("item", item);
        return prefix + "/edit";
    }

    /**
     * 列表查询
     *
     * @param itemDto 查询参数
     * @return 项目列表
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public TableDataInfo list(ItemDto itemDto) {
        Item item = BeanUtils.convertEntity(itemDto, Item.class);
        startPage();
        List<Item> list = itemService.list(item);
        return getDataTable(BeanUtils.convertList(list, ItemVo.class));
    }

    /**
     * 新增项目
     *
     * @param itemDto 项目
     * @return 项目
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public AjaxResult add(@Validated ItemDto itemDto) {
        Item item = BeanUtils.convertEntity(itemDto, Item.class);
        Item addItem = itemService.add(item);
        return AjaxResult.success(BeanUtils.convertEntity(addItem, ItemVo.class));
    }

    /**
     * 修改项目
     *
     * @param itemDto 项目
     * @return 项目
     */
    @PostMapping(value = "/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated(value = UpdateGroup.class) ItemDto itemDto) {
        Item item = BeanUtils.convertEntity(itemDto, Item.class);
        Item addItem = itemService.update(item);
        return AjaxResult.success(BeanUtils.convertEntity(addItem, ItemVo.class));
    }

    /**
     * 删除项目
     *
     * @param ids 项目ID
     * @return ture /fasle
     */
    @PostMapping(value = "/remove")
    @ResponseBody
    public AjaxResult remove(Long ids) {
        return AjaxResult.success(itemService.remove(ids));
    }
}
