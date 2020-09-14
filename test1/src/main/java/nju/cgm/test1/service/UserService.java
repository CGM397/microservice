package nju.cgm.test1.service;

import nju.cgm.test1.fallback.UserFeignFallbackFactory;
import nju.cgm.utils.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Bright Chan
 * @date: 2020/9/12 11:11
 * @description: UserService
 */

@FeignClient(value = "user-agent", fallbackFactory = UserFeignFallbackFactory.class)
public interface UserService {

    @PostMapping("/user/info")
    ResultData getUserByUserEmail(@RequestParam("userEmail") String userEmail);
}
