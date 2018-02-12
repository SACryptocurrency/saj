package com.sa.blockchain.sablockchain.core.block;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

public class GenesisTest {

    @Test
    public void createGenesisBlock() throws IOException {
        URL url = GenesisTest.class.getClassLoader().getResource("genesis/genesis.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Genesis genesis = objectMapper.readValue(url, Genesis.class);
        System.out.println(genesis);
    }
}