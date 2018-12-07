package com.salesmore.yak.integration.fyndiq.model.articles;

public enum Tag {

    iPhone_Accessories("iPhone Accessories"),
    Android_Accessories("Android Accessories"),
    Headphones_Speakers("Headphones & Speakers"),
    Women_Fashion("Women's Fashion"),
    Makeup("MakeUp"),
    Hair_Nails("Hair & Nails"),
    Shoes("Shoes"),
    Men_Fashion("Men's Fashion"),
    Toys("Toys"),
    Game_Computer("Gaming & Computers"),
    Gadgets_Electronics("Gadgets & Electronics"),
    Jewellery_Watches("Jewellery & Watches"),
    Bags_Wallets("Bags & Wallets"),
    Health_Wellness("Health & Wellness"),
    Home_Garden("Home & Garden"),
    Interior_Decorations("Interior Decorations"),
    Holidays_Celebrations("Holidays & Celebrations"),
    Parents_Toddlers("Parents With Toddlers"),
    Travel_Sports("Travel & Sports"),
    Pets_Hobbies("Pets & Hobbies"),
    TV_Books("TV & Books"),
    Business_Education("Business & Education");

    private String value;

    public String value() {
        return value;
    }

    Tag(String t) {
        this.value = t;
    }

    public static Tag from(String tag ) {

        for(Tag t : Tag.values()){
            if(t.value.equals(tag)){
                return t;
            }
        }
        return null;

    }
}
