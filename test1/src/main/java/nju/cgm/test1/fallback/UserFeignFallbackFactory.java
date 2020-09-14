package nju.cgm.test1.fallback;

import feign.hystrix.FallbackFactory;
import nju.cgm.test1.service.UserService;
import nju.cgm.utils.ResponseCode;
import nju.cgm.utils.ResultData;
import org.springframework.stereotype.Component;

/**
 * @author: Bright Chan
 * @date: 2020/9/14 15:18
 * @description: UserFeignFallback, "You also need to declare your implementation as a Spring bean"
 */

@Component
public class UserFeignFallbackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public ResultData getUserByUserEmail(String userEmail) {
                ResultData res = new ResultData();
                res.setResponseCode(ResponseCode.RESPONSE_ERROR);
                res.setDescription("get user info failed!");
                res.setData(throwable.getMessage());
                return res;
            }
        };
    }
}
