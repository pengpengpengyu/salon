package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.entity.BalanceRechargeRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 余额充值记录表 服务类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface BalanceRechargeRecordService extends IService<BalanceRechargeRecord> {

    /**
     * 新增
     *
     * @param record 余额充值记录
     * @return 余额充值记录
     */
    BalanceRechargeRecord add(BalanceRechargeRecord record);
}
