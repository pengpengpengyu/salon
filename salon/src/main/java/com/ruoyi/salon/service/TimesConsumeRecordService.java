package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.domain.entity.TimesConsumeRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.salon.domain.vo.TimesConsumeRecordVo;

import java.util.List;

/**
 * <p>
 * 次数消费记录表 服务类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface TimesConsumeRecordService extends IService<TimesConsumeRecord> {

    /**
     * 新增
     *
     * @param record 次数消费记录
     * @return true/false
     */
    Boolean add(TimesConsumeRecord record);

    /**
     * 记录列表查询
     * @param searchDto 查询参数
     * @return 记录列表
     */
    List<TimesConsumeRecordVo> queryVoList(RecordSearchDto searchDto);

    /**
     * 根据记录编号查询记录详情
     * @param id 记录编号
     * @return 记录详情
     */
    TimesConsumeRecordVo queryVoById(Long id);

    /**
     * 是否存在itemId对应对数据
     * @param itemId 项目编号
     * @return true/false
     */
    Boolean existsByItemId(Long itemId);
}
