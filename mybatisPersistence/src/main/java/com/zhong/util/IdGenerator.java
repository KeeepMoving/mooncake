package com.zhong.util;

import java.util.UUID;

public class IdGenerator {

	public IdGenerator () {
		
	}

	public static int intUuid() {
		return Integer.parseInt(stringUuid());
	}

	public static String stringUuid() {
		String uuid = UUID.randomUUID().toString();
		char[] cs = new char[32];
		int j = 0;
		for (int i = uuid.length(); i-- > 0;) {
			if (uuid.charAt(i) != '-') {
				cs[j++] = uuid.charAt(i);
			}
		}
		return new String(cs);
	}
	
}
