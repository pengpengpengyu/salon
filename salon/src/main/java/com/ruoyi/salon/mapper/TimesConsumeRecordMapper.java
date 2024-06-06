package com.ruoyi.salon.mapper;

import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.domain.entity.TimesConsumeRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.salon.domain.vo.TimesConsumeRecordVo;

import java.util.List;

/**
 * <p>
 * 次数消费记录表 Mapper 接口
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface TimesConsumeRecordMapper extends BaseMapper<TimesConsumeRecord> {

    /**
     * 列表查询
     * @param searchDto 查询参数
     * @return 记录列表
     */
    List<TimesConsumeRecordVo> selectVoList(RecordSearchDto searchDto);
}
