package com.pony.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/13
 */
public class AlipayUtil {

    public static final String GATEWAY_URL_ALIBABA = "https://openapi.alipaydev.com/gateway.do";
    public static final String APP_ID = "2017030906130605";
    public static final String FORMAT = "json";
    public static final String CHARSET = "UTF-8";
    public static final String APP_PRIVATE_KEY =
            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCb3duYHq9MVJBB" +
                    "wLDHckQzQs2uY7Kpqi/zENaVKn8xjH10ogtWF0mCEIxCFxHE7qoj5VB2GjHCTzud" +
                    "xMR0SYzW5jBY4WO8WMCIg+iBLoJTVM6T1/cGlKoJ3ZhfEETk7iCbk5sxi9pp2yNp" +
                    "Ra1a+DFYHR5hC4RsFNZ/CPFuF/Yfz/nVzi7HYV1B0D+0Qvdp7KLmu9jOxOgyyWYS" +
                    "+HZh2DWu0yjmBdF2iWZymF+7ZXovUxVv++AizwpwCfe0EdWA4RrWzjCX6q+k+DMy" +
                    "urt98wVzXqxFs1MfAu9oGL0KzfU2Vh+67SpI4BQLsF0Q0lIKLmZvAFfRVDnLxbWg" +
                    "coa1tNiRAgMBAAECggEAboxSPXg1+LtZfWk/eJYQzRKqcu9/PlrYm1rr9uwnPmtY" +
                    "Z6quw6bMmhVGhXF7RuPHhKIWCU3W0OwFaoaul5O68ohc7g0eAe4o0CpOc6EbCiNy" +
                    "SOW57M7wMwMaGQKe+ofyVKXCQsfgZ4fne7jRlV3HEanFbCsRBt9Yqs0a/2y7Qh/P" +
                    "98xOqNa4YpvC8GUzOwrwLcbRcawf5cvrmvZtMMS64PLy7fzPuAwGnCZuqJQX0Hy3" +
                    "zyL7L/mU5+Yu4wUb0veY0mM9waSATA84kXQHiKMtQP9UuIUgMCPaDbD7NhPfoMXE" +
                    "5HTSsssDa5szKU/LxLOvDsu/fD6OXv8uBO9xI0TogQKBgQDl6HI851ijRdBK8lrd" +
                    "kSJ+gxe2VywcGKCFsvsvcabyuntqhB9CfLYRmn6P2vMznW1JvfDvQg6SCK9x0V7i" +
                    "MyG9x4z4RgNr1FJNBPJEnn+dhEKXpSeZ6rp4EXOPjhBqmX496STikAMopL9tDEha" +
                    "vzaT97NjBVq9ZuBwe4uEnD12SQKBgQCtjkapSnbvnsSWb1v99JoCxHf6z3dNj+Zy" +
                    "vNWzBaOcQUXHYzZ8LfYDm4BhIE6sR4V064PGHMS3nyv1S7or7nW1DwMYMf3QHwiX" +
                    "GSuxdUMbEf2z5OJA5vq+PqB1UkWDL1t6+JQsOxK0ZpXUAPQqtUyNC/dCAxftk2zs" +
                    "6cmp7m4wCQKBgBVx3h4CMklgfLJQ8trR69bDIZYXgXzJa0etTzK4tirT7CkeU9Ae" +
                    "09jGgWGnuaGp4ITNW8jlb3h9qOfD8MbGoDIUh/ishysqrdaTTInMAvlNWezNMelw" +
                    "dJ44en/8b1mSIa1irtcXOcQzwctJJwKX7V5V73ygBju+edbkHzpqXG1JAoGAWfOm" +
                    "vfFhSXpha5LV+/69n/eSM8U5kVKm3wruO3YNwVu3Pcs3Hw93NZFv7WcgP3xmOB4k" +
                    "0xZwAreVwfH40PIrwabBNNYcNbUP77hVBAnBuRMPCiDz/y14AghVg9kbPA3cfRS/" +
                    "P1lyrVuKBjJkWopS3bu48FbIHRNO3k+hfNid9XkCgYEAy5VthfPFagbuNLvRcjP6" +
                    "s1fnIdvxqctO2EJB4xgg9xh7GjNmm0odC5UpkOtxb5vMBWcVY16lcejEjleUfVBT" +
                    "t9vc6jPUky5bi+SbW1phQ9uVXBDJ6kM9Khi4kqofKPQiSeJjfMPVWPK8p4Ski+Lc" +
                    "vpy3DrIbd5DsuScRTz561eI=";

    public static final String ALIPAY_PUBLIC_KEY =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm93bmB6vTFSQQcCwx3JE" +
                    "M0LNrmOyqaov8xDWlSp/MYx9dKILVhdJghCMQhcRxO6qI+VQdhoxwk87ncTEdEmM" +
                    "1uYwWOFjvFjAiIPogS6CU1TOk9f3BpSqCd2YXxBE5O4gm5ObMYvaadsjaUWtWvgx" +
                    "WB0eYQuEbBTWfwjxbhf2H8/51c4ux2FdQdA/tEL3aeyi5rvYzsToMslmEvh2Ydg1" +
                    "rtMo5gXRdolmcphfu2V6L1MVb/vgIs8KcAn3tBHVgOEa1s4wl+qvpPgzMrq7ffMF" +
                    "c16sRbNTHwLvaBi9Cs31NlYfuu0qSOAUC7BdENJSCi5mbwBX0VQ5y8W1oHKGtbTY" +
                    "kQIDAQAB";
    public static final String SIGN_TYPE = "RSA2";

    private static AlipayClient alipayClient = null;

    public static AlipayClient getAlipayClient() throws AlipayApiException {
        //实例化客户端
        if (alipayClient == null) {
            synchronized (AlipayUtil.class) {
                if (null == alipayClient) {
                    alipayClient = new DefaultAlipayClient(GATEWAY_URL_ALIBABA, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
                }
            }
        }
        return alipayClient;
    }
}
