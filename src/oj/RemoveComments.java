package oj;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
	public List<String> removeComments(String[] source) {
		List<String> res = new ArrayList<>();
		boolean content = false;
		for (String line : source) {
			content = handle(res, line, content);
		}
		return res;
	}

	// 处理每一行代码的注释
	private static boolean handle(List<String> res, String line, boolean content) {
		String newLine = "";
		int begin = 0;
		boolean quotation = false;
		if (content) {
			int index = line.indexOf("*/");
			if (index == -1) {
				return content;
			} else {
				String lastStr = res.get(res.size() - 1);
				res.remove(res.size() - 1);
				return handle(res, lastStr + line.substring(index + 2), false);

			}
		} else {
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c == '\\') {
					i++;
					continue;
				} else if (c == '"') {
					quotation = !quotation;
				} else if (quotation) {
					continue;
				} else if (c == '/') {
					if (i + 1 < line.length()) {
						c = line.charAt(i + 1);
						if (c == '/' || c == '*') {
							if (c == '/') {
								if ((newLine + line.substring(begin, i)).length() > 0)
									res.add(newLine + line.substring(begin, i));
								return false;
							} else {
								int endIndex = line.indexOf("*/", i + 2);
								if (endIndex == -1) {
									if ((newLine + line.substring(begin, i)).length() > 0)
										res.add(newLine + line.substring(begin, i));
									return true;
								} else {
									newLine += line.substring(begin, i);
									begin = endIndex + 2;
									i = begin - 1;
								}
							}
						} else {
							i++;
							continue;
						}
					}
				}
			}
		}
		if (begin > 0) {
			newLine = newLine + line.substring(begin);
		} else
			newLine = line;
		if (newLine.length() > 0)
			res.add(newLine);
		return false;

	}

	public static void main(String[] args) {
		String[] code = new String[] { "/*Test program */", "int main()", "{ ", "  // variable declaration ",
				"int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;",
				"}" };
		System.out.println(new RemoveComments().removeComments(code));
	}
}
