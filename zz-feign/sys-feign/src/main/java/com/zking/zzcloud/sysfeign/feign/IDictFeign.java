package com.zking.zzcloud.sysfeign.feign;

import com.zking.zzcloud.sysfeign.dto.DictDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("sys-service")
public interface IDictFeign {


    @RequestMapping(value = "/dict/together", method = RequestMethod.POST)
    String together(DictDTO dictDTO);

    @RequestMapping(value = "/dict/remove", method = RequestMethod.POST)
    String remove(DictDTO dictDTO);

    @RequestMapping(value = "/dict/get", method = RequestMethod.POST)
    String get(DictDTO dictDTO);

    @RequestMapping(value = "/dict/list", method = RequestMethod.POST)
    String list(DictDTO dictDTO);
}
