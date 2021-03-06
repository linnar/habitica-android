package com.magicmicky.habitrpgwrapper.lib.models;

import com.google.gson.annotations.SerializedName;

public class ShopItem {

    public String key;
    public String text;
    public String notes;
    @SerializedName("class") public String imageName;
    public Integer value;
    public Boolean locked;
    public String currency;
    public String purchaseType;
    public String categoryIdentifier;
    public ShopItemUnlockCondition unlockCondition;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getImageName() {
        if (imageName != null) {
            return imageName;
        } else {
            return "shop_"+key;
        }
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Boolean getLocked() {
        if (locked == null) {
            return false;
        }
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public ShopItemUnlockCondition getUnlockCondition() {
        return unlockCondition;
    }

    public void setUnlockCondition(ShopItemUnlockCondition unlockCondition) {
        this.unlockCondition = unlockCondition;
    }

    public boolean canBuy(HabitRPGUser user) {
        if (getCurrency().equals("gold")) {
            return getValue() <= user.getStats().getGp();
        } else if (getCurrency().equals("gems")) {
            return getValue() <= (user.getBalance()*4);
        } else {
            return false;
        }
    }
}
