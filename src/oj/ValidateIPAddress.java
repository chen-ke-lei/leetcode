package oj;

//	判断ip地址是否合法
public class ValidateIPAddress {
	public String validIPAddress(String IP) {
		String[] param1 = IP.split("\\.",-1);
		if (param1.length != 4) {
			param1 = IP.split(":",-1);
			if (param1.length != 8)
				return "Neither";
			for (int i = 0; i < 8; i++) {
				if (!judgeIpv6(param1[i]))
					return "Neither";
			}
			return "IPv6";
		} else {
			for (int i = 0; i < 4; i++) {
				if (!judgeIpv4(param1[i]))
					return "Neither";
			}
			return "IPv4";
		}
	}

	boolean judgeIpv4(String num) {
		if (num.length() > 4 || num.length() == 0)
			return false;

		return num.matches("^(0|([1-9][0-9]?)|(1[0-9]{2})|(2[0-4][0-9])|(25[0-5]))$");
	}

	boolean judgeIpv6(String num) {
		if (num.length() > 4 || num.length() == 0)
			return false;

		return num.matches("^[0-9a-fA-F]{0,4}$");
	}
	public static void main(String[] args) {
		System.out.println(new ValidateIPAddress().validIPAddress("256.256.256.256"));
	}
}
