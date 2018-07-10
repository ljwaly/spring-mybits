package com.ljw.spring.mybits.container;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import org.apache.log4j.Logger;

/**
 * 测试构造方法传入配置参数
 * @author PC
 *
 */
public class MyContainer {

	
	
	private static Logger log =Logger.getLogger(MyContainer.class);
	
	public MyContainer(String name, int port){
		
		
		System.out.println("***************************");
		System.out.println("MyContainer:[name:"+name+"]");
		System.out.println("port:"+port);
		
		String localip = null;// 本地IP，
		String ipStr = "";
		Enumeration allNetInterfaces;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces
				.nextElement();
				Enumeration addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address ) {
						if(!"127.0.0.1".equals(ip.getHostAddress()) && !"127.0.0.2".equals(ip.getHostAddress())){
							ipStr = ip.getHostAddress();
							break;
						}
					}
				}
			}
		} catch (SocketException e) {
		}
		String _ipStr = ipStr.replace(".", "_");
        
       
		System.out.println(_ipStr);
	
		System.out.println("localip:"+ipStr);
		System.out.println("***************************");
		
		log.info("localip:"+ipStr+"(log.info)");
		
	}



//	String localip = null;// 本地IP，如果没有配置外网IP则返回它
//    String netip = null;// 外网IP
//    try {
//        Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
//        InetAddress ip = null;
//        boolean finded = false;// 是否找到外网IP
//        while (netInterfaces.hasMoreElements() && !finded) {
//            NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
//            Enumeration address = ni.getInetAddresses();
//            while (address.hasMoreElements()) {
//                ip = (InetAddress) address.nextElement();
//                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
//                    netip = ip.getHostAddress();
//                    finded = true;
//                    break;
//                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
//                    localip = ip.getHostAddress();
//                }
//            }
//        }
//    } catch (SocketException e) {
//        e.printStackTrace();
//    }
//
//    if (netip != null && !"".equals(netip)) {
//        return netip;
//    } else {
//        return localip;
//    }
	
	
}
