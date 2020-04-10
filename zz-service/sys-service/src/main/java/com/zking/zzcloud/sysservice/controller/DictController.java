package com.zking.zzcloud.sysservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zking.zzcloud.common.util.JsonData;
import com.zking.zzcloud.common.util.RestResponse;
import com.zking.zzcloud.sysfeign.dto.DictDTO;
import com.zking.zzcloud.sysservice.model.Dict;
import com.zking.zzcloud.sysservice.service.IDictService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 凌
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/dict")
@Slf4j
public class DictController {

    @Autowired
    private IDictService dictService;
    @Autowired
    private MapperFactory mapperFactory;





    @RequestMapping("/together")
    public JsonData together(@RequestBody DictDTO dictDTO) {
        JsonData jsonData = new JsonData();
        System.out.println("1111111111111");
        if (dictDTO.getDictId() == null ) {
            System.out.println("222222222");
            log.info("together1={}", dictDTO);
            MapperFacade mapper = mapperFactory.getMapperFacade();
            Dict dict = mapper.map(dictDTO, Dict.class);
            dictService.save(dict);
            jsonData.put("coce", 0);
            jsonData.put("message", "新增成功");
            jsonData.put("ts", System.currentTimeMillis());
            return jsonData;
        }else{
            System.out.println("33333333");
            log.info("together2={}", dictDTO);
            UpdateWrapper<Dict> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("dict_id", dictDTO.getDictId());
            updateWrapper.set("dict_name", dictDTO.getDictName());
            updateWrapper.set("dict_text", dictDTO.getDictText());
            updateWrapper.set("dict_value", dictDTO.getDictValue());
            updateWrapper.set("editable", dictDTO.getEditable());
            dictService.update(updateWrapper);
            jsonData.put("coce", 0);
            jsonData.put("message", "修改成功");
            jsonData.put("ts", System.currentTimeMillis());
            return jsonData;

        }
    }


    @RequestMapping("/remove")
    public JsonData delete(@RequestBody DictDTO dictDTO) {
        JsonData jsonData = new JsonData();
        log.info("DictDTO={}", dictDTO);
        dictService.removeById(dictDTO.getDictId());
        jsonData.put("coce", 0);
        jsonData.put("message", "删除成功");
        jsonData.put("ts", System.currentTimeMillis());
        return jsonData;
    }


    @RequestMapping("/get")
    public RestResponse get(@RequestBody DictDTO dictDTO) {
        log.info("DictDTO={}", dictDTO);
        Dict byId = dictService.getById(dictDTO.getDictId());
        return RestResponse.succuess(byId);
    }

    @RequestMapping("/list")
    public JsonData list(@RequestBody DictDTO dictDTO) {
        JsonData jsonData = new JsonData();
        log.info("DictDTO={}", dictDTO);
        Page<Dict> page = new Page<>(dictDTO.getPageNum(), dictDTO.getRows());

        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(dictDTO.getDictName())) {
            queryWrapper.like("dict_name", dictDTO.getDictName());
        }
        queryWrapper.orderByDesc("dict_name");
        jsonData.put("coce", 0);
        jsonData.put("message", "查询成功");
        jsonData.put("ts", System.currentTimeMillis());
        Page<Dict> page1 = dictService.page(page, queryWrapper);

        jsonData.setResult(page1.getRecords());
        return jsonData;
    }

}
