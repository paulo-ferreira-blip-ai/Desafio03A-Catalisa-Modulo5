package com.api.gerenciadordecontas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
