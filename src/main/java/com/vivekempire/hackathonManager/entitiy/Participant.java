package com.vivekempire.hackathonManager.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.Map;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String college;

    private String email;

    @Column(length = 15)
    private String mobile_number;

    @ManyToOne
    private Hackathon hackathon;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "food_status",columnDefinition = "jsonb")
    private Map<String ,String> food_status;



}
