package com.zking.zzcloud.sysservice.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_sys_role")
public class Role extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * ID：主键
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色名：唯一键
     */
    private String roleName;

    /**
     * 是否可用：1 可用 0 不可用
     */
    private Integer available;

    /**
     * 角色描述
     */
    private String description;


}
