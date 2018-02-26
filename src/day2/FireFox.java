package day2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FireFox {

	public static void main(String[] args) throws IOException, InterruptedException {
		// 1.启动默认安装路径下的火狐浏览器，一个干净的无任何插件或配置的
		// FirefoxDriver fd = new FirefoxDriver();
		// fd.get("https://www.baidu.com");

		// 2.如果火狐浏览器未安装在默认路径下，启动方法如下
		// System.setProperty("webdriver.firefox.bin", "C:/Program Files/Mozilla
		// Firefox/firefox.exe");// 火狐安装在哪儿就写哪儿
		// FirefoxDriver fd = new FirefoxDriver();
		// fd.get("https://www.baidu.com");

		// 3.启动指定exe的firefox
		// FirefoxBinary fb = new FirefoxBinary(new File("C:/Program
		// Files/Mozilla Firefox/firefox.exe"));
		// FirefoxDriver fd = new FirefoxDriver(fb, null);
		// fd.get("https://www.baidu.com");

		// 4.动态加载firebug，启动有配置项的火狐
		// FirefoxProfile fp = new FirefoxProfile();
		// try {
		// fp.addExtension(new File("source/firebug-2.0.17.xpi"));
		// } catch (IOException e) {
		// e.printStackTrace();
		// System.out.println("读取文件失败！");
		// }
		// fp.setPreference("extensions.firebug.currentVersion", "2.0.17");//
		// 设置插件属性，插件属性存在于浏览器配置文件中
		// fp.setEnableNativeEvents(true);// 开启被firefox禁用的功能
		// fp.setPreference("extensions.firebug.allPagesActivation", "on");//
		// 打开页面时都开着firebug
		// FirefoxDriver fd = new FirefoxDriver(fp);
		// fd.get("https://www.baidu.com");

		// 5.设置启动的默认主页地址
		// FirefoxProfile fp = new FirefoxProfile();
		// fp.setPreference("browser.startup.homepage",
		// "http://www.huicewang.com");
		// FirefoxDriver fd = new FirefoxDriver(fp);

		// 6.启动带有我自己的配置文件的火狐
		// String profilePath =
		// "C:/Users/Administrator/AppData/Roaming/Mozilla/Firefox/Profiles/39cntvts.default";
		// FirefoxProfile fp = new FirefoxProfile(new File(profilePath));
		// FirefoxDriver fd = new FirefoxDriver(fp);
		// fd.get("https://www.baidu.com");

		// 7.通过配置文件名称启动指定firefox（效果和上面那个6的一样，firefox的配置文件可以有多个，想用哪个就写哪个）
//		ProfilesIni pi = new ProfilesIni();
//		FirefoxProfile fp = pi.getProfile("default");
//		FirefoxDriver fd = new FirefoxDriver(fp);
//		fd.get("https://www.baidu.com");
		
		// 8.实现获取某页面的性能数据的功能
		FirefoxProfile fp = new FirefoxProfile();
		fp.addExtension(new File("source/firebug-2.0.17.xpi"));// 添加插件firebug
		fp.addExtension(new File("source/netExport-0.8.xpi"));// 添加插件netExport
		fp.setPreference("extensions.firebug.currentVersion", "2.0.17");// 指定firebug的版本
		fp.setPreference("extensions.firebug.allPagesActivation", "on");// 打开页面时都开着firebug
		fp.setPreference("extensions.firebug.defaultPanelName", "net");// 将打开的firebug切换至net页签
		fp.setPreference("extensions.firebug.net.enableSites", true);// 将net页签的可用打开
		fp.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);// 点亮netExport插件
		fp.setPreference("extensions.firebug.netexport.savaFiles", true);// 设置保存导出文件为真
		fp.setPreference("extensions.firebug.netexport.defaultLogDir", "C:\\Users\\Administrator\\Desktop");// 设置导出文件的保存路径
		FirefoxDriver fd = new FirefoxDriver(fp);
		Thread.sleep(2000);
		fd.get("https://www.baidu.com");
		fd.get("http://www.huicewang.com");
	}

}
