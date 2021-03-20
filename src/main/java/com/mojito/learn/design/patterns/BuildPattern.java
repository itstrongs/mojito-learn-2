package com.mojito.learn.design.patterns;

import lombok.Data;

/**
 * description build模式：主要运用在构造复杂参数的对象时
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-05-20 10:07
 */
@Data
public class BuildPattern {

    public static void main(String[] args) {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .client("okhttp")
                .build();
        System.out.println(retrofit);
    }

    @Data
    public static class Retrofit {

        private String baseUrl;
        private String client;

        public static final class Builder {

            private Retrofit target;

            public Builder() {
                this.target = new Retrofit();
            }

            public Builder baseUrl(String baseUrl) {
                target.setBaseUrl(baseUrl);
                return this;
            }

            public Builder client(String client) {
                target.setClient(client);
                return this;
            }

            public Retrofit build() {
                return target;
            }
        }
    }
}
