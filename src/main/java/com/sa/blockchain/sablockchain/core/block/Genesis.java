package com.sa.blockchain.sablockchain.core.block;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Genesis {
    private Map<String, AllocatedAccount> alloc;
    private String mixhash;
    private String coinbase;
    private String timestamp;
    private String parentHash;
    private String extraData;
    private String gasLimit;
    private String nonce;
    private String difficulty;

    public static class AllocatedAccount {
        public Map<String, String> storage;
        public String nonce;
        public String code;
        public String balance;
    }
}
