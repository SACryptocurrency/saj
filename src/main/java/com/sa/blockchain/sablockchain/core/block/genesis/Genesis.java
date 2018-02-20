package com.sa.blockchain.sablockchain.core.block.genesis;

import com.sa.blockchain.sablockchain.core.block.Block;
import com.sa.blockchain.sablockchain.core.block.BlockHeaderInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Genesis extends Block {
	private Map<String, AllocatedAccount> alloc;
	private String mixhash;
	private String coinbase;
	private String timestamp;
	private String parentHash;
	private String extraData;
	private String gasLimit;
	private String nonce;
	private String difficulty;

	public Genesis(BlockHeaderInfo blockHeaderInfo) {
		super(blockHeaderInfo, null, null);
	}

	public static class AllocatedAccount {
		public Map<String, String> storage;
		public String nonce;
		public String code;
		public String balance;
	}
}
