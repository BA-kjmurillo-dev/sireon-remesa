package com.sireon.remesa.service;

import com.sireon.remesa.persistence.entity.UserEntity;
import com.sireon.remesa.persistence.entity.UserRoleEntity;
import com.sireon.remesa.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSecuriryService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserSecuriryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findById(username).orElseThrow(()-> new UsernameNotFoundException("User " + username + "not found"));

        String[] roles = userEntity.getRole().stream().map(UserRoleEntity::getRole).toArray(String[]::new);
        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                //.roles(roles)
                .authorities(this.grantedAuthorities(roles))
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisabled())
                .build();
    }

    private String[] getAuthorities(String role){
        if ("ADMIN".equals(role) || "CUSTOMER".equals(role)){
            return new String[] {"random_order"};
        }
        return new String[]{};
    }

    private List<GrantedAuthority> grantedAuthorities(String[] roles){
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
        for (String role: roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            for (String authoriry: this.getAuthorities(role)){
                authorities.add(new SimpleGrantedAuthority(authoriry));
            }
        }
        return authorities;
    }
}
