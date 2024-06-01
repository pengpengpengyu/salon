package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.entity.MemberItemRel;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * 新增会员项目关联或次数
     * @param memberItemRel 会员-项目关联
     */
    void addRelOrTimes(MemberItemRel memberItemRel);
}
