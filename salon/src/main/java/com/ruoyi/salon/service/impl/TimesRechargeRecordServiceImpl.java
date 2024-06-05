package com.ruoyi.salon.service.impl;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.framework.web.service.DictService;
import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.domain.entity.Item;
import com.ruoyi.salon.domain.entity.Member;
import com.ruoyi.salon.domain.entity.TimesRechargeRecord;
import com.ruoyi.salon.domain.enums.DictTypeEnum;
import com.ruoyi.salon.domain.vo.TimesRechargeRecordVo;
import com.ruoyi.salon.mapper.TimesRechargeRecordMapper;
import com.ruoyi.salon.service.ItemService;
import com.ruoyi.salon.service.MemberService;
import com.ruoyi.salon.service.TimesRechargeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 次数充值记录表 服务实现类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Service
public class TimesRechargeRecordServiceImpl extends ServiceImpl<TimesRechargeRecordMapper, TimesRechargeRecord> implements TimesRechargeRecordService {

    @Resource(name = "dict")
    private DictService dictService;
    @Resource
    private MemberService memberService;
    @Resource
    private ItemService itemService;

    @Override
    public List<TimesRechargeRecordVo> queryList(RecordSearchDto searchDto) {
        List<TimesRechargeRecordVo> list = baseMapper.selectList(searchDto);
        if (!list.isEmpty()) {
            Map<String, SysDictData> typeMap = dictService.getTypeMap(DictTypeEnum.SALON_PAY_MODE.getCode());
            list.forEach(t -> t.setPayMode(typeMap.getOrDefault(t.getPayMode(), new SysDictData()).getDictLabel()));
        }
        return list;
    }

    @Override
    public TimesRechargeRecordVo queryInfoById(Long recordId) {
        TimesRechargeRecord record = getById(recordId);
        if (record == null) {
            return null;
        }
        Member member = memberService.getById(record.getMemberId());
        if (member == null) {
            return null;
        }
        Item item = itemService.getById(record.getItemId());
        TimesRechargeRecordVo vo = BeanUtils.convertEntity(record, TimesRechargeRecordVo.class);
        vo.setMemberName(member.getMemberName());
        vo.setMobileNo(member.getMobileNo());
        if (item != null) {
            vo.setItemName(item.getItemName());
        }
        return vo;
    }
}
