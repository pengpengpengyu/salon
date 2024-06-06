package com.ruoyi.salon.service.impl;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.framework.web.service.DictService;
import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.domain.entity.BalanceRechargeRecord;
import com.ruoyi.salon.domain.entity.Member;
import com.ruoyi.salon.domain.enums.DictTypeEnum;
import com.ruoyi.salon.domain.vo.BalanceRechargeRecordVo;
import com.ruoyi.salon.mapper.BalanceRechargeRecordMapper;
import com.ruoyi.salon.service.BalanceRechargeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.salon.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 余额充值记录表 服务实现类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Service
public class BalanceRechargeRecordServiceImpl extends ServiceImpl<BalanceRechargeRecordMapper, BalanceRechargeRecord> implements BalanceRechargeRecordService {

    @Resource
    private MemberService memberService;
    @Resource(name = "dict")
    private DictService dictService;

    @Override
    public List<BalanceRechargeRecordVo> selectList(RecordSearchDto searchDto) {
        List<BalanceRechargeRecordVo> list = baseMapper.selectList(searchDto);
        if (!list.isEmpty()) {
            Map<String, SysDictData> typeMap = dictService.getTypeMap(DictTypeEnum.SALON_PAY_MODE.getCode());
            list.forEach(t -> t.setPayMode(typeMap.getOrDefault(t.getPayMode(), new SysDictData()).getDictLabel()));
        }
        return list;
    }

    @Override
    public BalanceRechargeRecordVo queryRecordById(Long recordId) {
        BalanceRechargeRecord record = getById(recordId);
        if (record == null) {
            return null;
        }
        Member member = memberService.getById(record.getMemberId());
        if (member == null) {
            return null;
        }
        BalanceRechargeRecordVo vo = BeanUtils.convertEntity(record, BalanceRechargeRecordVo.class);
        vo.setMemberName(member.getMemberName());
        vo.setMobileNo(member.getMobileNo());
        Map<String, SysDictData> typeMap = dictService.getTypeMap(DictTypeEnum.SALON_PAY_MODE.getCode());
        vo.setPayMode(typeMap.getOrDefault(vo.getPayMode(), new SysDictData()).getDictLabel());
        return vo;
    }

}
