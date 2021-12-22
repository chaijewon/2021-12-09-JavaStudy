package com.sist.en;
import java.util.*;
import java.util.stream.Collectors;
enum AreaCode {
	 
	A01("02", "서울특별시"),  A02("031", "경기도"), A03("032", "인천광역시"), A04("033", "강원도"), A05("041", "충청남도"),
	A06("042", "대전광역시"), A07("043", "충청북도"), A08("044", "세종특별자치시"), A09("051", "부산광역시"), A10("052", "울산광역시"),
	A11("053", "대구광역시"), A12("054", "경상북도"), A13("055", "경상남도"), A14("061", "전라남도"), A15("062", "광주광역시"),
	A16("063", "전라북도"), A17("064", "제주특별자치도");
 
	private String areaCode;
	private String sido;
 
	AreaCode(String areaCode, String sido) {
		this.areaCode = areaCode;
		this.sido = sido;
	}
 
	private static final List<Map<String, String>> areaCodes = Arrays.stream(values())
			.map(AreaCode -> {
				Map<String, String> m = new HashMap();
				m.put("cd", AreaCode.name());
				m.put("nm", AreaCode.areaCode);
				return m;
			})
			.collect(Collectors.toList());
	public static List<Map<String, String>> getAreaCodes() {
		return areaCodes;
	}
}
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<Map<String,String>> list=AreaCode.getAreaCodes();
        System.out.println(list.toString());
	}

}
