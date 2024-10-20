//package com.example.berryshoes.security;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//  private final JwtUtil jwtUtil;
//  private final UserDetailsService userDetailsService;
//
//  @Override
//  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//          throws ServletException, IOException {
//
//    final String authorizationHeader = request.getHeader("Authorization");
//
//    String username = null;
//    String jwt = null;
//
//    // Kiểm tra xem header có chứa Bearer token hay không
//    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//      jwt = authorizationHeader.substring(7); // Lấy token từ header
//      try {
//        username = jwtUtil.extractUsername(jwt); // Lấy username từ token
//      } catch (Exception e) {
//        log.error("Không thể lấy username từ token: {}", e.getMessage());
//      }
//    }
//
//    // Kiểm tra nếu username chưa được xác thực và token hợp lệ
//    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//      UserDetails userDetails = userDetailsService.loadUserByUsername(username); // Tải thông tin người dùng
//
//      // Xác thực token hợp lệ
//      if (jwtUtil.validateToken(jwt, userDetails.getUsername())) {
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                userDetails, null, userDetails.getAuthorities());
//        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//      }
//    }
//
//    // Tiếp tục chuỗi filter
//    filterChain.doFilter(request, response);
//  }
//}
