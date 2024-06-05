package com.ruoyi.salon.mapper;

import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.domain.entity.TimesRechargeRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.salon.domain.vo.TimesRechargeRecordVo;

import java.util.List;

/**
 * <p>
 * 次数充值记录表 Mapper 接口
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface TimesRechargeRecordMapper extends BaseMapper<TimesRechargeRecord> {

    /**
     * 记录列表查询
     *
     * @param searchDto 查询参数
     * @return 记录列表
     */
    List<TimesRechargeRecordVo> selectList(RecordSearchDto searchDto);
}
