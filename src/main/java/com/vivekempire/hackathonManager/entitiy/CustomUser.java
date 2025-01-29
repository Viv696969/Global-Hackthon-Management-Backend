package com.vivekempire.hackathonManager.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
    private UUID id;  // Use UUID type here instead of String

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String hashed_password;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private LocalDateTime last_logined_at;

    @PrePersist
    private void prePersist() {
        if (this.id == null) {
            this.id = UUID.randomUUID();  // Manually set UUID before insert
        }
    }

}
