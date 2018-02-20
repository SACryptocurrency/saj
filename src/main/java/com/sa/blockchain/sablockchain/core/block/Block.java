package com.sa.blockchain.sablockchain.core.block;

import com.google.common.collect.Lists;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

public class Block {

    private BlockHeader header;
    private List<Transaction> transactionList;
    private List<BlockHeader> uncleList;

	public Block(BlockHeaderInfo blockHeaderInfo, List<Transaction> transactionsList, List<BlockHeader> uncleList) {
		this.header = new BlockHeader(blockHeaderInfo);
		this.transactionList = isEmpty(transactionsList) ? Lists.newArrayList() : transactionsList;
		this.uncleList = isEmpty(uncleList) ? Lists.newArrayList() : uncleList;
	}

	public long getNumber() {
		return header.getNumber();
	}
}
