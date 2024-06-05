package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.domain.entity.TimesRechargeRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.salon.domain.vo.TimesRechargeRecordVo;

import java.util.List;

/**
 * <p>
 * 次数充值记录表 服务类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface TimesRechargeRecordService extends IService<TimesRechargeRecord> {

    /**
     * 记录列表查询
     *
     * @param searchDto 查询参数
     * @return 记录列表
     */
    List<TimesRechargeRecordVo> queryList(RecordSearchDto searchDto);

    /**
     * 根据记录ID查询详情
     *
     * @param recordId 记录ID
     * @return 详情
     */
    TimesRechargeRecordVo queryInfoById(Long recordId);
}
