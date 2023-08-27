package com.licifer.other;

public class StringCompare {
    public static boolean compareVersions(String apiVersionConfig, String apiVersionRequest, int compareDigits) {
        String[] configParts = apiVersionConfig.split("\\.");
        String[] requestParts = apiVersionRequest.split("\\.");

        for (int i = 0; i < compareDigits; i++) {
            int configPart = (i < configParts.length) ? Integer.parseInt(configParts[i]) : 0;
            int requestPart = (i < requestParts.length) ? Integer.parseInt(requestParts[i]) : 0;
            if (requestPart != configPart) return requestPart > configPart;
        }

        return true;
    }

    public static void main(String[] args) {
        String apiVersionConfig = "1.3.3.4.5";
        String apiVersionRequest = "1.1";
        int compareDigits = 3; // 比较的位数
        boolean result = compareVersions(apiVersionConfig, apiVersionRequest, compareDigits);
        System.out.println("比较结果是: " + result); // 输出 true
    }
}
