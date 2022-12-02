package com.org.fraud.model;


import com.org.fraud.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class URLParameters {
    private String scheme;
    private String host;
    private Integer port;
    private String path;


}
