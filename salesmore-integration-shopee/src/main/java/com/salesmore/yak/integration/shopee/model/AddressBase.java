package com.salesmore.yak.integration.shopee.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

@Data
public class AddressBase implements ModelEntity {
	
	private static final long serialVersionUID = 1L;

    /**
     * Name for the address.
     */
    protected String name;

    /**
     * The town of the recipient's address. Whether there is a town will depend on the region and/or country.
     */
    protected String town;

    /**
     * The district of the recipient's address. Whether there is a town will depend on the region and/or country.
     */
    protected String district;

    /**
     * The city of the recipient's address. Whether there is a town will depend on the region and/or country.
     */
    protected String city;

    /**
     * The state/province of the recipient's address. Whether there is a town will depend on the region and/or country.
     */
    protected String state;

    /**
     * The two-digit code representing the country of the Recipient.
     */
    protected String country;

    /**
     * Zip Code
     */
    @JsonProperty("zipcode")
    protected String zipCode;
}
