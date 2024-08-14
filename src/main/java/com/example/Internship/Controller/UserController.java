package com.example.Internship.Controller;

import com.example.Internship.Entity.Token;
import com.example.Internship.Entity.User;
//import com.example.Internship.JWT.JwtToken;
import com.example.Internship.Repository.UserRepository;
import com.example.Internship.Request.AuthenticationRequest;
import com.example.Internship.Request.LoginRequest;
import com.example.Internship.Response.AuthenticationResponse;
//import com.example.Internship.Service.CustomerUserDetailsService;
import com.example.Internship.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// This is for REST API and HTTP request.

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService; // TokenService sınıfını ekleyin

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Token token = tokenService.generateToken(user.getId()); // Token oluşturma
            Map<String, Object> response = new HashMap<>();
            response.put("token", token.getToken());
            response.put("userId", user.getId());
            return ResponseEntity.ok(response); // Token'ı döndür
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private CustomerUserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtToken jwtToken;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        User savedUser = userRepository.save(user);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> createToken(@RequestBody AuthenticationRequest authenticationRequest) {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//        } catch (BadCredentialsException e) {
//            throw new RuntimeException("Invalid credentials");
//        }
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//        String token = jwtToken.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthenticationResponse(token));
//    }
//
//    @GetMapping("/{id}/lands")
//    public String getUserLands(@PathVariable Long id) {
//        return "Lands";
//    }


//    @GetMapping("/user-data")
//    public UserData getUserData() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//        // I can get user data from here with username
//        return userService.getUserDataByUsername(username);
//    }

//    ----------------------------------------------------------------------------------------------

//    @GetMapping("/data")
//    public ResponseEntity<Map<String, Object>> getData() {
//        Map<String, Object> data = new HashMap<>();
//        data.put("speed", "100");
//        data.put("weight", "80");
//        data.put("battery", "100");
//        data.put("temperature", "25");
//        data.put("voltage", "5");
//        data.put("current", "2");
//        data.put("qr_estimated", "qr_estimated");
//        data.put("qr_now", "qr_now");
//        data.put("qr_last", "qr_last");
//        data.put("vehicle", "walking");
//        data.put("time", "0");
//        data.put("direction", "straight");
//        data.put("count_of_qr", "count_of_qr");
//        return ResponseEntity.ok(data);
//    }
//
//    @PostMapping("/data")
//    public ResponseEntity<Map<String, String>> postData(@RequestBody Map<String, Object> payload) {
//        System.out.println("Alınan veri: " + payload);
//        Map<String, String> response = new HashMap<>();
//        response.put("durum", "başarılı");
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello";
//    }


/*
* const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async () => {
      try {
        const response = await axios.post('http://192.168.125.44:8080/api/users/login', {
          username,
          password
        });
        if (response.status == 200) {
          Alert.alert('Başarılı', 'Giriş Başarılı');
          setScreen('MyLandScreen');
        }
      } catch (error) {
        Alert.alert('Hata', 'Giriş Hatalı');
        console.error(error);
      }
    }
* */
