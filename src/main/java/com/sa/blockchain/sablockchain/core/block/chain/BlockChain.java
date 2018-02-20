package com.sa.blockchain.sablockchain.core.block.chain;

import com.sa.blockchain.sablockchain.core.block.Block;
import com.sa.blockchain.sablockchain.core.block.BlockHeader;
import com.sa.blockchain.sablockchain.core.block.Transaction;

import java.util.List;

public interface BlockChain {

    Block getBestBlock();

    Block createNewBlock(Block parent, List<Transaction> transactions, List<BlockHeader> uncles);
}
