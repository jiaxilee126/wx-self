package com.lee.self.core.enums;

/**
 *
 */
public enum SkillLevelEnum {

    JUSTKNOW(1,"了解"),
    NORMAL(2,"一般"),
    PROFICIENCY(3,"熟练"),
    EXECELLENT(4,"精通");
    private Integer key;
    private String value;
    public static  String valueOf(Integer key){
        SkillLevelEnum[] values = SkillLevelEnum.values();
        for(int i=0; i< values.length ;i++){
            if (values[i].key == key)
                return values[i].value;
        }
        return  null;
    }

    private SkillLevelEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }
}
