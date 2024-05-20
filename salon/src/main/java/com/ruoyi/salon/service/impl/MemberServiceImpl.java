package com.ruoyi.salon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.salon.domain.entity.Member;
import com.ruoyi.salon.mapper.MemberMapper;
import com.ruoyi.salon.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author pywang
 * @since 2024-05-19
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Override
    public List<Member> list(Member member) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(member);
        queryWrapper.lambda().orderByDesc(Member::getMemberId);
        return list(queryWrapper);
    }

    @Override
    public Member add(Member member) {
        Member existsMember = lambdaQuery()
                .eq(Member::getMobileNo, member.getMobileNo())
                .eq(Member::getMemberName, member.getMemberName())
                .one();
        if (existsMember != null) {
            throw new ServiceException("该手机号对应的会员已存在!");
        }
        save(member);
        return member;
    }
}
