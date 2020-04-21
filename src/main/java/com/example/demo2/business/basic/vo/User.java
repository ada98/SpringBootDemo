package com.example.demo2.business.basic.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author ada
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("User")
public class User extends Model<User> {
    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private String uId;

    /**
     * 登陆账号
     */
    private String uLoginName;

    /**
     * 昵称
     */
    private String uNickName;

    /**
     * 密码
     */
    private String uPassword;

    /**
     * 个性签名
     */
    private String uSignature;

    /**
     * 性别编码
     */
    private String uSex;

    /**
     * 出生日期
     */
    private LocalDateTime uBirthday;

    /**
     * 手机
     */
    private String uTel;

    /**
     * 真实姓名
     */
    private String uName;

    /**
     * 邮箱
     */
    private String uEmail;

    /**
     * 简介
     */
    private String uIntro;

    /**
     * 头像地址
     */
    private String uHeadphotoUrl;

    /**
     * 生肖编码
     */
    private String uChineseZodiac;

    /**
     * 年龄
     */
    private Integer uAge;

    /**
     * 星座编码
     */
    private String uConstellation;

    /**
     * 血型编码
     */
    private String uBloodCode;

    /**
     * 毕业学校编码
     */
    private String uSchoolCode;

    /**
     * 职业编码
     */
    private String uProfession;

    /**
     * 国家编码
     */
    private String uNation;

    /**
     * 省份编码
     */
    private String uProvince;

    /**
     * 城市编码
     */
    private String uCity;

    /**
     * 区编码
     */
    private String uArea;

    /**
     * 好友策略编码
     */
    private String uFrendshipCode;

    /**
     * 用户状态编码
     */
    private String uUserState;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 登陆时间
     */
    private LocalDateTime loginTime;

    /**
     * 登陆次数
     */
    private Integer loginCount;

    /**
     * 上次登陆时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 删除时间
     */
    private LocalDateTime delTime;

    /**
     * 删除人
     */
    private String delerId;

    /**
     * 注册第几人
     */
    private Integer uSort;

    /**
     * 用户是否使用,用户是否使用，0使用，1删除
     */
    private Integer uIsDel;


    @Override
    protected Serializable pkVal() {
        return this.uId;
    }

}
