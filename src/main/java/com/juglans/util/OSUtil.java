package com.juglans.util;

public class OSUtil {

	private static final String OS = System.getProperty("os.name").toLowerCase();

	private static OSUtil _instance = new OSUtil();

	private OSEnum osEnum;

	private OSUtil() {}

	public static boolean isLinux() {
		return OS.indexOf("linux") >= 0;
	}

	public static boolean isMacOS() {
		return OS.indexOf("mac") >= 0 && OS.indexOf("os") > 0
				&& OS.indexOf("x") < 0;
	}

	public static boolean isMacOSX() {
		return OS.indexOf("mac") >= 0 && OS.indexOf("os") > 0
				&& OS.indexOf("x") > 0;
	}

	public static boolean isWindows() {
		return OS.indexOf("windows") >= 0;
	}

	public static boolean isOS2() {
		return OS.indexOf("os/2") >= 0;
	}

	public static boolean isSolaris() {
		return OS.indexOf("solaris") >= 0;
	}

	public static boolean isSunOS() {
		return OS.indexOf("sunos") >= 0;
	}

	public static boolean isMPEiX() {
		return OS.indexOf("mpe/ix") >= 0;
	}

	public static boolean isHPUX() {
		return OS.indexOf("hp-ux") >= 0;
	}

	public static boolean isAix() {
		return OS.indexOf("aix") >= 0;
	}

	public static boolean isOS390() {
		return OS.indexOf("os/390") >= 0;
	}

	public static boolean isFreeBSD() {
		return OS.indexOf("freebsd") >= 0;
	}

	public static boolean isIrix() {
		return OS.indexOf("irix") >= 0;
	}

	public static boolean isDigitalUnix() {
		return OS.indexOf("digital") >= 0 && OS.indexOf("unix") > 0;
	}

	public static boolean isNetWare() {
		return OS.indexOf("netware") >= 0;
	}

	public static boolean isOSF1() {
		return OS.indexOf("osf1") >= 0;
	}

	public static boolean isOpenVMS() {
		return OS.indexOf("openvms") >= 0;
	}

	public static OSEnum getOSname() {
		if (isAix()) {
			_instance.osEnum = OSEnum.AIX;
		} else if (isDigitalUnix()) {
			_instance.osEnum = OSEnum.Digital_Unix;
		} else if (isFreeBSD()) {
			_instance.osEnum = OSEnum.FreeBSD;
		} else if (isHPUX()) {
			_instance.osEnum = OSEnum.HP_UX;
		} else if (isIrix()) {
			_instance.osEnum = OSEnum.Irix;
		} else if (isLinux()) {
			_instance.osEnum = OSEnum.Linux;
		} else if (isMacOS()) {
			_instance.osEnum = OSEnum.Mac_OS;
		} else if (isMacOSX()) {
			_instance.osEnum = OSEnum.Mac_OS_X;
		} else if (isMPEiX()) {
			_instance.osEnum = OSEnum.MPEiX;
		} else if (isNetWare()) {
			_instance.osEnum = OSEnum.NetWare_411;
		} else if (isOpenVMS()) {
			_instance.osEnum = OSEnum.OpenVMS;
		} else if (isOS2()) {
			_instance.osEnum = OSEnum.OS2;
		} else if (isOS390()) {
			_instance.osEnum = OSEnum.OS390;
		} else if (isOSF1()) {
			_instance.osEnum = OSEnum.OSF1;
		} else if (isSolaris()) {
			_instance.osEnum = OSEnum.Solaris;
		} else if (isSunOS()) {
			_instance.osEnum = OSEnum.SunOS;
		} else if (isWindows()) {
			_instance.osEnum = OSEnum.Windows;
		} else {
			_instance.osEnum = OSEnum.Others;
		}
		return _instance.osEnum;
	}

}
