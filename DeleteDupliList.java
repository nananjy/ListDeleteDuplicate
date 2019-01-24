package com.main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * List<Flight> �б�ȥ�أ�ʵ����Flight����[����ţ�ʼ���������������]
 * ����ؼ�����дequals��hashcode���� 
 * @author wzy
 */
public class DeleteDupliList {

	public static void main(String[] args) {
		//����Ԥ�����List���� 
		List<Flight> flights = new ArrayList<DeleteDupliList.Flight>();
		Flight flight1 = new Flight("1021", "����", "�人");
		Flight flight2 = new Flight("1021", "����", "�人");
		Flight flight3 = new Flight("1022", "����", "����");
		flights.add(flight1);
		flights.add(flight2);
		flights.add(flight3);
		//�ж�flight1��ֵ�Ƿ����flight2��ֵ 
		System.out.println("flight1.equals(flight2) = " + flight1.equals(flight2) 
				+ ", \n flight1.hashcode() = " + flight1.hashCode() 
				+ ", \n flight2.hashcode() = " + flight2.hashCode() 
				+ ", \n flight3.hashcode() = " + flight3.hashCode());
		//����HashSet���飬ʵ�ֶ�������ȥ�� 
		HashSet<Flight> flightSet = new HashSet<DeleteDupliList.Flight>();
		flightSet.addAll(flights);
		System.out.println("flightSet.toString() = " + flightSet.toString());
		//��������浽List������ 
		List<Flight> result = new ArrayList<DeleteDupliList.Flight>();
		result.addAll(flightSet);
		System.out.println("result.toString() = " + result.toString());
	}
	
	//Flight ʵ����
	private static class Flight {
		private String id; //���
		private String oriairport; //ʼ������
		private String desairport; //�������
		
		public Flight(String id, String oriairport, String desairport) {
			super();
			this.id = id;
			this.oriairport = oriairport;
			this.desairport = desairport;
		}

		//��дhashcode()���� ��HashSet�õ�������������ͬʱhashcodeֵ��ͬ 
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

		//��дequals()�������ж����ݣ���д��ͬ��==(ֻ����ͬһ������ʱ����true) 
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
