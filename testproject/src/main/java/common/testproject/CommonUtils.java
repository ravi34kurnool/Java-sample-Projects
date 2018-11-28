package common.testproject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonUtils {
	
	private CommonUtils(){
		// singleton class
	}

	public static <T> boolean isNullOrEmpty(Collection<T> list) {
		if (list != null && list.size() > 0) {
			return false;
		}
		return true;
	}

	public static <T> boolean isNotNullOrEmpty(Collection<T> list) {
		return !isNotNullOrEmpty(list);
	}

	public static <T> boolean isNullOrEmpty(Map<T, T> mapValues) {
		if (mapValues != null && mapValues.size() > 0) {
			return false;
		}
		return true;
	}

	public static <T> boolean isNotNullOrEmpty(Map<T, T> mapValues) {
		return !isNotNullOrEmpty(mapValues);
	}

	public static <T> Set<T> convertListToSet(List<T> list) {
		return new HashSet<T>(list);
	}

	public static <T> List<T> convertSetToList(Set<T> set) {
		return new ArrayList<T>(set);
	}

	public static boolean isAllListObjectsAreNull(List<?> objList) {
		if (isNullOrEmpty(objList)) {
			return true;
		}
		for (Object obj : objList) {
			if (obj != null) {
				if (obj instanceof String) {
					if (((String) obj).length() > 0) {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isStringNotEmpty(String str) {
		if (str != null && str.length() > 0) {
			return true;
		}
		return false;
	}

	public static <T> Iterable<T> emptyIfNull(Iterable<T> iterable) {
		return iterable == null ? Collections.<T> emptyList() : iterable;
	}

}
