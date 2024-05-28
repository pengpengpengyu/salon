package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.entity.Item;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.salon.domain.entity.Member;

import java.util.List;

/**
 * <p>
 * 项目表 服务类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface ItemService extends IService<Item> {

    /**
     * 列表查询
     *
     * @param item 查询参数
     * @return 项目列表
     */
    List<Item> list(Item item);

    /**
     * 新增项目
     *
     * @param item 项目
     * @return 项目
     */
    Item add(Item item);

    /**
     * 修改项目
     *
     * @param item 项目
     * @return 项目
     */
    Item update(Item item);

    /**
     * 删除项目
     * @param itemId 项目编号
     * @return true/ false
     */
    boolean remove(Long itemId);
}
