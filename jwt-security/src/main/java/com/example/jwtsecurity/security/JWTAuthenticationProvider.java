package com.example.jwtsecurity.security;

import com.example.jwtsecurity.model.JWTAuthentucationToken;
import com.example.jwtsecurity.model.JWTUser;
import com.example.jwtsecurity.model.JWTUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JWTAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JWTValidator validator ;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        JWTAuthentucationToken jwtAuthentucationToken = (JWTAuthentucationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthentucationToken.getToken();
        JWTUser jwtUser = validator.validate(token);
        if (jwtUser == null) {
            throw new RuntimeException("JWT token is incorrect");
        }
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(jwtUser.getRole());
        return new JWTUserDetails(jwtUser.getUserName() ,jwtUser.getId() , token ,grantedAuthorities );
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (JWTAuthentucationToken.class.isAssignableFrom(aClass));
    }
}
