//package com.liu.SecurityDemo1.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.liu.SecurityDemo1.entity.Users;
//import com.liu.SecurityDemo1.mapper.UsersMapper;
//
////@Service("userDetailsService")
//public class MyUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private UsersMapper usersMapper;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		// DBよりユーザー情報取得
//		QueryWrapper<Users> wrapper = new QueryWrapper<Users>();
//		wrapper.eq("username", username);
//		Users users = usersMapper.selectOne(wrapper);
//
//		if (users == null) {
//			throw new UsernameNotFoundException("存在しないアカウントです");
//		}
//
//		List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(users.getRole());
//		return new User(users.getUsername(), new BCryptPasswordEncoder().encode(users.getPassword()), auths);
//
//	};
//}
