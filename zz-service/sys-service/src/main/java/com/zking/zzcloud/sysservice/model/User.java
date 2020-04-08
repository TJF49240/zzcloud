package com.zking.zzcloud.sysservice.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 凌
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_sys_user")
public class User extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * ID：主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 帐号：唯一键
     */
    private String username;

    /**
     * 密码：MD5+盐加密
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 是否锁定：INSERT=FALSE，1 TRUE 0 FALSE 锁定的帐号无法登陆系统
     */
    private Integer locked;

    /**
     * 创建日期时间：insert=false，update=false
     */
    private LocalDateTime createDatetime;


}
