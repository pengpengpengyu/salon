package com.ruoyi.web.controller.salon;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.salon.domain.dto.MemberDto;
import com.ruoyi.salon.domain.entity.Member;
import com.ruoyi.salon.domain.vo.MemberVo;
import com.ruoyi.salon.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * MemberController
 *
 * @author pywang
 * @version 1.0
 * @description 会员管理控制器
 * @date 2024/5/19 7:28
 */
@Controller
@RequestMapping(value = "/salon/member")
public class MemberController extends BaseController {

    @Resource
    private MemberService memberService;
    private String prefix = "salon/member";

    @GetMapping()
    public String member() {
        return prefix + "/member";
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 会员列表查询
     *
     * @param member 请求参数
     * @return 会员列表
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public TableDataInfo list(Member member) {
        startPage();
        List<MemberVo> list = BeanUtils.convertList(memberService.list(member), MemberVo.class);
        return getDataTable(list);
    }

    /**
     * 新增会员
     * @param memberDto 会员信息
     * @return 会员信息
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MemberDto memberDto) {
        Member member = BeanUtils.convertEntity(memberDto, Member.class);
        Member resultMemeber = memberService.add(member);
        return AjaxResult.success(member);
    }

}
