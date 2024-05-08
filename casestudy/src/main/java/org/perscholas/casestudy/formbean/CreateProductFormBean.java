package org.perscholas.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductFormBean {
    private Integer Id;

    private String productName;

    private String productDescription;

    private BigDecimal productMSRP;

    private String imageUrl;

    private String productCategory;
}
