package com.ruoyi.salon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.salon.domain.entity.Item;
import com.ruoyi.salon.mapper.ItemMapper;
import com.ruoyi.salon.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 项目表 服务实现类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {

    @Resource
    private MemberItemRelService memberItemRelService;
    @Resource
    private BalanceConsumeRecordService balanceConsumeRecordService;
    @Resource
    private TimesConsumeRecordService timesConsumeRecordService;


    @Override
    public List<Item> list(Item item) {
        return list(new QueryWrapper<>(item));
    }

    @Override
    public Item add(Item item) {
        Item existsItem = lambdaQuery().eq(Item::getItemName, item.getItemName()).one();
        if (existsItem != null) {
            checkUnionItem(existsItem, item);
        }
        save(item);
        return item;
    }

    @Override
    public Item update(Item item) {
        Item existsItem = getById(item.getItemId());
        checkItemNotExists(existsItem);
        checkUnionItem(existsItem, item);
        updateById(item);
        return item;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(Long itemId) {
        Item existsItem = getById(itemId);
        checkItemNotExists(existsItem);
        if (memberItemRelService.existByItemId(itemId)) {
            throw new ServiceException("该项目已有顾客充值");
        }
        if (timesConsumeRecordService.existsByItemId(itemId) || balanceConsumeRecordService.existsByItemId(itemId)) {
            throw new ServiceException("该项目已有顾客消费");
        }
        Item item = new Item();
        item.setItemId(itemId);
        item.setDelItmeId(itemId);
        updateById(item);
        return removeById(itemId);
    }

    @Override
    public Item queryByIdWithCheck(Long itemId) {
        Item existsItem = getById(itemId);
        if (existsItem == null) {
            throw new ServiceException("项目不存在");
        }
        return existsItem;
    }

    private void checkItemNotExists(Item item) {
        if (item == null) {
            throw new ServiceException("项目不存在");
        }
    }

    private void checkUnionItem(Item existsItem, Item item) {
        boolean isUpdate = item.getItemId() != null;
        if (!isUpdate) {
            if (item.getItemName().equals(existsItem.getItemName())) {
                throw new ServiceException("项目已存在:" + item.getItemName());
            }
        } else {
            if (item.getItemName().equals(existsItem.getItemName()) && !existsItem.getItemId().equals( item.getItemId())) {
                throw new ServiceException("项目已存在:" + item.getItemName());
            }
        }
    }
}
