package com.ruoyi.salon.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.salon.domain.entity.Item;
import com.ruoyi.salon.domain.entity.MemberItemRel;
import com.ruoyi.salon.domain.vo.MemberItemRelVo;
import com.ruoyi.salon.mapper.MemberItemRelMapper;
import com.ruoyi.salon.service.ItemService;
import com.ruoyi.salon.service.MemberItemRelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 会员项目关联表 服务实现类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Service
public class MemberItemRelServiceImpl extends ServiceImpl<MemberItemRelMapper, MemberItemRel> implements MemberItemRelService {

    @Resource
    private ItemService itemService;

    @Override
    public MemberItemRel queryByMemberAndItemId(Long memberId, Long itemId) {
        if (memberId == null || itemId == null) {
            return null;
        }
        return lambdaQuery()
                .eq(MemberItemRel::getMemberId, memberId)
                .eq(MemberItemRel::getItemId, itemId)
                .one();
    }

    @Override
    public MemberItemRel queryByMemberAndItemIdWithCheck(Long memberId, Long itemId) {
        MemberItemRel memberItemRel = queryByMemberAndItemId(memberId, itemId);
        if (memberItemRel == null) {
            throw new ServiceException("该会员未充值过该项目");
        }
        return memberItemRel;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRelOrTimes(MemberItemRel rel) {
        if (rel.getMemberId() == null || rel.getItemId() == null || rel.getTimes() == null) {
            throw new ServiceException("会员编号,项目编号,充值次数不能为空");
        }
        MemberItemRel memberItemRel = queryByMemberAndItemId(rel.getMemberId(), rel.getItemId());
        MemberItemRel updateRel = new MemberItemRel();
        if (memberItemRel == null) {
            updateRel = new MemberItemRel();
            updateRel.setMemberId(rel.getMemberId());
            updateRel.setItemId(rel.getItemId());
            updateRel.setTimes(rel.getTimes());
            addRel(updateRel);
        } else {
            updateRel.setMemberItemRelId(memberItemRel.getMemberItemRelId());
            updateRel.setTimes(memberItemRel.getTimes() + rel.getTimes());
            updateRel.setUpdateBy(ShiroUtils.getLoginName());
            updateById(updateRel);
        }
    }

    @Override
    public List<MemberItemRelVo> queryVoListByMemberId(Long memberId) {
        if (memberId == null) {
            return Collections.emptyList();
        }
        return baseMapper.selectVoListByMemberId(memberId);
    }

    @Override
    public List<MemberItemRelVo> queryRelForAllItemByMemberId(Long memberId) {
        if (memberId == null) {
            return Collections.emptyList();
        }
        List<MemberItemRelVo> memberItemRelVos = baseMapper.selectVoListByMemberId(memberId);
        Set<Long> itemIds = memberItemRelVos.stream().map(MemberItemRelVo::getItemId).collect(Collectors.toSet());
        itemService.list().forEach(item -> {
            if (!itemIds.contains(item.getItemId())) {
                MemberItemRelVo memberItemRelVo = new MemberItemRelVo();
                memberItemRelVo.setItemId(item.getItemId());
                memberItemRelVo.setItemName(item.getItemName());
                memberItemRelVo.setTimes(0);
                memberItemRelVo.setPrice(item.getPrice());
                memberItemRelVo.setDiscountedPrice(item.getDiscountedPrice());
                memberItemRelVos.add(memberItemRelVo);
            }
        });
        return memberItemRelVos;
    }

    @Override
    public Boolean updateByRelId(MemberItemRel rel) {
        rel.setUpdateBy(ShiroUtils.getLoginName());
        return updateById(rel);
    }

    @Override
    public Boolean existByItemId(Long itemId) {
        return lambdaQuery().eq(MemberItemRel::getItemId, itemId).last(" limit 1").one() != null;
    }

    private MemberItemRel addRel(MemberItemRel memberItemRel) {
        memberItemRel.setCreateBy(ShiroUtils.getLoginName());
        memberItemRel.setUpdateBy(ShiroUtils.getLoginName());
        save(memberItemRel);
        return memberItemRel;
    }
}
