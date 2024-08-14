package com.example.Internship.Controller;

//import com.example.Internship.JWT.JwtToken;
import com.example.Internship.Request.AuthenticationRequest;
import com.example.Internship.Response.AuthenticationResponse;
//import com.example.Internship.Service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private CustomerUserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtToken jwtToken;
//
//    @PostMapping("/login")
//    public AuthenticationResponse createToken(@RequestBody AuthenticationRequest authenticationRequest) {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//        } catch (BadCredentialsException e) {
//            throw new RuntimeException("Invalid credentials");
//        }
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//        String token = jwtToken.generateToken(userDetails);
//
//        return new AuthenticationResponse(token);
//    }
//}
