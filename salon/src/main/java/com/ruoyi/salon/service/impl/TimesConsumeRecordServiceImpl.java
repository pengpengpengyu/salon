package com.ruoyi.salon.service.impl;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.domain.entity.Item;
import com.ruoyi.salon.domain.entity.Member;
import com.ruoyi.salon.domain.entity.TimesConsumeRecord;
import com.ruoyi.salon.domain.vo.TimesConsumeRecordVo;
import com.ruoyi.salon.mapper.TimesConsumeRecordMapper;
import com.ruoyi.salon.service.ItemService;
import com.ruoyi.salon.service.MemberService;
import com.ruoyi.salon.service.TimesConsumeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 次数消费记录表 服务实现类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Service
public class TimesConsumeRecordServiceImpl extends ServiceImpl<TimesConsumeRecordMapper, TimesConsumeRecord> implements TimesConsumeRecordService {

    @Resource
    private MemberService memberService;
    @Resource
    private ItemService itemService;

    @Override
    public Boolean add(TimesConsumeRecord record) {
        record.setCreateBy(ShiroUtils.getLoginName());
        record.setUpdateBy(ShiroUtils.getLoginName());
        return save(record);
    }

    @Override
    public List<TimesConsumeRecordVo> queryVoList(RecordSearchDto searchDto) {
        return baseMapper.selectVoList(searchDto);
    }

    @Override
    public TimesConsumeRecordVo queryVoById(Long id) {
        TimesConsumeRecord record = getById(id);
        if (record == null) {
            return null;
        }
        Member member = memberService.getById(record.getMemberId());
        if (member == null) {
            return null;
        }
        TimesConsumeRecordVo vo = BeanUtils.convertEntity(record, TimesConsumeRecordVo.class);
        Item item = itemService.getById(record.getItemId());
        if (item != null) {
            vo.setItemName(item.getItemName());
        }
        vo.setMemberName(member.getMemberName());
        vo.setMobileNo(member.getMobileNo());
        return vo;
    }

    @Override
    public Boolean existsByItemId(Long itemId) {
        return lambdaQuery().eq(TimesConsumeRecord::getItemId, itemId).last(" limit 1 ").one() != null;
    }
}
