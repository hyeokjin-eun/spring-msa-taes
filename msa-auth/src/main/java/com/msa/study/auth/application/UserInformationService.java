package com.msa.study.auth.application;

import com.msa.study.auth.domain.User;
import com.msa.study.auth.domain.UserInformation;
import com.msa.study.auth.infra.UserDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserInformationService implements UserDetailsService {

    @Resource
    private UserDao UserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return makeLoginUser(UserDao.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("wrongId")));
    }

    public UserInformation makeLoginUser(User user) {
        UserInformation loginUser = new UserInformation();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        switch(user.getUserType()) {
            case 0:
                grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
            case 1:
                grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
            break;
        }

        loginUser.setUsername(user.getUserName());
        loginUser.setPassword(user.getPassword());
        loginUser.setAuthorities(grantedAuthorities);
        return loginUser;
    }
}
