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
@TableName("t_sys_tree_node")
public class TreeNode extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "tree_node_id", type = IdType.AUTO)
    private Integer treeNodeId;

    /**
     * 节点名
     */
    private String treeNodeName;

    /**
     * 节点类型：1 枝节点 2 叶节点
     */
    private Integer treeNodeType;

    /**
     * 父节点ID
     */
    private Integer parentNodeId;

    /**
     * URL
     */
    private String url;

    /**
     * 位置
     */
    private Integer position;

    /**
     * 图片
     */
    private String icon;


}
