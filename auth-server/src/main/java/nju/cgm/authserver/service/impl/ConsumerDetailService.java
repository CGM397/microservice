package nju.cgm.authserver.service.impl;

import nju.cgm.authserver.service.UserService;
import nju.cgm.model.user.User;
import nju.cgm.utils.ResponseCode;
import nju.cgm.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/8/29 19:33
 * @description: ConsumerDetailService
 */

@Service
public class ConsumerDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        ResultData response = userService.getUserByUserEmail(userEmail);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            User user = (User) response.getData();
            return new org.springframework.security.core.userdetails.User
                    (user.getUserEmail(), user.getUserPassword(), grantedAuthorities);
        }
        else {
            throw new UsernameNotFoundException("user not exists");
        }
    }
}
