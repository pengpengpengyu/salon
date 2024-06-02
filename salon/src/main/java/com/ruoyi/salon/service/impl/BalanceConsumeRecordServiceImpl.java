package com.ruoyi.salon.service.impl;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.salon.domain.entity.BalanceConsumeRecord;
import com.ruoyi.salon.mapper.BalanceConsumeRecordMapper;
import com.ruoyi.salon.service.BalanceConsumeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    @Override
    public Boolean add(BalanceConsumeRecord balanceConsumeRecord) {
        balanceConsumeRecord.setCreateBy(ShiroUtils.getLoginName());
        balanceConsumeRecord.setUpdateBy(ShiroUtils.getLoginName());
        return save(balanceConsumeRecord);
    }
}
