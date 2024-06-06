package com.ruoyi.salon.service.impl;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.domain.entity.BalanceConsumeRecord;
import com.ruoyi.salon.domain.entity.Item;
import com.ruoyi.salon.domain.entity.Member;
import com.ruoyi.salon.domain.entity.TimesConsumeRecord;
import com.ruoyi.salon.domain.vo.BalanceConsumeRecordVo;
import com.ruoyi.salon.mapper.BalanceConsumeRecordMapper;
import com.ruoyi.salon.service.BalanceConsumeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.salon.service.ItemService;
import com.ruoyi.salon.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 余额消费记录表 服务实现类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Service
public class BalanceConsumeRecordServiceImpl extends ServiceImpl<BalanceConsumeRecordMapper, BalanceConsumeRecord> implements BalanceConsumeRecordService {

    @Resource
    private MemberService memberService;
    @Resource
    private ItemService itemService;

    @Override
    public Boolean add(BalanceConsumeRecord balanceConsumeRecord) {
        balanceConsumeRecord.setCreateBy(ShiroUtils.getLoginName());
        balanceConsumeRecord.setUpdateBy(ShiroUtils.getLoginName());
        return save(balanceConsumeRecord);
    }

    @Override
    public List<BalanceConsumeRecordVo> queryVoList(RecordSearchDto searchDto) {
        return baseMapper.selectList(searchDto);
    }

    @Override
    public BalanceConsumeRecordVo queryVoById(Long id) {
        BalanceConsumeRecord record = getById(id);
        if (record == null) {
            return null;
        }
        Member member = memberService.getById(record.getMemberId());
        if (member == null) {
            return null;
        }
        BalanceConsumeRecordVo vo = BeanUtils.convertEntity(record, BalanceConsumeRecordVo.class);
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
        return lambdaQuery().eq(BalanceConsumeRecord::getItemId, itemId).last(" limit 1 ").one() != null;
    }
}
