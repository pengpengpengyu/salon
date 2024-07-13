package com.ruoyi.salon.mapper;

import com.ruoyi.salon.domain.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface MemberMapper extends BaseMapper<Member> {

    /**
     * 根据会员编号加锁查询
     * @param memberId 会员编号
     * @return 会员
     */
    Member selectByIdWithLock(Long memberId);
}
