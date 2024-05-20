package com.ruoyi.salon.service;

import com.ruoyi.salon.domain.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
public interface MemberService extends IService<Member> {

    /**
     * 会员列表查询
     * @param member 查询参数
     * @return 会员列表
     */
    List<Member> list(Member member);

    /**
     * 新增会员
     * @param member
     * @return
     */
    Member add(Member member);
}
