package com.sa.blockchain.sablockchain.utils;

import com.sa.blockchain.sablockchain.exceptions.SaException;
import lombok.extern.log4j.Log4j;
import org.spongycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

import static com.sun.tools.hat.internal.model.Snapshot.EMPTY_BYTE_ARRAY;

@Log4j
public class HashUtil {

	private HashUtil() {}

	private static final String HASH_256_ALGORITHM_NAME = "ETH-KECCAK-256";
	private static final String CRYPTO_PROVIDER_NAME = "SC";
	private static final Provider CRYPTO_PROVIDER;

	public static final byte[] EMPTY_LIST_HASH;
	public static final byte[] EMPTY_TRIE_HASH;
	public static final byte[] ZERO_HASH_2048 = new byte[256];

	static {
		Provider p = Security.getProvider(CRYPTO_PROVIDER_NAME);
		p = (p != null) ? p : new BouncyCastleProvider();
		p.put("MessageDigest.ETH-KECCAK-256", "org.ethereum.crypto.cryptohash.Keccak256");
		p.put("MessageDigest.ETH-KECCAK-512", "org.ethereum.crypto.cryptohash.Keccak512");

		Security.addProvider(p);
		CRYPTO_PROVIDER = Security.getProvider(CRYPTO_PROVIDER_NAME);
		EMPTY_LIST_HASH = sha3(RLP.encodeList());
		EMPTY_TRIE_HASH = sha3(RLP.encodeElement(EMPTY_BYTE_ARRAY));
	}

	public static byte[] sha3(byte[] input) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance(HASH_256_ALGORITHM_NAME, CRYPTO_PROVIDER);
			digest.update(input);
			return digest.digest();
		} catch (NoSuchAlgorithmException e) {
			log.error("Can't find such algorithm", e);
			throw new SaException(e);
		}

	}

}
