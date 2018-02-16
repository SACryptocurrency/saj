package com.sa.blockchain.sablockchain.core.block;

import org.junit.Test;

import static org.junit.Assert.*;

public class BlockChainTest {

    @Test
    public void getBestBlock() {
        BlockChain blockChain = new BlockChain();
        blockChain.getBestBlock();
    }
}