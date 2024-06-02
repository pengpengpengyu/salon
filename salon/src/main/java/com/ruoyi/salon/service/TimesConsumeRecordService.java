package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.entity.TimesConsumeRecord;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
