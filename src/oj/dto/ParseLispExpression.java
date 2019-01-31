package oj.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseLispExpression {

	public int evaluate(String expression) {
		Map<String, Integer> paramMap = new HashMap<>();
		return subEvaluate(expression, paramMap);
	}

	public int subEvaluate(String expression, Map<String, Integer> paramMap) {
		StringBuffer tokenBuffer = new StringBuffer(), subStatument = new StringBuffer();
		Map<String, Integer> newParamMap = new HashMap<>();
		newParamMap.putAll(paramMap);
		List<String> tokens = new ArrayList<>();
		expression = expression.substring(1, expression.length() - 1);
		int bracketNum = 0;
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '(') {
				bracketNum++;
				subStatument.append(c);
			} else if (c == ')') {
				bracketNum--;
				subStatument.append(c);
				if (bracketNum == 0) {
					tokens.add(subStatument.toString());
					subStatument = new StringBuffer();
				}
			} else if (bracketNum > 0) {
				subStatument.append(c);
			} else if (c == ' ') {
				if (tokenBuffer.length() > 0) {
					tokens.add(tokenBuffer.toString());
					tokenBuffer = new StringBuffer();
				}
			} else {
				tokenBuffer.append(c);
			}
		}
		if (tokenBuffer.length() > 0) {
			tokens.add(tokenBuffer.toString());
		}
		String first = tokens.get(0);
		if (first.equalsIgnoreCase("add")) {
			return handleAdd(tokens,newParamMap);
		} else if (first.equalsIgnoreCase("let")) {
			return handleLet(tokens,newParamMap);
		} else if (first.equalsIgnoreCase("mult")) {
			return handleMult(tokens,newParamMap);
		} else {
			return handleNomalToken(first,newParamMap);
		}
	}

	int handleNomalToken(String token,Map<String, Integer> paramMap) {
		char c = token.charAt(0);
		if (c >= '0' && c <= '9')
			return Integer.valueOf(token);

		return paramMap.get(token);
	}

	int handleLet(List<String> tokenList,Map<String, Integer> paramMap) {
		for (int i = 1; i < tokenList.size() - 1; i += 2) {
			int val = handleSingleToken(tokenList.get(i + 1),paramMap);
			paramMap.put(tokenList.get(i), val);
		}
		return handleSingleToken(tokenList.get(tokenList.size() - 1),paramMap);
	}

	int handleAdd(List<String> tokens,Map<String, Integer> paramMap) {
		String left = tokens.get(1);
		String right = tokens.get(2);
		return handleSingleToken(left,paramMap) + handleSingleToken(right,paramMap);
	}

	int handleSingleToken(String token,Map<String, Integer> paramMap) {
		if (token.trim().startsWith("("))
			return subEvaluate(token.trim(),paramMap);
		return handleNomalToken(token.trim(),paramMap);
	}

	int handleMult(List<String> tokens,Map<String, Integer> paramMap) {
		String left = tokens.get(1);
		String right = tokens.get(2);
		return handleSingleToken(left,paramMap) * handleSingleToken(right,paramMap);
	}

	public static void main(String[] args) {
		ParseLispExpression parseLispExpression = new ParseLispExpression();
		System.out.println(parseLispExpression.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
	}
}
