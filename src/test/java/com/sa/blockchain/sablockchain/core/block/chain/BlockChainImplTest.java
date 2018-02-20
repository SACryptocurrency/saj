package com.sa.blockchain.sablockchain.core.block.chain;

import com.sa.blockchain.sablockchain.core.block.genesis.Genesis;
import com.sa.blockchain.sablockchain.core.block.GenesisTest;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

public class BlockChainImplTest {

	private BlockChain blockChain = new BlockChainImpl();

	@Test
	public void getBestBlock() {
	}

	@Test
	public void createNewBlock() throws IOException {
		URL resourceUrl = GenesisTest.class.getClassLoader().getResource("genesis/genesis.json");
		Genesis parent = Genesis.readGenesisBlockFrom(resourceUrl);

		blockChain.createNewBlock(parent, null, null);
	}
}