package oj;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
	public List<String> removeComments(String[] source) {
		if (source == null || source.length == 0)
			return new ArrayList<>();
		List<String> res = new ArrayList<>();
		boolean comment = false;
		String tmpline = "";
		String line = null;
		boolean iscontinue = false;
		for (int i = 0; i < source.length; i++) {
			// 没有未处理的残留
			if (!iscontinue)
				line = tmpline + source[i];
			int c1 = line.indexOf("//");
			int c2 = line.indexOf("/*");
			int c3 = line.indexOf("*/");
//			System.out.println("tmpline:  " + tmpline);
//			System.out.println("line:  " + line);
//			System.out.println("c1:   " + c1);
//			System.out.println("c2:   " + c2);
//			System.out.println("c3:   " + c3);
//			System.out.println("comment:   " + comment);
//			System.out.println();
//			System.out.println();
			// 非注释状态
			if (!comment) {
				// 最简单的情况 不存在/* 或者 /*在 //之后
				if (c2 == -1 || (c1 != -1 && c2 > c1)) {
					tmpline=tmpline + line.split("//", -1)[0];
					if(tmpline.length()>0)
					res.add(tmpline);
					tmpline = "";
					iscontinue = false;
					// 存在/*
				}
				if (c2 != -1 && (c1 == -1 || c1 > c2)) {
					// 这一段是可用的
					tmpline += line.split("/\\*", -1)[0];
					// 包含了
					if (c3 != -1) {
						// 过滤掉中间被注释掉的部分
						line = line.split("\\*/", -1)[1];
						// 这一行尚未处理完
						i--;
						iscontinue = true;
					} else {
						comment = true;
						iscontinue = false;
					}
				}
				// 注释状态
			} else {
				// 注释状态到头
				if (c3 != -1) {
					line =tmpline+ line.split("\\*/", -1)[1];
					comment = false;
					iscontinue = true;
					i--;
				} else {
					iscontinue = false;
				}
			}
		}
//		for (String str : res)
//			System.out.println(str);
		return res;
	}

	public static void main(String[] args) {
		String[] code = new String[] { "/*Test program */", "int main()", "{ ", "  // variable declaration ",
				"int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;",
				"}" };
		System.out.println(new RemoveComments().removeComments(code));
	}
}
