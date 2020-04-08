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
@TableName("t_sys_user_role")
public class UserRole extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * ID：主键
     */
    @TableId(value = "urid", type = IdType.AUTO)
    private Long urid;

    /**
     * 用户ID：外键
     */
    private Long userId;

    /**
     * 角色ID：外键
     */
    private Long roleId;


}
