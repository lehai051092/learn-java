package com.example.springjwt.config;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
public class JwtUtils {

    public String generateToken(String username) {
        try {
            // Thay thế bằng secret của bạn
            String jwtSecret = "YourSuperSecretKeyThatIsAtLeast32CharactersLong";
            JWSSigner signer = new MACSigner(jwtSecret);
            // 1 hour
            int jwtExpirationInMs = 3600000;
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject(username)
                    .expirationTime(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                    .build();

            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(signer);

            return signedJWT.serialize();
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate JWT token", e);
        }
    }

    public String getUsernameFromJWT(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            return signedJWT.getJWTClaimsSet().getSubject();
        } catch (ParseException e) {
            throw new RuntimeException("Failed to get username from JWT token", e);
        }
    }

    public boolean validateToken(String authToken) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(authToken);
            return !signedJWT.getJWTClaimsSet().getExpirationTime().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
