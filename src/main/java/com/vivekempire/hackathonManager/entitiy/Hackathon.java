package com.vivekempire.hackathonManager.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hackathon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String hackathon_name;

    @Column(nullable = false)
    private String poster_image_name;

    @Column(nullable = false)
    private String poster_image_path;

    @Column(nullable = false)
    private int participants_number;

    @Column(nullable = false)
    private int no_of_days;

    @Column()
    private Date date;
    @Column(nullable = false)
    private String location;


    @ManyToOne
    private CustomUser organizer;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "food",columnDefinition = "text[]")
    private List<String> food;
}





