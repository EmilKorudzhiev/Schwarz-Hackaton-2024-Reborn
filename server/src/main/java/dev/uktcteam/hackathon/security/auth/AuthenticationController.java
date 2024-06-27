package dev.uktcteam.hackathon.security.auth;

import dev.uktcteam.hackathon.security.auth.requests.AuthenticationRequest;
import dev.uktcteam.hackathon.security.auth.requests.RegisterRequest;
import dev.uktcteam.hackathon.security.auth.responses.AuthenticationResponse;
import dev.uktcteam.hackathon.security.auth.responses.RefreshTokenResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080/api/v1/auth/authenticate")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

//    @PostMapping("/registerWithRole")
//    public ResponseEntity<AuthenticationResponse> registerWithRole(
//            @RequestBody RegisterRequest requestWithRole
//    ) {
//        return ResponseEntity.ok(authenticationService.registerWithRole(requestWithRole));
//    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<RefreshTokenResponse> refresh(
            HttpServletRequest request
    ) {
        return ResponseEntity.ok(authenticationService.refreshToken(request));
    }

}
