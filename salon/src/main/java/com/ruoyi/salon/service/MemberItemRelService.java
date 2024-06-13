package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.dto.RchgGiveItemRecordDto;
import com.ruoyi.salon.domain.entity.MemberItemRel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.salon.domain.entity.RchgGiveItemRecord;
import com.ruoyi.salon.domain.vo.MemberItemRelVo;

import java.util.List;

/**
 * <p>
 * 会员项目关联表 服务类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface MemberItemRelService extends IService<MemberItemRel> {

    /**
     * 根据会员编号和项目编号查询关联关系
     *
     * @param memberId 会员编号
     * @param itemId   项目编号
     * @return 会员-项目关联
     */
    MemberItemRel queryByMemberAndItemId(Long memberId, Long itemId);

    /**
     * 根据会员编号和项目编号查询关联关系(带校验)
     *
     * @param memberId 会员编号
     * @param itemId   项目编号
     * @return 会员-项目关联
     */
    MemberItemRel queryByMemberAndItemIdWithCheck(Long memberId, Long itemId);


    /**
     * 新增会员项目关联或更新次数
     *
     * @param memberItemRel 会员-项目关联
     */
    void addRelOrUpdateTime(MemberItemRel memberItemRel);

    /**
     * 新增会员项目或更新赠送项目次数
     * @param record 赠送次数记录
     */
    void addRelOrUpdateGiveTimes(RchgGiveItemRecord record);

    /**
     * 批量新增会员项目或更新赠送项目次数
     * @param records 赠送项目记录列表
     */
    void batchAddRelOrUpdateGiveTimes(List<RchgGiveItemRecordDto> records);

    /**
     * 根据会员编号查询 会员-项目关联列表
     *
     * @param memberId 会员编号
     * @return 会员-项目关联列表
     */
    List<MemberItemRelVo> queryVoListByMemberId(Long memberId);

    /**
     * 根据会员编号获取所有项目的关联,如果未关联某个项目则次数为0
     *
     * @param memberId 会员编号
     * @return 会员-项目关联列表
     */
    List<MemberItemRelVo> queryRelForAllItemByMemberId(Long memberId);

    /**
     * 根据编号更新
     * @param rel 会员-项目关联
     * @return true/false
     */
    Boolean updateByRelId(MemberItemRel rel);

    /**
     * 是否存在itemId对应对数据
     * @param itemId 项目编号
     * @return true/false
     */
    Boolean existByItemId(Long itemId);
}
