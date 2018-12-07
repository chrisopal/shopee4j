package com.salesmore.yak.integration.fyndiq.common;

import com.salesmore.yak.integration.core.model.ModelEntity;

/**
 * Possible Auth Types
 *
 */
public interface Auth extends ModelEntity {

    public enum Type { CREDENTIALS, TOKEN, RAX_APIKEY, TOKENLESS, OAUTH2 }

}
