package com.king.waimai.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.king.waimai.common.R;
import com.king.waimai.pojo.User;
import com.king.waimai.service.UserService;
import com.king.waimai.utils.SMSUtils;
import com.king.waimai.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户登录类
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 发送验证码
     *
     * @param user    用户发送过来的数据
     * @param session 把用户的数据保存到session 中去
     * @return 返回验证码发送成功的信息
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        // 获取用户的手机号 (用户输入的)
        String phone = user.getPhone();
        // 判断用户的手机号是否为空
        if (StringUtils.isNotEmpty(phone)) {
            // 不为空就生成4个随机的验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            // code 打印日志
            log.info("code={}", code);

            // 调用阿里提供的短信服务API 完成发送短信
            SMSUtils.sendMessage("Aniu", "SMS_276457324", phone, code);

            session.setAttribute(phone, code);
            System.out.println(code);
            return R.success("手机验证码发送成功");
        }
        return R.error("短信发送失败");
    }

    /**
     * 用户登录功能的开发
     * @param map 用户数据  code保存
     * @param session 放到域中
     * @return 返回用户登录
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session) {
        // 获取用户的手机号
        String phone = map.get("phone").toString();

        // 获取用户的验证码
        String code = map.get("code").toString();

        // 从session中获取保存验证码
        Object codeInSession = session.getAttribute(phone);

        // 进行验证码的比对 （页面提交的验证码和session 中保存的验证码对比）
        if (codeInSession != null && codeInSession.equals(code)){
            // 这里根据用户的电话查询用户的数据是否存在如果存在
            User user = userService.selectByPhone(phone);
            // 判断用户的电话不等于空 然后再进行插入数据
            if (user == null ){
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                // 插入用户数据
                userService.insert(user);
            }
            session.setAttribute("userId",user.getId());
            return R.success(user);
        }

        // 如果能够比对成功 说明登录成功

        return R.error("登录失败");
    }

}


























