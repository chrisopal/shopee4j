package com.salesmore.yak.integration.shopee.constants;

public class PathConstants {

    //============================== Shop info==========================================

    public static final String SHOP_PATH = "/shop";

    public static final String SHOP_GET_RELATIVE_PATH = "/shop/get";

    public static final String SHOP_UPDATE_RELATIVE_PATH = "/shop/update";

    public static final String SHOP_PERFORMANCE_RELATIVE_PATH = "/shop/performance";

    public static final String SHOP_CANCEL_AUTH_RELATIVE_PATH = "/shop/cancel_auth_partner";

    public static final String SHOP_AUTH_RELATIVE_PATH = "/shop/auth_partner";

    //public static final String SHOP_AUTH_QUERY_RELATIVE_PATH = "?id=%s&token=%s&redirect=%s";

    public static final String QUERY_PARAM_ID = "id";

    public static final String QUERY_PARAM_TOKEN = "token";

    public static final String QUERY_PARAM_REDIRECT = "redirect";

    //============================== Shop Category==========================================

    public static final String SHOP_CATEGORY_ADD_ITEMS_RELATEIVE_PATH = "/shop_category/add/item";

    public static final String SHOP_CATEGORY_DELETE_RELATEIVE_PATH = "/shop_category/delete";

    public static final String SHOP_CATEGORY_ADD_RELATEIVE_PATH = "/shop_category/add";

    public static final String SHOP_CATEGORY_GET_ITEMS_RELATEIVE_PATH = "/shop_category/get/item";

    public static final String SHOP_CATEGORY_GET_RELATEIVE_PATH = "/shop_categorys/get";

    public static final String SHOP_CATEGORY_UPDATE_RELATEIVE_PATH = "/shop_category/update";

    //============================== Item ===================================================
    public static final String ITEM_ADD_RELATIVE_PATH = "/item/add";

    public static final String ITEM_UPDATE_RELATIVE_PATH = "/item/update";

    public static final String ITEM_GET_LIST_RELATIVE_PATH = "/items/get";

    public static final String ITEM_GET_DETAIL_RELATIVE_PATH = "/item/get";

    public static final String ITEM_DELETE_RELATIVE_PATH = "/item/delete";

    public static final String ITEM_ATTRIBUTES_GET_PATH = "/item/attributes/get";

    public static final String ITEM_CATEGORY_GET_PATH = "/item/categories/get";

    public static final String ITEM_CATEGORY_GET_BY_COUNTRY = "item/categories/get_by_country";

    public static final String ITEM_VARIATIONS_ADD_PATH = "/item/add_variations";

    public static final String ITEM_VARIATIONS_DELETE_RELATIVE_PATH = "/item/delete_variation";

    public static final String ITEM_VARIATIONS_UPDATE_PRICE_PATH = "/items/update_variation_price";

    public static final String ITEM_VARIATIONS_UPDATE_STOCK_PATH = "/items/update_variation_price";

    public static final String ITEM_VARIATIONS_BATCH_UPDATE_PRICE_PATH = "/items/update/vars_price";

    public static final String ITEM_VARIATIONS_BATCH_UPDATE_STOCK_PATH = "/items/update/vars_stock";

    public static final String ITEM_UPDATE_PRICE_RELATIVE_PATH = "/items/update_price";

    public static final String ITEM_UPDATE_STOCK_RELATIVE_PATH = "/items/update_stock";

    public static final String ITEM_BATCH_UPDATE_PRICE_PATH = "/items/update/items_price";

    public static final String ITEM_BATCH_UPDATE_STOCK_PATH = "/items/update/items_stock";

    public static final String ITEM_IMAGE_ADD_RELATIVE_PATH = "/item/img/add";

    public static final String ITEM_IMAGE_DELETE_RELATIVE_PATH = "/item/img/delete";

    //============================== Image ===================================================
    public static final String IMAGE_UPLOAD_RELATIVE_PATH = "/image/upload";

    //============================== Discount ===================================================
    public static final String DISCOUNT_ADD_RELATIVE_PATH = "/discount/add";

    public static final String DISCOUNT_ITEM_ADD_RELATIVE_PATH = "/discount/items/add";

    public static final String DISCOUNT_DELETE_RELATIVE_PATH = "/discount/delete";

    public static final String DISCOUNT_ITEM_DELETE_RELATIVE_PATH = "/discount/item/delete";

    public static final String DISCOUNT_GET_DETAIL_RELATIVE_PATH = "/discount/detail";

    public static final String DISCOUNT_GET_LIST_RELATIVE_PATH = "/discounts/get";

    public static final String DISCOUNT_UPDATE_RELATIVE_PATH = "/discount/update";

    public static final String DISCOUNT_ITEM_UPDATE_RELATIVE_PATH = "/discount/items/update";

    //============================== Order ===================================================

    public static final String ORDER_ADD_NOTE_RELATIVE_PATH = "/orders/note/add";

    public static final String ORDER_CANCEL_RELATIVE_PATH = "/orders/cancel";

    public static final String ORDER_GET_ESCROW_DETAIL_RELATIVE_PATH = "/orders/my_income";

    public static final String ORDER_GET_ORDER_DETAIL_RELATIVE_PATH = "/orders/detail";

    public static final String ORDER_GET_BY_STATUS_RELATIVE_PATH = "/orders/get";

    public static final String ORDER_GET_BASICS_RELATIVE_PATH = "/orders/basics";

    public static final String ORDER_ACCEPT_BUYER_CANCELLATION_RELATIVE_PATH = "/orders/buyer_cancellation/accept";

    public static final String ORDER_REJECT_BUYER_CANCELLATION_RELATIVE_PATH = "/orders/buyer_cancellation/reject";

    //============================== Logistics Service ===================================================
    public static final String LOGISTICS_GET_RELATIVE_PATH = "/logistics/channel/get";

    public static final String LOGISTICS_GET_PARAMETER_INIT_RELATIVE_PATH = "/logistics/init_parameter/get";

    public static final String LOGISTICS_GET_ADDRESS_RELATIVE_PATH = "/logistics/address/get";

    public static final String LOGISTICS_GET_TIMESLOT_RELATIVE_PATH = "/logistics/timeslot/get";

    public static final String LOGISTICS_GET_BRANCH_RELATIVE_PATH = "/logistics/branch/get";

    public static final String LOGISTICS_GET_INFO_RELATIVE_PATH = "/logistics/init_info/get";

    public static final String LOGISTICS_INIT_RELATIVE_PATH = "/logistics/init";

    public static final String LOGISTICS_GET_AIRWAY_BILL_RELATIVE_PATH = "/logistics/airway_bill/get_mass";

    public static final String LOGISTICS_GET_ORDER_LOGISTICS_RELATIVE_PATH = "/logistics/order/get";

    public static final String LOGISTICS_GET_TRACKING_RELATIVE_PATH = "/logistics/tracking";

    //============================== Returns Service ===================================================
    public static final String RETURNS_DISPUTE_RELATIVE_PATH = "/returns/dispute";

    public static final String RETURNS_CONFIRM_RELATIVE_PATH = "/returns/confirm";

    public static final String RETURNS_GET_LIST_RELATIVE_PATH = "/returns/get";

}
