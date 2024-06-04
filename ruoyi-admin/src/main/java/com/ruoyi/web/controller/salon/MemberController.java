package com.ruoyi.web.controller.salon;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.core.validation.UpdateGroup;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.framework.web.service.DictService;
import com.ruoyi.salon.domain.dto.*;
import com.ruoyi.salon.domain.entity.*;
import com.ruoyi.salon.domain.enums.DictTypeEnum;
import com.ruoyi.salon.domain.vo.MemberVo;
import com.ruoyi.salon.service.MemberItemRelService;
import com.ruoyi.salon.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
    @Resource(name = "dict")
    private DictService dictService;
    @Resource
    private MemberItemRelService memberItemRelService;
    private final String prefix = "salon/member";

    @GetMapping()
    public String member() {
        return prefix + "/member";
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @GetMapping("/edit/{memberId}")
    public String edit(@PathVariable("memberId") String memberId, ModelMap modelMap) {
        Member member = memberService.getById(memberId);
        modelMap.put("member", BeanUtils.convertEntity(member, MemberVo.class));
        return prefix + "/edit";
    }

    /**
     * 余额充值
     *
     * @param memberId 会员编号
     * @param modelMap modelMap
     * @return 余额充值
     */
    @GetMapping("/balanceRecharge/{memberId}")
    public String balanceRecharge(@PathVariable("memberId") Long memberId, ModelMap modelMap) {
        Member member = memberService.getById(memberId);
        modelMap.put("member", BeanUtils.convertEntity(member, MemberVo.class));
        return prefix + "/balance_recharge";
    }

    /**
     * 次数充值
     *
     * @param memberId 会员编号
     * @param modelMap modelMap
     * @return 次数充值
     */
    @GetMapping("/timesRecharge/{memberId}")
    public String timesRecharge(@PathVariable("memberId") Long memberId, ModelMap modelMap) {
        Member member = memberService.getById(memberId);
        modelMap.put("member", BeanUtils.convertEntity(member, MemberVo.class));
        modelMap.put("memberItemRels", memberItemRelService.queryRelForAllItemByMemberId(memberId));
        return prefix + "/times_recharge";
    }

    /**
     * 消费
     * @param memberId 会员编号
     * @param modelMap modelMap
     * @return 消费页面
     */
    @GetMapping("/consume/{memberId}")
    public String consume(@PathVariable("memberId") Long memberId, ModelMap modelMap) {
        Member member = memberService.getById(memberId);
        modelMap.put("member", BeanUtils.convertEntity(member, MemberVo.class));
        modelMap.put("memberItemRels", memberItemRelService.queryRelForAllItemByMemberId(memberId));
        return prefix + "/consume";
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
        Map<String, SysDictData> dictDataMap = dictService.getTypeMap(DictTypeEnum.SALON_MEMBER_LEVEL.getCode());
        list.forEach(t -> t.setLevel(dictDataMap.getOrDefault(t.getLevel(), new SysDictData()).getDictLabel()));
        return getDataTable(list);
    }

    /**
     * 新增会员
     *
     * @param memberDto 会员信息
     * @return 会员信息
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MemberDto memberDto) {
        Member member = BeanUtils.convertEntity(memberDto, Member.class);
        member.setCreateBy(getLoginName());
        member.setUpdateBy(getLoginName());
        Member resultMemeber = memberService.add(member);
        return AjaxResult.success(resultMemeber);
    }

    /**
     * 修改会员信息
     *
     * @param memberDto 会员信息
     * @return 会员信息
     */
    @PostMapping(value = "/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated(value = UpdateGroup.class) MemberDto memberDto) {
        Member member = BeanUtils.convertEntity(memberDto, Member.class);
        member.setUpdateBy(getLoginName());
        Member resultMember = memberService.update(member);
        return AjaxResult.success(resultMember);
    }

    /**
     * 根据ID列表批量删除
     *
     * @param ids 会员ID 多个ID以英文逗号分割
     * @return 删除结果
     */
    @PostMapping(value = "/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        Set<Long> memberIds = Arrays.stream(Convert.toLongArray(ids)).collect(Collectors.toSet());
        return toAjax(memberService.removeBatch(memberIds));
    }

    /**
     * 余额充值
     *
     * @param dto 充值记录
     * @return true/false
     */
    @PostMapping("/balanceRecharge")
    @ResponseBody
    public AjaxResult balanceRechargeSave(@Validated BalanceRechargeRecordDto dto) {
        BalanceRechargeRecord record = BeanUtils.convertEntity(dto, BalanceRechargeRecord.class);
        record.setCreateBy(getLoginName());
        record.setUpdateBy(getLoginName());
        return toAjax(memberService.balanceRecharge(record));
    }

    /**
     * 次数充值充值
     *
     * @param dto 充值记录
     * @return true/false
     */
    @PostMapping("/timesRecharge")
    @ResponseBody
    public AjaxResult timesRechargeSave(@Validated TimesRechargeRecordDto dto) {
        TimesRechargeRecord record = BeanUtils.convertEntity(dto, TimesRechargeRecord.class);
        record.setCreateBy(getLoginName());
        record.setUpdateBy(getLoginName());
        return toAjax(memberService.timesRecharge(record));
    }

    /**
     * 余额消费
     *
     * @param dto 消费记录
     * @return true/false
     */
    @PostMapping("/balanceConsume")
    @ResponseBody
    public AjaxResult balanceConsumeSave(@Validated BalanceConsumeRecordDto dto) {
        BalanceConsumeRecord record = BeanUtils.convertEntity(dto, BalanceConsumeRecord.class);
        return toAjax(memberService.balanceConsume(record));
    }

    /**
     * 充次消费
     * @param dto 消费记录
     * @return true/false
     */
    @PostMapping("/timesConsume")
    @ResponseBody
    public AjaxResult timesConsume(@Validated TimesConsumeRecordDto dto) {
        TimesConsumeRecord record = BeanUtils.convertEntity(dto, TimesConsumeRecord.class);
        return toAjax(memberService.timesConsume(record));
    }

}
