package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.domain.entity.BalanceRechargeRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.salon.domain.vo.BalanceRechargeRecordVo;

import java.util.List;

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
     * 记录列表查询
     *
     * @param searchDto 查询参数
     * @return 记录列表
     */
    List<BalanceRechargeRecordVo> selectList(RecordSearchDto searchDto);

    /**
     * 查询记录详情
     *
     * @param recordId 记录编号
     * @return 记录详情
     */
    BalanceRechargeRecordVo queryRecordById(Long recordId);

}
