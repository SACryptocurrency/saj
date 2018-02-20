package com.sa.blockchain.sablockchain.core.block.genesis;

import com.sa.blockchain.sablockchain.core.block.BlockHeaderInfo;

import static com.sa.blockchain.sablockchain.utils.HashUtil.EMPTY_LIST_HASH;

public class GenesisLoader {

	public static Genesis loadGenesisForm(BlockHeaderInfo blockHeaderInfo) {
		blockHeaderInfo.setUnclesHash(EMPTY_LIST_HASH);
		return new Genesis(blockHeaderInfo);
	}
}
