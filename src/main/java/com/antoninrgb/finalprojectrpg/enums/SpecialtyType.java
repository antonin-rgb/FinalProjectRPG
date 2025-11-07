package com.antoninrgb.finalprojectrpg.enums;

public enum SpecialtyType {
    NORMAL_DMG, /*flat amount + varying range bonus*/
    MAGIC_DMG, /*% of your magic power*/
    BLEED_DMG, /*flat amount + % max health bonus*/
    ATK_BUFF,
    MAGIC_BUFF,
    HP_BUFF,
    HP_DEBUFF,
    STEALTH_ATK, /* % chance of executing enemies immediately*/
    DODGE /* % chance of avoiding damage*/
}
