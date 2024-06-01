package com.ruoyi.salon.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.salon.domain.entity.MemberItemRel;
import com.ruoyi.salon.mapper.MemberItemRelMapper;
import com.ruoyi.salon.service.MemberItemRelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    private MemberItemRel addRel(MemberItemRel memberItemRel) {
        memberItemRel.setCreateBy(ShiroUtils.getLoginName());
        memberItemRel.setUpdateBy(ShiroUtils.getLoginName());
        save(memberItemRel);
        return memberItemRel;
    }
}
