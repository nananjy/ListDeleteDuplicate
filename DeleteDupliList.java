package com.main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * List<Flight> 列表去重，实体类Flight包含[航班号，始发机场，到达机场]
 * 解题关键，重写equals、hashcode方法 
 * @author wzy
 */
public class DeleteDupliList {

	public static void main(String[] args) {
		//生成预定义的List数组 
		List<Flight> flights = new ArrayList<DeleteDupliList.Flight>();
		Flight flight1 = new Flight("1021", "广州", "武汉");
		Flight flight2 = new Flight("1021", "广州", "武汉");
		Flight flight3 = new Flight("1022", "广州", "深圳");
		flights.add(flight1);
		flights.add(flight2);
		flights.add(flight3);
		//判断flight1的值是否等于flight2的值 
		System.out.println("flight1.equals(flight2) = " + flight1.equals(flight2) 
				+ ", \n flight1.hashcode() = " + flight1.hashCode() 
				+ ", \n flight2.hashcode() = " + flight2.hashCode() 
				+ ", \n flight3.hashcode() = " + flight3.hashCode());
		//创建HashSet数组，实现对象内容去重 
		HashSet<Flight> flightSet = new HashSet<DeleteDupliList.Flight>();
		flightSet.addAll(flights);
		System.out.println("flightSet.toString() = " + flightSet.toString());
		//将结果保存到List数组中 
		List<Flight> result = new ArrayList<DeleteDupliList.Flight>();
		result.addAll(flightSet);
		System.out.println("result.toString() = " + result.toString());
	}
	
	//Flight 实体类
	private static class Flight {
		private String id; //编号
		private String oriairport; //始发机场
		private String desairport; //到达机场
		
		public Flight(String id, String oriairport, String desairport) {
			super();
			this.id = id;
			this.oriairport = oriairport;
			this.desairport = desairport;
		}

		//重写hashcode()方法 ，HashSet用到，对象内容相同时hashcode值相同 
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((desairport == null) ? 0 : desairport.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result
					+ ((oriairport == null) ? 0 : oriairport.hashCode());
			return result;
		}

		//重写equals()方法，判断内容，不写等同于==(只有是同一个对象时返回true) 
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Flight other = (Flight) obj;
			if (desairport == null) {
				if (other.desairport != null)
					return false;
			} else if (!desairport.equals(other.desairport))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (oriairport == null) {
				if (other.oriairport != null)
					return false;
			} else if (!oriairport.equals(other.oriairport))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Flight [id=" + id + ", oriairport=" + oriairport
					+ ", desairport=" + desairport + "]";
		}
	}
}
