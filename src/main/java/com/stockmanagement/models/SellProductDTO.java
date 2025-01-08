package com.stockmanagement.models;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
public class SellProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -5176740919965898365L;
    private UUID productUuid;
    private Integer quantity;
}
