package com.freshmarketer.catchhook;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Map;

@Table
@Entity(name = "requests")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Requests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid @NotBlank private String url;

    private String requestMethod;

    @Type(type = "json")
    private Map<String, Object> headers;

    private String queryString;

    @Type(type = "json")
    private Map<String, String[]> formValues;

    private String rawContent;

    @CreatedDate
    private Date createdAt;


}
