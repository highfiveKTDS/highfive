package com.ktds.shoppingbell.vo;

/**
 * Created by 206-021 on 2015-07-30.
 */
public class AlarmVO {
    private String settingOptionContent;
    private String tvSettingSelection;

    public AlarmVO(String optionContent
                    ,String settingSelection) {
        setSettingOptionContent(optionContent);
        setSettingSelection(settingSelection);

    }

    public String getSettingSelection() {
        return tvSettingSelection;
    }

    public void setSettingSelection(String tvSettingSelection) {
        this.tvSettingSelection = tvSettingSelection;
    }

    public String getSettingOptionContent() {

        return settingOptionContent;
    }

    public void setSettingOptionContent(String settingOptionContent) {
        this.settingOptionContent = settingOptionContent;
    }
}
