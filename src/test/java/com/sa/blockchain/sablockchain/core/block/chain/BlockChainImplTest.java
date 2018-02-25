package com.sa.blockchain.sablockchain.core.block.chain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.blockchain.sablockchain.core.block.BlockHeaderInfo;
import com.sa.blockchain.sablockchain.core.block.GenesisTest;
import com.sa.blockchain.sablockchain.core.block.genesis.Genesis;
import com.sa.blockchain.sablockchain.core.block.genesis.GenesisLoader;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

public class BlockChainImplTest {

	private BlockChain blockChain = new BlockChainImpl();

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void getBestBlock() {
	}

	@Test
	public void createNewBlock() throws IOException {
		URL resourceUrl = GenesisTest.class.getClassLoader().getResource("genesis/genesis.json");
		BlockHeaderInfo blockHeaderInfo = objectMapper.readValue(resourceUrl, BlockHeaderInfo.class);

		Genesis parent = GenesisLoader.loadGenesisForm(blockHeaderInfo);

		blockChain.createNewBlock(parent, null, null);
	}
}