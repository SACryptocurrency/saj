package com.sa.blockchain.sablockchain.core.block;

public class BlockHeader {
    public static final int NONCE_LENGTH = 8;
    public static final int MAX_HEADER_SIZE = 592;
    private byte[] parentHash;
    private byte[] unclesHash;
}
