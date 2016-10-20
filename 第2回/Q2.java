package pgcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] cardList = str.split(" ");
		List<Integer> sList = new ArrayList<>();
		List<Integer> dList = new ArrayList<>();
		List<Integer> cList = new ArrayList<>();
		List<Integer> hList = new ArrayList<>();

		for(String card : cardList){
			char num = card.charAt(1);
			if(card.charAt(0) == 'S'){
				sList.add(Integer.valueOf(replaceStr(num)));
			}else if(card.charAt(0) == 'D'){
				dList.add(Integer.valueOf(replaceStr(num)));
			}else if(card.charAt(0) == 'C'){
				cList.add(Integer.valueOf(replaceStr(num)));
			}else if(card.charAt(0) == 'H'){
				hList.add(Integer.valueOf(replaceStr(num)));
			}
		}

		// ソート
		Collections.sort(sList);
		Collections.sort(dList);
		Collections.sort(cList);
		Collections.sort(hList);

		// 出力
		output(sList, "S");
		output(dList, "D");
		output(cList, "C");
		output(hList, "H");

	}

	static String replaceStr(char c) {
		String res = String.valueOf(c);
		if(c == '0'){
			res = "10";
		}else if(c == 'A'){
			res = "1";
		}else if(c == 'J'){
			res = "11";
		}else if(c == 'Q'){
			res = "12";
		}else if(c == 'K'){
			res = "13";
		}
		return res;
	}

	static String replaceNum(Integer s) {
		String res = "";
		if(s == 10){
			res = "0";
		}else if(s == 1){
			res = "A";
		}else if(s == 11){
			res = "J";
		}else if(s == 12){
			res = "Q";
		}else if(s == 13){
			res = "K";
		}else{
			res = String.valueOf(s);
		}
		return res;
	}

	static void output(List<Integer> cardNoList, String type){
		if(cardNoList.size() > 0){
			StringBuilder sb1 = new StringBuilder();
			for (int i = 0; i < cardNoList.size(); i++) {
				sb1.append(replaceNum(cardNoList.get(i)));
				sb1.append(",");
			}
			String s = sb1.toString();
			StringBuilder sb2 = new StringBuilder();
			sb2.append(type);
			sb2.append(":");
			sb2.append(s);
			String ans = sb2.toString();
			ans = ans.substring(0, ans.length()-1);
			System.out.println(ans);
		}
	}
}