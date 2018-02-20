package com.sa.blockchain.sablockchain.utils;

import com.sa.blockchain.sablockchain.exceptions.SaException;
import org.springframework.util.StringUtils;

import java.math.BigInteger;

public interface ByteUtil {

	static byte[] hexStringToBytesWithValidation(String hexString, int bytes, boolean notGreater) {
		byte[] ret = hexStringToBytes(hexString);
		if (notGreater) {
			if (ret.length > bytes) {
				throw new SaException(String.format(
					"Wrong value length: %s, expected length < %d bytes", hexString, bytes
				));
			}
		} else {
			if (ret.length != bytes) {
				throw new SaException(String.format(
					"Wrong value length: %s, expected length %d bytes", hexString, bytes
				));
			}
		}

		return ret;
	}

	static byte[] hexStringToBytes(String hexString) {
		if (StringUtils.isEmpty(hexString)) {
			return new byte[0];
		}

		if (hexString.startsWith("0x")) {
			hexString = hexString.substring(2);
		}

		if (hexString.length() % 2 == 1) {
			hexString = "0" + hexString;
		}

		return new BigInteger(hexString, 16).toByteArray();
	}
}
