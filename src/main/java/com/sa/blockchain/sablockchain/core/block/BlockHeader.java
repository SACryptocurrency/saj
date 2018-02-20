package com.sa.blockchain.sablockchain.core.block;

import com.sa.blockchain.sablockchain.utils.HashUtil;
import lombok.Getter;

@Getter
public class BlockHeader {
	public static final int NONCE_LENGTH = 8;
	public static final int MAX_HEADER_SIZE = 592;

	private final byte[] stateRoot;
	private BlockHeaderInfo blockHeaderInfo;

	public BlockHeader(BlockHeaderInfo blockHeaderInfo) {
		this.blockHeaderInfo = blockHeaderInfo;
		this.stateRoot = HashUtil.EMPTY_TRIE_HASH;

	}

	public long getNumber() {
		return blockHeaderInfo.getNumber();
	}
}
