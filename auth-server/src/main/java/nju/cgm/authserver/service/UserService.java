package nju.cgm.authserver.service;

import nju.cgm.utils.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Bright Chan
 * @date: 2020/8/29 19:38
 * @description: UserService
 */

@FeignClient("user-agent")
public interface UserService {

    @PostMapping("/user/info")
    ResultData getUserByUserEmail(@RequestParam("userEmail") String userEmail);
}
