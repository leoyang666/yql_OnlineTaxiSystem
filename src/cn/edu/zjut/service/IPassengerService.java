package cn.edu.zjut.service;

import java.util.ArrayList;

import cn.edu.zjut.po.Driver;
import cn.edu.zjut.po.Order;
import cn.edu.zjut.po.Passenger;

public interface IPassengerService {
	public void register(Passenger transientInstance);
	public Boolean login(Passenger transientInstance);
	public Passenger findbyId(int id);
	
	public void update(String nickname,String password);//���ĳ˿���Ϣ
	public Passenger select(Passenger passenger);//��ѯ������Ϣ
	public Driver driverInformation(Order order);//��ȡ���ն�����˾����Ϣ
	public ArrayList<Order> allOrder(Passenger passenger);//�鿴���ж���
}
