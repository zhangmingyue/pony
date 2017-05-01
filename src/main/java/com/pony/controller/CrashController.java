package com.pony.controller;

import com.pony.util.ExeShellCmdUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/1
 */
@Controller
@RequestMapping(value = "/crash")
public class CrashController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String test1() {
        String output = ExeShellCmdUtils.exec("jps");
        return output;
    }

    @RequestMapping(value = "/kill", method = RequestMethod.GET)
    @ResponseBody
    public String test2(HttpServletRequest request,
                        HttpServletResponse response) {
        String param = request.getParameter("param");
        String output = ExeShellCmdUtils.exec("kill -9 " + param);
        return output;
    }
}
