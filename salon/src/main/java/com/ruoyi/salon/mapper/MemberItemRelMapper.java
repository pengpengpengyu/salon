package com.ruoyi.salon.mapper;

import com.ruoyi.salon.domain.entity.MemberItemRel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.salon.domain.vo.MemberItemRelVo;

import java.util.List;

/**
 * <p>
 * 会员项目关联表 Mapper 接口
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface MemberItemRelMapper extends BaseMapper<MemberItemRel> {

    /**
     * 根据会员编号查询 会员-项目关联列表
     *
     * @param memberId 会员编号
     * @return 会员-项目关联列表
     */
    List<MemberItemRelVo> selectVoListByMemberId(Long memberId);
}
