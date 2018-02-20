package com.sa.blockchain.sablockchain.core.block;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.blockchain.sablockchain.core.block.genesis.Genesis;
import com.sa.blockchain.sablockchain.core.block.genesis.GenesisLoader;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class GenesisTest {

    private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void createGenesisBlock() throws IOException {
		URL resourceUrl = GenesisTest.class.getClassLoader().getResource("genesis/genesis.json");
		BlockHeaderInfo headerInfo = objectMapper.readValue(resourceUrl, BlockHeaderInfo.class);

		Genesis genesis = GenesisLoader.loadGenesisForm(headerInfo);
		assertThat(genesis.getNumber()).isEqualTo(0);
	}
}