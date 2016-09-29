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
		List<String> sList = new ArrayList<>();
		List<String> dList = new ArrayList<>();
		List<String> cList = new ArrayList<>();
		List<String> hList = new ArrayList<>();

		for (int i = 0; i < cardList.length; i++) {
			if(cardList[i].indexOf("S") == 0){
				sList.add(cardList[i].substring(1,2));
			}else if(cardList[i].indexOf("D") == 0){
				dList.add((cardList[i].substring(1,2)));
			}else if(cardList[i].indexOf("C") == 0){
				cList.add((cardList[i].substring(1,2)));
			}else if(cardList[i].indexOf("H") == 0){
				hList.add((cardList[i].substring(1,2)));
			}
		}

		// 文字列を変換
		sList = replaceStr(sList);
		dList = replaceStr(dList);
		cList = replaceStr(cList);
		hList = replaceStr(hList);

		// ソート
		Collections.sort(sList);
		Collections.sort(dList);
		Collections.sort(cList);
		Collections.sort(hList);

		// 数字を変換
		sList = replaceNum(sList);
		dList = replaceNum(dList);
		cList = replaceNum(cList);
		hList = replaceNum(hList);


		//S出力
		if(sList.size() > 0){
			String s = "";
			for (int i = 0; i < sList.size(); i++) {
				s = s + sList.get(i) + ",";
			}
			s = s.substring(0, s.length()-1);
			System.out.println("S:" + s);
		}

		//D出力
		if(dList.size() > 0){
			String s = "";
			for (int i = 0; i < dList.size(); i++) {
				s = s + dList.get(i) + ",";
			}
			s = s.substring(0, s.length()-1);
			System.out.println("D:" + s);
		}

		//C出力
		if(cList.size() > 0){
			String s = "";
			for (int i = 0; i < cList.size(); i++) {
				s = s + cList.get(i) + ",";
			}
			s = s.substring(0, s.length()-1);
			System.out.println("C:" + s);
		}

		//H出力
		if(hList.size() > 0){
			String s = "";
			for (int i = 0; i < hList.size(); i++) {
				s = s + hList.get(i) + ",";
			}
			s = s.substring(0, s.length()-1);
			System.out.println("H:" + s);
		}

	}

	static List<String> replaceStr(List<String> tempList) {
		if(tempList.indexOf("0") > -1){
			int indexNum = tempList.indexOf("0");
			tempList.set(indexNum, "10");
		}

		if(tempList.indexOf("A") > -1){
			int indexNum = tempList.indexOf("A");
			tempList.set(indexNum, "0");
		}

		if(tempList.indexOf("J") > -1){
			int indexNum = tempList.indexOf("J");
			tempList.set(indexNum, "11");
		}

		if(tempList.indexOf("Q") > -1){
			int indexNum = tempList.indexOf("Q");
			tempList.set(indexNum, "12");
		}

		if(tempList.indexOf("K") > -1){
			int indexNum = tempList.indexOf("K");
			tempList.set(indexNum, "13");
		}
		return tempList;
	}

	static List<String> replaceNum(List<String> tempList) {

		if(tempList.indexOf("0") > -1){
			int indexNum = tempList.indexOf("0");
			tempList.set(indexNum, "A");
		}

		if(tempList.indexOf("10") > -1){
			int indexNum = tempList.indexOf("10");
			tempList.set(indexNum, "0");
		}

		if(tempList.indexOf("11") > -1){
			int indexNum = tempList.indexOf("11");
			tempList.set(indexNum, "J");
		}

		if(tempList.indexOf("12") > -1){
			int indexNum = tempList.indexOf("12");
			tempList.set(indexNum, "Q");
		}

		if(tempList.indexOf("13") > -1){
			int indexNum = tempList.indexOf("13");
			tempList.set(indexNum, "K");
		}
		return tempList;
	}
}