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
@TableName("t_sys_permission")
public class Permission extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * ID：主键
     */
    @TableId(value = "permission_id", type = IdType.AUTO)
    private Long permissionId;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 权限级别：暂只支持1~3，方便指定父权限,1无父编号
     */
    private Integer level;

    /**
     * 父编号
     */
    private Long parentPermissionId;

    /**
     * -- 是否可用：1 可用 0 不可用
     */
    private Integer available;

    /**
     * 权限字符串：例如：SYS:USER:CREATE
     */
    private String permission;


}
