package com.sa.blockchain.sablockchain.core.block;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import java.util.List;

@Log4j
@Data
@Builder
public class Block {

    private BlockHeader header;
    private List<Transaction> transactionList = Lists.newArrayList();
    private List<BlockHeader> uncleList = Lists.newArrayList();

}
