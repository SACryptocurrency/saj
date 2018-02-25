package com.sa.blockchain.sablockchain.core.block;

import com.sa.blockchain.sablockchain.core.block.genesis.Genesis;
import com.sa.blockchain.sablockchain.exceptions.SaException;
import com.sa.blockchain.sablockchain.utils.ByteUtil;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Map;

@Setter
public class BlockHeaderInfo {
	private static final int NONCE_LENGTH = 8;
	private Map<String, Genesis.AllocatedAccount> alloc;
	private byte[] mixhash;
	private byte[] coinbase;
	private long timestamp;
	private byte[] parentHash;
	private byte[] extraData;
	private long gasLimit;
	private byte[] nonce;
	private byte[] difficulty;
	private byte[] logsBlooms;
	private byte[] unclesHash;
	private long number;
	private long gasUsed;

	public void setMixhash(String mixhash) {
		this.mixhash = ByteUtil.hexStringToBytesWithValidation(mixhash, 32, false);
	}

	public void setCoinbase(String coinbase) {
		this.coinbase = ByteUtil.hexStringToBytesWithValidation(coinbase, 20, false);
	}

	public void setTimestamp(String timestamp) {
		byte[] bytesTimeStamp = ByteUtil.hexStringToBytesWithValidation(timestamp, 8, false);
		if (bytesTimeStamp == null || bytesTimeStamp.length == 0) {
			this.timestamp = 0;
		} else {
			this.timestamp = new BigInteger(1, bytesTimeStamp).longValue();
		}
	}

	public void setExtraData(String extraData) {
		this.extraData = ByteUtil.hexStringToBytesWithValidation(extraData, 32, true);
	}

	public void setGasLimit(String gasLimit) {
		byte[] bytesGasLimit = ByteUtil.hexStringToBytesWithValidation(gasLimit, 8, true);
		if (bytesGasLimit == null || bytesGasLimit.length == 0) {
			this.gasLimit = 0;
		} else {
			this.gasLimit = new BigInteger(1, bytesGasLimit).longValue();
		}
	}

	public void setNonce(String nonce) {
		byte[] nonceUnchecked = ByteUtil.hexStringToBytes(nonce);
		if (nonceUnchecked.length > 8) {
			throw new SaException(String.format("Invalid nonce, should be %s length", NONCE_LENGTH));
		} else if (nonceUnchecked.length == 8)  {
			this.nonce = nonceUnchecked;
			return;
		}

		byte[] validNonce = new byte[NONCE_LENGTH];
		int diff = NONCE_LENGTH - nonceUnchecked.length;
		System.arraycopy(nonceUnchecked, 0, validNonce, diff, NONCE_LENGTH - diff);
		this.nonce = validNonce;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = ByteUtil.hexStringToBytesWithValidation(difficulty, 32, true);
	}

	public void setParentHash(String parentHash) {
		this.parentHash = ByteUtil.hexStringToBytesWithValidation(parentHash, 32, false);
	}

	public void setUnclesHash(byte[] unclesHash) {
		this.unclesHash = unclesHash;
	}

	public void setLogsBlooms(byte[] logsBlooms) {
		this.logsBlooms = logsBlooms;
	}

	public long getNumber() {
		return number;
	}
}
