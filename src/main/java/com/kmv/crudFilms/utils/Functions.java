package com.kmv.crudFilms.utils;
import java.util.Collection;


public class Functions {

	private Functions() {
	}

	public static boolean calcSizeString(String pStr, int pMaxSize) {
		boolean vSizeOk = false;
		if (pStr != null && (pStr.length() > Constants.STR_LENGTH_0 && pStr.length() <= pMaxSize)) {
			vSizeOk = true;
		}
		return vSizeOk;
	}

	public static boolean isEmpty(Collection<?> coll) {
		return (coll == null || coll.isEmpty());
	}

	public static boolean isNotEmpty(Collection<?> coll) {
		return !isEmpty(coll);
	}
}
