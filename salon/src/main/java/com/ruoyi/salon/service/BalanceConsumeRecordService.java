package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.dto.RecordSearchDto;
import com.ruoyi.salon.domain.entity.BalanceConsumeRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.salon.domain.vo.BalanceConsumeRecordVo;

import java.util.List;

/**
 * <p>
 * 余额消费记录表 服务类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface BalanceConsumeRecordService extends IService<BalanceConsumeRecord> {

    /**
     * 新增
     * @param balanceConsumeRecord 余额消费记录
     * @return true/false
     */
    Boolean add(BalanceConsumeRecord balanceConsumeRecord);

    /**
     * 列表查询
     * @param searchDto 查询参数
     * @return 余额消费记录列表
     */
    List<BalanceConsumeRecordVo> queryVoList(RecordSearchDto searchDto);

    /**
     * 根据记录编号查询消费记录详情
     * @param id 记录编号
     * @return 消费记录详情
     */
    BalanceConsumeRecordVo queryVoById(Long id);

    /**
     * 是否存在itemId对应对数据
     * @param itemId 项目编号
     * @return true/false
     */
    Boolean existsByItemId(Long itemId);
}
