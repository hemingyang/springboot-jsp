package cn.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags ="MainController",description = "入口页面" )
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
    String home() {
        log.info("# 进入默认首页");
        return "index";
    }

    @RequestMapping(value = "leftnav", method = RequestMethod.GET)
    String leftnav() {
        return "leftnav";
    }

    @RequestMapping(value = "topnav", method = RequestMethod.GET)
    String topnav() {
        return "topnav";
    }

}
