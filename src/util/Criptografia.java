package util;

import java.util.Base64;

public class Criptografia {

	public Criptografia() {

	}

	public static String criptografiaBase64Encoder(String pValor) {
		return new String(Base64.getEncoder().encode(pValor.getBytes()));
	}

	/** Realizando o inverso */
	public static String descriptografiaBase64Decode(String pValor) {
		return new String(Base64.getDecoder().decode(pValor.getBytes()));
	}

}
