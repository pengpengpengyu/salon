package com.ruoyi.salon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.domain.entity.BalanceConsumeRecord;
import com.ruoyi.salon.domain.vo.BalanceConsumeRecordVo;

import java.util.List;

/**
 * <p>
 * 余额消费记录表 Mapper 接口
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface BalanceConsumeRecordMapper extends BaseMapper<BalanceConsumeRecord> {

    /**
     * 列表查询
     * @param searchDto 查询参数
     * @return 余额消费记录列表
     */
    List<BalanceConsumeRecordVo> selectList(RecordSearchDto searchDto);
}
