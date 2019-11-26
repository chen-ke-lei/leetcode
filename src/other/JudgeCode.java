
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JudgeCode {
	public static String getLogName(String content) {
		Pattern pattern = Pattern.compile(".*Logger[ ]+([0-9A-Za-z\\_]+)[ ]*\\=.*");
		Matcher matcher = pattern.matcher(content);
		String logName = "";
		if (matcher.find()) {
			logName = matcher.group(1);
			System.out.println(logName);
		}
		return logName;
	}

	public static String regLog(String content, String logName) {
		int index = 0;
		StringBuffer codeBuffer = new StringBuffer(content);
		while (index != -1 && index < content.length()) {
			index = content.indexOf("catch", index);
			if (index == -1) {
				break;
			}
			int stack = 1;
			index = content.indexOf("{", index);
			index++;
			boolean duobleQuotation = false, quotation = false, tranfer = false;
			String subCode = "";
			outer: for (; index < content.length(); index++) {
				char c = content.charAt(index);
				codeBuffer.replace(index, index + 1, " ");
				subCode += c;
				if (tranfer) {
					tranfer = false;
				} else if (quotation) {
					if (c == '\'')
						quotation = false;
				} else if (duobleQuotation) {
					if (c == '"')
						duobleQuotation = false;
				} else {
					switch (c) {
						case '\'':
							quotation = true;
							break;
						case '"':
							duobleQuotation = true;
							break;
						case '\\':
							tranfer = true;
							break;
						case '{':
							stack++;
							break;
						case '}':
							stack--;
							if (stack == 0)
								break outer;
							break;
						default:
							break;
					}
				}
			}
			if (subCode.length() > 0 && subCode.endsWith("}")) {
				subCode = subCode.substring(0, subCode.length() - 1);
				regCatchCode(subCode, logName);
			}
		}
		return codeBuffer.toString();
	}

	public static void regCatchCode(String subCode, String logName) {
		System.out.println(subCode);
		System.out.println();
		if (subCode.contains("catch")) {
			subCode = regLog(subCode, logName);
		}
		subCode = subCode.replaceAll("[\\n\\r ]+", "");
		String[] codeLines = subCode.split(";");
		boolean isOk = false;
		for (String coString : codeLines) {
			if (coString.contains(logName)) {
				if (coString.contains("task.getRealExt().getRequestId()")) {
					isOk = true;
					break;
				}
			} else {
				continue;
			}
		}
		if (isOk) {
			System.out.println("异常已处理");
		} else {
			System.out.println("异常未处理");
		}
	}

	static String formatJavaCode(String path) throws Exception {
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		String content = "";
		List<String> codeLines = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			codeLines.add(line);
		}
		reader.close();
		codeLines = deletContent(codeLines);
		for (String codeLine : codeLines) {
			content += codeLine;
		}
		content = content.replaceAll("[ \\n\\r]+", " ");

		return content;
	}

	public static void regImport(String content) throws Exception {
		String[] lines = content.split(";");
		String pageName = "";
		String basePage = "net.sc.spider.processor";
		for (String lineStr : lines) {
			lineStr = lineStr.trim();
			if (lineStr.startsWith("package")) {
				pageName = lineStr.split("[ ]+")[1];
				pageName = pageName.split("\\.")[pageName.split("\\.").length - 2];
			} else if (lineStr.startsWith("import")) {
				String importPage = lineStr.split("[ ]+")[1];
				if (importPage.startsWith(basePage)) {
					String subPage = importPage.substring(importPage.indexOf(basePage) + basePage.length() + 1);
					if (!subPage.startsWith("util") && !subPage.startsWith(pageName)) {
						System.out.println("引用了不合法的类" + importPage);
						return;
					}
				} else {
					continue;
				}
			} else if (lineStr.startsWith("public") || lineStr.startsWith("class"))
				break;
		}
		System.out.println("校验成功");
	}

	// 删除注释
	public static List<String> deletContent(List<String> codeLines) {
		List<String> res = new ArrayList<>();
		boolean content = false;
		for (String line : codeLines) {
			line = line.trim();
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
				return handle(res, line.substring(0, index), false);
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
								res.add(newLine + line.substring(begin, i));
								return false;
							} else {
								int endIndex = line.indexOf("*/", i + 2);
								if (endIndex == -1) {
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
			res.add(newLine + line.substring(begin));
		} else
			res.add(line);
		return false;

	}
}
