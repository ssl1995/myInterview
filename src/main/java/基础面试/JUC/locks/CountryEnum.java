package ssl.JUC.locks;

public enum CountryEnum {

    ONE(1, "齐"),
    TWE(2, "燕"),
    THREE(3, "楚"),
    FOUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "韩");

    private Integer retCode;
    private String retMessage;

    //Enum自带Setter，只用生产getter
    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    //构造器
    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    //获取枚举类中的值
    public static CountryEnum forEach_CountryEnum(Integer codeIndex) {
        // 枚举自带的元素数组，可用于遍历
        CountryEnum[] eles = CountryEnum.values();
        for (CountryEnum ele : eles) {
            if (codeIndex == ele.getRetCode()) {
                return ele;
            }
        }
        return null;
    }
}
