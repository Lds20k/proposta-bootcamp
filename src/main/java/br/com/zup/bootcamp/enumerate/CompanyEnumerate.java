package br.com.zup.bootcamp.enumerate;

public enum CompanyEnumerate {
    PAYPAL("paypal"),
    SAMSUNGPAY("samsungpay"),
    NONE("none");

    CompanyEnumerate(String company) {
    }

    public static CompanyEnumerate define(String company){
        if(company.equals(PAYPAL.toString().toLowerCase()))
            return PAYPAL;
        if(company.equals(SAMSUNGPAY.toString().toLowerCase()))
            return SAMSUNGPAY;
        return NONE;
    }
}
