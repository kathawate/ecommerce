package com.kathawate.ecommerce.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.kathawate.ecommerce.entity.User;
import com.kathawate.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> authenticate(String token) {

        try {
            // ✅ Verify Firebase token
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);

            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();

            // ✅ Fetch or create user
            User user = findOrCreateUser(email, uid);

            return ResponseEntity.ok(user);

        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid Firebase Token");
        }
    }

    // 🔥 Business logic separated
    private User findOrCreateUser(String email, String uid) {

        Optional<User> existingUser = userRepository.findByEmail(email);

        if (existingUser.isPresent()) {
            return existingUser.get();
        }

        User user = new User();
        user.setEmail(email);
        user.setFirebaseUid(uid);
        user.setProvider("FIREBASE");

        return userRepository.save(user);
    }


}
