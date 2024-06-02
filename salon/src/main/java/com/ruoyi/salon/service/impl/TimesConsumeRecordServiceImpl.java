package com.ruoyi.salon.service.impl;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.salon.domain.entity.TimesConsumeRecord;
import com.ruoyi.salon.mapper.TimesConsumeRecordMapper;
import com.ruoyi.salon.service.TimesConsumeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    @Override
    public Boolean add(TimesConsumeRecord record) {
        record.setCreateBy(ShiroUtils.getLoginName());
        record.setUpdateBy(ShiroUtils.getLoginName());
        return save(record);
    }
}
