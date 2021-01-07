package atguigu.session2.countDownLatchs;

public enum CountryEnum {
    ONE(1, "齐"), TWE(2, "燕"), THREE(3, "楚"), FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");

    private Integer retCode;
    private String retMessage;

    //获取枚举类中的值
    public static CountryEnum forEach_CountryEnum(Integer index) {
        //enum自带的元素数组，可用于遍历
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum value : values) {
            if (index == value.getRetCode()) {
                return value;
            }
        }
        return null;
    }
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

}
