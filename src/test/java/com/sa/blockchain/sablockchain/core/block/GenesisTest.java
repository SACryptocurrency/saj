package com.sa.blockchain.sablockchain.core.block;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;


public class GenesisTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void createGenesisBlock() throws IOException {
        URL url = GenesisTest.class.getClassLoader().getResource("genesis/genesis.json");
        Genesis genesis = objectMapper.readValue(url, Genesis.class);
        assertThat(genesis).isNotNull();
    }
}