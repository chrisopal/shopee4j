package com.salesmore.yak.integration.fyndiq.constants;

public class ClientConstants {


    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String USER_AGENT = "Fyndiq4j / Fyndiq Java Client";

    public static final String HEADER_CONTENT_TYPE = "Content-Type";

    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_STREAM = "application/stream";
    public static final String CONTENT_TYPE_DIRECTORY = "application/directory";
    public static final String CONTENT_TYPE_OCTECT_STREAM = "application/octet-stream";
    public static final String CONTENT_TYPE_TEXT = "text/plain";
    public static final String CONTENT_TYPE_TEXT_HTML = "text/html";
    public static final String CONTENT_TYPE_ARTIFACT_PATCH = "application/json-patch+json";


    // Paths
    public static final String URI_SEP = "/";
    public static final String ARTICLES_RELATIVE_PATH = "/articles";
    public static final String ARTICLES_PATH = "/articles/%s";
    public static final String ARTICLES_PRICE_PATH = "/articles/%s/price";
    public static final String ARTICLES_QUANTITY_PATH = "/articles/%s/quantity";
    public static final String BULK_RELATIVE_PATH = "/bulk";
    public static final String ARTICLES_BULK_ACTION_PATH = ARTICLES_RELATIVE_PATH + BULK_RELATIVE_PATH;

    public static final String SALES_FUNNEL_PATH = "/sales-funnels/products/%s";
    public static final String ORDERS_PATH = "/orders";
    public static final String GET_ORDER_PATH = "/orders/%s";
    public static final String FULFILL_ORDER_PATH = "/orders/%s/fulfill";
    public static final String CANCEL_ORDER_PATH = "/orders/%s/cancel";
}
